package com.supinfo.geekquote;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.supinfo.geekquote.model.Quote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuoteListActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private List<Quote> quoteList = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String[] stringsTable = this.getResources().getStringArray(R.array.quoteList);

        for(String strQuote : stringsTable) {
            addQuote(strQuote);
        }

        for(Quote quote : quoteList) {
            Log.d("QUOTE", quote.getStrQuote());
        }
    }

    public void addQuote(String strQuote) {

        Quote quote = new Quote();
        quote.setCreationDate(new Date());
        quote.setRating(-1);
        quote.setStrQuote(strQuote);

        this.quoteList.add(quote);
    }
}
