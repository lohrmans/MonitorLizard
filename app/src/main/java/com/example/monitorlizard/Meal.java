package com.example.monitorlizard;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Meal {

    private String mealName;

    private LocalDateTime mealTime;

    private ArrayList<MealItem> mealItems;

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
