package com.langham.chris.starships.api;

import com.langham.chris.starships.model.Person;
import com.langham.chris.starships.model.StarShip;
import com.langham.chris.starships.model.StarShipPage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StarWarsService {

    @GET("/api/people/{id}/")
    Call<Person> getPerson(@Path("id") int peopleId);

    @GET("/api/starships")
    Call<StarShipPage> getStarShips(@Query("page") int page);

    @GET("/api/starships/{id}/")
    Call<StarShip> getStarShip(@Path("id") int starShipId);
}
