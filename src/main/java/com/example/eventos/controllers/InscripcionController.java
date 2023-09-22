package com.example.eventos.controllers;

import com.example.eventos.DTO.InscripcionDTO;
import com.example.eventos.entities.Inscripcion;
import com.example.eventos.responses.ResponseHandler;
import com.example.eventos.services.ServiceInscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private ServiceInscripcion serviceInscripcion;
    @GetMapping
    public List<Inscripcion> findAll(){
        return serviceInscripcion.findAll();
    }

    @PostMapping()
    public ResponseEntity<Object> save(@RequestBody InscripcionDTO inscripcionDTO){
        System.out.println("Id evento: " + inscripcionDTO.getIdEvento());
        System.out.println("Id participante: " + inscripcionDTO.getIdParticipante());
        System.out.println("Valor pagado: " + inscripcionDTO.getValorPagado());

        try{

            Inscripcion inscripcion1 = serviceInscripcion.save(inscripcionDTO.getIdEvento(), inscripcionDTO.getIdParticipante());
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, inscripcion1);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
