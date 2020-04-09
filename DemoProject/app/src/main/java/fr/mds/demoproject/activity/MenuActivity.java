package fr.mds.demoproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MenuActivity extends Activity implements View.OnClickListener {

    private static String TAG = "MenuActivity";
    private Button bt_menu_spinner, bt_menu_picasso;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bt_menu_spinner = findViewById(R.id.bt_menu_spinner);
        bt_menu_picasso = findViewById(R.id.bt_menu_picasso);

        bt_menu_spinner.setOnClickListener(this);
        bt_menu_picasso.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if ( v == bt_menu_spinner) {
            Log.d(TAG, "MenuActivity - OnClick - bt_menu_spinner");
            Intent intent = new Intent(this, SpinnerActivity.class);
            startActivity(intent);
            return;
        }

        if ( v == bt_menu_picasso) {
            Log.d(TAG, "MenuActivity - OnClick - bt_menu_picasso");
            Intent intent = new Intent(this, PicassoActivity.class);
            startActivity(intent);
            return;
        }
    }
}
