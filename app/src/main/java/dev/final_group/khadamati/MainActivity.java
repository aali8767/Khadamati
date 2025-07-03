package dev.final_group.khadamati;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import dev.final_group.khadamati.databinding.ActivityMainBinding;
import dev.final_group.khadamati.screens.auth.RegisterActivity;
import dev.final_group.khadamati.screens.client.home.HomeClientActivity;
import dev.final_group.khadamati.screens.service_provider.home.HomeServiceProviderActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signUpTv.setOnClickListener(v ->
                startActivity(new Intent(getBaseContext(), RegisterActivity.class))
        );

        binding.signInBt.setOnClickListener(v -> loginUser());
    }

    private void loginUser() {
        String email = Objects.requireNonNull(binding.etEmail.getText()).toString().trim();
        String password = Objects.requireNonNull(binding.passwordEt.getText()).toString().trim();

        if (!validateInputs(email, password)) return;
        navigateToHome(false);
    }

    private boolean validateInputs(String email, String password) {
        if (email.isEmpty()) {
            binding.etEmail.setError("الرجاء إدخال البريد الإلكتروني");
            return false;
        }
        if (password.isEmpty()) {
            binding.passwordEt.setError("الرجاء إدخال كلمة المرور");
            return false;
        }
        return true;
    }

    private void navigateToHome(boolean isServiceProvider) {
        Intent intent = new Intent(
                this,
                isServiceProvider ? HomeServiceProviderActivity.class : HomeClientActivity.class
        );
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
