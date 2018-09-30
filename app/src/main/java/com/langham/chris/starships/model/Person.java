package com.langham.chris.starships.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Person implements Parcelable {
    private String name;
    private String gender;
    private String height;
    private String mass;
    private String url;


    @SerializedName("birth_year")
    private String birthYear;

    @SerializedName("hair_color")
    private String hairColor;

    @SerializedName("homeworld")
    private String homeWorldUrl;

    @SerializedName("skin_color")
    private String skinColor;

    @SerializedName("films")
    private List<String> filmsUrls;

    @SerializedName("species")
    private List<String> speciesUrls;

    @SerializedName("starships")
    private List<String> starShipsUrls;

    @SerializedName("vehicles")
    private List<String> vehiclesUrls;

    public Person() {
    }

    protected Person(Parcel in) {
        name = in.readString();
        gender = in.readString();
        height = in.readString();
        mass = in.readString();
        url = in.readString();
        birthYear = in.readString();
        hairColor = in.readString();
        homeWorldUrl = in.readString();
        skinColor = in.readString();
        filmsUrls = in.createStringArrayList();
        speciesUrls = in.createStringArrayList();
        starShipsUrls = in.createStringArrayList();
        vehiclesUrls = in.createStringArrayList();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(height);
        dest.writeString(mass);
        dest.writeString(url);
        dest.writeString(birthYear);
        dest.writeString(hairColor);
        dest.writeString(homeWorldUrl);
        dest.writeString(skinColor);
        dest.writeStringList(filmsUrls);
        dest.writeStringList(speciesUrls);
        dest.writeStringList(starShipsUrls);
        dest.writeStringList(vehiclesUrls);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHomeWorldUrl() {
        return homeWorldUrl;
    }

    public void setHomeWorldUrl(String homeWorldUrl) {
        this.homeWorldUrl = homeWorldUrl;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public List<String> getFilmsUrls() {
        return filmsUrls;
    }

    public void setFilmsUrls(List<String> filmsUrls) {
        this.filmsUrls = filmsUrls;
    }

    public List<String> getSpeciesUrls() {
        return speciesUrls;
    }

    public void setSpeciesUrls(List<String> speciesUrls) {
        this.speciesUrls = speciesUrls;
    }

    public List<String> getStarShipsUrls() {
        return starShipsUrls;
    }

    public void setStarShipsUrls(List<String> starShipsUrls) {
        this.starShipsUrls = starShipsUrls;
    }

    public List<String> getVehiclesUrls() {
        return vehiclesUrls;
    }

    public void setVehiclesUrls(List<String> vehiclesUrls) {
        this.vehiclesUrls = vehiclesUrls;
    }
}
