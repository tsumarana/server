package com.zjnu.mapper;

import com.zjnu.pojo.Friend;
import com.zjnu.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    //查询所有
    @ResultMap("orderResultMap")
    @Select("select * from tb_order where seller =#{seller}")
    List<Order> selectSellerOrder(Order order);
}
