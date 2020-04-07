package fr.mds.celciustofaranheitproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.mds.celciustofaranheitproject.R;

public class MainActivity extends AppCompatActivity {

    protected String TAG = "MainAcitivity";
    private Button bt_main_convert;
    private EditText ev_main_input;
    private TextView tv_main_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt_main_convert = findViewById(R.id.bt_main_convert);
        ev_main_input = findViewById(R.id.ev_main_input);
        tv_main_value = findViewById(R.id.tv_main_value);

        bt_main_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etValue = ev_main_input.getText().toString();
                Log.d(TAG, etValue);
                convert(etValue);
            }
        });

    }

    void convert (String inputValue) {
        double myInputDouble;
        try {
            myInputDouble = Double.parseDouble(inputValue);
            tv_main_value.setText((String) toString(myInputDouble));
        }
    }
}
