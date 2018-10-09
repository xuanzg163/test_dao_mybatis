package com.test.mapper.impl;

import com.test.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    /**
     *  测试添加用户返回主键
     *
     */
    @Test
    public void addUserHasKey() throws Exception{
        User user = new User();
        user.setUserName("lenlen");
        user.setUserPwd("sadad");
        user.setRealName("xxxxx");
        user.setNation("jp");
        user.setCardID(12);

        Integer num = userMapper.addUserHasKey(user);
        System.out.println("受影响行数 =====" +num);
        System.out.println("新建用户的主键为: "+user.getId());
    }

    /**
     * 测试添加用户返回主键(通用版)
     */
    @Test
    public void addUserHasKeyGeneral() throws Exception{
        User user = new User();
        user.setUserName("kation");
        user.setUserPwd("sao");
        user.setRealName("fuck konami");
        user.setNation("jp");
        user.setCardID(14);

        Integer num = userMapper.addUserHasKeyGeneral(user);
        System.out.println("受影响行数 =====" +num);
        System.out.println("新建用户的主键为: "+user.getId());
    }

    /**
     * 测试批量添加用户
     */
    @Test
    public void addUserBatch() throws Exception{
        List<User> userList = new ArrayList<>();

        for (int i = 0; i<10; i++){
            User user = new User();
            user.setUserName("kation"+i);
            user.setUserPwd("sao");
            user.setRealName("fuck konami");
            user.setNation("jp");
            user.setCardID(14+i);
            userList.add(user);
        }
        Integer num = userMapper.addUserBatch(userList);
        System.out.println("num ===="+num);
    }


    /**
     * 测试根据用户id更新指定的用户
     * @throws Exception
     */
    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setId(17);
        user.setUserName("好饿啊");
        user.setUserPwd("该去吃饭了");
        user.setRealName("fuck konami");

        Integer num = userMapper.updateUser(user);
        System.out.println("受影响行数 =====" + num);
    }

    /**
     * 测试批量更新用户的密码
     */
    @Test
    public void updateUserBatch() throws Exception{
        Integer[] idx = new Integer[10];

        for (int i = 0; i < 10; i++){
            idx[i] = 8+i;
        }
        Integer num = userMapper.updateUserBatch(idx);
        System.out.println("num == ===" +num);
    }

    /**
     * 测试根据用户id删除指定用户
     */
    @Test
    public void deleteUser() throws Exception{
        userMapper.deleteUser(28);
    }

    /**
     *  测试根据用户id批量删除用户
     * @throws Exception
     */
    @Test
    public void deleteUserBatch() throws Exception{
        List<Integer> list = new ArrayList<>();
        for (int i = 8; i <= 17; i++ ){
            list.add(i);
        }
       Integer num =  userMapper.deleteUserBatch(list);
        System.out.println(num);
    }



}