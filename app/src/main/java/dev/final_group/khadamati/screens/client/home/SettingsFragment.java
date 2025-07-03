package dev.final_group.khadamati.screens.client.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.final_group.khadamati.MainActivity;
import dev.final_group.khadamati.databinding.FragmentSettingsBinding;
import dev.final_group.khadamati.screens.client.EditeProfileActivity;
import dev.final_group.khadamati.screens.client.BookMarksActivity;


public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding binding;


    public SettingsFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnLogout.setOnClickListener(view1 -> {
            Intent intent = new Intent(requireContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK + Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        binding.btnBookmarks.setOnClickListener(view1 -> {
            Intent intent = new Intent(requireContext(), BookMarksActivity.class);
            startActivity(intent);
        });

//        Profile profile = new Profile(R.drawable.person_24, 1, "05954854", "علي اسماعيل");
//        binding.profileImage.setImageResource(profile.getImage());
//        binding.nameText.setText(profile.getName());
//        binding.phoneText.setText(profile.getNumber_phone());
        binding.btnEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), EditeProfileActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
