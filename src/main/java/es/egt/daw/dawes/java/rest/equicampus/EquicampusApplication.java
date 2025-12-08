package es.egt.daw.dawes.java.rest.equicampus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@EnableCaching
@SpringBootApplication
public class EquicampusApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquicampusApplication.class, args);
	}

}
