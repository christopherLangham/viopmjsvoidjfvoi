package com.langham.chris.starships.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Planet implements Parcelable {

    private String name;
    private String diameter;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    private String created;
    private String edited;
    private String url;

    @SerializedName("rotation_period")
    private String rotationPeriod;

    @SerializedName("orbital_period")
    private String orbitalPeriod;

    @SerializedName("surface_water")
    private String surfaceWater;

    @SerializedName("residents")
    private List<String> residentsUrls;

    @SerializedName("films")
    private List<String> filmsUrls;

    public Planet() {
    }

    protected Planet(Parcel in) {
        name = in.readString();
        diameter = in.readString();
        gravity = in.readString();
        population = in.readString();
        climate = in.readString();
        terrain = in.readString();
        created = in.readString();
        edited = in.readString();
        url = in.readString();
        rotationPeriod = in.readString();
        orbitalPeriod = in.readString();
        surfaceWater = in.readString();
        residentsUrls = in.createStringArrayList();
        filmsUrls = in.createStringArrayList();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(diameter);
        dest.writeString(gravity);
        dest.writeString(population);
        dest.writeString(climate);
        dest.writeString(terrain);
        dest.writeString(created);
        dest.writeString(edited);
        dest.writeString(url);
        dest.writeString(rotationPeriod);
        dest.writeString(orbitalPeriod);
        dest.writeString(surfaceWater);
        dest.writeStringList(residentsUrls);
        dest.writeStringList(filmsUrls);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public List<String> getResidentsUrls() {
        return residentsUrls;
    }

    public void setResidentsUrls(List<String> residentsUrls) {
        this.residentsUrls = residentsUrls;
    }

    public List<String> getFilmsUrls() {
        return filmsUrls;
    }

    public void setFilmsUrls(List<String> filmsUrls) {
        this.filmsUrls = filmsUrls;
    }
}
