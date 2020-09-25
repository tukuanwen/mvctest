package com.tu.mvctest.test;


import com.tu.mvctest.dao.entity.ClassTab;
import com.tu.mvctest.dao.entity.UserTab;
import com.tu.mvctest.dao.mapper.ClassTabMapper;
import com.tu.mvctest.dao.mapper.UserTabMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;


public class MybatisTestUtils {

    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("./spring/applicationContext.xml");

        //使用MapperFactoryBean获取表映射操作
//        ClassTabMapper classTabMapper = (ClassTabMapper)context.getBean("classTabMapper");
//        UserTabMapper userTabMapper = (UserTabMapper)context.getBean("userTabMapper");

        //使用SqlSessionTemplement直接获取SqlSession
        SqlSessionTemplate sqlSessionTp = (SqlSessionTemplate)context.getBean("sqlSession");
        UserTab tab = new UserTab();
        tab.setUserId(1);
        List<UserTab> result = sqlSessionTp.selectList("com.tu.mvctest.dao.mapper.UserTabMapper.selectByPrimaryKey", 1);

        for(UserTab res : result){
            System.out.println("姓名："+res.getUserName());
        }

//
//        List<UserTab> result
//
//        for(UserTab res : result){

//            System.out.println("编号："+res.getUserId());
//            System.out.println("姓名："+res.getUserName());
//            System.out.println("邮箱："+res.getUserMail());

//        }

//        ClassTab classTab = new ClassTab();
//        classTab.setClassName("混沌班");
//
//        int classNun = classTabMapper.insertSelective(classTab);
//
//        UserTab userTab = new UserTab();
//        userTab.setUserName("哈哈");
//        userTab.setUserMail("haha@qq.com");
//        userTab.setClassId(classNun);
//        userTabMapper.insert(userTab);
//
//        System.out.println("插入成功");



        Connection conn = sqlSessionTp.getConnection();

        String sqlStr = "select user_id, user_name, user_mail from user_tab";
        try {
            ResultSet sets =conn.createStatement().executeQuery(sqlStr);
            System.out.println( sets.getArray(0));

        }catch (Exception e){

        }



    }
}
