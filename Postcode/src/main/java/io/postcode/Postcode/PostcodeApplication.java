package io.postcode.Postcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class PostcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostcodeApplication.class, args);
	}

}
