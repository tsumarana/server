package com.zjnu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjnu.pojo.Verify;
import com.zjnu.util.CheckCodeUtil;
import org.apache.axis.encoding.Base64;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        ServletOutputStream outputStream = resp.getOutputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Verify verify = CheckCodeUtil.outputVerifyImage(100, 50, outputStream, 4);
        BufferedImage image = verify.getImage();
        ImageIO.write(image, "png", outputStream);
        String encode = Base64.encode(outputStream.toByteArray());
        encode ="data:image/jpg;base64,"+encode;
        verify.setOp(encode);
        verify.setImage(null);
        String checkcode = verify.getVerifyCode();
        System.out.println(checkcode);
        session.setAttribute("checkCode",checkcode);
        String jsonString = JSON.toJSONString(verify);
        resp.getWriter().write(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
