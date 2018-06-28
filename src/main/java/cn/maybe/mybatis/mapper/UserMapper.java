package cn.maybe.mybatis.mapper;

import cn.maybe.mybatis.pojo.User;

import java.util.List;

/**
 *用户管理mapper
 *
 */
public interface UserMapper {

    public User findById(Integer id);
    public   List<User> findUserList();
    public   void insertUser(User user);

}
