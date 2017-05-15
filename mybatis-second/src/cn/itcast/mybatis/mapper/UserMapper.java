package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;

public interface UserMapper {

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
    List<User> getUserByName(String username);
    
    /**
     * 
     * 插入用户
     * @param user<br/>
     * ============History===========<br/>
     * 2016年9月18日   Administrator    新建
     */
    void insertUser(User user);
}
