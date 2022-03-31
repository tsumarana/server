package com.zjnu.servece;

import com.zjnu.pojo.Brand;
import com.zjnu.pojo.Goods;
import com.zjnu.pojo.PageBean;

import java.util.List;

public interface GoodsService {
    public Goods selectInfo(int id);

    PageBean<Goods> selectByPage(int currentPage, int pageSize);

    PageBean<Goods> selectByPageAndCondition(int currentPage, int pageSize, Goods _goods);

    Goods selectById(int id);

    void addGoods(Goods goods);

    void deleteById(Goods goods);
}
