package com.test.mapper;

import com.test.po.User;


/**
 * UserDAO
 */

public interface UserMapper {
    public User queryUserById(Integer id);
    public Integer addUser(User user);
}

