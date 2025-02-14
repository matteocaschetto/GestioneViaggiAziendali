package com.epicode.GestioneViaggiAziendali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.epicode.GestioneViaggiAziendali"})
public class GestioneViaggiAziendaliApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneViaggiAziendaliApplication.class, args);
	}

}
