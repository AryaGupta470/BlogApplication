package com.springBoot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.web.payloads.CategoryDto;
import com.springBoot.web.services.CategoryService_Srv;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService_Srv category;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto catDto) {
		CategoryDto createdCat = this.category.createCategory(catDto);
		return new ResponseEntity<CategoryDto>(createdCat, HttpStatus.CREATED);
	}

	@PutMapping("/{id}") //not works
	public ResponseEntity<CategoryDto> updateCat(@RequestBody CategoryDto catDto, @PathVariable int id) {
		CategoryDto updatedCat = this.category.updateCategory(catDto, id);
		return new ResponseEntity<CategoryDto>(updatedCat, HttpStatus.OK);
	}

	@GetMapping("/{id}")//works
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int id) {
		CategoryDto cat = this.category.getCategoryById(id);
		return new ResponseEntity<CategoryDto>(cat, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id) {
		this.category.deleteCategory(id);
		return new ResponseEntity<String>("Category Deleted Successfully..", HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories() {
		List<CategoryDto> lstCatDto = this.category.getAllCategories();
		return new ResponseEntity<List<CategoryDto>>(lstCatDto, HttpStatus.OK);
	}
}
