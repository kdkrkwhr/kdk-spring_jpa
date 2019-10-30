package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Members {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;

	private String email;
	private String pwd;
	private String name;
	private String phone;
	private String address;

	@Builder
	public Members(String email, String pwd, String name, String phone, String address) {

		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.address = address;

	}
}