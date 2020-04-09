package fr.mds.geekquotes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.mds.geekquotes.model.Quote;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Quote> quotes = new ArrayList<>();

    private LinearLayout ll_main_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll_main_layout = findViewById(R.id.ll_main_layout);

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

        TextView textView = new TextView(this);
        textView.setText(strQuote);
        ArrayAdapter<Quote> quoteArrayAdapter  = new ArrayAdapter<Quote>(this, android.R.layout.simple_list_item_1 , quotes);
        if (quotes.size() % 2 != 0 ) {
            textView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
    }
}
