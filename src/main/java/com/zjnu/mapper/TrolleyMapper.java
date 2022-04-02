package com.zjnu.mapper;

import com.zjnu.pojo.Friend;
import com.zjnu.pojo.Trolley;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TrolleyMapper {
    @Select("select * from tb_trolley where username = #{username}")
    List<Trolley> selectTrolley(Trolley trolley);
}
