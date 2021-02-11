package com.hcl;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.hcl.repository.UserRepository;
@SpringBootTest
public class UserAuthenticationTests {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void userAuthenticateSuccess() {
		boolean result = repository.userAuthentication("IParam", "Hcl2021");
		assertEquals(true,result);
	}

	@Test
	public void userAuthenticateFailure() {
		boolean result = repository.userAuthentication("MTesla", "Model3");
		assertEquals(false,result);
	}
}
