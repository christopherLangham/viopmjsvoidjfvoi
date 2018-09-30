package com.langham.chris.starships.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.langham.chris.starships.api.NetworkListener;
import com.langham.chris.starships.api.StarWarsApi;
import com.langham.chris.starships.model.StarShip;
import com.langham.chris.starships.model.StarShipPage;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarShipListViewModel extends ViewModel {

    private StarShipPage currentPage;
    private final int FIRST_PAGE_INDEX = 1;
    private boolean isLoading = false;
    private List<StarShip> starShips = Collections.emptyList();

    public void getNextStarShipPage(final NetworkListener<List<StarShip>> listener) {
        getStarShips(getNextPageIndex(), listener);
    }

    public void getFirstStarShipPage(final NetworkListener<List<StarShip>> listener) {
        getStarShips(FIRST_PAGE_INDEX, listener);
    }

    private void getStarShips(final int pageIndex, final NetworkListener<List<StarShip>> listener) {
        isLoading = true;
        Call<StarShipPage> call = StarWarsApi.getApi().getStarShips(pageIndex);
        call.enqueue(new Callback<StarShipPage>() {
            @Override
            public void onResponse(@NonNull Call<StarShipPage> call, @NonNull Response<StarShipPage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    currentPage = response.body();
                    listener.onSuccess(response.body().getStarShipList());
                } else {
                    listener.onFailure(new Throwable("Something went wrong. Http code " + response.code()));
                }
                isLoading = false;
            }

            @Override
            public void onFailure(@NonNull Call<StarShipPage> call, @NonNull Throwable error) {
                listener.onFailure(error);
                isLoading = false;
            }
        });
    }

    public boolean shouldLoadMoreStarShips(final int visibleItemCount, final int totalItemCount, final int firstVisibleItemIndex) {
        return visibleItemCount + firstVisibleItemIndex >= totalItemCount
                && firstVisibleItemIndex > 0
                && !isLoading
                && currentPage.hasNext();
    }

    int getNextPageIndex() {
        if (currentPage == null) {
            return FIRST_PAGE_INDEX;
        } else {
            return currentPage.getNextIndex();
        }
    }

    public void setStarShips(final List<StarShip> starShips) {
        this.starShips = starShips;
    }

    public void addStarShips(final List<StarShip> starShips) {
        this.starShips.addAll(starShips);
    }

    public List<StarShip> getStarShips() {
        return starShips;
    }
}
