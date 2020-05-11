package com.web.demo.config;

import com.web.demo.model.Role;
import com.web.demo.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private MainService mainService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/css/**, /static/js/**, *.ico");		
	} 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();		// 개발 시 에만
		
		http.authorizeRequests()
			.antMatchers("/user/**").hasRole("User")				// 사용자 페이지
			// .antMatchers("/admin/**").access("ROLE_ADMIN")				// 관리자 페이지
			.antMatchers("/**").permitAll()
			// .antMatchers("/login").authenticated()
		.and()
			//allows granting access to all users 
		 	.formLogin()
			.loginPage("/login")
			.usernameParameter("id")
			.passwordParameter("password")
			.permitAll();
		
        // http.authenticationProvider(authProvider);

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mainService).passwordEncoder(passwordEncoder());
    }
}