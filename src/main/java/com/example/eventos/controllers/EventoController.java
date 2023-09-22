package com.example.eventos.controllers;


import com.example.eventos.entities.Evento;
import com.example.eventos.entities.Inscripcion;
import com.example.eventos.entities.Participante;
import com.example.eventos.responses.ResponseHandler;
import com.example.eventos.services.ServiceEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    public ServiceEvento serviceEvento;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try {
            List<Evento> result = serviceEvento.findAll();
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Evento evento){
        try{
            Evento evento1 = serviceEvento.save( evento );
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, evento1);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        System.out.println("ID evento"+id);
        try{
            List<Inscripcion> participantes = serviceEvento.findById( id ).getInscripciones();
            Evento evento = serviceEvento.findById( id );
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, participantes);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/valorTotal/{id}")
    public ResponseEntity<Object> valorTotalEvento(@PathVariable Long id){

        try{
            Evento evento = serviceEvento.findById( id );
            List<Inscripcion> participantes = evento.getInscripciones();
            BigDecimal valorTotal = new BigDecimal(0);
            for (Inscripcion inscripcion: participantes) {
                valorTotal = valorTotal.add(inscripcion.getValorPagado());
            }
            return new ResponseHandler().generateResponse("Success, valor total", HttpStatus.OK, valorTotal);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
