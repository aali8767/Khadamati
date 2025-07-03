package dev.final_group.khadamati.screens.service_provider;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.databinding.ActivityAddServiceBinding;
import dev.final_group.khadamati.models.MyService;

public class AddEditServiceActivity extends AppCompatActivity {
    private ActivityAddServiceBinding binding;
    private ActivityResultLauncher<String> pickServiceImageLauncher;
    private Uri serviceImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        boolean isEdit = getIntent().getBooleanExtra("isEdit", false);
        if (isEdit) {
            MyService myService = (MyService) getIntent().getSerializableExtra("myService");
            if (myService == null) return;

            binding.ivServiceImage.setImageResource(myService.getImage());
            binding.etServiceTitle.setText(myService.getTitle());
            binding.etServiceDescription.setText(myService.getDetails());
            binding.etServicePrice.setText(String.valueOf(myService.getPrice()));

            binding.btnAddService.setText("تعديل الخدمة");
            binding.btnAddService
                    .setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_edit, 0);

            binding.btnDeleteService.setOnClickListener(v ->
                    showDeleteConfirmationDialog(myService.getId())
            );
        } else {
            binding.btnDeleteService.setVisibility(View.GONE);
        }

        pickServiceImageLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(), uri -> {
                    if (uri != null) {
                        binding.ivServiceImage.setImageURI(uri);
                        serviceImageUri = uri;
                    }
                });

        binding.containerAddServiceImage.setOnClickListener(v ->
                pickServiceImageLauncher.launch("image/*")
        );
    }

    private void showDeleteConfirmationDialog(int myServiceId) {
        new AlertDialog.Builder(this)
                .setTitle("تأكيد")
                .setMessage("هل أنت متأكد من أنك تريد حذف الخدمة؟")
                .setPositiveButton("نعم", (dialog, which) -> {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("deletedServiceId", myServiceId);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                })
                .setNegativeButton("إلغاء", null)
                .show();
    }
}
