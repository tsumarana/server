package com.zjnu.servece.impl;

import com.zjnu.mapper.FriendMapper;
import com.zjnu.mapper.UserMapper;
import com.zjnu.pojo.Friend;
import com.zjnu.pojo.User;
import com.zjnu.servece.FriendService;
import com.zjnu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class FriendServiceImpl implements FriendService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public User addFriend(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectByUsername(user);
        sqlSession.close();
        return user1;
    }

    @Override
    public List<Friend> selectAllByUser(Friend friend) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FriendMapper mapper = sqlSession.getMapper(FriendMapper.class);
        List<Friend> friends = mapper.selectAllByUser(friend);
        sqlSession.close();
        return friends;
    }


}
