package com.android.tourguideapp;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by ART_F on 2017-05-07.
 */

public class ViewAdapter extends ArrayAdapter<ViewObject> {

    public ViewAdapter(Activity context, List<ViewObject> androidFlavors) {
        super(context, 0, androidFlavors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewObject viewObject = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item, parent, false);
        }
        CardView cardView = (CardView) convertView.findViewById(R.id.cardView);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.itemImage);
        TextView name = (TextView) convertView.findViewById(R.id.title);
        TextView openingHours = (TextView) convertView.findViewById(R.id.openingHours);

        if(viewObject.picture != null) {
            imageView.setImageDrawable(viewObject.picture);
        }else{
            cardView.setVisibility(View.GONE);
            name.setGravity(Gravity.START);
        }
        name.setText(viewObject.name);
        openingHours.setText(viewObject.openingHours);



        return convertView;
    }


}
