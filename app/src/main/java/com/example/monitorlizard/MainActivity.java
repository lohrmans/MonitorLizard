package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {

    private Button btnNewMeal, btnViewMeals;

    private ArrayList<Meal> meals = null;
    private ArrayList<MealItem> mealItems = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewMeal = findViewById(R.id.btnNewMeal);
        btnViewMeals = findViewById(R.id.btnViewMeals);

        parseJSON(readFromFile("file.json"));

        writeToFile("file.json", "Spoot");

        btnNewMeal.setOnClickListener(v -> {
            //startActivity(new Intent(MainActivity.this, NewMeal.class));
            Intent intent = new Intent(v.getContext(), NewMeal.class);
            startActivity(intent);
        });

        btnViewMeals.setOnClickListener(v -> {
            //startActivity(new Intent(MainActivity.this, MealList.class));
            Intent intent = new Intent(v.getContext(), MealList.class);
            intent.putExtra("meals", meals);
            startActivity(intent);
        });

    }

    private void writeToFile(String fileName, String content) {
        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(content.getBytes());
            writer.close();
            Toast.makeText(getApplicationContext(), "Wrote to file " + fileName, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile(String fileName) {
        File path = getApplicationContext().getFilesDir();
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

    private void parseJSON(String data) {
        meals = new ArrayList<>();

        try {
            JSONObject jsonData = new JSONObject(data);
            JSONArray mealsArray = jsonData.getJSONArray("meals");
            //Log.d("MEALS", mealsArray.toString());

            for(int i = 0; i < mealsArray.length(); i++) {
                mealItems = new ArrayList<>();
                JSONObject jsonMeal = mealsArray.getJSONObject(i);
                String mealName = jsonMeal.getString("mealName");
                String mealTime = jsonMeal.getString("mealTime");
                //Change all JSON keys to underscores instead of camel case  mealItemName, mealItemQuantity, mealItemUnits
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
                meals.add(mealObject);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



}

