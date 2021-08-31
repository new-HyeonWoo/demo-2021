package com.example.demo.common.utils.jwt;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil implements Serializable {

	public static final long TOKEN_VALIDATION_SECOND = 1000L * 10;
	public static final long REFRESH_TOKEN_VALIDATION_SECOND = 1000L * 60 * 24 * 2;

	public static final String ACCESS_TOKEN_NAME = "accessToken";
	public static final String REFRESH_TOKEN_NAME = "refreshToken";

	@Value("${jwt.secret}")
	private String SECRET_KEY;

	private Key getSigningKey(String secretKey) {
		byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	/**
	 * secret 키를 가지고 토큰에서 정보 검색
	 */
	public Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
			.setSigningKey(getSigningKey(SECRET_KEY))
			.build()
			.parseClaimsJws(token)
			.getBody();
	}

	/**
	 * 토큰 만료 체크
	 */
	public Boolean isTokenExpired(String token) {
		final Date expiration = extractAllClaims(token).getExpiration();
		return expiration.before(new Date());
	}

	/**
	 * Access Token 생성
	 */
	public String generateToken(User user) {
		return doGenerateToken(user.getUsername(), TOKEN_VALIDATION_SECOND);
	}

	/**
	 * Refresh Token 생성
	 */
	public String generateRefreshToken(User user) {
		return doGenerateToken(user.getUsername(), REFRESH_TOKEN_VALIDATION_SECOND);
	}

	/**
	 * 토큰을 생성
	 */
	public String doGenerateToken(String username, long expireTime) {
		Claims claims = Jwts.claims();
		claims.put("username", username);

		return Jwts.builder()
			.setClaims(claims)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + expireTime))
			.signWith(getSigningKey(SECRET_KEY), SignatureAlgorithm.HS256)
			.compact();
	}

	/**
	 * 토큰 검증
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public String getUsername(String token) {
		return extractAllClaims(token).get("username").toString();
	}
}
