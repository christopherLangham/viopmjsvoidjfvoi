package com.langham.chris.starships.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StarShipPage implements Parcelable {

    private int count;
    private String next;
    private String previous;

    @SerializedName("results")
    private List<StarShip> starShipList;


    protected StarShipPage(Parcel in) {
        count = in.readInt();
        next = in.readString();
        previous = in.readString();
        starShipList = in.createTypedArrayList(StarShip.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeString(next);
        dest.writeString(previous);
        dest.writeTypedList(starShipList);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public boolean hasNext() {
        return next != null;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<StarShip> getStarShipList() {
        return starShipList;
    }

    public void setStarShipList(List<StarShip> starShipList) {
        this.starShipList = starShipList;
    }

    public int getNextIndex() {
        if (hasNext()) {
            String nextUrl = getNext().replaceAll("\\D+", "");
            return Integer.valueOf(nextUrl);
        } else {
            return 0;
        }
    }
}
