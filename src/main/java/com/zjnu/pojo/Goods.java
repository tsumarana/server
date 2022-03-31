package com.zjnu.pojo;

public class Goods {
    private Integer id;
    private String title;
    private Integer price;
    private Integer grade;
    private String type;
    private Integer accountGrade;
    private String decorate;
    private String rank;
    private boolean adult;
    private String seller;

    public Goods() {
    }

    public Goods(Integer id, String title, Integer price, Integer grade, String type, Integer accountGrade, String decorate, String rank, boolean adult, String seller) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.grade = grade;
        this.type = type;
        this.accountGrade = accountGrade;
        this.decorate = decorate;
        this.rank = rank;
        this.adult = adult;
        this.seller = seller;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAccountGrade() {
        return accountGrade;
    }

    public void setAccountGrade(Integer accountGrade) {
        this.accountGrade = accountGrade;
    }

    public String getDecorate() {
        return decorate;
    }

    public void setDecorate(String decorate) {
        this.decorate = decorate;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", grade=" + grade +
                ", type='" + type + '\'' +
                ", accountGrade=" + accountGrade +
                ", decorate='" + decorate + '\'' +
                ", rank='" + rank + '\'' +
                ", adult=" + adult +
                ", seller='" + seller + '\'' +
                '}';
    }
}
