/** ======================================
 * Beijing Itcast Tech. Co.,Ltd
 * Date：2016年9月18日 下午4:18:37
 * Author：huyy
 * Version：1.0
 * =========Modification History==========
 * Date          Name        Description
 * 2016年9月18日       Administrator     创建IUser类
 */
package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.po.User;

/**
 * @Path cn.itcast.mybatis.dao.IUser
 * @Description 用户dao接口
 * @date 2016年9月18日下午4:18:37
 * @author huyy
 * @version：1.0
 */
public interface IUser {
    /**
     * 
     * 根据id查询用户信息
     * @param id
     * @return<br/>
     * ============History===========<br/>
     * 2016年9月18日   Administrator    新建
     */
    User getUserById(int id);
    
    /**
     * 
     * 根据用户名称模糊查询用户信息
     * @param username
     * @return<br/>
     * ============History===========<br/>
     * 2016年9月18日   Administrator    新建
     */
    List<User> getUsersByUserName(String username);
    
    /**
     * 
     * 插入用户
     * @param user<br/>
     * ============History===========<br/>
     * 2016年9月18日   Administrator    新建
     */
    void insertUser(User user);
}
