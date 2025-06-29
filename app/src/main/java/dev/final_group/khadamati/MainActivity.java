package dev.final_group.khadamati;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import dev.final_group.khadamati.databinding.ActivityMainBinding;
import dev.final_group.khadamati.screens.auth.RegisterActivity;
import dev.final_group.khadamati.screens.client.home.HomeClientActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signInBt.setOnClickListener(v -> {
            startActivity(new Intent(getBaseContext(), HomeClientActivity.class));
        });

        binding.signUpTv.setOnClickListener(v -> {
            startActivity(new Intent(getBaseContext(), RegisterActivity.class));
        });

    }
}
