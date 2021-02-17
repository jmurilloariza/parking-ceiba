package com.ceiba.ticket.servicio.testdatabuilder;

import com.ceiba.ticket.comando.ComandoTicket;

import java.util.UUID;

public class ComandoTicketTestDataBuilder {

    private Long id;
    private String placaVehiculo;
    private Integer tipoVehiculo;

    public ComandoTicketTestDataBuilder() {
        this.placaVehiculo = "UNS045";
        this.tipoVehiculo = 1;
    }

    public ComandoTicketTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoTicketTestDataBuilder setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
        return this;
    }

    public ComandoTicketTestDataBuilder setTipoVehiculo(Integer tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public ComandoTicket build(){
        return new ComandoTicket(id, placaVehiculo, tipoVehiculo);
    }
}
