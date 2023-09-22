package com.example.eventos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inscripcionID;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    @JsonIgnore
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;

    private BigDecimal valorPagado;

    public Inscripcion() {
    }

    public Inscripcion(Long inscripcionID, Participante participante, BigDecimal valorPagado) {

        this.inscripcionID = inscripcionID;
        this.participante = participante;
        this.valorPagado = valorPagado;
    }

    public Long getInscripcionID() {
        return inscripcionID;
    }

    public void setInscripcionID(Long inscripcionID) {
        this.inscripcionID = inscripcionID;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public BigDecimal getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(BigDecimal valorPagado) {
        this.valorPagado = valorPagado;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "inscripcionID=" + inscripcionID +
                ", evento=" + evento +
                ", participante=" + participante +
                ", valorPagado=" + valorPagado +
                '}';
    }
}
