package com.sist.ex0911_jwt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.sist.ex0911_jwt.jwt.JwtProvider;

import io.jsonwebtoken.security.Keys;

//단언테스트를 위해 static import를 한다
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

@SpringBootTest
class Ex0911JwtApplicationTests {

	@Value("${custom.jwt.secretKey}")
	private String secretKeyCode;

	@Test
	@DisplayName("시크릿 키 코드 체크")
	void loadSecretKeyCode() {
		//단언 : assertJ
		assertThat(secretKeyCode).isNotNull();
	}

	@Test
	@DisplayName("암호화알고리즘으로 secretKey 암호화")
	void genBase64(){
		String encoding = Base64.getEncoder().encodeToString(secretKeyCode.getBytes());
		
		SecretKey sKey = Keys.hmacShaKeyFor(encoding.getBytes());

		assertThat(sKey).isNotNull();
	}

	@Autowired
	private JwtProvider jwtProvider;

	@Test
	@DisplayName("accessToken발급")
	void tokenTEst(){
		Map<String,Object> claims = new HashMap<>();
		claims.put("id","qwer");
		claims.put("uname","홍길동");
		claims.put("upw","1234");
		claims.put("uemail","admin@korea.com");

		String accessToken = jwtProvider.getToken(claims, 3600*3);
		System.out.println("Access-Token :"+accessToken);
		
		assertThat(accessToken).isNotNull();
	}

	@Test
	@DisplayName("동일한 SecretKey인지 확인")
	void sameSecretKey(){
		SecretKey sKey1 = jwtProvider.getSecretKey();
		SecretKey sKey2 = jwtProvider.getSecretKey();
		assertThat(sKey1 == sKey2).isTrue();
	}

	@Test
	@DisplayName("유효한 토큰인지? 확인")
	void TokenValidTest(){
		Map<String,Object> claims = new HashMap<>();
		claims.put("mid","admin");
		claims.put("mname","이도");
		claims.put("mphone","01012345678");

		//토큰생성( -1을 넣어 바로 만료되는 토큰을 받는다.)
		String token = jwtProvider.getToken(claims, 3600);
		System.out.println("TOKEN = " + token);

		assertThat(jwtProvider.verify(token)).isTrue();
	}

	@Test
	@DisplayName("토큰으로 claims정보 확인")
	void TokenClaimsTest(){
		Map<String,Object> claims = new HashMap<>();
		claims.put("mid","admin");
		claims.put("mname","이도");
		claims.put("mphone","01012345678");

		String token = jwtProvider.getToken(claims, 3600);
		System.out.println("TOKEN = " + token);
		//이 토큰이 유효한지 검증을 받는다.
		assertThat(jwtProvider.verify(token)).isTrue();

		//토큰에 저장되어있는 정보를 받는다.
		//(위 map과 동일한지 확인)
		Map<String, Object> extractedClaims = jwtProvider.getClaims(token);
		System.out.println("extractedClaims = " + extractedClaims);
		System.out.println("map.name ="+claims.get("mname"));
	}
}
