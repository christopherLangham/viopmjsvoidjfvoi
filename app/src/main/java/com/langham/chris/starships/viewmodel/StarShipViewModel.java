package com.langham.chris.starships.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.langham.chris.starships.model.StarShip;

public class StarShipViewModel extends ViewModel {

    public StarShip starShip;

    public StarShipViewModel(final StarShip starShip) {
        this.starShip = starShip;
    }

    public String getShipName() {
        return starShip.getName();
    }

    public String getManufacturer() {
        return starShip.getManufacturer();
    }
}
