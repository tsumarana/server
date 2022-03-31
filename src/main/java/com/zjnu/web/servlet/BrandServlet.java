package com.zjnu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.zjnu.pojo.Brand;
import com.zjnu.pojo.PageBean;
import com.zjnu.servece.BrandService;
import com.zjnu.servece.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();
        //转为JSON
        String jsonString = JSON.toJSONString(brands);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void Add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        String param = reader.readLine();
        Brand brand = JSON.parseObject(param, Brand.class);
        brandService.add(brand);
        resp.getWriter().write("success");
    }
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        String param = reader.readLine();
        Brand brand = JSON.parseObject(param, Brand.class);
        brandService.deletedById(brand);
        resp.getWriter().write("success");
    }
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        //转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);

        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage,pageSize,brand);
        //转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
