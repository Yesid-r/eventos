package com.example.eventos.controllers;


import com.example.eventos.entities.Actividad;
import com.example.eventos.responses.ResponseHandler;
import com.example.eventos.services.ServiceActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private ServiceActividad serviceActividad;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try {
            List<Actividad> result = serviceActividad.findAll();
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Actividad actividad){
        System.out.println(actividad.toString());
        try{

            Actividad actividad1 = serviceActividad.save( actividad );
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, actividad1);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        try{
            Actividad actividad = serviceActividad.findById( id );
            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, actividad);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
