package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Activity for creating a new meal.
public class NewMeal extends AppCompatActivity {

    EditText etMealName;
    RecyclerView rvItemList;
    Button btnAddItem, btnSaveMeal;

    //isNewMeal is used to indicate that the meal is already created so that duplicates aren't made
    //as you add more items to the meal
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

        btnSaveMeal.setVisibility(View.GONE);

        //Here is where I have the check for whether or not the meal is new. Saves the mealtime
        //and passes it through as identifier for newMealItem activity
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
                    MealsHolder.newMealTimeString = mealTime;
                    isNewMeal = false;
                    startActivity(intent);
                }
            }
        });


    }

    //Here the save meal button is made visible and recyclerView is populated with items added to meal
    @Override
    protected void onRestart() {
        super.onRestart();

        setContentView(R.layout.activity_new_meal);

        etMealName = findViewById(R.id.etMealName);
        rvItemList = findViewById(R.id.rvItemList);
        btnAddItem = findViewById(R.id.btnAddItem);
        btnSaveMeal = findViewById(R.id.btnSaveMeal);

        btnSaveMeal.setVisibility(View.VISIBLE);
        etMealName.setFreezesText(true);

        String mealTime = MealsHolder.newMealTimeString;
        int newMealIndex = MealsHolder.findMeal(mealTime);

        etMealName.setText(MealsHolder.meals.get(newMealIndex).getMealName());

        rvItemList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        MealItemListAdapter mealItemListAdapter = new MealItemListAdapter(NewMeal.this, mealTime);
        rvItemList.setAdapter(mealItemListAdapter);

        btnAddItem.setOnClickListener(v -> {
            if (etMealName.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter meal name.", Toast.LENGTH_SHORT).show();
            } else {
                if (!isNewMeal) {
                    Intent intent = new Intent(v.getContext(), NewMealItem.class);
                    intent.putExtra("mealTime", MealsHolder.newMealTimeString);
                    startActivity(intent);
                }
            }
        });

        //Calls writeToFile to save meal
        btnSaveMeal.setOnClickListener(v -> {
            MealsHolder.meals.get(newMealIndex).setMealName(etMealName.getText().toString());
            MealsHolder.writeToFile("meals.json", MealsHolder.toJSON(), getApplicationContext());
            finish();
        });

    }

}