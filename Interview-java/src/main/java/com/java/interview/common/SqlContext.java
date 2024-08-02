package com.java.interview.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 * @author liaowenhui
 * @date 2023/1/17 15:46
 */
@Component
public class SqlContext {
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSession getSqlSession(){
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        return sqlSessionFactory.openSession();
    }
}
