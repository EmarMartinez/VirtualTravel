package com.virtualtravel.domain;

import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue
    int id;
    int id_reserva;
    String ciudad;
    String nombre;
    String apellido;
    String telefono;
    String email;
    Date fecha;
    int hora_salida;

    public Reserva(ReservaInputDto reservaInputDto) {
        this.id_reserva = reservaInputDto.id_reserva();
        this.ciudad = reservaInputDto.ciudad();
        this.nombre = reservaInputDto.nombre();
        this.apellido = reservaInputDto.apellido();
        this.telefono = reservaInputDto.telefono();
        this.email = reservaInputDto.email();
        this.fecha = reservaInputDto.fecha();
        this.hora_salida = reservaInputDto.hora_salida();
    }
}
