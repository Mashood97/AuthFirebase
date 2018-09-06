package com.example.okcomputers.authfirebase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.okcomputers.authfirebase.FoodItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OK Computers on 8/3/2018.
 */

public class FoodItemAdapter extends ArrayAdapter<FoodItemclass> {

    public FoodItemAdapter(Activity context, List<FoodItemclass> arrayList)
    {
        super(context,0,arrayList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View ListItemView = convertView;

       if(ListItemView == null)
       {
           ListItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
       }
        FoodItemclass foodItemclass = getItem(position);
        TextView itename = ListItemView.findViewById(R.id.ItemnameId);
        itename.setText(foodItemclass.getmItemName());

        TextView itemprice = ListItemView.findViewById(R.id.ItemPriceId);
        itemprice.setText(foodItemclass.getmItemPrice());

       return ListItemView;
    }
}
