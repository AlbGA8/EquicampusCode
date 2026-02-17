package es.egt.daw.dawes.java.rest.equicampus.auth.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import es.egt.daw.dawes.java.rest.equicampus.auth.domain.Permiso;
import es.egt.daw.dawes.java.rest.equicampus.auth.domain.Rol;
import es.egt.daw.dawes.java.rest.equicampus.auth.infraestructure.db.jpa.repository.UserEntityRepository;
import es.egt.daw.dawes.java.rest.equicampus.auth.infraestructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserEntityRepository repository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Deshabilitamos CSRF temporalmente para llamadas POST o HTMX
            .csrf(csrf -> csrf.disable())
            
            // Configuración de rutas
            .authorizeHttpRequests(requests -> requests
                // Login y recursos públicos
                .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "favicon.ico").permitAll()
                
                // Solo ADMIN puede gestionar profesores
                .requestMatchers("/web/profesores/**").hasRole(Rol.ADMIN.name())
                
                // ADMIN puede leer alumnos
                .requestMatchers(HttpMethod.GET, "/web/alumnos/**")
                    .hasAuthority(Permiso.ADMIN_READ.getPermiso())
                    
                
                // El resto de la app requiere autenticación
                .anyRequest().authenticated()
            )
            
            // Configuración del login con Thymeleaf
            .formLogin(login -> login
                .loginPage("/login")           // tu login.html
                .defaultSuccessUrl("/web/dashboard", true)  // redirige al layout principal
                .permitAll()
            )
            
            // Configuración de logout
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
            )
            
            // Habilita autenticación básica si quieres usar Postman o AJAX
            .httpBasic(withDefaults());

        return http.build();
    }

    // Servicio para obtener usuario por email y mapearlo a UserDetails
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> UserMapper.toAuth(
            UserMapper.toDomain(repository.findByEmail(username))
        );
    }

    // Encoder de passwords
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
