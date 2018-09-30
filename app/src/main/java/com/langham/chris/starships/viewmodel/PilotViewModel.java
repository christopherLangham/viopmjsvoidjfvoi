package com.langham.chris.starships.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.langham.chris.starships.model.Person;

public class PilotViewModel extends ViewModel {

    private Person pilot;

    public PilotViewModel() {
    }

    public PilotViewModel(final Person person) {
        this.pilot = person;
    }

    public String getName() {
        return pilot.getName();
    }

    public void setPilot(final Person person) {
        this.pilot = person;
    }


}
