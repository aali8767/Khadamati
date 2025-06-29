package dev.final_group.khadamati.screens.service_provider.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import dev.final_group.khadamati.databinding.FragmentProfileServiceProviderBinding;
import dev.final_group.khadamati.screens.service_provider.EditProviderProfileActivity;


public class ProfileServiceProviderFragment extends Fragment {

    private FragmentProfileServiceProviderBinding binding;

    public ProfileServiceProviderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileServiceProviderBinding.inflate(inflater, container, false);
//        binding.tvName.setText("محمد احمد");
//        binding.tvPhone.setText("05998741513");
//        binding.tvJobTitle.setText("فني كهرباء");
        binding.editeBt.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), EditProviderProfileActivity.class));
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
