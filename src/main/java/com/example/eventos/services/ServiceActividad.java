package com.example.eventos.services;

import com.example.eventos.entities.Actividad;
import com.example.eventos.repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceActividad {
    @Autowired
    private ActividadRepository actividadRepository;

    public List<Actividad> findAll(){
        return actividadRepository.findAll();
    }
    public Actividad findById( Long id ){
        return actividadRepository.findById(id).get();
    }
    public Actividad save( Actividad actividad){
        return actividadRepository.save( actividad );
    }

}
