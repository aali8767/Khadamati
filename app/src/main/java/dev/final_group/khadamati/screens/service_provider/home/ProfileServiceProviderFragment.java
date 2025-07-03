package dev.final_group.khadamati.screens.service_provider.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.adapters.RatingAdapter;
import dev.final_group.khadamati.databinding.FragmentProfileServiceProviderBinding;
import dev.final_group.khadamati.models.RatingModel;
import dev.final_group.khadamati.screens.service_provider.EditProviderProfileActivity;


public class ProfileServiceProviderFragment extends Fragment {

    private FragmentProfileServiceProviderBinding binding;

    public ProfileServiceProviderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileServiceProviderBinding.inflate(inflater, container, false);
//        binding.tvName.setText("محمد احمد");
//        binding.tvPhone.setText("05998741513");
//        binding.tvJobTitle.setText("فني كهرباء");
        binding.editeBt.setOnClickListener(view -> {
            startActivity(new Intent(getContext(), EditProviderProfileActivity.class));
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<RatingModel> ratings = new ArrayList<>();
        ratings.add(new RatingModel("1", 4, "أحمد سالم", R.drawable.fake_image, "الخدمة ممتازة وسريعة", "service1", "provider1"));
        ratings.add(new RatingModel("2", 5, "سارة محمد", R.drawable.image6, "رائعة جدًا! تم إنجاز العمل بدقة واحترام", "service1", "provider1"));
        ratings.add(new RatingModel("3", 3, "مروان حسن", R.drawable.fake_image, "الخدمة جيدة بشكل عام", "service1", "provider1"));
        ratings.add(new RatingModel("4", 5, "عمر سالم", R.drawable.fake_image, "الخدمة ممتازة وسريعة", "service2", "provider1"));
        ratings.add(new RatingModel("5", 4.5f, "دعاء محمد", R.drawable.image5, "رائعة جدًا! تم إنجاز العمل بدقة واحترام", "service2", "provider1"));
        ratings.add(new RatingModel("6", 3.5f, "كرميد ابو جبس", R.drawable.fake_image, "الخدمة جيدة بشكل عام", "service3", "provider1"));

        RatingAdapter ratingAdapter = new RatingAdapter(ratings);
        binding.allRatingRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.allRatingRecyclerView.setAdapter(ratingAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
