package com.example.monitorlizard;

import java.time.LocalDateTime;
import java.util.ArrayList;

//Template for user created meals containing a name, time, and list of items. With constructors
//for meals made by user and meals loaded from meals.json
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

    //Updates mealItem at specified index.
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
