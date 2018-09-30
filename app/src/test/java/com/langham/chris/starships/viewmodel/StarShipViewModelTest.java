package com.langham.chris.starships.viewmodel;

import com.langham.chris.starships.model.Person;
import com.langham.chris.starships.model.StarShip;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class StarShipViewModelTest {

    private StarShipViewModel viewModel = new StarShipViewModel();
    private StarShip starShip = new StarShip();

    @Test
    public void getValueAddCreditsStringWhenTheShipPriceIsKnown() {
        starShip.setCostInCredits("1234");
        viewModel.setStarShip(starShip);

        String result = viewModel.getValue();

        assertEquals("Value: 1234 credits", result);
    }

    @Test
    public void getValueShouldNotHaveCreditsInResultWhenShipPriceIsUnknown() {
        starShip.setCostInCredits("unknown");
        viewModel.setStarShip(starShip);

        String result = viewModel.getValue();

        assertEquals("Value: unknown", result);
    }

    @Test
    public void getPilotIdsShouldReturnEmptyListWhenStapShipHasZeroPilots() {
        starShip.setPilotsUrls(Collections.emptyList());
        viewModel.setStarShip(starShip);

        List result = viewModel.getPilotIds();

        assertEquals(0, result.size());
    }

    @Test
    public void getPilotIdsShouldReturnListOfIdsFromPilotUrls() {
        List<String> urls = new ArrayList<>();
        urls.add("weokf1dlkf");
        urls.add("2slsdf///");
        urls.add("dlksflkw3");
        starShip.setPilotsUrls(urls);
        viewModel.setStarShip(starShip);

        List result = viewModel.getPilotIds();

        assertEquals(3, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(3, result.get(2));
    }
}