package com.example.monitorlizard;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

//RecyclerView Adapter for mealItemList activity
public class MealItemListAdapter extends RecyclerView.Adapter<MealItemListAdapter.ItemViewHolder> {

    int mealPosition;
    Context context;

    //mealTime is passed to pull meals from the meals list
    public MealItemListAdapter(Context context, String mealTime) {
        this.context = context;
        this.mealPosition = MealsHolder.findMeal(mealTime);
    }

    //Specifies layout to use for each row in recyclerView
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item_row_layout, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.mealItemName.setText(MealsHolder.meals.get(mealPosition).getMealItems().get(position).getItemName());
        holder.mealItemQuantity.setText(MealsHolder.meals.get(mealPosition).getMealItems().get(position).getItemQuantity());
        holder.mealItemUnits.setText(MealsHolder.meals.get(mealPosition).getMealItems().get(position).getItemUnits());

        //This passes information on which item was clicked to the NewMealItem class
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), NewMealItem.class);
            intent.putExtra("mealTime", MealsHolder.meals.get(mealPosition).getMealTime().toString());
            intent.putExtra("itemName", holder.mealItemName.getText());
            intent.putExtra("itemQuantity", holder.mealItemQuantity.getText());
            intent.putExtra("itemUnits", holder.mealItemUnits.getText());
            intent.putExtra("itemPosition", holder.getAdapterPosition());
            context.startActivity(intent);
        });
    }

    //Length of list
    @Override
    public int getItemCount() {
        return MealsHolder.meals.get(mealPosition).getMealItems().size();
    }

    //Constructor for view in recyclerView
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView mealItemName, mealItemQuantity, mealItemUnits;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            mealItemName = itemView.findViewById(R.id.mealItemName);
            mealItemQuantity = itemView.findViewById(R.id.mealItemQuantity);
            mealItemUnits = itemView.findViewById(R.id.mealItemUnits);

        }

    }




}
