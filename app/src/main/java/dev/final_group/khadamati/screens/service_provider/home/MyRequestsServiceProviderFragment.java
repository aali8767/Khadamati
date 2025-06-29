package dev.final_group.khadamati.screens.service_provider.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.adapters.RequestsProviderPagerAdapter;
import dev.final_group.khadamati.databinding.FragmentMyRequestsServiceProviderBinding;
import dev.final_group.khadamati.models.RequestProvider;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MyRequestsServiceProviderFragment extends Fragment {
    private FragmentMyRequestsServiceProviderBinding binding;

    public MyRequestsServiceProviderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyRequestsServiceProviderBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<RequestProvider> requestProviderList = new ArrayList<>();

        requestProviderList.add(new RequestProvider(
                R.drawable.image6,
                "أحمد علي",
                true,
                "تصليح أبواب خشب",
                "الباب الأمامي مكسور وأحتاج صيانته بشكل عاجل",
                "غزة - الرمال",
                "0599123456",
                "22/06/2025 - 10:30 ص",
                RequestProvider.Status.RECEIVED,
                0));

        requestProviderList.add(new RequestProvider(
                R.drawable.image3,
                "منى إبراهيم",
                false,
                "تنظيف واجهة المحل",
                "أرغب بتنظيف واجهة محلي التجاري بالكامل قبل موسم الأعياد",
                "غزة - شارع الوحدة",
                "0599988776",
                "22/06/2025 - 11:00 ص",
                RequestProvider.Status.RECEIVED,
                0));

        requestProviderList.add(new RequestProvider(
                R.drawable.image2,
                "علي سمير",
                true,
                "صيانة مكيف",
                "المكيف لا يعمل بشكل جيد ويحتاج صيانة عاجلة",
                "خانيونس - حي الأمل",
                "0597766554",
                "22/06/2025 - 12:00 م",
                RequestProvider.Status.RECEIVED,
                0));

// حالة قيد التنفيذ (IN_PROGRESS)
        requestProviderList.add(new RequestProvider(
                R.drawable.image5,
                "سارة أحمد",
                true,
                "دهان غرفة أطفال",
                "أحتاج إلى إعادة دهان غرفة الأطفال بألوان جديدة مناسبة",
                "غزة - تل الهوا",
                "0598877665",
                "21/06/2025 - 9:00 ص",
                RequestProvider.Status.IN_PROGRESS,
                0));

        requestProviderList.add(new RequestProvider(
                R.drawable.image4,
                "يوسف محمد",
                false,
                "تركيب شبابيك ألمنيوم",
                "تركيب شبابيك ألمنيوم جديدة بدلاً من القديمة",
                "رفح - حي الجنينة",
                "0596655443",
                "21/06/2025 - 11:30 ص",
                RequestProvider.Status.IN_PROGRESS,
                0));

// حالة مكتملة (COMPLETED)
        requestProviderList.add(new RequestProvider(
                R.drawable.image3,
                "إيمان حسين",
                true,
                "تركيب باب زجاج",
                "تركيب باب زجاج لمحل تجاري جديد",
                "دير البلح - السوق المركزي",
                "0593344552",
                "20/06/2025 - 2:00 م",
                RequestProvider.Status.COMPLETED,
                4.0f));

        requestProviderList.add(new RequestProvider(
                R.drawable.image2,
                "محمود عبد الله",
                false,
                "تصليح كهرباء",
                "إصلاح بعض أعطال الكهرباء في المنزل",
                "جباليا - معسكر جباليا",
                "0592233445",
                "19/06/2025 - 1:30 م",
                RequestProvider.Status.COMPLETED,
                0)); // بدون تقييم

        requestProviderList.add(new RequestProvider(
                R.drawable.image1,
                "ليلى محمد",
                true,
                "تركيب باب حديد",
                "استبدال الباب الحديدي بآخر جديد مع تأمينه",
                "غزة - الشيخ رضوان",
                "0591122334",
                "18/06/2025 - 4:00 م",
                RequestProvider.Status.COMPLETED,
                5.0f));

        RequestsProviderPagerAdapter adapter = new RequestsProviderPagerAdapter(requireActivity(), requestProviderList);
        binding.viewPager.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("معلقة");
                            break;
                        case 1:
                            tab.setText("قيد التنفيذ");
                            break;
                        case 2:
                            tab.setText("مكتملة");
                            break;
                    }
                }).attach();
    }
}
