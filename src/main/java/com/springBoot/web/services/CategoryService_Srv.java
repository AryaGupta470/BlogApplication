package com.springBoot.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.web.payloads.CategoryDto;

@Service
public interface CategoryService_Srv {
	
	//create
	public CategoryDto createCategory(CategoryDto catDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto catDto,int catId);

	
	//delete
	public void deleteCategory(int catId);

	//get By Id
	public CategoryDto getCategoryById(int catId);
	
	//getAll
	public List<CategoryDto> getAllCategories();

}
