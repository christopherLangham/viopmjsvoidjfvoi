package com.langham.chris.starships;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.langham.chris.starships.adapter.StarShipDetailListener;
import com.langham.chris.starships.adapter.StarShipListAdapter;
import com.langham.chris.starships.api.NetworkListener;
import com.langham.chris.starships.databinding.ActivityMainBinding;
import com.langham.chris.starships.model.StarShip;
import com.langham.chris.starships.viewmodel.StarShipListViewModel;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StarShipDetailListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;
    private StarShipListAdapter adapter;
    private StarShipListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupViewModel();
        setupRecyclerAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (viewModel.getStarShips().size() > 0) {
            adapter.setStarShips(viewModel.getStarShips());
            return;
        }

        viewModel.getFirstStarShipPage(new NetworkListener<List<StarShip>>() {
            @Override
            public void onSuccess(List<StarShip> starShips) {
                viewModel.setStarShips(starShips);
                adapter.setStarShips(viewModel.getStarShips());
            }

            @Override
            public void onFailure(Throwable error) {
                Log.d(TAG, error.getMessage());
                //load from database to see if we can show something to the user
                //possibly show an alert dialog
            }
        });
    }

    @Override
    public void onShowDetail(StarShip starShip) {
        Intent intent = new Intent(this, StarShipActivity.class);
        intent.putExtra(StarShipActivity.STAR_SHIP_KEY, starShip);
        startActivity(intent);
    }

    private void setupRecyclerAdapter() {
        adapter = new StarShipListAdapter(this, Collections.emptyList());
        binding.starShipListView.setAdapter(adapter);
        binding.starShipListView.setLayoutManager(new LinearLayoutManager(this));
        binding.starShipListView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) binding.starShipListView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemIndex = layoutManager.findFirstVisibleItemPosition();

                if (viewModel.shouldLoadMoreStarShips(visibleItemCount, totalItemCount, firstVisibleItemIndex)) {
                    binding.spinner.setVisibility(View.VISIBLE);
                    viewModel.getNextStarShipPage(new NetworkListener<List<StarShip>>() {
                        @Override
                        public void onSuccess(List<StarShip> starShips) {
                            viewModel.addStarShips(starShips);
                            adapter.setStarShips(viewModel.getStarShips());
                            binding.spinner.setVisibility(View.GONE);
                        }

                        @Override
                        public void onFailure(Throwable error) {
                            Log.d(TAG, error.getMessage());
                        }
                    });
                }
            }
        });
    }

    private void setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(StarShipListViewModel.class);
    }
}
