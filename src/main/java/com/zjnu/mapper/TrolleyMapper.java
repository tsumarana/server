package com.zjnu.mapper;

import com.zjnu.pojo.Friend;
import com.zjnu.pojo.Trolley;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TrolleyMapper {
    @ResultMap("trolleyResultMap")
    @Select("select * from tb_trolley where username = #{username}")
    List<Trolley> selectTrolley(Trolley trolley);

    @Delete("delete from tb_trolley where id = #{id}")
    void deleteTrolley(Trolley trolley);

    @Update("update tb_trolley set count = #{count} where id = #{id}")
    void saveCount(Trolley trolley);
    //新增
    @ResultMap("trolleyResultMap")
    @Insert("insert into tb_trolley values (null,#{brandId},#{name},1,#{username},#{price},#{seller})")
    void addTrolley(Trolley trolley);
}
