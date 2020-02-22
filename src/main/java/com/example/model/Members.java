package com.example.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

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

	private Collection<? extends GrantedAuthority> authorities;

	@Builder
	public Members(String email, String pwd, String name, String phone, String address) {

		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.address = address;

	}
}