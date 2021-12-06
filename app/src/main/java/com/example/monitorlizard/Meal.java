package com.example.monitorlizard;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Meal {

    private String mealName;

    private LocalDateTime mealTime;

    private ArrayList<MealItem> mealItems;

    public Meal(String mealName, LocalDateTime mealTime, ArrayList<MealItem> mealItems) {
        this.mealName = mealName;
        this.mealTime = mealTime;
        this.mealItems = mealItems;
    }

    public Meal(String mealName) {
        this.mealName = mealName;
        this.mealTime = LocalDateTime.now();
        mealItems = new ArrayList<>();
    }

    public void editMealItem(int mealItemIndex, MealItem mealItem) {
        mealItems.set(mealItemIndex, mealItem);
    }

    public void deleteMealItem(int mealItemIndex) {
        mealItems.remove(mealItemIndex);
    }

    public void addMealItem(MealItem mealItem) {
        mealItems.add(mealItem);
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
