package com.example.eventos.repositories;

import com.example.eventos.entities.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ActividadRepository extends JpaRepository<Actividad, Long> {
}
