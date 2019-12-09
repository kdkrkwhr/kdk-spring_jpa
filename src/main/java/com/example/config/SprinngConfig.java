package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.example.controller.MembersController;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SprinngConfig extends WebSecurityConfigurerAdapter {

	private MembersController membersController;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// 페이지 권한 설정
				.antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/members/myinfo").hasRole("MEMBER")
				.antMatchers("/**").permitAll().and() // 로그인 설정
				.formLogin().loginPage("/members/api/login").defaultSuccessUrl("/members/api/login").permitAll().and() // 로그아웃
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/members/api/logout"))
				.logoutSuccessUrl("/members/api/logout").invalidateHttpSession(true).and()
				// 403 예외처리 핸들링
				.exceptionHandling().accessDeniedPage("/members/"); // 생성 예정
	}

	/*
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.userDetailsService(membersController).passwordEncoder(passwordEncoder())
	 * ; }
	 */
}
