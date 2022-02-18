package com.example.hw1a3again.ui.films;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hw1a3again.App;
import com.example.hw1a3again.R;
import com.example.hw1a3again.common.OnItemClick;
import com.example.hw1a3again.data.models.Film;
import com.example.hw1a3again.databinding.FragmentFilmsBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsFragment extends Fragment implements OnItemClick<String> {
    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    public FilmsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new FilmsAdapter();
        adapter.setListener(this);

        getFilms();

        binding.recycler.setAdapter(adapter);
    }

    private void getFilms() {
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(getContext(), "Success!", Toast.LENGTH_SHORT).show();

                    adapter.setFilms(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed to load this response! (" + t + ")", Toast.LENGTH_SHORT).show();
                Log.e("f_global", "onFailure: " + t);
            }
        });
    }

    @Override
    public void onItemClick(String data) {
        Log.d("f_global", "onItemClick: " + "got id: " + data);

        Bundle bundle = new Bundle();
        bundle.putString("getId", data);

        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.filmDetailFragment, bundle);
    }
}