package main.adminlogin;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import main.admin.Admin;
import main.admin.AdminDetails;
import main.admin.AdminRepository;
import main.client.Client;
import main.client.ClientDetails;
import main.client.ClientRepository;
import main.properties.ApplicationProperties;

public class AdminLoginFilter extends OncePerRequestFilter {
	@Autowired
	private ApplicationProperties properties;
	@Autowired
	private AdminRepository adminRepo;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain) throws ServletException, IOException {
		if(SecurityContextHolder.getContext().getAuthentication() == null) {
			if(request.getHeader("Authorization") != null) {
				String jwt = request.getHeader("Authorization");
				try {
					Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(properties.getHashedKey()).build().parseClaimsJws(jwt.substring(7));
					long expiration = Long.valueOf(Integer.toString((int) jws.getBody().get("exp")));
					Date expiredDate = new Date(expiration * 1000);
					if(expiredDate.after(Date.valueOf(LocalDate.now()))) {
						String email = (String) jws.getBody().get("email");
						Optional<Admin> admin = this.adminRepo.findById(email);
						if(!admin.isEmpty()) {
							AdminDetails adminDetails = new AdminDetails(admin.get());
							Authentication auth = new UsernamePasswordAuthenticationToken(adminDetails, null, adminDetails.getAuthorities());
							SecurityContextHolder.getContext().setAuthentication(auth);
						}
					}
				}
				catch(JwtException e) {
					throw new IllegalStateException("Invalid JWT");
				}
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
