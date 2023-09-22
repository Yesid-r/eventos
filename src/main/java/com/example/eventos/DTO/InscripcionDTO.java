package com.example.eventos.DTO;

import java.math.BigDecimal;

public class InscripcionDTO {
    private Long idEvento;
    private Long idParticipante;
    private BigDecimal valorPagado;

    public InscripcionDTO() {
    }

    public InscripcionDTO(Long idEvento, Long idParticipante, BigDecimal valorPagado) {
        this.idEvento = idEvento;
        this.idParticipante = idParticipante;
        this.valorPagado = valorPagado;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Long idParticipante) {
        this.idParticipante = idParticipante;
    }

    public BigDecimal getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(BigDecimal valorPagado) {
        this.valorPagado = valorPagado;
    }
}
