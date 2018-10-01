package com.langham.chris.starships.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StarShip implements Parcelable {
    private String name;
    private String model;
    private String manufacturer;
    private String crew;
    private String passengers;

    @SerializedName("cost_in_credits")
    private String costInCredits;

    @SerializedName("cargo_capacity")
    private String cargoCapacity;

    @SerializedName("pilots")
    private List<String> pilotsUrls;

    @SerializedName("starship_class")
    private String starShipClass;

    public StarShip() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public List<String> getPilotsUrls() {
        return pilotsUrls;
    }

    public void setPilotsUrls(List<String> pilotsUrls) {
        this.pilotsUrls = pilotsUrls;
    }

    public String getStarShipClass() {
        return starShipClass;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(model);
        dest.writeString(manufacturer);
        dest.writeString(crew);
        dest.writeString(passengers);
        dest.writeString(costInCredits);
        dest.writeString(cargoCapacity);
        dest.writeStringList(pilotsUrls);
        dest.writeString(starShipClass);
    }

    protected StarShip(Parcel in) {
        name = in.readString();
        model = in.readString();
        manufacturer = in.readString();
        crew = in.readString();
        passengers = in.readString();
        costInCredits = in.readString();
        cargoCapacity = in.readString();
        pilotsUrls = in.createStringArrayList();
        starShipClass = in.readString();
    }

    public static final Creator<StarShip> CREATOR = new Creator<StarShip>() {
        @Override
        public StarShip createFromParcel(Parcel in) {
            return new StarShip(in);
        }

        @Override
        public StarShip[] newArray(int size) {
            return new StarShip[size];
        }
    };

}
