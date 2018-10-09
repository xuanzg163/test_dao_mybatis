package com.test.mapper.impl;

import com.test.mapper.UserMapper;
import com.test.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserMapperImpl implements UserMapper {

    private SqlSessionFactory sqlSessionFactory;

    public UserMapperImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    @Override
    public User queryUserById(Integer id) {

        SqlSession sqlSession = null;
        User user = null;
        sqlSession = sqlSessionFactory.openSession();
        user = sqlSession.selectOne("com.test.mapper.UserMapper.queryUserById",id);

        if (sqlSession !=null){
            sqlSession.close();
        }
        return user;
    }

    /**
     *  添加用户不返回主键
     * @param user
     * @return
     */
    @Override
    public Integer addUser(User user) {
        SqlSession sqlSession = null;
        Integer num = null;

        sqlSession = sqlSessionFactory.openSession(true);
        num = sqlSession.insert("com.test.mapper.UserMapper.addUser",user);
        sqlSession.close();
        return num;
    }
}
