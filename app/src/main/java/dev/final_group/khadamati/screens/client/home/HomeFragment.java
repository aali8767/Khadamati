package dev.final_group.khadamati.screens.client.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import dev.final_group.khadamati.CategoryData;
import dev.final_group.khadamati.R;
import dev.final_group.khadamati.ServiceData;
import dev.final_group.khadamati.adapters.CategoryAdapter;
import dev.final_group.khadamati.adapters.ServiceAdapter;
import dev.final_group.khadamati.databinding.FragmentHomeBinding;
import dev.final_group.khadamati.models.Category;
import dev.final_group.khadamati.models.Service;
import dev.final_group.khadamati.screens.client.ServiceDetailsActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class HomeFragment extends Fragment implements CategoryAdapter.OnCategoryClickListener {
    private FragmentHomeBinding binding;
    private CategoryAdapter categoryAdapter;
    private ServiceAdapter serviceCategoryAdapter;
    private ServiceAdapter serviceMostPopular;
    private ServiceAdapter serviceAdapter;

    private final List<Service> filteredServices = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.searchBar.setOnClickListener(v -> binding.searchView.show());

        setupCategoriesAdapter();
        setupServicesCategory();
        setupMostPopular();
        setupServices();
    }

    private void setupCategoriesAdapter() {
        categoryAdapter = new CategoryAdapter(CategoryData.categoryList, this);
        binding.categoriesRecyclerView.setLayoutManager(
                new LinearLayoutManager(
                        requireContext(), LinearLayoutManager.HORIZONTAL, false
                )
        );
        binding.categoriesRecyclerView.setAdapter(categoryAdapter);
    }

    private void setupServicesCategory() {
        serviceCategoryAdapter = new ServiceAdapter(this::openServiceDetails);
        binding.servicesCategoryRecyclerView.setLayoutManager(
                new LinearLayoutManager(
                        requireContext(), LinearLayoutManager.HORIZONTAL, false
                )
        );
        binding.servicesCategoryRecyclerView.setAdapter(serviceCategoryAdapter);
        serviceCategoryAdapter.submitList(ServiceData.serviceList);
    }

    private void setupMostPopular() {
        serviceMostPopular = new ServiceAdapter(this::openServiceDetails);
        binding.recyclerMostPopular.setLayoutManager(
                new LinearLayoutManager(
                        requireContext(), LinearLayoutManager.HORIZONTAL, false
                )
        );
        binding.recyclerMostPopular.setAdapter(serviceMostPopular);
        serviceMostPopular.submitList(ServiceData.serviceList);
    }

    private void setupServices() {
        serviceAdapter = new ServiceAdapter(true, this::openServiceDetails);
        binding.servicesRecyclerView.setLayoutManager(
                new LinearLayoutManager(requireContext())
        );
        binding.servicesRecyclerView.setAdapter(serviceAdapter);
        serviceAdapter.submitList(ServiceData.serviceList);
    }

    private void openServiceDetails(Service service) {
        Intent intent = new Intent(requireContext(), ServiceDetailsActivity.class);
        intent.putExtra("service", service);
        startActivity(intent);
    }

    @Override
    public void onCategoryClick(Category category) {
        filteredServices.clear();
        filteredServices.addAll(
                ServiceData.serviceList.stream()
                        .filter(service ->
                                Objects.equals(service.getCategory_id(), category.getId())
                        )
                        .collect(Collectors.toList())
        );
        serviceCategoryAdapter.submitList(new ArrayList<>(filteredServices));
    }
}
