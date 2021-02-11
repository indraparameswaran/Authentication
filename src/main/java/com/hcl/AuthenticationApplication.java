package com.hcl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.model.User;
import com.hcl.repository.UserRepository;

@SpringBootApplication
public class AuthenticationApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//User user = repository.findById(1);
	    //User user = repository.findByName("IParam");
		
		//logger.info("User Details -> {}", user);
		
		if(repository.userAuthentication("IParam", "Hcl2021")) {
			logger.info("User Authenticated Successfully.\n");
		}
		
		if(!repository.userAuthentication("MTesla", "Model3")) {
			logger.info("User Authentication Failure.\n");
		}
		
	}

}
