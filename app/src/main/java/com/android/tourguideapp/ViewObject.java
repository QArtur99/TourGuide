package com.android.tourguideapp;

import android.graphics.drawable.Drawable;

/**
 * Created by ART_F on 2017-05-07.
 */

public class ViewObject {
    Drawable picture;
    String name;
    String description;
    String openingHours;

    ViewObject(Drawable picture, String name, String description, String openingHours) {
        this.picture = picture;
        this.name = name;
        this.description = description;
        this.openingHours = openingHours;
    }
    public ViewObject(Drawable picture, String name, String openingHours) {
        this.picture = picture;
        this.name = name;
        this.openingHours = openingHours;
    }
    public ViewObject(String name, String openingHours) {
        this.name = name;
        this.openingHours = openingHours;
    }
}
