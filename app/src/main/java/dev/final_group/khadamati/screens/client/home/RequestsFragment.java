package dev.final_group.khadamati.screens.client.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import dev.final_group.khadamati.adapters.RequestAdapter;
import dev.final_group.khadamati.databinding.FragmentRequestsBinding;
import dev.final_group.khadamati.models.Request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RequestsFragment extends Fragment {
    private FragmentRequestsBinding binding;

    public static RequestsFragment newInstance(List<Request> requestProviders) {
        RequestsFragment fragment = new RequestsFragment();
        Bundle args = new Bundle();
        args.putSerializable("requests", (Serializable) requestProviders);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRequestsBinding.inflate(inflater, container, false);

        List<Request> requestProviderList;
        if (getArguments() != null) {
            requestProviderList = (List<Request>) getArguments().getSerializable("requests");
        } else {
            requestProviderList = new ArrayList<>();
        }

        RequestAdapter adapter = new RequestAdapter(requestProviderList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
}

