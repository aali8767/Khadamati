package dev.final_group.khadamati.screens.client.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.databinding.ActivityHomeClientBinding;

public class HomeClientActivity extends AppCompatActivity {
    private ActivityHomeClientBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeClientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Fragment homeFragment = new HomeFragment();
        Fragment myRequestsFragment = new MyRequestsFragment();
        Fragment notificationsFragment = new NotificationsFragment();
        Fragment settingsFragment = new SettingsFragment();

        binding.bottomNavigation.setSelectedItemId(R.id.nav_home);
        loadFragment(homeFragment);

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                loadFragment(homeFragment);
            } else if (id == R.id.nav_assignment) {
                loadFragment(myRequestsFragment);
            } else if (id == R.id.nav_notifications) {
                loadFragment(notificationsFragment);
            } else if (id == R.id.nav_person) {
                loadFragment(settingsFragment);
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
