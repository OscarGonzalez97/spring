package com.roshka.spring.spring.service;

import com.roshka.spring.spring.model.Reaccion;
import com.roshka.spring.spring.repository.ReaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaccionService {

    @Autowired
    private ReaccionRepository reaccionRepository;

    public List<Reaccion> list() {
        return reaccionRepository.findAll();
    }

    public Optional<Reaccion> findById(Long id) {
        return reaccionRepository.findById(id);
    }


}