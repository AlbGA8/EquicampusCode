package es.egt.daw.dawes.java.rest.equicampus.auth.domain;


import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.ADMIN_CREATE;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.ADMIN_DELETE;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.ADMIN_READ;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.ADMIN_UPDATE;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.INSTRUCTOR_CREATE;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.INSTRUCTOR_READ;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.INSTRUCTOR_UPDATE;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.ALUMN_READ;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.ALUMN_UPDATE;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.USER_CREATE;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.USER_DELETE;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.USER_READ;
import static es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso.USER_UPDATE;


import java.util.Set;
import lombok.Getter;

public enum Rol {

    ALUMN(
        Set.of(
            ALUMN_READ,
            ALUMN_UPDATE
        )
    ),
    
    INSTRUCTOR(
        Set.of(
            INSTRUCTOR_CREATE,
            INSTRUCTOR_READ,
            INSTRUCTOR_UPDATE
           
        )
    ),
    ADMIN(
        Set.of(
            USER_CREATE,
            USER_READ,
            USER_UPDATE,
            USER_DELETE,
            
            ADMIN_CREATE,
            ADMIN_READ,
            ADMIN_UPDATE,
            ADMIN_DELETE
        )
    );

    @Getter
    private final Set<Permiso> permisos;

    private Rol(Set<Permiso> values){
        permisos = values;
    }
}

