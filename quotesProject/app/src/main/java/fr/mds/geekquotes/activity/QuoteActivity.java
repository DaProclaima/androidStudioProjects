package fr.mds.geekquotes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            quote = (Quote) bundle.getSerializable("quote");
            tv_quote_layout_quotedate.setText(quote.getCreatingDate().toString());
            tv_quote_layout_quotestr.setText(quote.getStrQuote());
            rb_quote.setRating(quote.getRating());
        }
    }

    @Override
    public void onClick(View v) {

        if(v == bt_quote_cancel) {
            Intent intent = new Intent(this, QuoteListActivity.class);
            quote.setRating(rb_quote.getNumStars());
            intent.putExtra("quote",quote);
            startActivity(intent);
            finish();
        }

        if (v == bt_quote_ok) {
            finish();
        }
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        extras = data.getExtras();
//        Log.d(TAG, "QuoteActivity - data - " + data);
//
//        if(extras != null) {
//            Log.d(TAG, "QuoteActivity - QuoteDate - " + extras.getString("QuoteDate"));
//            Log.d(TAG, "QuoteActivity - QuoteStr - " + extras.getString("QuoteStr"));
//            Log.d(TAG, "QuoteActivity - QuoteStr - " + extras.getInt("QuoteRating"));
//        }
//    }
}
