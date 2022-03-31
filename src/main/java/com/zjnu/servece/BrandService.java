package com.zjnu.servece;

import com.zjnu.pojo.Brand;
import com.zjnu.pojo.PageBean;

import java.util.List;

public interface BrandService {
    //查询所有
    List<Brand> selectAll();
    void add(Brand brand);
    void deletedById(Brand brand);
    PageBean<Brand> selectByPage(int currentPage,int pageSize);
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);
}
