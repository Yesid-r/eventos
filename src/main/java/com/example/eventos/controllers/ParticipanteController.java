package com.example.eventos.controllers;

import com.example.eventos.entities.Participante;
import com.example.eventos.responses.ResponseHandler;
import com.example.eventos.services.ServiceEvento;
import com.example.eventos.services.ServiceParticipante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ServiceParticipante serviceParticipante;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try {
            List<Participante> result = serviceParticipante.findAll();
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Participante participante){
        try{
            Participante participante1 = serviceParticipante.save( participante );
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, participante1);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        try{
            Participante participante = serviceParticipante.findById( id );
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, participante);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
