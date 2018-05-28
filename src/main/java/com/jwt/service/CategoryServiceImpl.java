package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jwt.dao.CategoryDAO;
import com.jwt.model.Category;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categorydao;
	
	@Override
	public void AddCategory(Category category) {
		categorydao.AddCategory(category);
	}

	@Override
	public void updateCategory(Category category) {
		categorydao.updateCategory(category);
	}

	@Override
	public void deleteCategory(int id) {
		categorydao.deleteCategory(id);
	}

	@Override
	public List<Category> getAllCategories() {
		return categorydao.getAllCategories();
	}

	@Override
	public Category getCategoryById(int id) {
		return categorydao.getCategoryById(id);
	}

	@Override
	public Category getCategoryByName(String name) {
		return categorydao.getCategoryByName(name);
	}

}
