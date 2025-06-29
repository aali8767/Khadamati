package dev.final_group.khadamati.screens.service_provider;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import dev.final_group.khadamati.adapters.RequestsProviderAdapter;
import dev.final_group.khadamati.databinding.FragmentRequestsProviderBinding;
import dev.final_group.khadamati.models.RequestProvider;

import java.util.ArrayList;

public class RequestsProviderFragment extends Fragment implements RequestsProviderAdapter.OnCompleteClickListener {
    private FragmentRequestsProviderBinding binding;
    private static final String ARG_REQUESTS = "requests";

    private ArrayList<RequestProvider> requestProviderList;

    public static RequestsProviderFragment newInstance(ArrayList<RequestProvider> requestProviders) {
        RequestsProviderFragment fragment = new RequestsProviderFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_REQUESTS, requestProviders);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestProviderList = (ArrayList<RequestProvider>) getArguments().getSerializable(ARG_REQUESTS);
    }

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull android.view.LayoutInflater inflater,
                                          @Nullable android.view.ViewGroup container,
                                          @Nullable Bundle savedInstanceState) {
        binding = FragmentRequestsProviderBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RequestsProviderAdapter adapter = new RequestsProviderAdapter(requestProviderList, this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onComplete(RequestProvider requestProvider) {
        new AlertDialog.Builder(getContext())
                .setTitle("تأكيد")
                .setMessage("هل أنت متأكد أنك أكملت الطلب؟")
                .setPositiveButton("نعم", (dialog, which) -> {

                })
                .setNegativeButton("إلغاء", null)
                .show();
    }

    @Override
    public void onAccept(RequestProvider requestProvider) {

    }

    @Override
    public void onReject(RequestProvider requestProvider) {
        new AlertDialog.Builder(getContext())
                .setTitle("تأكيد")
                .setMessage("هل أنت متأكد أنك من رفض الطلب؟")
                .setPositiveButton("نعم", (dialog, which) -> {

                })
                .setNegativeButton("إلغاء", null)
                .show();
    }
}

