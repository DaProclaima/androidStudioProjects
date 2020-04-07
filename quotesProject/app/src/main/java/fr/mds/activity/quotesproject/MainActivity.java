package fr.mds.activity.quotesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] initialQuotes = getResources().getStringArray(R.array.initial_quotes);

        for(String s : initialQuotes) {
            addQuote(s);
        }

        Log.d(TAG, initialQuotes.toString());

    }

    void addQuote(String strQuote) {
        Quote quote = new Quote(strQuote);
        TextView tv_main_str = findViewById(R.id.tv_main_str);
        tv_main_str.setText(strQuote);
//        Toast.makeText(this, strQuote, Toast.LENGTH_SHORT).show();
    }
}
