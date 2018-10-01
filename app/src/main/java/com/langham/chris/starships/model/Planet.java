package com.langham.chris.starships.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Planet implements Parcelable {

    private String name;
    private String population;
    private String climate;

    public Planet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public String getClimate() {
        return climate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(population);
        dest.writeString(climate);
    }

    protected Planet(Parcel in) {
        name = in.readString();
        population = in.readString();
        climate = in.readString();
    }

    public static final Creator<Planet> CREATOR = new Creator<Planet>() {
        @Override
        public Planet createFromParcel(Parcel in) {
            return new Planet(in);
        }

        @Override
        public Planet[] newArray(int size) {
            return new Planet[size];
        }
    };
}
