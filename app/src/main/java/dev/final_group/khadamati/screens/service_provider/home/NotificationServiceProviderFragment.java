package dev.final_group.khadamati.screens.service_provider.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import dev.final_group.khadamati.adapters.NotificationProviderAdapter;
import dev.final_group.khadamati.databinding.FragmentNotificationServiceProviderBinding;
import dev.final_group.khadamati.models.Notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationServiceProviderFragment extends Fragment {
    private FragmentNotificationServiceProviderBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationServiceProviderBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification(1, 101, "طلب أحمد خدمة تنظيف سطح", "تم قبول طلب تنظيف نوافذ من المزود أحمد. سيتم التواصل خلال 30 دقيقة.", new Date()));
        notificationList.add(new Notification(2, 102, "طلبت سارة خدمة صيانة مكيف", "طلبك لخدمة تركيب خزائن تم رفضه بسبب عدم توفر مزودين حاليًا.", new Date()));
        notificationList.add(new Notification(3, 103, "حصلت خدمتك دهان غرفة أطفال على تقييم جديد", "أبو عجل: عمل ممتاز جدًا وأتمنى لك التوفيق دائمًا", new Date(), 4.5f));
        notificationList.add(new Notification(4, 104, "حصلت خدمتك تركيب باب زجاج على تقييم جديد", "محمد: خدمة رائعة وسريعة، شكرا جزيلا", new Date(), 5f));

        binding.rvNotifications.setHasFixedSize(true);
        binding.rvNotifications.setLayoutManager(new LinearLayoutManager(requireContext()));

        NotificationProviderAdapter adapter = new NotificationProviderAdapter(notificationList);
        binding.rvNotifications.setAdapter(adapter);
    }
}
