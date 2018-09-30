package com.langham.chris.starships.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.langham.chris.starships.model.Person;

public class PilotViewModel extends ViewModel {

    private Person person;

    public PilotViewModel() {
    }

    public PilotViewModel(Person person) {
        this.person = person;
    }

    public String getName() {
        return person.getName();
    }


}
