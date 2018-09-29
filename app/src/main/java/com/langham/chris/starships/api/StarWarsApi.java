package com.langham.chris.starships.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StarWarsApi {

    private static final String BASE_URL = "https://swapi.co/";
    public static final String STAR_SHIPS_URL = BASE_URL + "api/starships/?page=";
    private static StarWarsApi apiInstance;
    private StarWarsService starWarsService;

    private StarWarsApi() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        starWarsService = retrofit.create(StarWarsService.class);
    }

    public static StarWarsService getApi() {
        if (apiInstance == null) {
            apiInstance = new StarWarsApi();
        }
        return apiInstance.starWarsService;
    }
}
