package workspace.fr.sebastienn.cours.mds.javatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import workspace.fr.sebastienn.cours.mds.javatest.model.Wheel;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "JavaTraining";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        System.out.println("Hello World !");
        Log.d(TAG, "Hello World");
    }

    Wheel wheel1 = new Wheel();
    Wheel wheel2 = new Wheel();


//    Create new instance
    Bycicle myBycicle1 = new Bycicle();
    Bycicle myBycicle2 = new Bycicle(wheel1, wheel2);
    Bycicle myBycicle3 = new Bycicle("pink", wheel1, wheel2);


}
