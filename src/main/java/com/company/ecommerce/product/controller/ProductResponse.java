package com.company.ecommerce.product.controller;

public class ProductResponse {

    private int id;
    private String name;
    private String image;
    private float price;
    private float discount;
    private int totalStock;

    public ProductResponse() {
    }

    public ProductResponse(int id, String name, String image, float price, float discount, int totalStock) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.totalStock = totalStock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public float getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public int getTotalStock() {
        return totalStock;
    }
}
