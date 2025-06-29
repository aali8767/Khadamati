package dev.final_group.khadamati.screens.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.final_group.khadamati.CategoryData;

import dev.final_group.khadamati.databinding.FragmentProviderRegisterBinding;

import dev.final_group.khadamati.screens.service_provider.home.HomeServiceProviderActivity;

public class ProviderRegisterFragment extends Fragment {
    private FragmentProviderRegisterBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentProviderRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                CategoryData.getJobTitles()
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerJobTitles.setAdapter(adapter);
        binding.spinnerJobTitles.setSelection(0);


        binding.signUpBt.setOnClickListener(v -> {
            String selectedJobTitle = (String) binding.spinnerJobTitles.getSelectedItem();
            int jobId = CategoryData.getJobIdByTitle(selectedJobTitle);
            if (jobId != -1) {
                Toast.makeText(requireContext(), selectedJobTitle + " " + jobId, Toast.LENGTH_SHORT).show();
            }

            startActivity(new Intent(requireContext(), HomeServiceProviderActivity.class));
        });
    }
}
