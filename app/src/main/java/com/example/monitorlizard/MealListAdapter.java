package com.example.monitorlizard;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class MealListAdapter extends ArrayAdapter<Meal> {

    public MealListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

}
