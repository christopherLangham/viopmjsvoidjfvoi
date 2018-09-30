package com.langham.chris.starships.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.langham.chris.starships.StarShipActivity;
import com.langham.chris.starships.model.Person;
import com.langham.chris.starships.model.StarShip;

import java.util.List;

public class PilotListAdapter extends RecyclerView.Adapter<PilotViewHolder> {

    private List<Person> pilotList;

    public PilotListAdapter(final List<Person> pilotList) {
        this.pilotList = pilotList;
    }

    @NonNull
    @Override
    public PilotViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final PilotViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return pilotList.size();
    }

    public void setPilotList(final List<Person> pilotList) {
        this.pilotList = pilotList;
    }
}
