package com.example.android.lastass;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
public class DishAdapter extends ArrayAdapter<Dish>{
    public DishAdapter(@NonNull Context context, ArrayList<Dish> dish) {
        super(context, 0, dish);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Dish currentDish = getItem(position);
        ImageView dishImage = listItemView.findViewById(R.id.dish_image);
        dishImage.setImageResource(currentDish.getDishImageId());
        TextView dishName = listItemView.findViewById(R.id.dish_name);
        dishName.setText(currentDish.getDishName());
        TextView dishPrice = listItemView.findViewById(R.id.dish_price);
        dishPrice.setText(Integer.toString(currentDish.getDishPrice()));
        return listItemView;
    }
}
