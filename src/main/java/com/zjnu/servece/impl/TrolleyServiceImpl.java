package com.zjnu.servece.impl;

import com.zjnu.mapper.TrolleyMapper;
import com.zjnu.pojo.Trolley;
import com.zjnu.servece.TrolleyService;
import com.zjnu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TrolleyServiceImpl implements TrolleyService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Trolley> selectTrolley(Trolley trolley) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TrolleyMapper mapper = sqlSession.getMapper(TrolleyMapper.class);
        List<Trolley> trolleys = mapper.selectTrolley(trolley);
        sqlSession.close();
        return trolleys;
    }
}
