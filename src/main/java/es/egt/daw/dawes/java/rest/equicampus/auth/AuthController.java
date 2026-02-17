package es.egt.daw.dawes.java.rest.equicampus.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "fragments/login"; // Thymeleaf cargará el fragmento
    }
}