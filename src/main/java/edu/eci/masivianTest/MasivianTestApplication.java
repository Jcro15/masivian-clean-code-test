package edu.eci.masivianTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class MasivianTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(MasivianTestApplication.class, args);
	}
}
