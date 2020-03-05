package com.example.persistenthotel;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public class Guest implements Parcelable {
    private String prefix;
    private String actualName;
    private String dateMade;

    public Guest(String prefix, String actualName, String dateMade){
        this.prefix=prefix;
        this.actualName=actualName;
        this.dateMade=dateMade;
    }

    protected Guest(Parcel in) {
        prefix = in.readString();
        actualName = in.readString();
        dateMade = in.readString();
    }

    public static final Creator<Guest> CREATOR = new Creator<Guest>() {
        @Override
        public Guest createFromParcel(Parcel in) {
            return new Guest(in);
        }

        @Override
        public Guest[] newArray(int size) {
            return new Guest[size];
        }
    };


    public String getPrefix(){
        return prefix;
    }
    public void setPrefix(String prefix){
        this.prefix=prefix;
    }

    public String getActualName(){
        return actualName;
    }

    public void setActualName(String actualName){
        this.actualName=actualName;
    }

    public String getDateMade(){return dateMade;}
    public void setDateMade(String dateMade){
        this.dateMade=dateMade;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(prefix);
        dest.writeString(actualName);
        dest.writeString(dateMade);
    }
}
