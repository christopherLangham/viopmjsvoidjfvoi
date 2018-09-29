package com.langham.chris.starships.adapter;

import android.support.v7.widget.RecyclerView;

import com.langham.chris.starships.databinding.CardViewStarShipBinding;
import com.langham.chris.starships.model.StarShip;
import com.langham.chris.starships.viewmodel.StarShipViewModel;

public class StarShipViewHolder extends RecyclerView.ViewHolder {

    private CardViewStarShipBinding binding;

    public StarShipViewHolder(final CardViewStarShipBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setViewModel(final StarShip starShip) {
        binding.setViewModel(new StarShipViewModel(starShip));
    }
}
