package cn.maybe.pojo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUser {

    public  User findById();
    public   List<User> findUserListById();
    public   List<User> findByUserName(@Param(value="username")String username);

}
