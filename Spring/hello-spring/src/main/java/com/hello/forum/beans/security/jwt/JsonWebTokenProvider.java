package com.hello.forum.beans.security.jwt;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.forum.member.vo.MemberVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;



/**
 * JWT를 생성하고 검증하는 클래스.
 */
@Component
public class JsonWebTokenProvider {

	@Value("${app.jwt.issuer:hello-spring}")
	private String issuer;
	
	@Value("${app.jwt.secret-key:spring-security-key-random-token-key}")
	private String secretKey;
	
	/**
	 * 토큰을 생성한다. 
	 * @param expireAt 토큰의 유효기간
	 * @param memberVO 토큰 본문에 첨부할 사용자의 정보
	 * @return JWT 토큰
	 */
	public String generateToken( Duration expireAt , MemberVO memberVO) {
	      
	      Date now = new Date();
	      Date expiry = new Date(now.getTime()+ expireAt.toMillis());
	      
	      SecretKey key = 
	            Keys.hmacShaKeyFor(//hmacSha 알고리즘으로 구현된 인코드 키
	            (secretKey.getBytes(StandardCharsets.UTF_8)));
	      
	      return Jwts.builder()
	            .header().add("typ","JWT").and()
	            .issuer(issuer)
	            .issuedAt(now)
	            .expiration(expiry)
	            .subject(memberVO.getEmail())
	            .claims(Map.of("user", memberVO))
	            .signWith(key)
	            .compact();
	   }
//	public String generateToken(Duration expireAt, MemberVO memberVO) {
//		
//		Date now = new Date();
//		// Token 유효기간
//		Date expiry = new Date(now.getTime() + expireAt.toMillis());
//		
//		// JWT 암/복호화를 위해 대칭키 생성.
//		SecretKey key = Keys.hmacShaKeyFor(this.secretKey.getBytes(StandardCharsets.UTF_8));
//		
//		return Jwts.builder()
//				   .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
//				   .setIssuer(issuer)
//				   .setIssuedAt(now)
//				   .setExpiration(expiry)
//				   .setSubject(memberVO.getEmail())
//				   .setClaims(Map.of("user", memberVO))
//				   .signWith(key)
//				   .compact();
//		
//	}
	
	/**
	 * JWT 에서 사용자의 정보를 조회한다.
	 * 만약, 잘못된 토큰일 경우 예외가 발생한다.
	 * @param token HttpServletRequest header로 전달된 토큰의 정보
	 * @return 회원 정보
	 * @throws JsonProcessingException
	 */
	public MemberVO getUserFormToken(String token) throws JsonProcessingException {
		
		SecretKey key = Keys.hmacShaKeyFor(this.secretKey.getBytes(StandardCharsets.UTF_8));
		
//		Claims claims = Jwts.parser()
//				.setSigningKey(key)
//				.build()
//				.parseClaimsJws(token)
//				.getBody();
		


		Jws<Claims> jwsClaJws = Jwts.parser()
          .requireIssuer(issuer)
          .verifyWith(key)
          .build()
          .parseSignedClaims(token);

		Claims claims= jwsClaJws.getPayload();
				
		ObjectMapper om = new ObjectMapper();
		Object user = claims.get("user");
		String json = om.writeValueAsString(user);
		
		MemberVO memberVO = om.readValue(json, MemberVO.class);
		
		return memberVO;
	}
	
}
