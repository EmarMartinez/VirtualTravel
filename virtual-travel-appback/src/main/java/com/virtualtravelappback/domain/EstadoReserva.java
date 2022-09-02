package com.virtualtravelappback.domain;

import com.virtualtravelappback.infraestructure.controller.dto.EstadoReservaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.EstadoReservaOutputDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EstadoReserva {
    @Id
    @GeneratedValue
    int id_estado_reserva;

    @OneToOne(fetch= FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    Reserva reserva;

    boolean aceptada;
    String comentarios;

    public int getId_estado_reserva() {
        return id_estado_reserva;
    }

    public void setId_estado_reserva(int id_estado_reserva) {
        this.id_estado_reserva = id_estado_reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public boolean isAceptada() {
        return aceptada;
    }

    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public EstadoReserva(EstadoReservaInputDto estadoReservaInputDto) {
        this.aceptada = estadoReservaInputDto.aceptada();
        this.comentarios = estadoReservaInputDto.comentarios();
    }

    public EstadoReservaOutputDto EstadoReservaToOutputDto(EstadoReserva estadoReserva) {
        return new EstadoReservaOutputDto(
                estadoReserva.id_estado_reserva,
                estadoReserva.reserva.getId_reserva(),
                estadoReserva.isAceptada(),
                estadoReserva.comentarios);
    }
}
