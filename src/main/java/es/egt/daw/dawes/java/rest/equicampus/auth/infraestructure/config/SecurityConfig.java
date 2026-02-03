package es.egt.daw.dawes.java.rest.equicampus.auth.infraestructure.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
       @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .cors(cors -> cors.configure(http)) // Habilita CORS dentro de Spring Security
        .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para pruebas (opcional)
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
    
        return http.build();
    }

    /** Configuración para evitar el error de CORS que dará el navegador */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Permitimos todos los orígenes
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        
        // Permitimos los métodos necesarios
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Permitimos todas las cabeceras
        configuration.setAllowedHeaders(Arrays.asList("*"));
        
        // Permitimos que el navegador reciba la respuesta
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
