package com.langham.chris.starships.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StarShipPage implements Parcelable {
    private String next;

    @SerializedName("results")
    private List<StarShip> starShipList;

    public StarShipPage() {
    }

    public boolean hasNext() {
        return next != null;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<StarShip> getStarShipList() {
        return starShipList;
    }

    public int getNextIndex() {
        if (hasNext()) {
            String nextUrl = getNext().replaceAll("\\D+", "");
            return Integer.valueOf(nextUrl);
        } else {
            return 0;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(next);
        dest.writeTypedList(starShipList);
    }

    protected StarShipPage(Parcel in) {
        next = in.readString();
        starShipList = in.createTypedArrayList(StarShip.CREATOR);
    }

    public static final Creator<StarShipPage> CREATOR = new Creator<StarShipPage>() {
        @Override
        public StarShipPage createFromParcel(Parcel in) {
            return new StarShipPage(in);
        }

        @Override
        public StarShipPage[] newArray(int size) {
            return new StarShipPage[size];
        }
    };
}
