package com.example.monitorlizard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MealListAdapter extends RecyclerView.Adapter<MealListAdapter.MyViewHolder> {

    ArrayList<String> mealNames;
    ArrayList<String> mealTimes;
    Context context;

    public MealListAdapter(Context context) {
        this.context = context;
//        this.mealNames =
//        this.mealTimes = mealTimes;
    }

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

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //what happens when you click a meal
            }
        });
    }

    @Override
    public int getItemCount() {
        return MealsHolder.meals.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mealName, mealDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mealName = itemView.findViewById(R.id.mealName);
            mealDate = itemView.findViewById(R.id.mealDate);

        }

    }
}
