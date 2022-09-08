package com.virtualtravelappback.domain;

import com.virtualtravelappback.infraestructure.controller.dto.ReservaOutputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaProcesadaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaProcesadaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservasProcesadas {
    @Id
    int id;
    int id_reserva;
    String ciudad;
    String nombre;
    String apellido;
    String telefono;
    String email;
    Date fecha;
    int hora_salida;
    boolean aceptada;
    String motivo;

    public ReservasProcesadas(ReservaProcesadaInputDto reservaProcesadaInputDto) {
        this.id = reservaProcesadaInputDto.id();
        this.id_reserva = reservaProcesadaInputDto.id_reserva();
        this.ciudad = reservaProcesadaInputDto.ciudad();
        this.nombre = reservaProcesadaInputDto.nombre();
        this.apellido = reservaProcesadaInputDto.apellido();
        this.telefono = reservaProcesadaInputDto.telefono();
        this.email = reservaProcesadaInputDto.email();
        this.fecha = reservaProcesadaInputDto.fecha();
        this.hora_salida = reservaProcesadaInputDto.hora_salida();
        this.aceptada = reservaProcesadaInputDto.aceptada();
        this.motivo = reservaProcesadaInputDto.motivo();
    }

    public ReservaProcesadaOutputDto reservaProcesadaToOutputDto(ReservasProcesadas reserva) {

        return new ReservaProcesadaOutputDto(
                reserva.getId(),
                reserva.getId_reserva(),
                reserva.getCiudad(),
                reserva.getNombre(),
                reserva.getApellido(),
                reserva.getTelefono(),
                reserva.getEmail(),
                reserva.getFecha(),
                reserva.getHora_salida(),
                reserva.isAceptada(),
                reserva.getMotivo()
        );
    }
}
