package dev.final_group.khadamati.screens.client;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.adapters.RatingAdapter;
import dev.final_group.khadamati.databinding.ActivityServiceDetailsBinding;
import dev.final_group.khadamati.models.RatingModel;

import java.util.ArrayList;
import java.util.List;

public class ServiceDetailsActivity extends AppCompatActivity {
    private ActivityServiceDetailsBinding binding;
    private boolean isServiceBookmarked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityServiceDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ratingRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<RatingModel> ratings = new ArrayList<>();
        ratings.add(new RatingModel("1", 4, "أحمد سالم", R.drawable.fake_image, "الخدمة ممتازة وسريعة", "service1", "provider1"));
        ratings.add(new RatingModel("2", 5, "سارة محمد", R.drawable.image6, "رائعة جدًا! تم إنجاز العمل بدقة واحترام", "service1", "provider1"));
        ratings.add(new RatingModel("3", 3, "مروان حسن", R.drawable.image5, "الخدمة جيدة بشكل عام", "service1", "provider1"));

        RatingAdapter adapter = new RatingAdapter(ratings);
        binding.ratingRecyclerView.setAdapter(adapter);


        binding.requestServiceBt.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), RequestServiceActivity.class);
//            intent.putExtra("service", service);
            startActivity(intent);
        });

        binding.btnBookmarks.setOnClickListener(view -> {
            if (isServiceBookmarked) {
                isServiceBookmarked = false;
                binding.btnBookmarks.setImageResource(R.drawable.ic_bookmark_border);
            } else {
                isServiceBookmarked = true;
                binding.btnBookmarks.setImageResource(R.drawable.bookmark_24);
            }
        });
    }
}
