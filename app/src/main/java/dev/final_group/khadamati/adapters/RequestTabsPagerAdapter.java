package dev.final_group.khadamati.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import dev.final_group.khadamati.models.Request;
import dev.final_group.khadamati.screens.client.home.RequestsFragment;

import java.util.List;
import java.util.stream.Collectors;

public class RequestTabsPagerAdapter extends FragmentStateAdapter {

    private final List<Request> allRequest;

    public RequestTabsPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Request> allRequest) {
        super(fragmentActivity);
        this.allRequest = allRequest;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        List<Request> filtered;

        if (position == 0) {
            filtered = allRequest.stream()
                    .filter(r -> r.getStatus() == 0 || r.getStatus() == 1)
                    .collect(Collectors.toList());
        } else {
            filtered = allRequest.stream()
                    .filter(r -> r.getStatus() == 2)
                    .collect(Collectors.toList());
        }

        return RequestsFragment.newInstance(filtered);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

