package com.virtualtravelappback.domain;

import com.virtualtravelappback.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaOutputDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue
    int id_reserva;

    @OneToOne(fetch= FetchType.LAZY, optional = true)
    EstadoReserva estadoReserva;
    String ciudad;
    String nombre;
    String apellido;
    String telefono;
    String email;
    Date fecha;
    int hora_salida;

    public Reserva(String ciudad, String nombre, String apellido, String telefono, String email, Date fecha, int hora_salida) {
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fecha = fecha;
        this.hora_salida = hora_salida;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(int hora_salida) {
        this.hora_salida = hora_salida;
    }



    public Reserva(ReservaInputDto reservaInputDto) {
        this.ciudad = reservaInputDto.ciudad();
        this.nombre = reservaInputDto.nombre();
        this.apellido = reservaInputDto.apellido();
        this.telefono = reservaInputDto.telefono();
        this.email = reservaInputDto.email();
        this.fecha = reservaInputDto.fecha();
        this.hora_salida = reservaInputDto.hora_salida();
    }

    public ReservaOutputDto reservaToOutputDto(Reserva reserva) {

        return new ReservaOutputDto(
                reserva.getId_reserva(),
                reserva.getCiudad(),
                reserva.getNombre(),
                reserva.getApellido(),
                reserva.getTelefono(),
                reserva.getEmail(),
                reserva.getFecha(),
                reserva.getHora_salida()
                );
    }
}
