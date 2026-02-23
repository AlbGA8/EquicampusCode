package es.egt.daw.dawes.java.rest.equicampus.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Usuario {
    
    // Atributos
    private UsuarioId id;
    private String nombre;
    private String apellido;
    private String mail;
    private String password;
    private Rol rol;
}