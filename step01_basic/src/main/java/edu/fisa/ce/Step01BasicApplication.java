package edu.fisa.ce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class Step01BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step01BasicApplication.class, args);
		System.out.println("********");
	}

}
