package com.web.demo.config;

import com.web.demo.filter.JWTAuthenticationFilter;
import com.web.demo.filter.JWTAuthorizationFilter;
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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


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
		
		http.cors().and().csrf().disable();		// 개발 시 에만
		
		http.authorizeRequests()
			// .antMatchers("/user/**").hasRole("User")				// 사용자 페이지
			// .antMatchers("/admin/**").access("ROLE_ADMIN")				// 관리자 페이지
			.antMatchers("/**").permitAll()
			.antMatchers("/user/**").authenticated()
		.and()
			.logout().logoutUrl("/logout")
			.logoutSuccessUrl("/")
		.and()
			//allows granting access to all users 
		 	.formLogin()
			.loginPage("/login")
			.usernameParameter("id")
			.passwordParameter("password")
			.permitAll()
		.and()
			.addFilter(new JWTAuthenticationFilter(authenticationManager()))
			.addFilter(new JWTAuthorizationFilter(authenticationManager()))
			// this disables session creation on Spring Security
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// http.authenticationProvider(authProvider);
		
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mainService).passwordEncoder(passwordEncoder());
	}
	
	//API 서버와 Web FrontEnd 서버를 나누어서 구성할 때 CORS(Cross Origin Resource Sharing) 설정을 해야한다는데 이유는 ?
	@Bean
  	public CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    	return source;
  }
}