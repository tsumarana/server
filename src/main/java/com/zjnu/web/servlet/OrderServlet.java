package com.zjnu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.zjnu.pojo.Order;
import com.zjnu.servece.OrderService;
import com.zjnu.servece.impl.OrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order/*")
public class OrderServlet extends BaseServlet{
    OrderService orderService = new OrderServiceImpl();

    public void selectSellerOrder(HttpServletRequest req , HttpServletResponse resp)throws IOException {
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        Order order = JSON.parseObject(s, Order.class);
        System.out.println(order);
        List<Order> orders = orderService.selectSellerOrder(order);
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(orders);
        resp.getWriter().write(jsonString);
    }
}
