package com.example.monitorlizard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

//Activity for adding and editing meal items
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

        //Gets information on meal item that was pressed
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String mealTime = bundle.getString("mealTime");
        int mealIndex = MealsHolder.findMeal(mealTime);

        //Sets editTexts if item was information was passed in bundle and changes button to edit
        if (bundle.getString("itemName") != null) {
            etItemName.setText(bundle.getString("itemName"));
            etItemQuantity.setText(bundle.getString("itemQuantity"));
            etItemUnits.setText(bundle.getString("itemUnits"));

            int mealItemIndex = bundle.getInt("itemPosition");

            btnSaveItem.setText(R.string.edit);

            //Updates meal item if all fields are entered
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

            //Saves new item
        } else {

            btnSaveItem.setText(R.string.save);

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

    //Adds option menu for deleting only if item already exists
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(btnSaveItem.getText().equals("Edit")) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.delete_item_menu, menu);
        }
        return true;
    }

    //Deletes current meal item
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String mealTime = bundle.getString("mealTime");
        int mealIndex = MealsHolder.findMeal(mealTime);
        int mealItemIndex = bundle.getInt("itemPosition");
        MealsHolder.meals.get(mealIndex).deleteMealItem(mealItemIndex);
        MealsHolder.writeToFile("meals.json", MealsHolder.toJSON(), getApplicationContext());
        finish();
        return super.onOptionsItemSelected(item);
    }



}