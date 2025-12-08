package es.egt.daw.dawes.java.rest.equicampus.common.domain.error;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String entity) {
        super("%s no encontrado".formatted(entity));
    }

    public EntityNotFoundException(String entity, int id){
        super("%s con id %s no se encuentra".formatted(entity, id));
    }
    
}
