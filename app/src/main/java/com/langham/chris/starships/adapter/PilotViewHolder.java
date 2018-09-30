package com.langham.chris.starships.adapter;

import android.support.v7.widget.RecyclerView;

import com.langham.chris.starships.databinding.LineItemPilotBinding;
import com.langham.chris.starships.model.Person;
import com.langham.chris.starships.viewmodel.PilotViewModel;

public class PilotViewHolder extends RecyclerView.ViewHolder {

    private LineItemPilotBinding binding;

    public PilotViewHolder(LineItemPilotBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public void setViewModel(Person person) {
        binding.setViewModel(new PilotViewModel(person));
    }
}
