package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class NewMealItem extends AppCompatActivity {

    Button btnSaveItem;
    EditText etItemName, etItemQuantity, etItemUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal_item);

        etItemName = findViewById(R.id.etItemName);
        etItemQuantity = findViewById(R.id.etItemQuantity);
        etItemUnits = findViewById(R.id.etItemUnits);

        btnSaveItem = findViewById(R.id.btnSaveItem);

        //Break out into method
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String mealTime = bundle.getString("mealTime");
        int mealIndex = MealsHolder.findMeal(mealTime);

        if (bundle.getString("itemName") != null) {
            etItemName.setText(bundle.getString("itemName"));
            etItemQuantity.setText(bundle.getString("itemQuantity"));
            etItemUnits.setText(bundle.getString("itemUnits"));

            int mealItemIndex = bundle.getInt("itemPosition");

            btnSaveItem.setText("Edit");

            btnSaveItem.setOnClickListener(v -> {
                if (etItemName.getText().toString().isEmpty() ||
                        etItemUnits.getText().toString().isEmpty() ||
                        etItemQuantity.toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please enter all fields.", Toast.LENGTH_SHORT).show();

                } else {
                    MealItem newMealItem = new MealItem(etItemName.getText().toString(),
                            etItemUnits.getText().toString(), etItemQuantity.getText().toString());
                    MealsHolder.meals.get(mealIndex).editMealItem(mealItemIndex, newMealItem);

                    finish();
                }
            });

        } else {

            btnSaveItem.setText("Save");

            btnSaveItem.setOnClickListener(v -> {
                if (etItemName.getText().toString().isEmpty() ||
                        etItemUnits.getText().toString().isEmpty() ||
                        etItemQuantity.toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please enter all fields.", Toast.LENGTH_SHORT).show();

                } else {
                    MealItem newMealItem = new MealItem(etItemName.getText().toString(),
                            etItemUnits.getText().toString(), etItemQuantity.getText().toString());
                    MealsHolder.meals.get(mealIndex).addMealItem(newMealItem);

                    finish();
                }
            });
        }
    }



}