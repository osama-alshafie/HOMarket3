package com.jwt.dao;

import java.util.List;

import com.jwt.model.Category;

public interface CategoryDAO {
	
	public void AddCategory(Category category);

    public void updateCategory(Category category);

    public void deleteCategory(int id);

    public List<Category> getAllCategories();

    public Category getCategoryById(int id);

	public Category getCategoryByName(String name);

}
