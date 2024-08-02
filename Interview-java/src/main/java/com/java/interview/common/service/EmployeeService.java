package com.java.interview.common.service;

import com.java.interview.common.entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author liaowenhui
 * @date 2023/1/17 15:23
 */
public interface EmployeeService {
     /**
      * 使用 @Transactional
      * @param employeeDOList
      */
     void saveThread(List<Employee> employeeDOList);

     /**
      * 使用sqlSession控制手动提交事务
      * @param employeeDOList
      */
     void saveThread2(List<Employee> employeeDOList) throws SQLException;

}
