package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MealList extends AppCompatActivity implements Serializable {

    RecyclerView rvMealList;

    //Maybe move to onCreate
    ArrayList<Meal> meals;

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list);

        rvMealList = findViewById(R.id.rvMealList);


        meals = (ArrayList<Meal>) getIntent().getSerializableExtra("meals");


        rvMealList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));





    }



}