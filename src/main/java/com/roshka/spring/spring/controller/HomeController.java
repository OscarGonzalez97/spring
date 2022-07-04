package com.roshka.spring.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// marca la clase como controlador
@Controller
public class HomeController {
    // maneja el request para la ruta base
    @GetMapping("/")
    public String home() {
        // retorna el nombre de la vista
        return "home";
    }
}
