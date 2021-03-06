package com.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/api/register").permitAll()
			.antMatchers("/auth/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated();

		http.formLogin().loginPage("/login") // default
			.loginProcessingUrl("/authenticate")
			// .failureUrl("/login?error") // default
			.defaultSuccessUrl("/")
			.usernameParameter("email")
			.passwordParameter("pwd").permitAll();

		http.logout().logoutUrl("/logout") // default
				.logoutSuccessUrl("/login").permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider);
	}
}