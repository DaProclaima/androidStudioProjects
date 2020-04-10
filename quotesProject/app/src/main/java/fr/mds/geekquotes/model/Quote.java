package fr.mds.geekquotes.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public class Quote implements Serializable {
    private String strQuote;
    private int rating;
    private Date creatingDate;

    public Quote(String strQuote) {
        this.strQuote = strQuote;
        this.rating = 0;
        this.creatingDate = new Date();
    }

    public String getStrQuote() {
        return strQuote;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }
}
