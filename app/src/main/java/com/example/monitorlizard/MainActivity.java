package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {

    private Button btnNewMeal, btnViewMeals;

    private ArrayList<Meal> meals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewMeal = findViewById(R.id.btnNewMeal);
        btnViewMeals = findViewById(R.id.btnViewMeals);

        writeToFile("file.json", "Spoot");
        Toast.makeText(getApplicationContext(), readFromFile("file.json"), Toast.LENGTH_LONG).show();

        btnNewMeal.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NewMeal.class));
        });

        btnViewMeals.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MealList.class));
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





}

