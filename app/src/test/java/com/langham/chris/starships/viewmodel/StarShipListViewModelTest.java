package com.langham.chris.starships.viewmodel;

import com.langham.chris.starships.model.StarShipPage;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class StarShipListViewModelTest {

    private StarShipListViewModel viewModel;
    private int visibleItemCount = 6;
    private int totalItemCount = 10;
    private int firstVisibleItem = 4;
    private StarShipPage starShipPage = new StarShipPage();

    @Before
    public void setUp() throws Exception {
        viewModel = new StarShipListViewModel();
        starShipPage.setNext("https://nextUrl2");
        setPrivateField("currentPage", starShipPage);
    }

    @Test
    public void shouldLoadMoreShouldReturnFalseWhenIsLoadingIsTrue() {
        setPrivateField("isLoading", true);

        boolean result = viewModel.shouldLoadMoreStarShips(visibleItemCount, totalItemCount, firstVisibleItem);

        assertEquals(false, result);
    }

    @Test
    public void shouldLoadMoreShouldReturnFalseWhenCurrentPageDoesNotHaveNextPage() {
        setPrivateField("currentPage", new StarShipPage());

        boolean result = viewModel.shouldLoadMoreStarShips(visibleItemCount, totalItemCount, firstVisibleItem);

        assertEquals(false, result);
    }

    @Test
    public void shouldLoadMoreShouldReturnFalseWhenFirstVisibleIsZero() {
        firstVisibleItem = 0;

        boolean result = viewModel.shouldLoadMoreStarShips(visibleItemCount, totalItemCount, firstVisibleItem);

        assertEquals(false, result);
    }

    @Test
    public void shouldLoadMoreShouldReturnFalseWhenVisibleItemsIsNotMoreThanTotalItemCount() {
        totalItemCount = 20;

        boolean result = viewModel.shouldLoadMoreStarShips(visibleItemCount, totalItemCount, firstVisibleItem);

        assertEquals(false, result);
    }

    @Test
    public void shouldLoadMoreShouldReturnTrueWhenWhenVisibleItemsIsMoreThanTotalItemCount() {
        boolean result = viewModel.shouldLoadMoreStarShips(visibleItemCount, totalItemCount, firstVisibleItem);

        assertEquals(true, result);
    }

    @Test
    public void getNextPageIndexShouldReturnOneForNullPage() {
        setPrivateField("currentPage", null);

        int result = viewModel.getNextPageIndex();

        assertEquals(1, result);
    }

    @Test
    public void getNextPageIndexShouldReturnNextPageIndexWhenPageIsNotNull() {
        int result = viewModel.getNextPageIndex();

        assertEquals(2, result);
    }

    private void setPrivateField(String fieldName, Object value) {
        try {
            Field field = viewModel.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(viewModel, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}