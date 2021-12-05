package com.example.monitorlizard;

import java.util.ArrayList;

public class MealsHolder {
    //This feels like bad practice here, but I am short on time and I'm pretty confident it will work,
    //so here we are.
    public static ArrayList<Meal> meals = new ArrayList<>();

    public static int findMeal(String mealTime) {
        int mealIndex = -1;
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).getMealTime().toString().equals(mealTime)) {
                mealIndex = i;
                break;
            }
        }
        return mealIndex;
    }

    //findMeal passing as extra needed on:
    //NewMeal ADD ITEM, LIST OF ITEMS
    //MealList LIST OF MEALS
    //NewMealItem SAVE ITEM

}
