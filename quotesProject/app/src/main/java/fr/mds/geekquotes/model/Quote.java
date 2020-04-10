package fr.mds.geekquotes.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Date;

public class Quote implements Serializable, Parcelable {

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

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public Quote createFromParcel(Parcel in) {
//            Log.d("HERE", "Quote - createFromParcel - in.readString() = " + in.readString());

            return new Quote(in.readString());
        }

        public Quote[] newArray(int size) {
            return new Quote[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.strQuote);
        dest.writeString(this.creatingDate.toString());
        dest.writeInt(this.rating);
    }
}
