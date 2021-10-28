package com.fzn;

import com.fzn.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
public class MyTest {

    //测试MyBatis执行sql语句
    @Test
    public void testSelectStudentById() throws IOException {
        //调用MyBatis某个对象的方法，执行mapper文件的sql语句
        //MyBatis核心类：SqlSessionFactory

        //1.定义MyBatis主配置文件的位置，从类路径开始的相对路径
        String resource = "mybatis.xml";
        //2.读取主配置文件，使用MyBatis框架中的Resource类
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //3.创建sqlSessionFactory对象，使用SqlSessionFactoryBuilder类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //4.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //5.指定要执行sql语句的id sql的id = nameSpace + "." + select|update|insert|delete 标签的id属性值
        String sqlId = "com.fzn.dao.StudentDao" + "." + "selectStudentById";
        //6.通过SqlSession的方法，执行sql语句
        Student student = session.selectOne(sqlId);
        System.out.println("使用MyBatis查询一个学生：" + student);
        //7.关闭SqlSession对象
        session.close();
    }
}
