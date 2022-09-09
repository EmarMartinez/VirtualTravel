package com.virtualtravel.domain;

import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaNoAceptada {
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

    String motivo;

    int email_id;

    public ReservaNoAceptada(ReservaInputDto reserva) {

        this.id_reserva = reserva.id_reserva();
        this.ciudad = reserva.ciudad();
        this.nombre = reserva.nombre();
        this.apellido = reserva.apellido();
        this.telefono = reserva.telefono();
        this.email = reserva.email();
        this.fecha = reserva.fecha();
        this.hora_salida = reserva.hora_salida();
    }
}
