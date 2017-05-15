package cn.itcast.test;


import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.dao.IUser;
import cn.itcast.mybatis.dao.impl.UserDaoImpl;
import cn.itcast.mybatis.po.User;

/**
 * 
 * @Path cn.itcast.test.UserDaoImplTest
 * @Description UserDaoImpl的实现类的测试案例
 * @date 2016年9月18日下午4:33:51
 * @author huyy
 * @version：1.0
 */
public class UserDaoImplTest {

    private SqlSessionFactory factory = null;
    
    /**
     * 
     * 进行单元测试前，必须执行的方法：完成factory的初始化
     * @throws Exception<br/>
     * ============History===========<br/>
     * 2016年9月18日   Administrator    新建
     */
    @Before
    public void init() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }
    
    @Test
    public void testGetUserById() {
        IUser userDao = new UserDaoImpl(factory);
        User user = userDao.getUserById(30);
        System.out.println(user);
    }

    @Test
    public void testGetUsersByUserName() {
        IUser userDao = new UserDaoImpl(factory);
        List<User> userList = userDao.getUsersByUserName("张");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        IUser userDao = new UserDaoImpl(factory);
        User user = new User();
        user.setUsername("慕容复");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("上海");
        userDao.insertUser(user);
    }

}
