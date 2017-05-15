package cn.itcast.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.User;
import junit.framework.TestCase;

/**
 * 
 * @Path cn.itcast.test.UserMapperTest
 * @Description mapper代理的测试类
 * @date 2016年9月18日下午5:24:43
 * @author huyy
 * @version：1.0
 */
public class UserMapperTest /*extends TestCase*/{
    
    private SqlSessionFactory factory = null;
    
    @Before
    public void init() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }
    
    /*@Override
    public void setUp() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }*/

    @Test
    public void testGetUserById() throws Exception {
        SqlSession session = factory.openSession();
        
        /**
         * 使用mapper代理类进行dao的操作
         */
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserById(30);
        System.out.println(user);
        
        session.close();
    }

    @Test
    public void testGetUserByName() {
        SqlSession session = factory.openSession();
        
        /**
         * 使用mapper代理类进行dao的操作
         */
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserByName("张");
        for (User user : userList) {
            System.out.println(user);
        }
        
        session.close();
    }

    @Test
    public void testInsertUser() {
        SqlSession session = factory.openSession();
        
        /**
         * 使用mapper代理类进行dao的操作
         */
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("王语嫣");
        user.setBirthday(new Date());
        user.setSex("2");
        user.setAddress("苏州");
        userMapper.insertUser(user);
        
        session.commit();
        session.close();
    }

}
