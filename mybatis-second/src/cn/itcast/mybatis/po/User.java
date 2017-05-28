/** ======================================
 * Beijing Itcast Tech. Co.,Ltd
 * Date：2016年9月18日 上午10:32:42
 * Author：huyy
 * Version：1.0
 * =========Modification History==========
 * Date          Name        Description
 * 2016年9月18日       Administrator     创建User类
 */
package cn.itcast.mybatis.po;

import java.util.Date;

/**
 * @Path cn.itcast.mybatis.po.User
 * @Description 用户po对象
 * @date 2016年9月18日上午10:32:42
 * @author huyy
 * @version：1.0
 */
public class User {

    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别
     */
    private String sex;
    /**
     * 地址
     */
    private String address;
    
    /*public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }*/
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex + ", address="
                + address + "]";
    }
    
}
