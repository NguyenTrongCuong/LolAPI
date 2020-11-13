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

import main.admin.AdminDetailsService;
import main.adminlogin.AdminCustomAuthenticationFilter;
import main.adminlogin.AdminLoginFilter;
import main.properties.ApplicationProperties;


@Configuration
@EnableWebSecurity
@Order(2)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AdminDetailsService adminDetailsService;
	@Autowired
	private ApplicationProperties properties;
	
	@Bean
	public PasswordEncoder getPasswordEncoder2() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
	public DaoAuthenticationProvider getDaoAuthenticationProvider2() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(getPasswordEncoder2());
		provider.setUserDetailsService(adminDetailsService);
		return provider;
	}
	
	@Bean
	public AdminLoginFilter getAdminLoginFilter() {
		return new AdminLoginFilter();
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean2() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDaoAuthenticationProvider2());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.requestMatchers()
				.antMatchers("/api/v1/admin/**")
				.and()
			.addFilter(new AdminCustomAuthenticationFilter(authenticationManagerBean2(), properties))
			.addFilterBefore(getAdminLoginFilter(), AdminCustomAuthenticationFilter.class)
			.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/v1/admin/login").permitAll()
				.antMatchers(HttpMethod.POST, "/api/v1/admin/addChampion", "/api/v1/admin/addEquipment").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/v1/admin/updateInfoOfEquipment",
											 "/api/v1/admin/updateEquipmentsOfChampion",
											 "/api/v1/admin/updateChampionsOfEquipment",
											 "/api/v1/admin/updateInfoOfSkill",
											 "/api/v1/admin/updateInfoOfChampion",
											 "/api/v1/admin/updateInfoOfPassive").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/v1/admin/deleteChampion",
												"/api/v1/admin/deleteEquipment",
												"/api/v1/admin/deletePassiveOfSkill",
												"/api/v1/admin/deletePassiveOfEquipment").hasRole("ADMIN")
				.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	

}


















































































