package dev.final_group.khadamati.screens.auth;

import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.databinding.ActivityRegisterBinding;
import com.google.android.material.tabs.TabLayout;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("مستفيد"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("مزود خدمة"));

        Fragment clientRegisterFragment = new ClientRegisterFragment();
        Fragment providerRegisterFragment = new ProviderRegisterFragment();

        loadFragment(clientRegisterFragment);

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    loadFragment(clientRegisterFragment);
                } else {
                    loadFragment(providerRegisterFragment);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        binding.siginTv.setOnClickListener(v -> finish());
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.registerFragmentContainer, fragment)
                .commit();
    }
}
