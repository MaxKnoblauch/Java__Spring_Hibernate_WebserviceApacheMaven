package de.dhbwheidenheim.informatik.springhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"de.dhbwheidenheim.informatik.springhibernate.persondemo"})

public class SpringhibernateApplication { 

	public static void main(String[] args) {
		SpringApplication.run(SpringhibernateApplication.class, args);
	}

}
