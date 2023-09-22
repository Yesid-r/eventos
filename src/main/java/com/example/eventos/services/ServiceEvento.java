package com.example.eventos.services;

import com.example.eventos.entities.Evento;
import com.example.eventos.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEvento {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> findAll(){

        return eventoRepository.findAll();
    }
    public Evento findById( Long id ){

        return eventoRepository.findById(id).get();
    }
    public Evento save( Evento evento){

        return eventoRepository.save( evento );
    }
    public Evento delete( Long id ){

        Evento evento = findById( id );

        if( evento != null ){
            eventoRepository.delete( evento );

            return evento;
        }

        return null;
    }
}
