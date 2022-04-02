package com.zjnu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.zjnu.pojo.Friend;
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
       System.out.println(trolleys);
       resp.setContentType("text/json;charset=utf-8");
       String jsonString = JSON.toJSONString(trolleys);
       resp.getWriter().write(jsonString);
   }
}
