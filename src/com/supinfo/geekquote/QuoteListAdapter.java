package com.supinfo.geekquote;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.supinfo.geekquote.model.Quote;

import java.util.List;

/**
 * Created by alexandrenguyen on 06/01/15.
 */
public class QuoteListAdapter extends BaseAdapter {

    private Context appContext;
    private List<Quote> quotes;
    private int resource;
    private LayoutInflater layoutInflater;

    public QuoteListAdapter(Context _appContext, int textViewResourceId, List<Quote> _quotes) {

        this.appContext = _appContext;
        this.quotes = _quotes;
        this.resource = textViewResourceId;
        this.layoutInflater = (LayoutInflater) _appContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.quotes.size();
    }

    @Override
    public Object getItem(int i) {
        return this.quotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View view;

        if(convertView == null) {
            view = this.layoutInflater.inflate(resource, viewGroup, false);
        }
        else {
            view = convertView;
        }

        TextView tv = (TextView) view;

        Quote quote = (Quote) getItem(i);

        tv.setText(quote.getStrQuote());
        Log.d("MYQUOTE", quote.toString());

        if(quotes.indexOf(quote) % 2 == 0) {
            tv.setBackgroundColor(appContext.getResources().getColor(R.color.list_dark_color));
        }
        else {
            tv.setBackgroundColor(appContext.getResources().getColor(R.color.list_light_color));
        }

        return tv;
    }
}
