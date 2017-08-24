package com.qualitest.demo;


import com.qualitest.demo.services.TokenHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalCarApplicationTests {


	@Test
	public void contextLoads() {
		PasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("123"));

		TokenHandler tokenHandler = new TokenHandler();
		String token = tokenHandler.generateTokenId(0 , LocalDateTime.now().plusSeconds(60));
		System.out.println(token);


		System.out.println(tokenHandler.extractUserId(token).toString());
	}

}
