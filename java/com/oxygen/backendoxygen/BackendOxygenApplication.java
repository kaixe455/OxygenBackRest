package com.oxygen.backendoxygen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Añado el exclude para desactivar la configuracion de seguridad de momento
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class BackendOxygenApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendOxygenApplication.class, args);
	}

}
