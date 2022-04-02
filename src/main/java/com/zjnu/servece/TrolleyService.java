package com.zjnu.servece;

import com.zjnu.pojo.Trolley;

import java.util.List;

public interface TrolleyService {
    //查询购物车
    List<Trolley> selectTrolley(Trolley trolley);
    //删除购物车
    void deleteTrolley(Trolley trolley);
    //保存数量
    void saveCount(Trolley trolley);
    //新增
    void addTrolley(Trolley trolley);
}
