package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

//MealList shows list of meals user has created
public class MealList extends AppCompatActivity {

    RecyclerView rvMealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list);

        //Hooking up adapter to this activity
        rvMealList = findViewById(R.id.rvMealList);

        rvMealList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        MealListAdapter mealListAdapter = new MealListAdapter(MealList.this);
        rvMealList.setAdapter(mealListAdapter);
    }

    //onRestart is used again here to update the recyclerView when this activity is restarted.
    @Override
    protected void onRestart() {
        super.onRestart();

        setContentView(R.layout.activity_meal_list);

        rvMealList = findViewById(R.id.rvMealList);

        rvMealList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        MealListAdapter mealListAdapter = new MealListAdapter(MealList.this);
        rvMealList.setAdapter(mealListAdapter);
    }
}