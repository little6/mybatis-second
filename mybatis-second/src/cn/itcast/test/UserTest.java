/** ======================================
 * Beijing Itcast Tech. Co.,Ltd
 * Date：2016年9月18日 上午10:38:18
 * Author：huyy
 * Version：1.0
 * =========Modification History==========
 * Date          Name        Description
 * 2016年9月18日       Administrator     创建UserTest类
 */
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


import cn.itcast.mybatis.po.User;

/**
 * @Path cn.itcast.test.UserTest
 * @Description 测试方法
 * @date 2016年9月18日上午10:38:18
 * @author huyy
 * @version：1.0
 */
public class UserTest {
    
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
    public void testGetUser(){
        /**
         * 1、创建SqlSessionFactoryBuilder对象
         * 2、加载配置文件(sqlMapConfig.xml)
         * 3、创建sqlSessionFactory对象
         * 4、创建sqlSession对象
         * 5、使用sqlSession对象来执行查询，得到User对象
         */
        InputStream in;
        SqlSession session = null;
        try {
            /**
             * 1、使用类加载器的方式读取配置文件
             * 2、使用Resources工具类
             */
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        InputStream in = UserTest.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
            /**
             * 构建sqlSession的工厂
             */
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            session = factory.openSession();
            
            /**
             * 映射sql的标识字符串， 
             * cn.itcast.mapping.UserMapping是userMapping.xml文件中mapper标签的namespace属性的值，
             * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
             */
            String statement = "cn.itcast.mapping.UserMapping.getUser";
            User user = session.selectOne(statement, 1);
            System.out.println(user);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
    
    /**
     * 
     * 根据用户名称模糊匹配<br/>
     * ============History===========<br/>
     * 2016年9月18日   Administrator    新建
     */
    @Test
    public void testGetUserByName(){
        SqlSession session = factory.openSession();
        String statement = "cn.itcast.mapping.UserMapping.getUserByName";
        List<User> list = session.selectList(statement, "张");
//        session.selectList(statement, parameter, rowBounds); 使用rowBounds可以实现分页
        for (User user : list) {
            System.out.println(user);
        }
        session.close();
    }
    
    /**
     * 
     * 插入user<br/>
     * ============History===========<br/>
     * 2016年9月18日   Administrator    新建
     */
    @Test
    public void testInsertUser(){
        SqlSession session = factory.openSession();
        String statement = "cn.itcast.mapping.UserMapping.insertUser";
        User user = new User();
        user.setUsername("乔峰");
        user.setBirthday(new Date());
        user.setSex("2");
        user.setAddress("开封");
        
        session.insert(statement, user);
        System.out.println(user.getId());
        session.commit();//提交事务
        session.close();//释放资源
    }
    
    /**
     * 
     * 插入user,返回主键<br/>
     * ============History===========<br/>
     * 2016年9月18日   Administrator    新建
     */
    @Test
    public void testInsertUserReturn(){
        SqlSession session = factory.openSession();
        String statement = "cn.itcast.mapping.UserMapping.insertUserR";
        User user = new User();
        user.setUsername("段誉");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("大理");
        
        session.insert(statement, user);
        System.out.println(user.getId());
        session.commit();//提交事务
        session.close();//释放资源
    }
    
    /**
     * 
     * 删除用户信息<br/>
     * ============History===========<br/>
     * 2016年9月18日   Administrator    新建
     */
    @Test
    public void testDeleteUser(){
        SqlSession session = factory.openSession();
        String statement = "cn.itcast.mapping.UserMapping.deleteUser";
        session.delete(statement, 25);
        session.commit();
        session.close();
    }
    
    /**
     * 
     * 删除用户信息<br/>
     * ============History===========<br/>
     * 2016年9月18日   Administrator    新建
     */
    @Test
    public void testUpdateUser(){
        SqlSession session = factory.openSession();
        String statement = "cn.itcast.mapping.UserMapping.updateUser";
        User user = new User();
        user.setUsername("乔乔");
        user.setId("28");
        session.update(statement, user);
        session.commit();
        session.close();
    }
}
