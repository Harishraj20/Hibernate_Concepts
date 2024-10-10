package com.hibernate;

public class product {

    private int id;
    private String name;
    private String brand;
    private double price;
    private double discountPercent;
    private int totalQuantity;

    // Default constructor
    public product() {

    }

    public product(String brand, double discountPercent, String name, double price, int totalQuantity) {
        this.brand = brand;
        this.discountPercent = discountPercent;
        this.name = name;
        this.price = price;
        this.totalQuantity = totalQuantity;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

}
