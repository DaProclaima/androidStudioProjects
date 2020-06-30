package fr.mds.geekquotes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import fr.mds.geekquotes.model.Quote;

public class QuoteActivity extends Activity implements View.OnClickListener {
    private static final String TAG = QuoteActivity.class.getSimpleName();
    private Button bt_quote_cancel, bt_quote_ok;
    private RatingBar rb_quote;
    private Quote quote;
    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_layout);

        rb_quote = findViewById(R.id.rb_quote_layout);
        TextView tv_quote_layout_quotedate = findViewById(R.id.tv_quote_layout_quotedate);
        TextView tv_quote_layout_quotestr = findViewById(R.id.tv_quote_layout_quotestr);

        bt_quote_cancel = findViewById(R.id.bt_quote_cancel);
        bt_quote_ok = findViewById(R.id.bt_quote_ok);

        bt_quote_cancel.setOnClickListener(this);
        bt_quote_ok.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            try {
                position =  bundle.getInt("position");
                Log.d(TAG, "QuoteActivity - bundle - position = " + position);
                quote = bundle.getParcelable("quote");
                Log.d(TAG, "QuoteActivity - bundle - quote = " + quote);

            } catch (Exception e) {
                System.out.println( TAG +": Something went wrong bro. \n ");
            }
            tv_quote_layout_quotedate.setText(quote.getCreatingDate().toString());
            tv_quote_layout_quotestr.setText(quote.getStrQuote());
            rb_quote.setRating(quote.getRating());

//            Log.d(TAG, "QuoteActivity - bundle - position = " + position);
//            Log.d(TAG, "QuoteActivity - bundle - quote = " + quote.toString());
        }
    }

    @Override
    public void onClick(View v) {

        if(v == bt_quote_ok) {
           getIntent().putExtra("rating",rb_quote.getRating());
            getIntent().putExtra("position", position);
            setResult(RESULT_OK, getIntent());
            finish();
            return;
        }

        if (v == bt_quote_cancel) {
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
