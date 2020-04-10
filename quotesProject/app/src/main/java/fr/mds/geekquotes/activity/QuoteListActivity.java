package fr.mds.geekquotes.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

import fr.mds.geekquotes.adapter.QuoteListAdapter;
import fr.mds.geekquotes.model.Quote;

public class QuoteListActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final int ACTIVITY_CODE = 1;
    private static final String TAG = QuoteListActivity.class.getSimpleName();

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
        lv_main_quotes.setOnItemClickListener(this);

        quoteArrayAdapter = new QuoteListAdapter(this,quotes);

        lv_main_quotes.setAdapter(quoteArrayAdapter);

        String[] initialQuotes = getResources().getStringArray(R.array.initial_quotes);
        for(String s : initialQuotes) {
            addQuote(s);
        }
    }

    void addQuote(String strQuote) {
        Quote quote = new Quote(strQuote);
        quotes.add(0, quote);
//        UPDATE LIST
        quoteArrayAdapter.notifyDataSetChanged();
//        Toast.makeText(this, strQuote, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if( v == bt_main_add) {
            String inputStr = et_main_quote.getText().toString();
            addQuote(inputStr);
            et_main_quote.getText().clear();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if( parent == lv_main_quotes) {

            Quote quote = quotes.get(position);

            Intent intent = new Intent(this, QuoteActivity.class);
            intent.putExtra("position", position);
            intent.putExtra("quote",(Serializable) quote);
            startActivityForResult(intent, ACTIVITY_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "QuoteListActivity - onActivityResult");
        Log.d(TAG, "QuoteListActivity - onActivityResult - requestCode = "+ requestCode);
        Log.d(TAG, "QuoteListActivity - onActivityResult - resultCode = "+ resultCode);
        Log.d(TAG, "QuoteListActivity - onActivityResult - data position = "+ data);

       if(requestCode == 1 && resultCode == RESULT_OK) {
           int position =  data.getIntExtra("position", 0);
           float rating = data.getFloatExtra("rating", 0);
           Log.d(TAG, "QuoteListActivity - bundle - rating = " + rating);
           Log.d(TAG, "QuoteListActivity - bundle - position = " + position);
           quotes.get(position).setRating((int) rating);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "QuoteListActivity - onSaveInstanceState- quotes = " + quotes);
        outState.putParcelableArrayList("quotes", quotes);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.quotes = savedInstanceState.getParcelableArrayList("quotes");
        Log.d(TAG, "QuoteListActivity - onRestoreInstanceState - quotes = " + this.quotes);
    }


}


