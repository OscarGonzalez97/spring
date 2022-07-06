package com.roshka.spring.spring.repository;

import com.roshka.spring.spring.model.Reaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReaccionRepository extends JpaRepository<Reaccion, Long> {

}
