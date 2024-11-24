package com.springBoot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springBoot.web.repository.UserRepo;

@SpringBootTest
class BlogApplicationTests {
	
	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}
	
	
	@Test
	void repoTest()
	{
		System.out.println("Repository interface's class name : "+userRepo.getClass().getName());
		System.out.println(userRepo.getClass().getPackageName());
		
//		System.out.println("Test Class of Spring Boot");

	}

}
