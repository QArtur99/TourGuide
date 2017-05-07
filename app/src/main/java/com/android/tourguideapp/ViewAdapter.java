package com.android.tourguideapp;

import android.app.Activity;
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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        if (viewObject.picture != null) {
            holder.imageView.setImageDrawable(viewObject.picture);
        } else {
            holder.cardView.setVisibility(View.GONE);
            holder.name.setGravity(Gravity.START);
        }
        holder.name.setText(viewObject.name);
        holder.openingHours.setText(viewObject.openingHours);


        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.cardView) CardView cardView;
        @BindView(R.id.itemImage) ImageView imageView;
        @BindView(R.id.title) TextView name;
        @BindView(R.id.openingHours) TextView openingHours;


        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
