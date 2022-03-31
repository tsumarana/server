package com.zjnu.web.servlet;
import com.alibaba.fastjson.JSON;
import com.zjnu.pojo.Message;
import com.zjnu.servece.MessageService;
import com.zjnu.servece.impl.MessageServiceImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/message/*")
public class MessageServlet extends BaseServlet{
    MessageService messageService = new MessageServiceImpl();
    //获取消息列表
    public void selectMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        Message message = JSON.parseObject(s, Message.class);
        List<Message> messages = messageService.selectMessage(message);
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(messages);
        resp.getWriter().write(jsonString);
    }
    //加入消息
    public void addMessage(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        Message message = JSON.parseObject(s, Message.class);
        messageService.addMessage(message);
    }
}
