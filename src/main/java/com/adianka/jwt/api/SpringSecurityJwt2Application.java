package com.adianka.jwt.api;

import com.adianka.jwt.api.entity.User;
import com.adianka.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwt2Application {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUsers(){
		List<User> users = Stream.of(
				new User(101,"daniel","daniel@gmail.com", "admin"),
				new User(102,"jack","jack@gmail.com", "1234"),
				new User(103,"flex","flex@gmail.com", "1234"),
				new User(104,"mario","mario@gmail.com", "1234")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwt2Application.class, args);
	}

}
