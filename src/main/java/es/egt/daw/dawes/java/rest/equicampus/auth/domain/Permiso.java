package es.egt.daw.dawes.java.rest.equicampus.auth.domain;

import lombok.Getter;

public enum Permiso {
    ADMIN_CREATE("admin:create"),
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    
    INSTRUCTOR_CREATE("instructor:create"),
    INSTRUCTOR_READ("instructor:read"),
    INSTRUCTOR_UPDATE("instructor:update"),
    INSTRUCTOR_DELETE("instructor:delete"), 

    ALUMN_CREATE("alumn:create"),
    ALUMN_READ("alumn:read"),
    ALUMN_UPDATE("alumn:update"),
    ALUMN_DELETE("alumn:delete"),
    
    USER_CREATE("user:create"),
    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete");   

    @Getter
    private final String permiso;

    private Permiso(String value){
        permiso = value;
    }
}