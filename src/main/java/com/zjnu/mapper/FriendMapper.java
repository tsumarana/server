package com.zjnu.mapper;

import com.zjnu.pojo.Friend;
import org.apache.ibatis.annotations.*;

import java.io.FileReader;
import java.util.List;
public interface FriendMapper {
    //查询所有
    @ResultMap("friendResultMap")
    @Select("select friend_name,img from tb_friend where user_name = #{username}")
    List<Friend> selectAllByUser(Friend friend);

    @ResultMap("friendResultMap")
    @Insert("insert into tb_friend  values (null,#{friendname},1,#{username},#{img})")
    void addFriend(Friend friend);
}
