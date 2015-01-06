package com.supinfo.geekquote;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
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

        LinearLayout ll = (LinearLayout) findViewById(R.id.generalLayout);

        EditText et = new EditText(this);

        et.setText(strQuote);

        if(quoteList.indexOf(quote) % 2 == 0) {
            et.setBackgroundColor(getResources().getColor(R.color.list_dark_color));
        }
        else {
            et.setBackgroundColor(getResources().getColor(R.color.list_light_color));
        }

        ll.addView(et);
    }
}
