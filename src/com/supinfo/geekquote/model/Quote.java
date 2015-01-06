package com.supinfo.geekquote.model;

import java.util.Date;

/**
 * Created by alexandrenguyen on 06/01/15.
 */
public class Quote {

    private String strQuote;
    private int rating;
    private Date creationDate;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStrQuote() {
        return strQuote;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "creationDate=" + creationDate +
                ", strQuote='" + strQuote + '\'' +
                ", rating=" + rating +
                '}';
    }
}
