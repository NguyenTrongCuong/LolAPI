package main.adminlogin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import main.admin.AdminDetails;
import main.client.ClientDetails;
import main.clientlogin.JsonInput;
import main.properties.ApplicationProperties;

public class AdminCustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private ApplicationProperties properties;
	private AuthenticationManager authManager;
	
	public AdminCustomAuthenticationFilter(AuthenticationManager authManager, ApplicationProperties properties) {
		this.setFilterProcessesUrl("/api/v1/admin/login");
		this.authManager = authManager;
		this.properties = properties;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
												HttpServletResponse response) throws AuthenticationException {
		try {
			ObjectMapper obj = new ObjectMapper();
			InputStream input = request.getInputStream();
			JsonInput jsonInput = obj.readValue(input, JsonInput.class);
			Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(jsonInput.getUsername(), jsonInput.getPassword()));
			return auth;
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response,
											FilterChain chain,
											Authentication authResult) throws IOException, ServletException {
		AdminDetails adminDetails = (AdminDetails) authResult.getPrincipal();
		String jws = Jwts.builder()
						 .setExpiration(Date.valueOf(LocalDate.now().plusDays(this.properties.getExpiredAfterDays())))
						 .claim("email", adminDetails.getUsername())
						 .signWith(this.properties.getHashedKey())
						 .compact();
		response.addHeader(this.properties.getAuthorizationHeader(), this.properties.getTokenPrefix() + " " + jws);
	}
	

}
