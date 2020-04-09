package fr.mds.geekquotes.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import fr.mds.geekquotes.adapter.QuoteListAdapter;
import fr.mds.geekquotes.model.Quote;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{
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
            et_main_quote.setText(null);
        }


    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if( parent == lv_main_quotes) {

            String quoteStr = quotes.get(position).getStrQuote();
            String quoteDate = quotes.get(position).getCreatingDate().toString();
            int quoteRating = quotes.get(position).getRating();

            Intent intent = new Intent(this, QuoteActivity.class);
            intent.putExtra("quoteStr",quoteStr);
            intent.putExtra("quoteDate",quoteDate);
            intent.putExtra("quoteRating",quoteRating);
            startActivity(intent);
        }
    }
}


