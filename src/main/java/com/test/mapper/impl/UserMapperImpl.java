package com.test.mapper.impl;

import com.test.mapper.UserMapper;
import com.test.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

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

        sqlSession = sqlSessionFactory.openSession(true);//默认提交
        num = sqlSession.insert("com.test.mapper.UserMapper.addUser",user);
        sqlSession.close();
        return num;
    }

    /**
     *  添加用户返回主键
     * @param user
     * @return
     */
    @Override
    public Integer addUserHasKey(User user) {
        SqlSession sqlSession = null;
        Integer num = null;

        sqlSession = sqlSessionFactory.openSession(true);
        num = sqlSession.insert("com.test.mapper.UserMapper.addUserHasKey",user);
        sqlSession.close();
        return num;
    }

    /**
     *  添加用户返回主键(通用)
     * @param user
     * @return
     */
    @Override
    public Integer addUserHasKeyGeneral(User user) {
        SqlSession sqlSession = null;
        Integer num = null;

        sqlSession = sqlSessionFactory.openSession(true);
        num = sqlSession.insert("com.test.mapper.UserMapper.addUserHasKeyGeneral",user);
        sqlSession.close();
        return num;
    }

    /**
     *  批量添加用户
     * @param userList
     * @return
     */
    @Override
    public Integer addUserBatch(List<User> userList) {
        SqlSession sqlSession = null;
        Integer num = null;

        sqlSession = sqlSessionFactory.openSession(true);
        num = sqlSession.insert("com.test.mapper.UserMapper.addUserBatch",userList);
        sqlSession.close();
        return num;
    }

    /**
     *  更具用户id
     *  更新用户信息
     * @param user
     * @return
     */
    @Override
    public Integer updateUser(User user) {
        SqlSession sqlSession = null;
        Integer num = null;

        sqlSession = sqlSessionFactory.openSession(true);
        num = sqlSession.update("com.test.mapper.UserMapper.updateUser",user);
        sqlSession.close();
        return num;
    }

    @Override
    public Integer updateUserBatch(Integer[] idx) {
        SqlSession sqlSession = null;
        Integer num = null;

        sqlSession = sqlSessionFactory.openSession(true);
        num = sqlSession.update("com.test.mapper.UserMapper.updateUserBatch",idx);
        sqlSession.close();
        return num;
    }

    /**
     *  根据用户id删除指定用户
     * @param id
     * @return
     */
    @Override
    public Integer deleteUser(Integer id) {
        SqlSession sqlSession = null;
        Integer num = null;

        sqlSession = sqlSessionFactory.openSession(true);
        num = sqlSession.delete("com.test.mapper.UserMapper.deleteUser",id);
        sqlSession.close();
        return num;
    }

    /**
     *  根据用户id批量删除用户
     * @param idx
     * @return
     */
    @Override
    public Integer deleteUserBatch(List<Integer> idx) {
        SqlSession sqlSession = null;
        Integer num = null;

        sqlSession = sqlSessionFactory.openSession(true);
        num = sqlSession.delete("com.test.mapper.UserMapper.deleteUserBatch",idx);
        sqlSession.close();
        return num;
    }


}
