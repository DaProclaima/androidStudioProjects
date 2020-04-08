package fr.mds.activity.quotesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Quote> quotes = new ArrayList<>();

    private LinearLayout ll_main_layout;

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
        quotes.add(quote);

        Toast.makeText(this, strQuote, Toast.LENGTH_SHORT).show();

//        TextView tv_main_str = findViewById(R.id.tv_main_str);
//        tv_main_str.setText(strQuote);
        TextView textView = new TextView(this);
        textView.setText(strQuote);
        ll_main_layout.findViewById(R.id.ll_main_layout);

//        if (quotes.size() % 2 != 0 ) {
//            ll_main_layout.setBackgroundColor(android);
//        }
    }
}
