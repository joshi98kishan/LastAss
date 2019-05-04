package com.example.android.lastass;
public class Dish {
    private int dishImageId;
    private String dishName;
    private int dishPrice;
    public Dish(int dishId, String dishName, int dishPrice){
        this.dishImageId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }
    public int getDishImageId() {
        return dishImageId;
    }
    public String getDishName() {
        return dishName;
    }
    public int getDishPrice() {
        return dishPrice;
    }
}
