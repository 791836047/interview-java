package com.java.interview.common.service.impl;

import com.java.interview.common.ExecutorConfig;
import com.java.interview.common.SqlContext;
import com.java.interview.common.entity.Employee;
import com.java.interview.common.mapper.EmployeeMapper;
import com.java.interview.common.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author liaowenhui
 * @date 2023/1/17 15:23
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SqlContext sqlContext;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveThread(List<Employee> employeeDOList) {
        try {
            //先做删除操作,如果子线程出现异常,此操作不会回滚
            employeeMapper.delete(null);
            //获取线程池
            ExecutorService service = ExecutorConfig.getThreadPool();
            //拆分数据,拆分5份
            List<List<Employee>> lists=averageAssign(employeeDOList, 5);
            //执行的线程
            Thread []threadArray = new Thread[lists.size()];
            //监控子线程执行完毕,再执行主线程,要不然会导致主线程关闭,子线程也会随着关闭
            CountDownLatch countDownLatch = new CountDownLatch(lists.size());
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            for (int i =0;i<lists.size();i++){
                if (i==lists.size()-1){
                    atomicBoolean.set(false);
                }
                List<Employee> list  = lists.get(i);
                threadArray[i] =  new Thread(() -> {
                    try {
                        //最后一个线程抛出异常
                        if (!atomicBoolean.get()){
                            throw new RuntimeException("出现异常");
                        }
                        //批量添加,mybatisPlus中自带的batch方法
                        employeeMapper.saveBatch(list);
                    }finally {
                        countDownLatch.countDown();
                    }

                });
            }
            for (int i = 0; i <lists.size(); i++){
                service.execute(threadArray[i]);
            }
            //当子线程执行完毕时,主线程再往下执行
            countDownLatch.await();
            System.out.println("添加完毕");
        }catch (Exception e){
            log.info("error",e);
            throw new RuntimeException("出现异常");
        }

    }

    @Override
    public void saveThread2(List<Employee> employeeDOList) throws SQLException {
        // 获取数据库连接,获取会话(内部自有事务)
        SqlSession sqlSession = sqlContext.getSqlSession();
        Connection connection = sqlSession.getConnection();
        try {
            // 设置手动提交
            connection.setAutoCommit(false);
            //获取mapper
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            //先做删除操作
            employeeMapper.delete(null);
            //获取执行器
            ExecutorService service = ExecutorConfig.getThreadPool();
            List<Callable<Integer>> callableList  = new ArrayList<>();
            //拆分list
            List<List<Employee>> lists=averageAssign(employeeDOList, 5);
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            for (int i =0;i<lists.size();i++){
                if (i==lists.size()-1){
                    atomicBoolean.set(false);
                }
                List<Employee> list  = lists.get(i);
                //使用返回结果的callable去执行,
                Callable<Integer> callable = () -> {
                    //让最后一个线程抛出异常
                    if (!atomicBoolean.get()){
                        throw new RuntimeException("出现异常");
                    }
                    return employeeMapper.saveBatch(list);
                };
                callableList.add(callable);
            }
            //执行子线程
            List<Future<Integer>> futures = service.invokeAll(callableList);
            for (Future<Integer> future:futures) {
                //如果有一个执行不成功,则全部回滚
                if (future.get()<=0){
                    connection.rollback();
                    return;
                }
            }
            connection.commit();
            System.out.println("添加完毕");
        }catch (Exception e){
            connection.rollback();
            log.info("error",e);
            throw new RuntimeException("出现异常");
        }finally {
            connection.close();
        }
    }

    /**
     * 平均拆分list方法.
     * @param source
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source,int n){
        List<List<T>> result=new ArrayList<List<T>>();
        int remaider=source.size()%n;
        int number=source.size()/n;
        //偏移量
        int offset=0;
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=source.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=source.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }
}
