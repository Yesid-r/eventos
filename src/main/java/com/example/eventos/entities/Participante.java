package com.example.eventos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participanteID;

    private String nombre;
    private String tipo;

    @OneToMany(mappedBy = "participante")
    @JsonIgnore
    private List<Inscripcion> inscripciones;

    @OneToMany(mappedBy = "participantes")
    @JsonIgnore
    private List<Actividad> actividades;

    public Participante() {
    }

    public Participante(Long participanteID, String nombre, String tipo) {
        this.participanteID = participanteID;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Long getParticipanteID() {
        return participanteID;
    }

    public void setParticipanteID(Long participanteID) {
        this.participanteID = participanteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "participanteID=" + participanteID +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", inscripciones=" + inscripciones +
                ", actividades=" + actividades +
                '}';
    }
}
