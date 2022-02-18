package com.example.hw1a3again.ui.films_details;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hw1a3again.App;
import com.example.hw1a3again.R;
import com.example.hw1a3again.data.models.Film;
import com.example.hw1a3again.databinding.FragmentFilmDetailBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailFragment extends Fragment {
    private FragmentFilmDetailBinding binding;

    public FilmDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        App.api.getFilmById(getArguments().getString("getId")).enqueue(new Callback<Film>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(getContext(), "Success!", Toast.LENGTH_SHORT).show();

                    Glide.with(getContext()).load(response.body().getMovieBanner()).into(binding.ivBanner);
                    binding.tvTitle.setText(response.body().getTitle());
                    binding.tvAnotherTitle.setText(response.body().getOriginalTitle());
                    binding.tvDirector.setText("Director: " + response.body().getDirector());
                    binding.tvProducer.setText("Producer: " + response.body().getProducer());
                    binding.tvDescription.setText(response.body().getDescription());
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }
}