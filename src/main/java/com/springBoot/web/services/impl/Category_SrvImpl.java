package com.springBoot.web.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.web.entities.Category;
import com.springBoot.web.payloads.CategoryDto;
import com.springBoot.web.repository.CategoryRepo;
import com.springBoot.web.services.CategoryService_Srv;

@Service
public class Category_SrvImpl implements CategoryService_Srv {

	@Autowired
	private CategoryRepo catRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto catDto) {
		Category category = this.modelMapper.map(catDto, Category.class);
		Category savedCat = catRepo.save(category);
		return this.modelMapper.map(savedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto catDto, int catId) {
		Optional<Category> existingCat = this.catRepo.findById(catId);

		CategoryDto toBeUpdate = this.modelMapper.map(existingCat.get(), CategoryDto.class);

		toBeUpdate.setCategoryTitle(catDto.getCategoryTitle());
		toBeUpdate.setCategoryDescription(catDto.getCategoryDescription());

		Category updatedCat = catRepo.save(modelMapper.map(toBeUpdate, Category.class));
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(int catId) {
		this.catRepo.deleteById(catId);
	}

	@Override
	public CategoryDto getCategoryById(int catId) {
		Optional<Category> findCat = this.catRepo.findById(catId);
		return this.modelMapper.map(findCat.get(), CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> lstCat = this.catRepo.findAll();
		List<CategoryDto> lstCatDtos = lstCat.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());
		return lstCatDtos;
	}
}
