package com.test.mapper;

import com.test.po.User;

import java.util.List;


/**
 * UserDAO
 */

public interface UserMapper {
    public User queryUserById(Integer id);
    public Integer addUser(User user);
    public Integer addUserHasKey(User user);
    public Integer addUserHasKeyGeneral(User user);
    public Integer addUserBatch(List<User> userList);
    public Integer updateUser(User user);
    public Integer updateUserBatch(Integer[] idx);
    public Integer deleteUser(Integer id);
    public Integer deleteUserBatch(List<Integer> idx);
}

