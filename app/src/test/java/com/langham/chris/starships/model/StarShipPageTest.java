package com.langham.chris.starships.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class StarShipPageTest {

    private StarShipPage starShipPage = new StarShipPage();

    @Test
    public void getNextIndexShouldZeroWhenNextIsNull() {
        assertEquals(0, starShipPage.getNextIndex());
    }

    @Test
    public void getNextIndexShouldReturnNumberWhenNextIsNotNull() {
        starShipPage.setNext("erierio1dksdf");
        assertEquals(1, starShipPage.getNextIndex());
    }
}