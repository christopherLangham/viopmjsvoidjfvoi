package com.langham.chris.starships.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.langham.chris.starships.R;
import com.langham.chris.starships.databinding.CardViewStarShipBinding;
import com.langham.chris.starships.model.StarShip;

import java.util.List;

public class StarShipListAdapter extends RecyclerView.Adapter<StarShipViewHolder> {

    private List<StarShip> starShips;
    private final StarShipDetailListener starShipDetailListener;

    public StarShipListAdapter(final StarShipDetailListener listener, final List<StarShip> starShips) {
        this.starShipDetailListener = listener;
        this.starShips = starShips;
    }

    @NonNull
    @Override
    public StarShipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardViewStarShipBinding binding = DataBindingUtil.inflate(inflater, R.layout.card_view_star_ship, parent, false);
        return new StarShipViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StarShipViewHolder holder, final int position) {
        holder.setViewModel(starShips.get(position));
        holder.itemView.setOnClickListener(v -> starShipDetailListener.onShowDetail(starShips.get(position)));
    }

    @Override
    public int getItemCount() {
        return starShips.size();
    }

    public void setStarShips(final List<StarShip> starShips) {
        this.starShips = starShips;
        notifyDataSetChanged();
    }
}
