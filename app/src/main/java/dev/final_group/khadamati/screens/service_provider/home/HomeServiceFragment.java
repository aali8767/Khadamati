package dev.final_group.khadamati.screens.service_provider.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import dev.final_group.khadamati.adapters.RecentJobsAdapter;
import dev.final_group.khadamati.databinding.FragmentHomeServiceBinding;
import dev.final_group.khadamati.screens.service_provider.RatingActivity;

public class HomeServiceFragment extends Fragment {
    private FragmentHomeServiceBinding binding;

    public HomeServiceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeServiceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ratingCard.setOnClickListener(v -> {
            startActivity(new Intent(requireContext(), RatingActivity.class));
        });

        binding.recyclerRecentJobs.setHasFixedSize(true);
        binding.recyclerRecentJobs.setLayoutManager(new LinearLayoutManager(requireContext()));

        RecentJobsAdapter adapter = new RecentJobsAdapter();
        binding.recyclerRecentJobs.setAdapter(adapter);
    }
}
