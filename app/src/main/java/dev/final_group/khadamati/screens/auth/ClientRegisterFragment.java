package dev.final_group.khadamati.screens.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.final_group.khadamati.screens.client.home.HomeClientActivity;
import dev.final_group.khadamati.databinding.FragmentClientRegisterBinding;

public class ClientRegisterFragment extends Fragment {
    private FragmentClientRegisterBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentClientRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.signUpBt.setOnClickListener(v -> {
            startActivity(new Intent(requireContext(), HomeClientActivity.class));
        });
    }
}

