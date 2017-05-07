package com.android.tourguideapp.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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

public class TuristAttractions extends Fragment {

    ListView listView;
    List<ViewObject> viewObjectList =  new ArrayList<>();;
    Drawable picture;
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
    private void loadData(){
        picture = ContextCompat.getDrawable(getContext(), R.drawable.cytadela);
        name = getContext().getResources().getString(R.string.cytadela);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

        picture = ContextCompat.getDrawable(getContext(), R.drawable.krzyze);
        name = getContext().getResources().getString(R.string.krzyze);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

        picture = ContextCompat.getDrawable(getContext(), R.drawable.malta);
        name = getContext().getResources().getString(R.string.malta);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

        picture = ContextCompat.getDrawable(getContext(), R.drawable.maltanka);
        name = getContext().getResources().getString(R.string.maltanka);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

        picture = ContextCompat.getDrawable(getContext(), R.drawable.most);
        name = getContext().getResources().getString(R.string.most);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

        picture = ContextCompat.getDrawable(getContext(), R.drawable.parkcytadela);
        name = getContext().getResources().getString(R.string.parkcytadela);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

        picture = ContextCompat.getDrawable(getContext(), R.drawable.placwolnosci);
        name = getContext().getResources().getString(R.string.placwolnosci);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

        picture = ContextCompat.getDrawable(getContext(), R.drawable.rowery);
        name = getContext().getResources().getString(R.string.rowery);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

        picture = ContextCompat.getDrawable(getContext(), R.drawable.teatrwielki);
        name = getContext().getResources().getString(R.string.teatrwielki);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

        picture = ContextCompat.getDrawable(getContext(), R.drawable.termy);
        name = getContext().getResources().getString(R.string.termy);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

        picture = ContextCompat.getDrawable(getContext(), R.drawable.zoo);
        name = getContext().getResources().getString(R.string.zoo);
        openingHours  = getContext().getResources().getString(R.string.cytadelaOH);
        viewObjectList.add(new ViewObject(picture,name, openingHours));

    }
}
