package com.langham.chris.starships.viewmodel;

import com.langham.chris.starships.model.Person;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotViewModelTest {

    private PilotViewModel viewModel;
    private Person person;

    @Before
    public void setUp() {
        viewModel = new PilotViewModel();
        person = new Person();
        person.setName("Han Solo");
        viewModel.setPilot(person);
    }

    @Test
    public void getNameShouldReturnPilotName() {
        assertEquals("Han Solo", viewModel.getName());
    }

}