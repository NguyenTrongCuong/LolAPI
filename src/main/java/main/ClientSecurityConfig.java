package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import main.adminlogin.AdminCustomAuthenticationFilter;
import main.adminlogin.AdminLoginFilter;
import main.client.ClientDetailsService;
import main.clientlogin.ClientCustomAuthenticationFilter;
import main.clientlogin.ClientLoginFilter;
import main.properties.ApplicationProperties;

@Configuration
@EnableWebSecurity
@Order(1)
public class ClientSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private ClientDetailsService clientDetailsService;
	@Autowired
	private ApplicationProperties properties;
	
	@Bean
	public PasswordEncoder getPasswordEncoder1() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
	public DaoAuthenticationProvider getDaoAuthenticationProvider1() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(getPasswordEncoder1());
		provider.setUserDetailsService(clientDetailsService);
		return provider;
	}
	
	@Bean
	public ClientLoginFilter getClientLoginFilter() {
		return new ClientLoginFilter();
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean1() throws Exception {
		return super.authenticationManagerBean();
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDaoAuthenticationProvider1());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.requestMatchers()
				.antMatchers("/api/v1/client/**")
				.and()
			.addFilter(new ClientCustomAuthenticationFilter(authenticationManagerBean1(), properties))
			.addFilterBefore(getClientLoginFilter(), ClientCustomAuthenticationFilter.class)
			.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/v1/client/login").permitAll()
				.antMatchers(HttpMethod.GET, "/api/v1/client/**").hasRole("USER")
				.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	

}
