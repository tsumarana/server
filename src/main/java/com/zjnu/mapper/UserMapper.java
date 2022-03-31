package com.zjnu.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import com.zjnu.pojo.User;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();
    //login校验
    User selectUser(User user);

    User selectUserByUserInfo(User user);
    void insertUser(User user);

    @ResultMap("userResultMap")
    @Select("select * from tb_user limit #{begin}, #{size}")
    List<User> selectUserByPage(@Param("begin") int begin, @Param("size") int size);

    @Select("select count(*) from tb_user")
    int selectTotalCount();

    @Delete("delete from tb_user where id = #{id} ")
    void deleteById(User user);

    User selectByUsername(User user);

    @ResultMap("userResultMap")
    void alterUserInfo(User user);

    @ResultMap("userResultMap")
    @Select(" select token,vip from tb_user where user_name = #{username}")
    User selectTokenByUsername(User user);

    @ResultMap("userResultMap")
    void addToken(User user);

    @ResultMap("userResultMap")
    @Select("select user_name from tb_user where id = #{id}")
    User selectUserById(User user);
}
