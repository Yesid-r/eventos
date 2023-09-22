package com.example.eventos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actividadID;
    private String nombre;
    private String tipo;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "actividad_participante",
            joinColumns = @JoinColumn(name = "actividad_id"),
            inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private List<Participante> participantes;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    public Actividad() {
    }

    public Actividad(Long actividadID, String nombre, String tipo) {
        this.actividadID = actividadID;
        this.nombre = nombre;
        this.tipo = tipo;

        this.participantes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "actividadID=" + actividadID +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", participantes=" + participantes +
                ", evento=" + evento +
                '}';
    }
}
