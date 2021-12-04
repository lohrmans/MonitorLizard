package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

public class MealList extends AppCompatActivity implements Serializable {

    RecyclerView rvMealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list);

        rvMealList = findViewById(R.id.rvMealList);

        rvMealList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



    }



}