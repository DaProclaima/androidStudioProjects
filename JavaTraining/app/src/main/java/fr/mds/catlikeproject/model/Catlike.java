package fr.mds.catlikeproject.model;

import android.util.Log;

import fr.mds.catlikeproject.MainActivity;

public class Catlike {

    private String color;
    private String height;

    public Catlike() {
    }

    protected void eat() {
        Log.d(MainActivity.TAG, "Catlike is eating");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }


    public Catlike(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Catlike{" +
                "color='" + color + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
