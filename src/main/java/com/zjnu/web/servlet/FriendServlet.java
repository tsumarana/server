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

@WebServlet("/friend/*")
public class FriendServlet extends BaseServlet{
    FriendService  friendService= new FriendServiceImpl();
    //目前先为通过名字查找全部用户
    public void addFriend(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        System.out.println(s);
        User user = JSON.parseObject(s, User.class);
        System.out.println(user);
        User user1 = friendService.addFriend(user);
        System.out.println(user1);
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(user1);
        resp.getWriter().write(jsonString);

    }
    //获取所有用户好友关系列表
    public void selectList(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        System.out.println(s);
        Friend friend = JSON.parseObject(s, Friend.class);
        List<Friend> friends = friendService.selectAllByUser(friend);
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(friends);
        resp.getWriter().write(jsonString);
    }

    //添加好友
    public void makeFriend(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        Friend friend = JSON.parseObject(s, Friend.class);
        friendService.addFriend(friend);
        String username = friend.getUsername();
        friend.setUsername(friend.getFriendname());
        friend.setFriendname(username);
        friend.setImg(friend.getMyImg());
        friendService.addFriend(friend);
    }

}
