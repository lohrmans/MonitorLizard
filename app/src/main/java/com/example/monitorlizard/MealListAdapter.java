package com.example.monitorlizard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//Adapter for MealList Activity
public class MealListAdapter extends RecyclerView.Adapter<MealListAdapter.MyViewHolder> {

    Context context;

    public MealListAdapter(Context context) {
        this.context = context;
    }

    //Specifies layout to use for each row in recyclerView
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_row_layout, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mealName.setText(MealsHolder.meals.get(position).getMealName());
        holder.mealDate.setText(MealsHolder.meals.get(position).getMealTime().toString());

        //Passes mealTime so that the correct meal is referenced in MealItemList activity
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MealItemList.class);
            intent.putExtra("mealTime", holder.mealDate.getText().toString());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return MealsHolder.meals.size();
    }

    //Constructor for views in recyclerView
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mealName, mealDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mealName = itemView.findViewById(R.id.mealName);
            mealDate = itemView.findViewById(R.id.mealDate);

        }

    }
}
