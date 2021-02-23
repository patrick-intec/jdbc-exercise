package be.infernalwhale.service.fake;

import be.infernalwhale.model.Category;
import be.infernalwhale.service.CategoryService;

import java.util.*;
import java.util.stream.Collectors;

public class MockCategoryService implements CategoryService {
    private final List<Category> categories = generateFakeList();

    @Override
    public List<Category> getCategories() {
        return this.categories;
    }

    @Override
    public Category createCategory(Category category) {
        Category cat = new Category(99, category.getCategoryName());
        categories.add(cat);

        return cat;
    }

    @Override
    public Category updateCategory(Category category) {
        return category;
    }

    @Override
    public boolean deleteCategory(Category category) {
        return true;
    }

    private List<Category> generateFakeList() {
        return new ArrayList<>(List.of(
                new Category(2, "Alcoholarm"),
                new Category(3, "Alcoholvrij"),
                new Category(4, "Ale"),
                new Category(5, "Alt"),
                new Category(6, "Amber"),
                new Category(7, "Bierrette"),
                new Category(8, "Bitter"),
                new Category(9, "Donkerbok"),
                new Category(11, "Dort"),
                new Category(12, "Dubbel Donker"),
                new Category(13, "Edelbier"),
                new Category(14, "Extra"),
                new Category(15, "Faro"),
                new Category(16, "Geuze")
        ));
    }

}
