package com.langham.chris.starships;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.langham.chris.starships.adapter.PilotInfoListener;
import com.langham.chris.starships.adapter.PilotListAdapter;
import com.langham.chris.starships.api.NetworkListener;
import com.langham.chris.starships.databinding.ActivityStarShipBinding;
import com.langham.chris.starships.model.Person;
import com.langham.chris.starships.model.StarShip;
import com.langham.chris.starships.viewmodel.StarShipViewModel;

import java.util.Collections;

public class StarShipActivity extends AppCompatActivity implements PilotInfoListener {

    public static final String STAR_SHIP_KEY = "starShipKey";
    private static final String TAG = StarShipActivity.class.getSimpleName();

    private ActivityStarShipBinding binding;
    private StarShipViewModel viewModel;
    private PilotListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_star_ship);
        setupViewModels();
        setupRecyclerAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (viewModel.getPilotList().size() > 0) {
            adapter.setPilotList(viewModel.getPilotList());
            return;
        }

        viewModel.getPilotsInfo(new NetworkListener<Person>() {
            @Override
            public void onSuccess(Person person) {
                viewModel.addPilot(person);
                adapter.setPilotList(viewModel.getPilotList());
            }

            @Override
            public void onFailure(Throwable error) {
                Log.d(TAG, error.getMessage());
            }
        });
    }

    private void setupViewModels() {
        StarShip starShip = getIntent().getParcelableExtra(STAR_SHIP_KEY);
        viewModel = ViewModelProviders.of(this).get(StarShipViewModel.class);
        viewModel.setStarShip(starShip);

        setTitle(viewModel.getShipName());
        binding.setViewModel(viewModel);
    }

    private void setupRecyclerAdapter() {
        adapter = new PilotListAdapter(this, Collections.emptyList());
        binding.pilotListView.setAdapter(adapter);
        binding.pilotListView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onShowPerson(Person person) {
        Log.d(TAG, person.getName());
    }
}
