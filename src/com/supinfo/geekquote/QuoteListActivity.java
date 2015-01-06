package com.supinfo.geekquote;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.supinfo.geekquote.model.Quote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuoteListActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private List<Quote> quoteList = new ArrayList();
    private QuoteListAdapter listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String[] stringsTable = this.getResources().getStringArray(R.array.quoteList);

        ListView quotesLv = (ListView) findViewById(R.id.quotesListView);

        for(String strQuote : stringsTable) {
            addQuote(strQuote);
        }

        for(Quote quote : quoteList) {
            Log.d("QUOTE", quote.getStrQuote());
        }

        Button button = (Button) findViewById(R.id.addQuoteButton);
        final EditText et = (EditText) findViewById(R.id.quoteField);

        listAdapter = new QuoteListAdapter(this, android.R.layout.simple_list_item_1, quoteList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addQuote(et.getText().toString());
                et.setText("");
                listAdapter.notifyDataSetChanged();
            }
        });

        quotesLv.setAdapter(listAdapter);
    }

    public void addQuote(String strQuote) {

        Quote quote = new Quote();
        quote.setCreationDate(new Date());
        quote.setRating(-1);
        quote.setStrQuote(strQuote);

        this.quoteList.add(quote);
    }
}
