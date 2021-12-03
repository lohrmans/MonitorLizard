package com.example.monitorlizard;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class MealItemListAdapter extends ArrayAdapter {

    public MealItemListAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

}
