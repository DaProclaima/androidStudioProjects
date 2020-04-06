package fr.mds.catlikeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import fr.mds.catlikeproject.model.Cat;
import fr.mds.catlikeproject.model.Catlike;
import fr.mds.catlikeproject.model.Tiger;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "CatlikeProject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity - onCreate");

//        <Generic> : "Java Generics List. Check in compilation
//        we add this type in the ArrayList
        ArrayList<Integer> myIntList = new ArrayList<>();
        myIntList.add(10);
        myIntList.add(5);
        myIntList.add(1);
        myIntList.add(14);

        ArrayList<Catlike> catlikes = new ArrayList<>();
        catlikes.add(new Cat());
        catlikes.add(new Catlike());
        catlikes.add(new Tiger());

//        foreach
        for (Catlike c : catlikes) {
            Log.d(TAG, c.toString());

//            Polymorphism grants us for example
//            to add elements in a list provided those
//            elements inherit a common class.
            Catlike myCatLike = new Cat("Royal Canin");

            String color = myCatLike.getColor();
//    cant work we need to cast myCatLike
//            String foodBrand = myCatLike.getCatFoodBrand();

        }

        ArrayList<Catlike> catlikes2 = new ArrayList<>();
        catlikes2.add(new Cat("Royal Canin"));
        catlikes2.add(new Cat("Hill's"));
        catlikes2.add(new Catlike());
        catlikes2.add(new Tiger());

        for (Catlike c : catlikes2) {
            if (c instanceof Cat) {
                Log.d(MainActivity.TAG, "This is a cat");
            } else if (c instanceof Tiger) {
                Log.d(MainActivity.TAG, "This is a tiger");
            } else {
                Log.d(MainActivity.TAG, "This is a catlike");
            }
        }

        Catlike myRandomCatlike = getRandomCatlike();

        if(myRandomCatlike instanceof Cat) {
            Log.d(MainActivity.TAG, "I got a cat!");
            Cat myCat2 = (Cat)myRandomCatlike;
            myCat2.getCatFoodBrand();
        } else if (myRandomCatlike instanceof Tiger) {
            Log.d(MainActivity.TAG, "I got a tiger;");
        } else {
            Log.d(MainActivity.TAG, "I got a catlike");
        }
    }


    Catlike getRandomCatlike() {
        int randomInt = new Random().nextInt(3);

        if(randomInt == 0) {
            return new Catlike();
        } else if (randomInt == 1) {
            return new Cat();
        } else {
            return new Tiger();
        }
    }
}

