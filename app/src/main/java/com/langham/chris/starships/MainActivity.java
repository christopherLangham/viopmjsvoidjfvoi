package com.langham.chris.starships;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.langham.chris.starships.adapter.StarShipListAdapter;
import com.langham.chris.starships.api.StarWarsApi;
import com.langham.chris.starships.databinding.ActivityMainBinding;
import com.langham.chris.starships.model.StarShipPage;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;
    private StarShipListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo set up tool bar
        //viewModel = ViewModelProviders.of(this).get(ChooseYourRewardViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //set view model if needed

        setupRecyclerAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Call<StarShipPage> call = StarWarsApi.getApi().getStarships(1);

        //spinner?
        call.enqueue(new Callback<StarShipPage>() {
            @Override
            public void onResponse(@NonNull Call<StarShipPage> call, @NonNull Response<StarShipPage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setStarShips(response.body().getStarShipList());
                    adapter.notifyDataSetChanged();
                } else {
                    Log.d(TAG, "Something went wrong. Http code " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<StarShipPage> call, @NonNull Throwable error) {
                Log.d(TAG, error.getMessage());
                //load from db??
                //alert dialog
            }
        });
    }

    private void setupRecyclerAdapter() {
        adapter = new StarShipListAdapter(Collections.emptyList());
        binding.starShipListView.setAdapter(adapter);
        binding.starShipListView.setLayoutManager(new LinearLayoutManager(this));
    }
}
