package com.langham.chris.starships.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.langham.chris.starships.api.NetworkListener;
import com.langham.chris.starships.api.StarWarsApi;
import com.langham.chris.starships.model.Person;
import com.langham.chris.starships.model.StarShip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class StarShipViewModel extends ViewModel {

    private static final String TAG = StarShipViewModel.class.getSimpleName();
    private StarShip starShip;
    private List<Person> pilotList = Collections.emptyList();

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

    public void setPilotList(final List<Person> pilotList) {
        this.pilotList = pilotList;
    }

    public void getPilotsInfo(NetworkListener<List<Person>> listener) {
        List<Integer> personIds = getPilotIds();
        this.pilotList = new ArrayList<>();

        for (int personId : personIds) {
            try {
                retrievePersonInfo(personId);
            } catch (IOException e) {
                Log.d(TAG, "Something went wrong getting person " + personId
                        + "Error: " + e.getMessage());
            }
        }

        if (listener == null) {
            return;
        }

        if (pilotList.size() > 0) {
            listener.onSuccess(this.pilotList);
        }
    }

    private void retrievePersonInfo(int personId) throws IOException {
        Call<Person> call = StarWarsApi.getApi().getPerson(personId);
        Response<Person> response = call.execute();
        if (response.isSuccessful() && response.body() != null) {
            pilotList.add(response.body());
        } else {
            Log.d(TAG, "Something went wrong getting person " + personId
                    + ". Http code " + response.code());
        }
    }

    private List<Integer> getPilotIds() {
        List<Integer> pilotIds = new ArrayList<>();
        for (String pilotUrl : starShip.getPilotsUrls()) {
            pilotUrl = pilotUrl.replaceAll("\\D+", "");
            pilotIds.add(Integer.valueOf(pilotUrl));
        }
        return pilotIds;
    }
}
