package fr.mds.demoproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import fr.mds.demoproject.model.Virus;

public class MenuActivity extends Activity implements View.OnClickListener {

    private static String TAG = "MenuActivity";
    private Button bt_menu_spinner, bt_menu_picasso, bt_menu_demo_extra;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bt_menu_spinner = findViewById(R.id.bt_menu_spinner);
        bt_menu_picasso = findViewById(R.id.bt_menu_picasso);
        bt_menu_demo_extra = findViewById(R.id.bt_menu_demo_extra);

        bt_menu_spinner.setOnClickListener(this);
        bt_menu_picasso.setOnClickListener(this);
        bt_menu_demo_extra.setOnClickListener(this);


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

        if ( v == bt_menu_demo_extra) {

            Log.d(TAG, "MenuActivity - OnClick - bt_menu_demo_extra");

            Virus virus = new Virus("Covid-19", "China", 2);

            Intent intent = new Intent(this, DemoExtraActivity.class);
            intent.putExtra("message", "This is a message from MenuActivity");
            intent.putExtra("virus", virus);
            startActivity(intent);
            return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "MenuActivity onAcitivtyResult");
        Log.d(TAG, "MenuActivity "+ resultCode);

        if (data != null && data.getExtras() != null) {
            String response = data.getExtras().getString("response");
            Toast.makeText(this, response, Toast.LENGTH_SHORT).show();

        }
    }
}
