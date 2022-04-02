package com.zjnu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjnu.pojo.LoginBean;
import com.zjnu.pojo.PageBean;
import com.zjnu.pojo.User;
import com.zjnu.servece.UserService;
import com.zjnu.servece.impl.UserServiceImpl;
import com.zjnu.util.GenerateToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
    private UserService userService = new UserServiceImpl();
    private GenerateToken generateToken = new GenerateToken();
    //校验用户名密码生成token
    public void selectUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        String string = reader.readLine();
        LoginBean loginBean = new LoginBean();
        String id = req.getSession().getId();
        User user = JSON.parseObject(string,User.class);
        User user1 = userService.selectUser(user);
        resp.setContentType("text/json;charset=utf-8");
        if(user1 != null ) {
            //生产token
            String generate = generateToken.generate(id, String.valueOf(user1.getId()),user1.getUsername(), user1.getVip());
            user1.setToken(generate);
            userService.addToken(user1);
            //写数据
            if(user1.getVip().trim().equals("1")) {
                loginBean.setRole("1011");

            }
            else{
                loginBean.setRole("1012");
            }
            loginBean.setUsername(user1.getUsername());
            loginBean.setId(user1.getId());
            loginBean.setToken(generate);
            loginBean.setImg(user1.getImg());
        }else{
            loginBean.setRole("1013");
        }
        String s = JSON.toJSONString(loginBean);
        resp.getWriter().write(s);
    }

    public void exit(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        User user = JSON.parseObject(s, User.class);
        userService.cleanToken(user);
    }

    public void selectUserByUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        String string = reader.readLine();
        User user = JSON.parseObject(string,User.class);
        String checkCode = JSONObject.parseObject(string).getString("check");
        HttpSession session = req.getSession();
        String checkCode_re = (String) session.getAttribute("checkCode");
        if(checkCode != "" && checkCode_re!="" && checkCode_re!= null && checkCode != null){
            checkCode = checkCode.toUpperCase().trim();
            checkCode_re = checkCode_re.trim();

        }
//        boolean flag = checkCode.equals(checkCode_re);
        boolean flag = true;
        if(flag && userService.selectUserByUserInfo(user) == null ){
            userService.insertUser(user);
            resp.getWriter().write("success");
        }
        else {
            resp.getWriter().write("fail");
        }
    }
    //分页查询用户
    public void selectUserByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        User user = JSON.parseObject(s, User.class);

        PageBean<User> pageBean = userService.selectUserByPage(user,currentPage, pageSize);
        //转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    //通过id删除
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        String string = reader.readLine();
        User user = JSON.parseObject(string, User.class);
        userService.deleteByID(user);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }
    //检查缓存
    public void checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        resp.setContentType("text/json;charset=utf-8");
        if(user != null ){
            String jsonString = JSON.toJSONString(user);
            resp.getWriter().write(jsonString);
        }
        else {
            resp.getWriter().write("false");
        }
    }
    //清楚缓存
    public void cleanSession(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        HttpSession session = req.getSession();
        session.setAttribute("user",null);
    }
    //根据id查找用户
    public void selectUserById(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println(s);
        User _user = JSON.parseObject(s, User.class);
        User user = userService.selectUserById(_user);
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(user);
        resp.getWriter().write(jsonString);
    }
    //通过用户名查找用户
    public void selectUserByUsername(HttpServletRequest req ,HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        User user = JSON.parseObject(s, User.class);
        User user1 = userService.selectUserByUsername(user);
        String jsonString = JSON.toJSONString(user1);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    //修改用户信息
    public void alterUserInfo(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        System.out.println(s);
        User user = JSON.parseObject(s, User.class);
        userService.alterUserInfo(user);
    }

    public void logoffUser(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        System.out.println(s);
        User user = JSON.parseObject(s, User.class);
        userService.logoffUser(user);
    }
}
