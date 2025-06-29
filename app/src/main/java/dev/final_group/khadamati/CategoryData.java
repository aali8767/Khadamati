package dev.final_group.khadamati;

import dev.final_group.khadamati.models.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CategoryData {

    public static final List<Category> categoryList = Arrays.asList(
            new Category(1, "حدادة", R.drawable.welding, "حداد"),
            new Category(2, "نجارة", R.drawable.carpentry, "نجار"),
            new Category(3, "سباكة", R.drawable.plumbing, "سباك"),
            new Category(4, "كهرباء", R.drawable.electrical_energy, "كهربائي"),
            new Category(5, "أعمال منزلية", R.drawable.cleaning_service, "عامل منزلي"),
            new Category(6, "دهان", R.drawable.paint_roller, "دهان")
    );

    public static List<String> getJobTitles() {
        List<String> jobTitles = new ArrayList<>();
        jobTitles.add("اختر المسمى الوظيفي");
        for (Category category : CategoryData.categoryList) {
            jobTitles.add(category.getJobTitle());
        }
        return jobTitles;
    }

    public static String getJobTitleById(int id) {
        for (Category category : categoryList) {
            if (category.getId() == id) {
                return category.getJobTitle();
            }
        }
        return "";
    }

    public static int getJobIdByTitle(String title) {
        for (Category category : categoryList) {
            if (Objects.equals(category.getJobTitle(), title)) {
                return category.getId();
            }
        }
        return -1;
    }
}
