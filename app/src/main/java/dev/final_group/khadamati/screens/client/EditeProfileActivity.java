package dev.final_group.khadamati.screens.client;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import dev.final_group.khadamati.databinding.ActivityEditeProfileBinding;

public class EditeProfileActivity extends AppCompatActivity {
    private ActivityEditeProfileBinding binding;
    private ActivityResultLauncher<String> pickProfileImageLauncher;
    private Uri profileImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditeProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAddIdImage.setText("تم توثيق");

        pickProfileImageLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(), uri -> {
                    if (uri != null) {
                        binding.ivUserImage.setImageURI(uri);
                        profileImageUri = uri;
                    }
                });

        binding.cardAddEditImage.setOnClickListener(v ->
                pickProfileImageLauncher.launch("image/*")
        );
    }
}
