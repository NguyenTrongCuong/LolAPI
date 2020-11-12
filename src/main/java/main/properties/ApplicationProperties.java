package main.properties;


import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import io.jsonwebtoken.security.Keys;

@ConfigurationProperties(prefix="jwt.properties")
public class ApplicationProperties {
	private String secretKey;
	private String authorizationHeader;
	private String tokenPrefix;
	private int expiredAfterDays;
	
	public String getSecretKey() {
		return secretKey;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	@Bean
	public SecretKey getHashedKey() {
		return Keys.hmacShaKeyFor(this.secretKey.getBytes());
	}

	public int getExpiredAfterDays() {
		return expiredAfterDays;
	}

	public void setExpiredAfterDays(int expiredAfterDays) {
		this.expiredAfterDays = expiredAfterDays;
	}

	public String getAuthorizationHeader() {
		return authorizationHeader;
	}

	public void setAuthorizationHeader(String authorizationHeader) {
		this.authorizationHeader = authorizationHeader;
	}

	public String getTokenPrefix() {
		return tokenPrefix;
	}

	public void setTokenPrefix(String tokenPrefix) {
		this.tokenPrefix = tokenPrefix;
	}
	
	

	
	

}
