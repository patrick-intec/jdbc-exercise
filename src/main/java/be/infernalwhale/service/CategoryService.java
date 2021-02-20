package be.infernalwhale.service;

import be.infernalwhale.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    List<Category> getCategories(String filter);
    Category createCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Category category);
}
