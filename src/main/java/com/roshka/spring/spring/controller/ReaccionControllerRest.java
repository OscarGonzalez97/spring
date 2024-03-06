package com.roshka.spring.spring.controller;

import com.roshka.spring.spring.model.Reaccion;
import com.roshka.spring.spring.service.ReaccionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReaccionControllerRest {
    private ReaccionService reaccionService;

    public ReaccionControllerRest (ReaccionService reaccionService) {
        this.reaccionService = reaccionService;
    }

    @GetMapping("/list-rest")
    public List<Reaccion> all() {
        return reaccionService.list();
    }

    @PostMapping("/create-rest")
    public Reaccion newReaccion(@RequestBody Reaccion reaccion) {
        return reaccionService. save(reaccion);
    }
}
