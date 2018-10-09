package com.test.mapper.impl;

import com.test.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class UserMapperImplTest {

    private UserMapperImpl userMapper;

    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        userMapper = new UserMapperImpl(sqlSessionFactory);
    }

    /**
     * 测试根据用户ID查询用户信息
     * @throws IOException
     */
    @Test
    public void queryUserById() throws IOException {
        User user = userMapper.queryUserById(1);
        System.out.println(user);
    }

    /**
     *  测试addUser 不返回主键
     * @throws Exception
     */
    @Test
    public void addUser() throws Exception{
        User user = new User();
        user.setUserName("rinrin");
        user.setUserPwd("sadad");
        user.setRealName("xxxxx");
        user.setNation("jp");
        user.setCardID(11);

        Integer num = userMapper.addUser(user);
        System.out.println("num =====" +num);
    }
}