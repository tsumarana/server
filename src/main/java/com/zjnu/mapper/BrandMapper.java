package com.zjnu.mapper;

import com.zjnu.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    //查询所有
    @ResultMap("brandResultMap")
    @Select("select * from tb_brand")
    List<Brand> selectAll();
    //新增
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);
    //通过id删除
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(Brand brand);
    //分页查询
    @ResultMap("brandResultMap")
    @Select("select * from tb_brand limit #{begin}, #{size}")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);
    //数目查询
    @Select("select count(*) from tb_brand")
    int selectTotalCount();
    //分页条件查询
    @ResultMap("brandResultMap")
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);
    //数目查询
    int selectTotalCountByCondition(Brand brand);
}
