package es.egt.daw.dawes.java.rest.equicampus.common.infraestructure.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@Data
@AllArgsConstructor
public class CustomResponse {

    private final LocalDateTime date;
		private final HttpStatus status;
		private final String message;
}
