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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal);

        etMealName = findViewById(R.id.etMealName);
        rvItemList = findViewById(R.id.rvItemList);
        btnAddItem = findViewById(R.id.btnAddItem);
        btnSaveMeal = findViewById(R.id.btnSaveMeal);

        btnAddItem.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), NewMealItem.class);
            startActivity(intent);
        });



    }

}