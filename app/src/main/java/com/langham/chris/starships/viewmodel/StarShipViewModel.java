package com.langham.chris.starships.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.langham.chris.starships.api.NetworkListener;
import com.langham.chris.starships.api.StarWarsApi;
import com.langham.chris.starships.model.Person;
import com.langham.chris.starships.model.StarShip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarShipViewModel extends ViewModel {

    private static final String TAG = StarShipViewModel.class.getSimpleName();
    private StarShip starShip;
    private List<Person> pilotList = new ArrayList<>();

    public StarShipViewModel() {
    }

    public StarShipViewModel(final StarShip starShip) {
        this.starShip = starShip;
    }

    public String getShipName() {
        return starShip.getName();
    }

    public String getManufacturer() {
        return starShip.getManufacturer();
    }

    public String getModel() {
        return "Model: " + starShip.getModel();
    }

    public String getShipClass() {
        return "Class: " + starShip.getStarShipClass();
    }

    public String getManufacturerFormatted() {
        return "Manufacturer: " + starShip.getManufacturer();
    }

    public String getValue() {
        String value = "Value: " + starShip.getCostInCredits();
        if (starShip.getCostInCredits().equals("unknown")) {
            return value;
        } else {
            return value + " credits";
        }
    }

    public String getCrewSize() {
        return "Crew: " + starShip.getCrew();
    }

    public String getPassengerCapacity() {
        return "Passengers: " + starShip.getPassengers();
    }

    public String getCargoCapacity() {
        return "Cargo Capacity: " + starShip.getCargoCapacity();
    }

    public void setStarShip(final StarShip starShip) {
        this.starShip = starShip;
    }

    public List<Person> getPilotList() {
        return pilotList;
    }

    public void getPilotsInfo(NetworkListener<Person> listener) {
        for (int personId : getPilotIds()) {
            retrievePersonInfo(personId, listener);
        }
    }

    private void retrievePersonInfo(int personId, NetworkListener<Person> listener) {
        Call<Person> call = StarWarsApi.getApi().getPerson(personId);
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(@NonNull Call<Person> call, @NonNull final Response<Person> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(new Throwable("Something went wrong getting person " + personId
                            + ". Http code " + response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Person> call, @NonNull Throwable error) {
                listener.onFailure(error);
            }
        });
    }

    private List<Integer> getPilotIds() {
        List<Integer> pilotIds = new ArrayList<>();
        for (String pilotUrl : starShip.getPilotsUrls()) {
            pilotUrl = pilotUrl.replaceAll("\\D+", "");
            pilotIds.add(Integer.valueOf(pilotUrl));
        }
        return pilotIds;
    }

    public void addPilot(final Person person) {
        this.pilotList.add(person);
    }
}
