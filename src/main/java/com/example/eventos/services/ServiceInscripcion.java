package com.example.eventos.services;

import com.example.eventos.entities.Evento;
import com.example.eventos.entities.Inscripcion;
import com.example.eventos.entities.Participante;
import com.example.eventos.repositories.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ServiceInscripcion {

    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private ServiceEvento serviceEvento;
    @Autowired
    private ServiceParticipante serviceParticipante;

    public List<Inscripcion> findAll(){
        return inscripcionRepository.findAll();
    }
    public  Inscripcion findById( Long id ){
        return inscripcionRepository.findById(id).get();
    }

    public void deleteById(Long id){
        inscripcionRepository.deleteById(id);
    }


    public Inscripcion save(Long idEvento, Long idParticipante) {

        Evento evento = serviceEvento.findById(idEvento);
        Participante participante = serviceParticipante.findById(idParticipante);

        if (evento != null && participante != null) {

            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setEvento(evento);
            inscripcion.setParticipante(participante);
            if (participante.getTipo().equals("estudiante")){
                BigDecimal valorInscripcionEstudiante = evento.getValorEvento().multiply(new BigDecimal("0.7"));
                inscripcion.setValorPagado(valorInscripcionEstudiante);
            }else {
                inscripcion.setValorPagado(evento.getValorEvento());
            }
            return inscripcionRepository.save(inscripcion);
        }else {
            return  null;
        }


    }
}
