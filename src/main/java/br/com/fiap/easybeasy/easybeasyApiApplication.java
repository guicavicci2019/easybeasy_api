package br.com.fiap.easybeasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class easybeasyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(easybeasyApiApplication.class, args);
	}

}
