package com.springBoot.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.web.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
