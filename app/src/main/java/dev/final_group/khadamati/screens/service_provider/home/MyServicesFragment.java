package dev.final_group.khadamati.screens.service_provider.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.adapters.MyServiceAdapter;
import dev.final_group.khadamati.databinding.FragmentMyServicesBinding;
import dev.final_group.khadamati.models.MyService;
import dev.final_group.khadamati.screens.service_provider.AddEditServiceActivity;


public class MyServicesFragment extends Fragment implements MyServiceAdapter.OnMyServiceClickListener {
    private FragmentMyServicesBinding binding;
    private  MyServiceAdapter adapter;
    private ActivityResultLauncher<Intent> editServiceLauncher;

    public MyServicesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyServicesBinding.inflate(inflater, container, false);

        editServiceLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null && data.hasExtra("deletedServiceId")) {
                            int deletedId = data.getIntExtra("deletedServiceId", -1);
                            adapter.removeServiceFromList(deletedId);
                        }
                    }
                }
        );

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<MyService> serviceList = new ArrayList<>();
        serviceList.add(new MyService(
                1,
                "تنظيف المنازل",
                "تنظيف شامل للمنازل مع توفير عمالة محترفة.",
                150,
                R.drawable.image1
        ));

        serviceList.add(new MyService(
                2,
                "صيانة كهرباء",
                "خدمة إصلاح وصيانة كافة الأعطال الكهربائية.",
                200,
                R.drawable.image2
        ));

        serviceList.add(new MyService(
                3,
                "سباكة",
                "خدمة إصلاح الأعطال وتسليك المجاري وتركيب الأدوات الصحية.",
                180,
                R.drawable.image1
        ));

        serviceList.add(new MyService(
                4,
                "نقل الأثاث",
                "نقل الأثاث بأمان مع فك وتركيب.",
                300,
                R.drawable.image2
        ));

        serviceList.add(new MyService(
                5,
                "تنظيف السجاد",
                "تنظيف وغسيل السجاد باستخدام معدات متخصصة.",
                100,
                R.drawable.image1
        ));


        binding.fabAddService.setOnClickListener(v -> {
            startActivity(new Intent(requireContext(), AddEditServiceActivity.class));
        });

        binding.rvMyServices.setHasFixedSize(true);
        binding.rvMyServices.setLayoutManager(new LinearLayoutManager(requireContext()));

        adapter = new MyServiceAdapter(serviceList, this);
        binding.rvMyServices.setAdapter(adapter);
    }

    @Override
    public void onMyServiceClick(MyService myService) {
        Intent intent = new Intent(requireContext(), AddEditServiceActivity.class);
        intent.putExtra("myService", myService);
        intent.putExtra("isEdit", true);
        editServiceLauncher.launch(intent);
    }
}
