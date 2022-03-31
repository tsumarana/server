package com.zjnu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.zjnu.pojo.Friend;
import com.zjnu.pojo.User;
import com.zjnu.servece.FriendService;
import com.zjnu.servece.impl.FriendServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/filter/*")
public class AuthorizationServlet extends BaseServlet{

    public void tokenCheck(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        User user = JSON.parseObject(s, User.class);
        String response = "username="+user.getUsername()+"\npassword="+user.getPassword();
        System.out.println(response);
        resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(response);
    }

}
