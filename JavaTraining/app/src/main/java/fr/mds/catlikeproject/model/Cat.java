package fr.mds.catlikeproject.model;

import android.util.Log;

import fr.mds.catlikeproject.MainActivity;

public class Cat extends Catlike {
    public Cat() {
    }

    private String catFoodBrand;

    public Cat(String catFoodBrand) {
        this.catFoodBrand = catFoodBrand;
    }

    public Cat(String color, String catFoodBrand) {
        super(color);
        this.catFoodBrand = catFoodBrand;
    }

    public String getCatFoodBrand() {
        return catFoodBrand;
    }

    public void setCatFoodBrand(String catFoodBrand) {
        this.catFoodBrand = catFoodBrand;
    }

    @Override
    protected void eat() {
        Log.d(MainActivity.TAG, "Eating like cat");
    }

}
