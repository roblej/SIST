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
}
