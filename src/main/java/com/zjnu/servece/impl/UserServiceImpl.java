package com.zjnu.servece.impl;

import com.zjnu.mapper.BrandMapper;
import com.zjnu.mapper.UserMapper;
import com.zjnu.pojo.Brand;
import com.zjnu.pojo.PageBean;
import com.zjnu.pojo.User;
import com.zjnu.servece.UserService;
import com.zjnu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public User selectUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectUser(user);
        sqlSession.close();
        return user1;
    }

    @Override
    public User selectUserByUserInfo(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectUserByUserInfo(user);
        sqlSession.close();
        return user1;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByID(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteById(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<User> selectUserByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        List<User> users = mapper.selectUserByPage(begin, size);
        int count = mapper.selectTotalCount();
        PageBean<User> pageBean= new PageBean<User>();
        pageBean.setTotalCount(count);
        pageBean.setRows(users);
        sqlSession.close();
        return pageBean;
    }

    @Override
    public User selectUserById(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectUserById(user);
        sqlSession.close();
        return user1;
    }

    @Override
    public User selectUserByUsername(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectByUsername(user);
        sqlSession.close();
        return user1;
    }

    @Override
    public void alterUserInfo(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(user);
        mapper.alterUserInfo(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
