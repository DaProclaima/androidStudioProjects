package fr.mds.lifecycle.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.mds.lifecycle.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Lifecycle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Log.d(TAG, "LifeCycleActivity");
        Resources resources = getResources();
        String helloWorldStr = resources.getString(R.string.hello_string);
        Log.d(TAG,helloWorldStr );

//        String cancelAndroidString = resources.getString(android.R.string.cancel);
//        Log.d(TAG, cancelAndroidString);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity - onStart");
    }

    @Override
    protected void onStop() {

        super.onStop();
        Log.d(TAG, "MainActivity - onStop");
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.d(TAG, "MainActivity - onResume");
    }

    @Override
    protected void onPause() {

        super.onPause();
        Log.d(TAG, "MainActivity - onPause");
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Log.d(TAG, "MainActivity - onRestart");
    }

}
