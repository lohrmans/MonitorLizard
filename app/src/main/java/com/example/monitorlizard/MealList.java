package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MealList extends AppCompatActivity {

    RecyclerView rvMealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list);

        rvMealList = findViewById(R.id.rvMealList);

        rvMealList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //Create new local arraylist copy
        //Need to change parameters to what I am passing to view in holder in adapter class
        MealListAdapter mealListAdapter = new MealListAdapter(MealList.this);
        rvMealList.setAdapter(mealListAdapter);







    }



}