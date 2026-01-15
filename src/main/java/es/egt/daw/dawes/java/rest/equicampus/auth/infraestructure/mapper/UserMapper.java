package es.egt.daw.dawes.java.rest.equicampus.auth.infraestructure.mapper;

import es.egt.daw.dawes.java.rest.equicampus.auth.domain.Usuario;
import es.egt.daw.dawes.java.rest.equicampus.auth.domain.UsuarioId;
import es.egt.daw.dawes.java.rest.equicampus.auth.infraestructure.db.jpa.entity.UserEntity;
import es.egt.daw.dawes.java.rest.equicampus.auth.infraestructure.security.UserAuth;

public class UserMapper {
    
    public static Usuario toDomain(UserEntity user){
        Usuario usuario = new Usuario(new UsuarioId(user.getId()), user.getFirstname(), user.getLastname(),
                            user.getEmail(), user.getPassword(), user.getRole());
        return usuario;
    }

    public static UserAuth toAuth(Usuario usuario){
        UserAuth user = new UserAuth(usuario.getId().getValue(), usuario.getNombre(), 
                                usuario.getMail(), usuario.getPassword(), usuario.getRol());
        return user;
    }
}