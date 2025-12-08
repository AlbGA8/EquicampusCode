package es.egt.daw.dawes.java.rest.equicampus.common.domain.repository;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Alba Garcia Puerta
 * @version 1.0
 * @since 2025-12-08
 */

public interface CRUDRepository <T, ID> {

    public T save(T t);
    public List<T> getAll();
    public Optional<T> getById(ID id);
    public void deteteById(ID id);

}
