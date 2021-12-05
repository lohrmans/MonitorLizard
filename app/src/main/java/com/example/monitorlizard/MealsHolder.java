package com.example.monitorlizard;

import android.content.Context;
import android.util.JsonReader;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MealsHolder {
    //This feels like bad practice here, but I am short on time and I'm pretty confident it will work,
    //so here we are.
    public static ArrayList<Meal> meals = new ArrayList<>();

    public static String newMealTimeString = "";

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

    public static String toJSON(){
        try {
            JSONObject mealsObject = new JSONObject();
            JSONArray mealsArray = new JSONArray();

            for(int i = 0; i < meals.size(); i++) {
                JSONObject meal = new JSONObject();
                meal.put("mealName", meals.get(i).getMealName());
                meal.put("mealTime", meals.get(i).getMealTime().toString());
                JSONArray mealItems = new JSONArray();
                for(int j = 0; j < meals.get(i).getMealItems().size(); j++) {
                    JSONObject mealItem = new JSONObject();
                    mealItem.put("mealItemName", meals.get(i).getMealItems().get(j).getItemName());
                    mealItem.put("mealItemQuantity", meals.get(i).getMealItems().get(j).getItemQuantity());
                    mealItem.put("mealItemUnits", meals.get(i).getMealItems().get(j).getItemUnits());
                    mealItems.put(mealItem);
                }
                meal.put("mealItems", mealItems);
                mealsArray.put(meal);
            }

            mealsObject.put("meals", mealsArray);



            return mealsObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void parseJSON(String data) {
        ArrayList<Meal>jSONmeals = new ArrayList<>();

        try {
            JSONObject jsonData = new JSONObject(data);
            JSONArray mealsArray = jsonData.getJSONArray("meals");


            for(int i = 0; i < mealsArray.length(); i++) {
                ArrayList<MealItem>mealItems = new ArrayList<>();
                JSONObject jsonMeal = mealsArray.getJSONObject(i);
                String mealName = jsonMeal.getString("mealName");
                String mealTime = jsonMeal.getString("mealTime");
                JSONArray mealItemsArray = jsonMeal.getJSONArray("mealItems");
                for (int j = 0; j < mealItemsArray.length(); j++) {
                    JSONObject jsonMealItem = mealItemsArray.getJSONObject(j);
                    String mealItemName = jsonMealItem.getString("mealItemName");
                    String mealItemQuantity = jsonMealItem.getString("mealItemQuantity");
                    String mealItemUnits = jsonMealItem.getString("mealItemUnits");

                    MealItem mealItemObject = new MealItem(mealItemName, mealItemQuantity, mealItemUnits);
                    mealItems.add(mealItemObject);
                }

                Meal mealObject = new Meal(mealName, LocalDateTime.parse(mealTime), mealItems);
                jSONmeals.add(mealObject);
            }

            meals = jSONmeals;

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFile(String fileName, String content, Context context) {
        File path = context.getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(content.getBytes());
            writer.close();
            Toast.makeText(context.getApplicationContext(), "Wrote to file " + fileName, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName, Context context) {
        File path = context.getApplicationContext().getFilesDir();
        File readFrom = new File(path, fileName);
        byte[] content = new byte[(int)readFrom.length()];
        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(content);
            return new String(content);
        } catch (IOException e) {
            e.printStackTrace();

            return e.toString();
        }
    }

}
