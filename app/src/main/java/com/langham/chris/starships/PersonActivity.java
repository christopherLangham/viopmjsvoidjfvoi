package com.langham.chris.starships;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.langham.chris.starships.databinding.ActivityPersonBinding;
import com.langham.chris.starships.model.Person;
import com.langham.chris.starships.model.StarShip;
import com.langham.chris.starships.viewmodel.PilotViewModel;
import com.langham.chris.starships.viewmodel.PlanetViewModel;

import static com.langham.chris.starships.StarShipActivity.STAR_SHIP_KEY;

public class PersonActivity extends AppCompatActivity {

    public static final String PILOT_KEY = "pilotKey";

    private ActivityPersonBinding binding;
    private PilotViewModel pilotViewModel;
    private PlanetViewModel plantViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_person);
        setupViewModels();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (plantViewModel.getName() == null) {
            plantViewModel.getPlanetInfo(pilotViewModel.getHomeWorldId());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, StarShipActivity.class);
        intent.putExtra(STAR_SHIP_KEY, pilotViewModel.getStarShip());
        startActivity(intent);
    }

    private void setupViewModels() {
        StarShip starShip = getIntent().getParcelableExtra(STAR_SHIP_KEY);
        Person person = getIntent().getParcelableExtra(PILOT_KEY);
        pilotViewModel = ViewModelProviders.of(this).get(PilotViewModel.class);
        pilotViewModel.setPilot(person);
        pilotViewModel.setStarShip(starShip);

        plantViewModel = new PlanetViewModel();
        binding.setWorldViewModel(plantViewModel);

        setTitle(pilotViewModel.getName());
        binding.setPilotViewModel(pilotViewModel);
    }
}
