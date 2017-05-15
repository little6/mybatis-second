/** ======================================
 * Beijing Itcast Tech. Co.,Ltd
 * Date：2016年9月18日 下午4:21:49
 * Author：huyy
 * Version：1.0
 * =========Modification History==========
 * Date          Name        Description
 * 2016年9月18日       Administrator     创建UserDaoImpl类
 */
package cn.itcast.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.dao.IUser;
import cn.itcast.mybatis.po.User;

/**
 * @Path cn.itcast.mybatis.dao.impl.UserDaoImpl
 * @Description IUser接口实现类
 * @date 2016年9月18日下午4:21:49
 * @author huyy
 * @version：1.0
 */
public class UserDaoImpl implements IUser {
    
    /**
     * 需要传入sqlSessionFactory对象的实例(单例)
     */
    private SqlSessionFactory sqlSessionFactory;
    
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    
    @Override
    public User getUserById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        String statement = "cn.itcast.mapping.UserMapping.getUser";
        User user = session.selectOne(statement, id);
        session.close();
        return user;
    }

    @Override
    public List<User> getUsersByUserName(String username) {
        SqlSession session = sqlSessionFactory.openSession();
        String statement = "cn.itcast.mapping.UserMapping.getUserByName";
        List<User> list = session.selectList(statement, "张");
        session.close();
        return list;
    }

    @Override
    public void insertUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        String statement = "cn.itcast.mapping.UserMapping.insertUser";
        
        session.insert(statement, user);
        session.commit();//提交事务
        session.close();//释放资源
    }

}
