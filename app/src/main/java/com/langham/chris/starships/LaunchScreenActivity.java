package com.langham.chris.starships;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.langham.chris.starships.api.NetworkListener;
import com.langham.chris.starships.model.StarShip;
import com.langham.chris.starships.viewmodel.StarShipListViewModel;

import java.util.List;

import static com.langham.chris.starships.MainActivity.STAR_SHIPS_KEY;

public class LaunchScreenActivity extends AppCompatActivity {

    private StarShipListViewModel viewModel;
    private static final String TAG = LaunchScreenActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        viewModel = ViewModelProviders.of(this).get(StarShipListViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (viewModel.getStarShips().size() > 0) {
            startMainActivity();
            return;
        }

        viewModel.getFirstStarShipPage(new NetworkListener<List<StarShip>>() {
            @Override
            public void onSuccess(List<StarShip> starShips) {
                viewModel.setStarShips(starShips);
                startMainActivity();
            }

            @Override
            public void onFailure(Throwable error) {
                Log.d(TAG, error.getMessage());
                //load from database to see if we can show something to the user
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(STAR_SHIPS_KEY, viewModel.getCurrentPage());
        startActivity(intent);
        finish();
    }
}

