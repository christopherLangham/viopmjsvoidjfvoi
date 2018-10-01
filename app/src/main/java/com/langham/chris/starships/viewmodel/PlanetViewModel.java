package com.langham.chris.starships.viewmodel;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.langham.chris.starships.api.StarWarsApi;
import com.langham.chris.starships.model.Planet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetViewModel extends BaseObservable {

    private static final String TAG = PlanetViewModel.class.getSimpleName();

    private Planet planet = new Planet();

    public PlanetViewModel() {
    }

    public String getName() {
        return planet.getName();
    }

    public String getClimate() {
        return "Climate: " + planet.getClimate();
    }

    public String getPopulation() {
        return "Population: " + planet.getPopulation();
    }

    public void getPlanetInfo(int plantId) {
        Call<Planet> call = StarWarsApi.getApi().getPlanet(plantId);
        call.enqueue(new Callback<Planet>() {
            @Override
            public void onResponse(@NonNull Call<Planet> call, @NonNull final Response<Planet> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PlanetViewModel.this.planet = response.body();
                    notifyChange();
                } else {
                    Log.d(TAG, "Something went wrong getting planet " + plantId
                            + ". Http code " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Planet> call, @NonNull Throwable error) {
                Log.d(TAG, error.getMessage());
            }
        });
    }
}
