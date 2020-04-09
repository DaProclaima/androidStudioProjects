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

public class QuoteActivity extends Activity implements View.OnClickListener {
    private static final String TAG = QuoteActivity.class.getSimpleName();
    private Button bt_quote_cancel, bt_quote_ok;
    private RatingBar rb_quote;
    private Bundle extrasInit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_layout);

        extrasInit = getIntent().getExtras();

        rb_quote = findViewById(R.id.rb_quote_layout);
        TextView tv_quote_layout_quotedate = findViewById(R.id.tv_quote_layout_quotedate);
        TextView tv_quote_layout_quotestr = findViewById(R.id.tv_quote_layout_quotestr);

        bt_quote_cancel = findViewById(R.id.bt_quote_cancel);
        bt_quote_ok = findViewById(R.id.bt_quote_ok);

        bt_quote_cancel.setOnClickListener(this);
        bt_quote_ok.setOnClickListener(this);

//        Log.d(TAG, "QuoteActivity - quoteStr - " + extras.getString("quoteStr"));
//        Log.d(TAG, "QuoteActivity - quoteDate - " + extras.getString("quoteDate"));
//        Log.d(TAG, "QuoteActivity - quoteRating - " + extras.getInt("quoteRating"));

        tv_quote_layout_quotedate.setText(extrasInit.getString("quoteDate"));
        tv_quote_layout_quotestr.setText(extrasInit.getString("quoteStr"));
        rb_quote.setRating(extrasInit.getInt("quoteRating"));
    }

    @Override
    public void onClick(View v) {

        if(v == bt_quote_cancel) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("quoteRating", rb_quote.getRating());
            intent.putExtra("quoteStr", extrasInit.getString("quoteStr"));
            startActivity(intent);
            return;
        }

        if (v == bt_quote_ok) {
            extrasInit.clear();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
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
