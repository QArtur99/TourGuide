package com.android.tourguideapp.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.tourguideapp.MainActivity;
import com.android.tourguideapp.R;
import com.android.tourguideapp.ViewAdapter;
import com.android.tourguideapp.ViewObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ART_F on 2017-05-07.
 */

public class ShoppingMalls extends Fragment {
    ListView listView;
    List<ViewObject> viewObjectList = new ArrayList<>();
    String name, openingHours;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView);

        loadData();


        MainActivity.ObjectComparatorByName comparator = new MainActivity.ObjectComparatorByName();
        Collections.sort(viewObjectList, comparator);

        ViewAdapter viewAdapter = new ViewAdapter(getActivity(), viewObjectList);
        listView.setAdapter(viewAdapter);
        return rootView;
    }

    private void loadData() {
        name = getContext().getResources().getString(R.string.galeriaMalta);
        openingHours = getContext().getResources().getString(R.string.shoppingMallsOH);
        viewObjectList.add(new ViewObject(name, openingHours));

        name = getContext().getResources().getString(R.string.franowo);
        openingHours = getContext().getResources().getString(R.string.shoppingMallsOH);
        viewObjectList.add(new ViewObject(name, openingHours));

        name = getContext().getResources().getString(R.string.poznania);
        openingHours = getContext().getResources().getString(R.string.shoppingMallsOH);
        viewObjectList.add(new ViewObject(name, openingHours));

        name = getContext().getResources().getString(R.string.avenida);
        openingHours = getContext().getResources().getString(R.string.shoppingMallsOH);
        viewObjectList.add(new ViewObject(name, openingHours));

        name = getContext().getResources().getString(R.string.pestka);
        openingHours = getContext().getResources().getString(R.string.shoppingMallsOH);
        viewObjectList.add(new ViewObject(name, openingHours));

        name = getContext().getResources().getString(R.string.staryBrowar);
        openingHours = getContext().getResources().getString(R.string.shoppingMallsOH);
        viewObjectList.add(new ViewObject(name, openingHours));

    }
}
