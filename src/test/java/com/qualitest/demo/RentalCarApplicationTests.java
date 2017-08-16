package com.qualitest.demo;

import com.qualitest.demo.model.Role;
import com.qualitest.demo.model.User;
import com.qualitest.demo.services.TokenHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
