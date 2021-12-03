package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        btnSaveItem.setOnClickListener(v -> {

        });
    }
}