package com.jwt.service;

import java.util.List;

import com.jwt.model.Category;

public interface CategoryService {
	
	public void AddCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(int id);

	public List<Category> getAllCategories();

	public Category getCategoryById(Integer id);

	public Category getCategoryByName(String name);

}
