package fr.mds.geekquotes.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class QuoteActivity extends Activity {
    private static final String TAG = QuoteActivity.class.getSimpleName();
    private Bundle extras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_layout);
        extras = getIntent().getExtras();
        Log.d(TAG, "QuoteActivity - quoteStr - " + extras.getString("quoteStr"));
        Log.d(TAG, "QuoteActivity - quoteDate - " + extras.getString("quoteDate"));
        Log.d(TAG, "QuoteActivity - quoteRating - " + extras.getInt("quoteRating"));
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
