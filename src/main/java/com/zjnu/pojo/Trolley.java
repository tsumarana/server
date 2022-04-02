package com.zjnu.pojo;

public class Trolley {
    private int id;
    private int brandId;
    private String name;
    private String count;
    private String price;
    private String username;

    public Trolley() {
    }

    public Trolley(int id, int brandId, String name, String count, String price, String username) {
        this.id = id;
        this.brandId = brandId;
        this.name = name;
        this.count = count;
        this.price = price;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Trolley{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                ", price='" + price + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
