package fr.mds.activity.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_main_1, bt_main_2, bt_main_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_main_1 = findViewById(R.id.bt_main_1);
        bt_main_2 = findViewById(R.id.bt_main_2);
        bt_main_3 = findViewById(R.id.bt_main_3);

        bt_main_1.setOnClickListener(this);
        bt_main_2.setOnClickListener(this);
        bt_main_3.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if ( v == bt_main_1) {
            Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
            return;
        }

        if ( v == bt_main_2) {
            Toast.makeText(this, "Button 2 clicked", Toast.LENGTH_SHORT).show();
            return;
        }

        if ( v == bt_main_3) {
            Toast.makeText(this, "Button 3 clicked", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
