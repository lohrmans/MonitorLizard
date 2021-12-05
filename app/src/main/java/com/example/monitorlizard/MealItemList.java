package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.FileOwnerAttributeView;

public class MealItemList extends AppCompatActivity {

    RecyclerView rvItemList;
    TextView tvMealName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_item_list);

        rvItemList = findViewById(R.id.rvItemList);
        tvMealName = findViewById(R.id.tvMealName);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String mealTime = bundle.getString("mealTime");

        tvMealName.setText(MealsHolder.meals.get(MealsHolder.findMeal(mealTime)).getMealName());

        rvItemList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        MealItemListAdapter mealItemListAdapter = new MealItemListAdapter(MealItemList.this, mealTime);
        rvItemList.setAdapter(mealItemListAdapter);
    }
}