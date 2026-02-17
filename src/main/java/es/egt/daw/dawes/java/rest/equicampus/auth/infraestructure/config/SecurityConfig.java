package es.egt.daw.dawes.java.rest.equicampus.auth.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Importante para habilitar la seguridad web
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Mantener deshabilitado si vas a usar HTMX con métodos POST/DELETE sin configurar el token CSRF todavía
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll() // Recursos estáticos libres
                .requestMatchers("/login", "/register", "/error").permitAll() // Páginas de acceso público
                .anyRequest().authenticated() // El resto requiere estar logueado
            )
            .formLogin(form -> form
                .loginPage("/login") // Nuestra ruta personalizada de login
                .loginProcessingUrl("/login") // La URL que Spring Security escuchará (POST)
                .defaultSuccessUrl("/web/dashboard", true) // A dónde ir tras loguearse
                .failureUrl("/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Para encriptar las contraseñas en la DB
    }
}