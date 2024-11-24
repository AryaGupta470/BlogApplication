package com.springBoot.web.payloads;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
	
	private int id;

	private String userName;
	
	private String about;

	private String email;

	private String password;
	

}
