package com.example.eventos.services;

import com.example.eventos.entities.Participante;
import com.example.eventos.repositories.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceParticipante {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Participante> findAll(){

        return participanteRepository.findAll();
    }
    public Participante findById( Long id ){

        return participanteRepository.findById(id).get();
    }
    public Participante save( Participante participante){

        return participanteRepository.save( participante );
    }
}
