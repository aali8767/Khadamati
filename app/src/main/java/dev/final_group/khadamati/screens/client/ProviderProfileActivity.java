package dev.final_group.khadamati.screens.client;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.adapters.ProviderServiceAdapter;

import dev.final_group.khadamati.databinding.ActivityProviderProfileBinding;
import dev.final_group.khadamati.models.Service;

import java.util.ArrayList;
import java.util.List;

public class ProviderProfileActivity extends AppCompatActivity implements ProviderServiceAdapter.OnServiceClickListener {
    private ActivityProviderProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProviderProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupServices();
    }

    private void setupServices() {
        List<Service> allServices = new ArrayList<>();

        allServices.add(new Service(1, 1, 101, "تفصيل أبواب حديد", "أعمال حدادة لتفصيل وتركيب الأبواب والنوافذ الحديدية", 250, 4.5, R.drawable.image5));
        allServices.add(new Service(2, 1, 102, "صيانة شبابيك حديد", "خدمة إصلاح وصيانة الشبابيك الحديدية المتآكلة", 150, 4.2, R.drawable.image5));
        allServices.add(new Service(3, 2, 103, "تفصيل مطبخ خشب", "أعمال نجارة لتفصيل مطابخ حسب الطلب", 1200, 4.7, R.drawable.image2));
        allServices.add(new Service(4, 2, 104, "تصليح أثاث منزلي", "نجار لإصلاح وتركيب قطع الأثاث الخشبي في المنازل", 300, 4.4, R.drawable.image2));

        ProviderServiceAdapter serviceAdapter = new ProviderServiceAdapter(allServices,this);


        binding.servicesRecyclerView.setLayoutManager(
                new LinearLayoutManager(getBaseContext())
        );
        binding.servicesRecyclerView.setAdapter(serviceAdapter);
    }

    @Override
    public void onServiceClick(Service service) {

    }
}
