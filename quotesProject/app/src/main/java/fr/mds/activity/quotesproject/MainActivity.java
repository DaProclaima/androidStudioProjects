package fr.mds.activity.quotesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
        add.(quote);

        Toast.makeText(this, StrQuote, Toast.LENGTH_SHORT).show();
    }
}
