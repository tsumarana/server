package com.zjnu.servece;

import com.zjnu.pojo.Friend;
import com.zjnu.pojo.User;

import java.util.List;

public interface FriendService {
    public User addFriend(User user);
    public List<Friend> selectAllByUser(Friend friend);

}
