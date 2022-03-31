package com.zjnu.mapper;

import com.zjnu.pojo.Friend;
import com.zjnu.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {
    @ResultMap("messageResultMap")
    @Select("select * from tb_message where (from_name = #{fromName} and to_name = #{toName}) OR (from_name = #{toName} and to_name = #{fromName})")
    List<Message> selectMessage(Message message);

    @ResultMap("messageResultMap")
    @Insert("insert into tb_message values (null,#{fromName},#{toName},#{time},#{message})")
    void addMessage(Message message);
}
