package com.springBoot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.web.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
