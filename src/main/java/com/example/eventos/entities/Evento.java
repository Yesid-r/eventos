package com.example.eventos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventoID;
    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private BigDecimal valorTotalRecibido;

    private BigDecimal valorEvento;
    @OneToMany(mappedBy = "evento")
    @JsonIgnore
    private List<Inscripcion> inscripciones;
    @OneToMany(mappedBy = "evento")
    @JsonIgnore
    private List<Actividad> actividades;

    public Evento() {
    }

    public Evento(Long eventoID, String nombre, LocalDate fecha, String lugar, BigDecimal valorEvento) {
        this.eventoID = eventoID;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.valorTotalRecibido = BigDecimal.ZERO;
        this.valorEvento = valorEvento;
        this.actividades = new ArrayList<>();
        this.inscripciones = new ArrayList<>();
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public Long getEventoID() {
        return eventoID;
    }

    public void setEventoID(Long eventoID) {
        this.eventoID = eventoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public BigDecimal getValorTotalRecibido() {

        return valorTotalRecibido;
    }
    public BigDecimal getValorEvento() {
        return valorEvento;
    }


    public void setValorTotalRecibido(BigDecimal valorTotalRecibido) {
        this.valorTotalRecibido = valorTotalRecibido;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "eventoID=" + eventoID +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", valorTotalRecibido=" + valorTotalRecibido +
                ", inscripciones=" + inscripciones +
                ", actividades=" + actividades +
                '}';
    }
}
