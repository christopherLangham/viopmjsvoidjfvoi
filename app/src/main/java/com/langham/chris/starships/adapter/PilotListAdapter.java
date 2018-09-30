package com.langham.chris.starships.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.langham.chris.starships.R;
import com.langham.chris.starships.databinding.LineItemPilotBinding;
import com.langham.chris.starships.model.Person;

import java.util.List;

public class PilotListAdapter extends RecyclerView.Adapter<PilotViewHolder> {

    private List<Person> pilotList;
    private final PilotInfoListener pilotInfoListener;

    public PilotListAdapter(final PilotInfoListener listener, final List<Person> pilotList) {
        this.pilotInfoListener = listener;
        this.pilotList = pilotList;
    }

    @NonNull
    @Override
    public PilotViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LineItemPilotBinding binding = DataBindingUtil.inflate(inflater, R.layout.line_item_pilot, parent, false);
        return new PilotViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final PilotViewHolder holder, final int position) {
        holder.setViewModel(pilotList.get(position));
        holder.itemView.setOnClickListener(v -> pilotInfoListener.onShowPerson(pilotList.get(position)));
    }

    @Override
    public int getItemCount() {
        return pilotList.size();
    }

    public void setPilotList(final List<Person> pilotList) {
        this.pilotList = pilotList;
        notifyDataSetChanged();
    }
}
