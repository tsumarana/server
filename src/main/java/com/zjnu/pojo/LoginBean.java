package com.zjnu.pojo;

public class LoginBean {
    private String role;
    private String token;
    private String username;
    private int id;

    @Override
    public String toString() {
        return "LoginBean{" +
                "role='" + role + '\'' +
                ", token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LoginBean(String role, String token, String username, int id) {
        this.role = role;
        this.token = token;
        this.username = username;
        this.id = id;
    }

    public LoginBean() {
    }

    public LoginBean(String role, String token) {
        this.role = role;
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
