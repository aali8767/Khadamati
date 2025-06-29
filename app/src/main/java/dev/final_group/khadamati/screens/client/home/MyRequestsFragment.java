package dev.final_group.khadamati.screens.client.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.final_group.khadamati.adapters.RequestTabsPagerAdapter;
import dev.final_group.khadamati.databinding.FragmentMyRequestsBinding;
import dev.final_group.khadamati.models.Request;

import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyRequestsFragment extends Fragment {
    private FragmentMyRequestsBinding binding;

    public MyRequestsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyRequestsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Request> allRequest = new ArrayList<>();

        allRequest.add(new Request(1, "تنظيف المنزل", "طلبك قيد التنفيذ مع المزود أحمد", 1, new Date()));
        allRequest.add(new Request(2, "تركيب أبواب حديد", "تم تنفيذ الطلب بنجاح بواسطة المزود محمد", 2, new Date()));
        allRequest.add(new Request(3, "صيانة المكيفات", "المزود لم يقبل الطلب بعد", 0, new Date()));
        allRequest.add(new Request(4, "دهان خارجي", "الخدمة اكتملت بنجاح", 2, new Date()));
        allRequest.add(new Request(5, "سباكة المطبخ", "طلبك قيد التنفيذ مع المزود يوسف", 1, new Date()));
        allRequest.add(new Request(6, "تنظيف خزائن", "تم إنهاء الطلب، يمكنك التقييم الآن", 2, new Date()));

        RequestTabsPagerAdapter adapter = new RequestTabsPagerAdapter(requireActivity(), allRequest);
        binding.viewPager.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> {
                    if (position == 0) tab.setText("غير مكتملة");
                    else tab.setText("مكتملة");
                }
        ).attach();
    }
}
