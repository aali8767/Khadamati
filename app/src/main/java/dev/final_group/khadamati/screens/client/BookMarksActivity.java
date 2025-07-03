package dev.final_group.khadamati.screens.client;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import dev.final_group.khadamati.ServiceData;
import dev.final_group.khadamati.adapters.ServiceAdapter;
import dev.final_group.khadamati.databinding.ActivityBookMarksBinding;
import dev.final_group.khadamati.models.Service;

public class BookMarksActivity extends AppCompatActivity implements ServiceAdapter.OnServiceClickListener {
    private ActivityBookMarksBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookMarksBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupBookmarksService();
    }

    private void setupBookmarksService() {
        ServiceAdapter serviceAdapter = new ServiceAdapter(true, this);
        binding.rvBookmarksService.setLayoutManager(
                new LinearLayoutManager(this)
        );
        binding.rvBookmarksService.setAdapter(serviceAdapter);
        serviceAdapter.submitList(ServiceData.serviceList);
    }

    @Override
    public void onServiceClick(Service service) {
        Intent intent = new Intent(this, ServiceDetailsActivity.class);
        intent.putExtra("service", service);
        startActivity(intent);
    }
}
