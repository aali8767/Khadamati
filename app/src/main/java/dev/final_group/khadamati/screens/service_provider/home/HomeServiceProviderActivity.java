package dev.final_group.khadamati.screens.service_provider.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.databinding.ActivityHomeSeriveProviderBinding;

public class HomeServiceProviderActivity extends AppCompatActivity {
    ActivityHomeSeriveProviderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeSeriveProviderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Fragment home_service_Fragment = new HomeServiceFragment();
        Fragment myRequests_service_Fragment = new MyRequestsServiceProviderFragment();
        Fragment myServicesFragment = new MyServicesFragment();
        Fragment notifications_service_Fragment = new NotificationServiceProviderFragment();
        Fragment profile_service_Fragment = new ProfileServiceProviderFragment();
        binding.bottomNavigation.setSelectedItemId(R.id.nav_home);
        loadFragment(home_service_Fragment);

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                loadFragment(home_service_Fragment);
            } else if (id == R.id.nav_assignment) {
                loadFragment(myRequests_service_Fragment);
            } else if (id == R.id.nav_my_service) {
                loadFragment(myServicesFragment);
            } else if (id == R.id.nav_notifications) {
                loadFragment(notifications_service_Fragment);
            } else if (id == R.id.nav_person) {
                loadFragment(profile_service_Fragment);
            }
            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }
}
