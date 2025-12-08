package es.egt.daw.dawes.java.rest.equicampus.common.domain.model;

import lombok.Data;

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
