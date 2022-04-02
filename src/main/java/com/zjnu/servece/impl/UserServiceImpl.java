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
    public PageBean<User> selectUserByPage(User user,int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        String username = user.getUsername();
        if(username != null && username.length() > 0){
            user.setUsername("%"+username+"%");
        }
        String email = user.getEmail();
        if(email != null && email.length() > 0){
            user.setEmail("%"+email+"%");
        }
        String idCard = user.getIdCard();
        if(idCard != null && idCard.length()>0){
            user.setIdCard("%"+idCard+"%");
        }
        String name = user.getName();
        if(name != null && name.length()>0){
            user.setName("%"+name+"%");
        }
        List<User> users = mapper.selectUserByPage(user,begin, size);
        int count = mapper.selectTotalCount(user.getUsername(),user.getEmail(),user.getIdCard(),user.getName());
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

    @Override
    public void addToken(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addToken(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User selectTokenByUsername(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectTokenByUsername(user);
        return user1;
    }

    @Override
    public void cleanToken(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.cleanToken(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void logoffUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.logoffUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
