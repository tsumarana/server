package com.zjnu.pojo;

public class Friend {
    private String id;
    private String username;
    private String friendname;
    private  String img;
    private boolean status;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", friendname='" + friendname + '\'' +
                ", img='" + img + '\'' +
                ", status=" + status +
                '}';
    }

    public Friend(String id, String username, String friendname, String img, boolean status) {
        this.id = id;
        this.username = username;
        this.friendname = friendname;
        this.img = img;
        this.status = status;
    }

    public Friend() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFriendname() {
        return friendname;
    }

    public void setFriendname(String friendname) {
        this.friendname = friendname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
