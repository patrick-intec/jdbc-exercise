package be.infernalwhale.service;

import be.infernalwhale.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category createCategory(Category category);
    Category updateCategory(Category category);
    boolean deleteCategory(Category category);
}
