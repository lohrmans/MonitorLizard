package com.example.monitorlizard;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Meal implements Serializable {

    private String mealName;

    private LocalDateTime mealTime;

    private ArrayList<MealItem> mealItems;

    public Meal(String mealName, LocalDateTime mealTime, ArrayList<MealItem> mealItems) {
        this.mealName = mealName;
        this.mealTime = mealTime;
        this.mealItems = mealItems;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public ArrayList<MealItem> getMealItems() {
        return mealItems;
    }

    public void setMealItems(ArrayList<MealItem> mealItems) {
        this.mealItems = mealItems;
    }

    public LocalDateTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(LocalDateTime mealTime) {
        this.mealTime = mealTime;
    }
}
