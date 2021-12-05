package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class NewMeal extends AppCompatActivity {

    EditText etMealName;
    RecyclerView rvItemList;
    Button btnAddItem, btnSaveMeal;

    private boolean isNewMeal = true;
    private String mealTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal);

        etMealName = findViewById(R.id.etMealName);
        rvItemList = findViewById(R.id.rvItemList);
        btnAddItem = findViewById(R.id.btnAddItem);
        btnSaveMeal = findViewById(R.id.btnSaveMeal);

        btnAddItem.setOnClickListener(v -> {
            if (etMealName.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter meal name.", Toast.LENGTH_SHORT).show();
            } else {
                if (!isNewMeal) {
                    Intent intent = new Intent(v.getContext(), NewMealItem.class);
                    intent.putExtra("mealTime", mealTime);
                    startActivity(intent);
                } else {
                    Meal newMeal = new Meal(etMealName.getText().toString());
                    MealsHolder.meals.add(newMeal);

                    Intent intent = new Intent(v.getContext(), NewMealItem.class);
                    intent.putExtra("mealTime", newMeal.getMealTime().toString());
                    mealTime = newMeal.getMealTime().toString();
                    isNewMeal = false;
                    startActivity(intent);
                }
            }
        });

    }

}