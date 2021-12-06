package com.example.monitorlizard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    private int currentMeal = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_item_list);

        rvItemList = findViewById(R.id.rvItemList);
        tvMealName = findViewById(R.id.tvMealName);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String mealTime = bundle.getString("mealTime");

        currentMeal = MealsHolder.findMeal(mealTime);

        tvMealName.setText(MealsHolder.meals.get(MealsHolder.findMeal(mealTime)).getMealName());

        rvItemList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        MealItemListAdapter mealItemListAdapter = new MealItemListAdapter(MealItemList.this, mealTime);
        rvItemList.setAdapter(mealItemListAdapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();


        setContentView(R.layout.activity_meal_item_list);

        rvItemList = findViewById(R.id.rvItemList);
        tvMealName = findViewById(R.id.tvMealName);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String mealTime = bundle.getString("mealTime");

        currentMeal = MealsHolder.findMeal(mealTime);

        tvMealName.setText(MealsHolder.meals.get(MealsHolder.findMeal(mealTime)).getMealName());

        rvItemList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        MealItemListAdapter mealItemListAdapter = new MealItemListAdapter(MealItemList.this, mealTime);
        rvItemList.setAdapter(mealItemListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete_menu, menu);

        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addItem:
                Intent intent = new Intent(getApplicationContext(), NewMealItem.class);
                intent.putExtra("mealTime", MealsHolder.meals.get(currentMeal).getMealTime().toString());
                startActivity(intent);
                return true;
            case R.id.delete:
                MealsHolder.meals.remove(currentMeal);
                MealsHolder.writeToFile("meals.json", MealsHolder.toJSON(), getApplicationContext());
                Toast.makeText(this, "Meal Deleted", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}