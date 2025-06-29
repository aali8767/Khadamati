package dev.final_group.khadamati.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import dev.final_group.khadamati.models.RequestProvider;
import dev.final_group.khadamati.screens.service_provider.RequestsProviderFragment;

import java.util.ArrayList;
import java.util.List;

public class RequestsProviderPagerAdapter extends FragmentStateAdapter {
    private final List<RequestProvider> fullList;

    public RequestsProviderPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<RequestProvider> fullList) {
        super(fragmentActivity);
        this.fullList = fullList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        ArrayList<RequestProvider> filtered = new ArrayList<>();
        RequestProvider.Status status;

        switch (position) {
            case 1:
                status = RequestProvider.Status.IN_PROGRESS;
                break;
            case 2:
                status = RequestProvider.Status.COMPLETED;
                break;
            default:
                status = RequestProvider.Status.RECEIVED;
        }

        for (RequestProvider r : fullList) {
            if (r.getStatus() == status) {
                filtered.add(r);
            }
        }

        return RequestsProviderFragment.newInstance(filtered);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

