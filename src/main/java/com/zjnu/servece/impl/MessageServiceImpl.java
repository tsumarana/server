package com.zjnu.servece.impl;

import com.zjnu.mapper.MessageMapper;
import com.zjnu.pojo.Message;
import com.zjnu.servece.MessageService;
import com.zjnu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Message> selectMessage(Message message) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        List<Message> messages = mapper.selectMessage(message);
        sqlSession.close();
        return messages;
    }

    @Override
    public void addMessage(Message message) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        mapper.addMessage(message);
        sqlSession.commit();
        sqlSession.close();
    }
}
