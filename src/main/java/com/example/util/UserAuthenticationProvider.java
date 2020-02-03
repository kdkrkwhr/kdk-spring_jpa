package com.example.util;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.model.Members;
import com.example.repository.MembersRepository;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	MembersRepository userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String password = (String) authentication.getCredentials();

		System.out.println("email : " + email);
		System.out.println("password : " + password);

		Members member = userService.memberLogin(email, password);
		if (member == null) {
			throw new BadCredentialsException("Login Error !!");
		}

		member.setPwd(null);

		ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new UsernamePasswordAuthenticationToken(member, null, authorities);
	}

	@Override
	public boolean supports(Class authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}