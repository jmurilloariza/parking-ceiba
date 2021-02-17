package com.ceiba.ticket.comando;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComandoTicket {

    private Long id;
    private String placaVehiculo;
    private Integer tipoVehiculo;

    public ComandoTicket() {
    }

    public ComandoTicket(Long id, String placaVehiculo, Integer tipoVehiculo) {
        this.id = id;
        this.placaVehiculo = placaVehiculo;
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public String toString() {
        return "ComandoTicket{" +
                "id=" + id +
                ", placaVehiculo='" + placaVehiculo + '\'' +
                ", tipoVehiculo=" + tipoVehiculo +
                '}';
    }
}
