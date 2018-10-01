package com.langham.chris.starships.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.langham.chris.starships.model.Person;
import com.langham.chris.starships.model.StarShip;

public class PilotViewModel extends ViewModel {

    private Person pilot;
    private StarShip starShip;

    public PilotViewModel() {
    }

    public PilotViewModel(final Person person) {
        this.pilot = person;
    }

    public String getName() {
        return pilot.getName();
    }

    public String getHeight() {
        return "Height: " + pilot.getHeight() + " cm";
    }

    public String getWeight() {
        return "Weight: " + pilot.getMass() + " kg";
    }

    public int getHomeWorldId() {
        String planetId = pilot.getHomeWorldUrl().replaceAll("\\D+", "");
        return Integer.valueOf(planetId);
    }

    public void setPilot(final Person person) {
        this.pilot = person;
    }


    public StarShip getStarShip() {
        return starShip;
    }

    public void setStarShip(StarShip starShip) {
        this.starShip = starShip;
    }
}
