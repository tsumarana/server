package com.zjnu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjnu.pojo.Friend;
import com.zjnu.pojo.Goods;
import com.zjnu.pojo.Trolley;
import com.zjnu.pojo.User;
import com.zjnu.servece.FriendService;
import com.zjnu.servece.TrolleyService;
import com.zjnu.servece.impl.FriendServiceImpl;
import com.zjnu.servece.impl.TrolleyServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/trolley/*")
public class TrolleyServlet extends BaseServlet{
    TrolleyService trolleyService = new TrolleyServiceImpl();
   public void selectTrolley(HttpServletRequest req,HttpServletResponse resp) throws IOException{
       req.setCharacterEncoding("utf-8");
       String s = req.getReader().readLine();
       Trolley trolley = JSON.parseObject(s, Trolley.class);
       List<Trolley> trolleys = trolleyService.selectTrolley(trolley);
       resp.setContentType("text/json;charset=utf-8");
       String jsonString = JSON.toJSONString(trolleys);
       resp.getWriter().write(jsonString);
   }
   //删除
   public void deleteTrolley(HttpServletRequest req ,HttpServletResponse resp) throws IOException{
       req.setCharacterEncoding("utf-8");
       String s = req.getReader().readLine();
       Trolley trolley = JSON.parseObject(s, Trolley.class);
       trolleyService.deleteTrolley(trolley);
   }
   //保存数量
   public void saveCount(HttpServletRequest req,HttpServletResponse resp) throws IOException{
       req.setCharacterEncoding("utf-8");
       String s = req.getReader().readLine();
       List<Trolley> trolleys = JSON.parseArray(s, Trolley.class);
       System.out.println(trolleys);
       trolleys.size();
       for(Trolley trolley : trolleys){
            trolleyService.saveCount(trolley);
       }
   }
   //添加到购物车
   public void addTrolley(HttpServletRequest req,HttpServletResponse resp) throws IOException{
       req.setCharacterEncoding("utf-8");
       String s = req.getReader().readLine();
       System.out.println(s);
       Goods goods = JSON.parseObject(s, Goods.class);
       Trolley trolley = new Trolley();
       System.out.println(goods);
       trolley.setPrice(String.valueOf(goods.getPrice()));
       trolley.setBrandId(goods.getId());
       trolley.setSeller(goods.getSeller());
       trolley.setName(goods.getTitle());
       trolley.setUsername(goods.getUsername());
       trolleyService.addTrolley(trolley);
   }

}
