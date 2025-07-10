package dev.final_group.khadamati.screens.auth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.databinding.FragmentClientRegisterBinding;
import dev.final_group.khadamati.screens.client.home.HomeClientActivity;

public class ClientRegisterFragment extends Fragment {
    private FragmentClientRegisterBinding binding;

    private Uri idImageUri = null;
    private Uri prfileImageUri = null;

    String fullName, phoneNumber, password, confirmPassword;

    private ActivityResultLauncher<String> pickProfileImageLauncher;
    private ActivityResultLauncher<Intent> pickIdImageLauncher;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentClientRegisterBinding.inflate(inflater, container, false);

        binding.btnAddIdImage.setOnClickListener(v -> pickIdImage());
        binding.signUpBt.setOnClickListener(v -> registerClient());

        requireActivity().findViewById(R.id.cardAddImage)
                .setOnClickListener(view -> pickProfileImageLauncher.launch("image/*"));

        pickProfileImageLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(), uri -> {
                    if (uri != null) {
                        ((ImageView) requireActivity().findViewById(R.id.ivUserImage)).setImageURI(uri);
                        prfileImageUri = uri;
                    }
                });

        pickIdImageLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        idImageUri = result.getData().getData();
                        binding.btnAddIdImage.setText("تم اختيار صورة الهوية");
                    }
                }
        );

        return binding.getRoot();
    }

    private void pickIdImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        pickIdImageLauncher.launch(intent);
    }

    private void registerClient() {
        fullName = Objects.requireNonNull(binding.NameET.getText()).toString().trim();
//        email = Objects.requireNonNull(binding.teEmail.getText()).toString().trim();
        phoneNumber = Objects.requireNonNull(binding.PhoneET.getText()).toString().trim();
        password = Objects.requireNonNull(binding.PasswordET.getText()).toString().trim();
        confirmPassword = Objects.requireNonNull(binding.ConfirmePasswordET.getText()).toString().trim();

        if (!validateInputs(fullName, phoneNumber, password, confirmPassword)) return;

        navigateToHome();
    }

    private boolean validateInputs(String fullName, String phone, String password, String confirmPassword) {
        if (prfileImageUri == null) {
            showToast("الرجاء اختبار صورة الحساب");
            return false;
        }
        if (fullName.isEmpty()) {
            binding.NameET.setError("الرجاء إدخال الاسم الكامل");
            return false;
        }
//        if (email.isEmpty()) {
//            binding.teEmail.setError("الرجاء إدخال البريد الإلكتروني");
//            return false;
//        }
        if (phone.isEmpty()) {
            binding.PhoneET.setError("الرجاء إدخال رقم الهاتف");
            return false;
        }
        if (password.isEmpty()) {
            binding.PasswordET.setError("الرجاء إدخال كلمة المرور");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            binding.ConfirmePasswordET.setError("كلمة المرور غير متطابقة");
            return false;
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void navigateToHome() {
        Intent intent = new Intent(requireContext(), HomeClientActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        requireActivity().finish();
    }
}
