package dev.final_group.khadamati.screens.service_provider;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.adapters.RatedServiceAdapter;
import dev.final_group.khadamati.adapters.RatingAdapter;
import dev.final_group.khadamati.databinding.ActivityRatingBinding;
import dev.final_group.khadamati.models.RatedService;
import dev.final_group.khadamati.models.RatingModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RatingActivity extends AppCompatActivity implements RatedServiceAdapter.OnClickListener {
    private ActivityRatingBinding binding;
    private List<RatingModel> filteredRatings = new ArrayList<>();
    private List<RatingModel> ratings = new ArrayList<>();
    private RatingAdapter ratingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRatingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<RatedService> fakeServices = new ArrayList<>();
        fakeServices.add(new RatedService("service1", "تصليح أبواب", R.drawable.image1, 4.2));
        fakeServices.add(new RatedService("service2", "صيانة كهرباء", R.drawable.image2, 4.5));
        fakeServices.add(new RatedService("service3", "تنظيف منازل", R.drawable.image3, 4.0));
        fakeServices.add(new RatedService("service4", "تنظيف منازل", R.drawable.image4, 3.1));

        RatedServiceAdapter ratedServiceAdapter = new RatedServiceAdapter(fakeServices, this);
        binding.recyclerRatedService.setAdapter(ratedServiceAdapter);
        binding.recyclerRatedService.setLayoutManager(
                new LinearLayoutManager(
                        this, RecyclerView.HORIZONTAL,
                        false
                )
        );

        ratings.add(new RatingModel("1", 4, "أحمد سالم", R.drawable.fake_image, "الخدمة ممتازة وسريعة", "service1", "provider1"));
        ratings.add(new RatingModel("2", 5, "سارة محمد", R.drawable.image6, "رائعة جدًا! تم إنجاز العمل بدقة واحترام", "service1", "provider1"));
        ratings.add(new RatingModel("3", 3, "مروان حسن", R.drawable.fake_image, "الخدمة جيدة بشكل عام", "service1", "provider1"));
        ratings.add(new RatingModel("4", 5, "عمر سالم", R.drawable.fake_image, "الخدمة ممتازة وسريعة", "service2", "provider1"));
        ratings.add(new RatingModel("5", 4.5f, "دعاء محمد", R.drawable.image5, "رائعة جدًا! تم إنجاز العمل بدقة واحترام", "service2", "provider1"));
        ratings.add(new RatingModel("6", 3.5f, "كرميد ابو جبس", R.drawable.fake_image, "الخدمة جيدة بشكل عام", "service3", "provider1"));

        filterRatings(ratings.get(0).getServiceId());
        ratingAdapter = new RatingAdapter(filteredRatings);
        binding.ratingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.ratingRecyclerView.setAdapter(ratingAdapter);

    }

    private void filterRatings(String serviceId) {
        filteredRatings = ratings.stream()
                .filter(r -> Objects.equals(r.getServiceId(), serviceId))
                .collect(Collectors.toList());
    }

    @Override
    public void OnRatedServiceClickListener(String serviceId) {
        filterRatings(serviceId);
        ratingAdapter.updateList(filteredRatings);
    }
}
