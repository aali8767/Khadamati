package dev.final_group.khadamati.screens.client.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import dev.final_group.khadamati.adapters.NotificationAdapter;
import dev.final_group.khadamati.databinding.FragmentNotificationsBinding;
import dev.final_group.khadamati.models.Notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationsFragment extends Fragment {
    private FragmentNotificationsBinding binding;

    public NotificationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Notification> notificationList = new ArrayList<>();

        notificationList.add(new Notification(1, 101, "تم قبول طلبك!", "تم قبول طلب تنظيف نوافذ من المزود أحمد. سيتم التواصل خلال 30 دقيقة.", new Date()));
        notificationList.add(new Notification(2, 102, "تم رفض الطلب", "طلبك لخدمة تركيب خزائن تم رفضه بسبب عدم توفر مزودين حاليًا.", new Date()));
        notificationList.add(new Notification(3, 103, "تم قبول طلبك!", "المزود محمد وافق على تنفيذ خدمة تركيب أبواب حديد. نرجو تأكيد الموعد.", new Date()));
        notificationList.add(new Notification(4, 104, "تم رفض الطلب", "المزود سامي اعتذر عن تنفيذ طلب تنظيف المنزل بسبب ضغط الطلبات.", new Date()));
        notificationList.add(new Notification(5, 105, "تم قبول طلبك!", "تمت الموافقة على طلبك لخدمة دهان داخلي. تواصل مع المزود يوسف لترتيب التفاصيل.", new Date()));
        notificationList.add(new Notification(6, 106, "تم رفض الطلب", "خدمة صيانة شبابيك غير متاحة حاليًا في منطقتك.", new Date()));
        notificationList.add(new Notification(7, 107, "تم قبول طلبك!", "خدمة إصلاح كهرباء تم تأكيدها من المزود عادل. نرجو تجهيز المكان قبل الموعد.", new Date()));
        notificationList.add(new Notification(8, 108, "تم رفض الطلب", "تم رفض طلبك بسبب عدم تحديد موعد مناسب للتنفيذ.", new Date()));
        notificationList.add(new Notification(9, 109, "تم قبول طلبك!", "تم قبول طلبك لصيانة السباكة في الحمام الرئيسي. سيتم التواصل معك لاحقًا.", new Date()));
        notificationList.add(new Notification(10, 110, "تم رفض الطلب", "المزود فهد رفض طلب دهان خارجي بسبب الأحوال الجوية السيئة.", new Date()));

        NotificationAdapter adapter = new NotificationAdapter(notificationList);
        binding.notificationsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.notificationsRecyclerView.setAdapter(adapter);
    }
}
