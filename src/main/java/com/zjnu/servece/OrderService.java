package com.zjnu.servece;

import com.zjnu.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> selectSellerOrder(Order order);
}
