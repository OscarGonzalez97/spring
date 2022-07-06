package com.roshka.spring.spring.controller;

import com.roshka.spring.spring.model.Reaccion;
import com.roshka.spring.spring.service.ReaccionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class ReaccionController {

    private ReaccionService reaccionService;

    public ReaccionController (ReaccionService reaccionService) {
        this.reaccionService = reaccionService;
    }

    @GetMapping("/reaccion/{id}")
    public String getReaccionById(@PathVariable long id, Model model) throws Exception {
        Optional<Reaccion> reaccion = reaccionService.findById(id);
        if (reaccion.isPresent()) {
            model.addAttribute("tipo", reaccion.get().getTipo());
            model.addAttribute("icono", reaccion.get().getIcono());
        }
        return "reaccion-detail";
    }

    @GetMapping("/reaccion/")
    public String getReaccion(Model model) throws Exception {
        List<Reaccion> reacciones = reaccionService.list();
        model.addAttribute("reacciones", reacciones);
        return "reacciones";
    }
}