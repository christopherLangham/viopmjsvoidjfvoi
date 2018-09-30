package com.langham.chris.starships.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StarShip implements Parcelable {
    private String name;
    private String model;
    private String manufacturer;
    private String length;
    private String crew;
    private String passengers;
    private String consumables;
    private String created;
    private String edited;
    private String url;

    @SerializedName("cost_in_credits")
    private String costInCredits;

    @SerializedName("max_atmosphering_speed")
    private String maxSpeed;

    @SerializedName("cargo_capacity")
    private String cargoCapacity;

    @SerializedName("pilots")
    private List<String> pilotsUrls;

    @SerializedName("films")
    private List<String> filmsUrls;

    @SerializedName("starship_class")
    private String starShipClass;

    @SerializedName("hyperdrive_rating")
    private String hyperDriveRating;

    @SerializedName("MGLT")
    private String maxMegaLight;


    protected StarShip(Parcel in) {
        name = in.readString();
        model = in.readString();
        manufacturer = in.readString();
        length = in.readString();
        crew = in.readString();
        passengers = in.readString();
        consumables = in.readString();
        created = in.readString();
        edited = in.readString();
        url = in.readString();
        costInCredits = in.readString();
        maxSpeed = in.readString();
        cargoCapacity = in.readString();
        pilotsUrls = in.createStringArrayList();
        filmsUrls = in.createStringArrayList();
        starShipClass = in.readString();
        hyperDriveRating = in.readString();
        maxMegaLight = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(model);
        dest.writeString(manufacturer);
        dest.writeString(length);
        dest.writeString(crew);
        dest.writeString(passengers);
        dest.writeString(consumables);
        dest.writeString(created);
        dest.writeString(edited);
        dest.writeString(url);
        dest.writeString(costInCredits);
        dest.writeString(maxSpeed);
        dest.writeString(cargoCapacity);
        dest.writeStringList(pilotsUrls);
        dest.writeStringList(filmsUrls);
        dest.writeString(starShipClass);
        dest.writeString(hyperDriveRating);
        dest.writeString(maxMegaLight);
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

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
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

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public List<String> getPilotsUrls() {
        return pilotsUrls;
    }

    public void setPilotsUrls(List<String> pilotsUrls) {
        this.pilotsUrls = pilotsUrls;
    }

    public List<String> getFilmsUrls() {
        return filmsUrls;
    }

    public void setFilmsUrls(List<String> filmsUrls) {
        this.filmsUrls = filmsUrls;
    }

    public String getStarShipClass() {
        return starShipClass;
    }

    public void setStarShipClass(String starShipClass) {
        this.starShipClass = starShipClass;
    }

    public String getHyperDriveRating() {
        return hyperDriveRating;
    }

    public void setHyperDriveRating(String hyperDriveRating) {
        this.hyperDriveRating = hyperDriveRating;
    }

    public String getMaxMegaLight() {
        return maxMegaLight;
    }

    public void setMaxMegaLight(String maxMegaLight) {
        this.maxMegaLight = maxMegaLight;
    }
}
