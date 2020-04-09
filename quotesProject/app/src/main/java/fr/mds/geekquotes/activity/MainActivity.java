package fr.mds.geekquotes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.mds.geekquotes.adapter.QuoteListAdapter;
import fr.mds.geekquotes.model.Quote;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Quote> quotes = new ArrayList<>();

    private EditText et_main_quote;
    private Button bt_main_add;
    private ListView lv_main_quotes;

    private QuoteListAdapter quoteArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_main_quote = findViewById(R.id.et_main_strquote);
        bt_main_add = findViewById(R.id.bt_main_add);
        lv_main_quotes = findViewById(R.id.lv_main_quotes);

        bt_main_add.setOnClickListener(this);


        quoteArrayAdapter = new QuoteListAdapter(this,quotes);

        lv_main_quotes.setAdapter(quoteArrayAdapter);

        String[] initialQuotes = getResources().getStringArray(R.array.initial_quotes);
        for(String s : initialQuotes) {
            addQuote(s);
        }

//        Log.d(TAG, initialQuotes.toString());

    }

    void addQuote(String strQuote) {
        Quote quote = new Quote(strQuote);
        quotes.add(0, quote);

//        UPDATE LIST
        quoteArrayAdapter.notifyDataSetChanged();

//        Toast.makeText(this, strQuote, Toast.LENGTH_SHORT).show();

//        TextView textView = new TextView(this);
//        textView.setText(strQuote);
//        if (quotes.size() % 2 != 0 ) {
//            textView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//        }
    }

    @Override
    public void onClick(View v) {
        String inputStr = et_main_quote.getText().toString();
        addQuote(inputStr);
        et_main_quote.setText(null);
    }


}


