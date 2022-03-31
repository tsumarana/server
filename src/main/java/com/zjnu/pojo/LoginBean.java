package com.zjnu.pojo;

public class LoginBean {
    private String role;
    private String token;

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

    @Override
    public String toString() {
        return "LoginBean{" +
                "role='" + role + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
