package com.zjnu.mapper;

import com.zjnu.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsMapper {
    @ResultMap("goodsResultMap")
    @Select("select * from tb_goods where id = #{id}")
    Goods selectInfo(int id);

    //查询所有
    @ResultMap("goodsResultMap")
    @Select("select * from tb_goods")
    List<Goods> selectAll();
    //新增
    @ResultMap("goodsResultMap")
    @Insert("insert into tb_goods values(null,#{title},#{price},#{grade},#{type},#{accountGrade},#{decorate},#{rank},#{adult},#{seller})")
    void addGoods(Goods goods);
    //通过id删除
    @Delete("delete from tb_goods where id = #{id}")
    void deleteById(Goods goods);
    //通过id查找
    @ResultMap("goodsResultMap")
    @Select("select * from tb_goods where id = #{id}")
    Goods selectById(int id);
    //分页查询
    @ResultMap("goodsResultMap")
    @Select("select * from tb_goods limit #{begin}, #{size}")
    List<Goods> selectByPage(@Param("begin") int begin,@Param("size") int size);
    //数目查询
    @Select("select count(*) from tb_goods")
    int selectTotalCount();

    //分页条件查询
    @ResultMap("goodsResultMap")
    List<Goods> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("goods") Goods goods);

    //数目查询
    int selectTotalCountByCondition(Goods goods);
}
