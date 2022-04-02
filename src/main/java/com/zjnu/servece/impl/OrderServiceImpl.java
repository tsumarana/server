package com.zjnu.servece.impl;

import com.zjnu.mapper.OrderMapper;
import com.zjnu.pojo.Order;
import com.zjnu.servece.OrderService;
import com.zjnu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Order> selectSellerOrder(Order order) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = mapper.selectSellerOrder(order);
        sqlSession.close();
        return orders;
    }
}
