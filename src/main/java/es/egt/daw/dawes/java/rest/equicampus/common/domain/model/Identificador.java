package es.egt.daw.dawes.java.rest.equicampus.common.domain.model;

import lombok.Data;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

@Data
public abstract class Identificador {

    protected Integer value;

    protected Identificador(Integer value) {
        if (value == null ) {
            throw new IllegalArgumentException("El identificador no puede ser nulo");
        }
        this.value = value;

    }
}
