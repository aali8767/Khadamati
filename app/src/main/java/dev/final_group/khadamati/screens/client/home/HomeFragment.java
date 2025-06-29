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

    private List<Service> allServices;
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

        initAllServices();

        setupCategoriesAdapter();
        setupServicesCategory();
        setupMostPopular();
        setupServices();
    }


    private void initAllServices() {
        allServices = new ArrayList<>();
        allServices.add(new Service(1, 1, 101, "تفصيل أبواب حديد", "أعمال حدادة لتفصيل وتركيب الأبواب والنوافذ الحديدية", 250, 4.5, R.drawable.image5));
        allServices.add(new Service(2, 1, 102, "صيانة شبابيك حديد", "خدمة إصلاح وصيانة الشبابيك الحديدية المتآكلة", 150, 4.2, R.drawable.image5));
        allServices.add(new Service(3, 2, 103, "تفصيل مطبخ خشب", "أعمال نجارة لتفصيل مطابخ حسب الطلب", 1200, 4.7, R.drawable.image2));
        allServices.add(new Service(4, 2, 104, "تصليح أثاث منزلي", "نجار لإصلاح وتركيب قطع الأثاث الخشبي في المنازل", 300, 4.4, R.drawable.image2));
        allServices.add(new Service(5, 3, 105, "تأسيس تمديدات صحية", "سباك لتركيب وتأسيس شبكات المياه والصرف الصحي", 600, 4.6, R.drawable.image1));
        allServices.add(new Service(6, 3, 106, "تسليك مجاري", "خدمة تسليك المجاري والمواسير المسدودة", 200, 4.1, R.drawable.image1));
        allServices.add(new Service(7, 4, 107, "تمديد كهرباء منزلية", "كهربائي لتركيب وتمديد شبكة كهرباء للمنازل", 800, 4.5, R.drawable.image3));
        allServices.add(new Service(8, 4, 108, "إصلاح أعطال كهربائية", "صيانة أعطال الكهرباء وتغيير المفاتيح والأسلاك", 250, 4.3, R.drawable.image3));
        allServices.add(new Service(9, 5, 109, "تنظيف منازل", "خدمة تنظيف منازل كاملة شاملاً الأرضيات والنوافذ", 100, 4.6, R.drawable.image4));
        allServices.add(new Service(10, 5, 110, "ترتيب وتنظيم المنزل", "خدمة ترتيب غرف المنزل وتنظيم الأغراض", 120, 4.2, R.drawable.image4));
        allServices.add(new Service(11, 6, 111, "دهان داخلي", "دهان الجدران الداخلية بألوان حسب الطلب", 500, 4.5, R.drawable.image6));
        allServices.add(new Service(12, 6, 112, "دهان خارجي", "دهان واجهات المنازل والفلل بدهانات مقاومة", 700, 4.3, R.drawable.image6));
        allServices.add(new Service(13, 1, 113, "تركيب بوابات حديد", "تصميم وتركيب بوابات حديد للمنازل والفلل", 1000, 4.4, R.drawable.image5));
        allServices.add(new Service(14, 2, 114, "تفصيل خزائن خشب", "نجارة لتفصيل خزائن وحلول تخزين عملية", 900, 4.6, R.drawable.image2));
        allServices.add(new Service(15, 3, 115, "كشف تسربات المياه", "خدمة كشف التسربات باستخدام أحدث الأجهزة", 350, 4.5, R.drawable.image1));
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
        serviceCategoryAdapter.submitList(allServices);
    }

    private void setupMostPopular() {
        serviceMostPopular = new ServiceAdapter(this::openServiceDetails);
        binding.recyclerMostPopular.setLayoutManager(
                new LinearLayoutManager(
                        requireContext(), LinearLayoutManager.HORIZONTAL, false
                )
        );
        binding.recyclerMostPopular.setAdapter(serviceMostPopular);
        serviceMostPopular.submitList(allServices);
    }

    private void setupServices() {
        serviceAdapter = new ServiceAdapter(true, this::openServiceDetails);
        binding.servicesRecyclerView.setLayoutManager(
                new LinearLayoutManager(requireContext())
        );
        binding.servicesRecyclerView.setAdapter(serviceAdapter);
        serviceAdapter.submitList(allServices);
    }

    // khada
    private void openServiceDetails(Service service) {
        Intent intent = new Intent(requireContext(), ServiceDetailsActivity.class);
        intent.putExtra("service", service);
        startActivity(intent);
    }

    @Override
    public void onCategoryClick(Category category) {
        filteredServices.clear();
        filteredServices.addAll(
                allServices.stream()
                        .filter(service ->
                                Objects.equals(service.getCategory_id(), category.getId())
                        )
                        .collect(Collectors.toList())
        );
        serviceCategoryAdapter.submitList(new ArrayList<>(filteredServices));
    }
}
