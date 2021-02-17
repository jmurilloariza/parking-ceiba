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

    public ComandoTicket build(){
        return new ComandoTicket(id, placaVehiculo, tipoVehiculo);
    }
}
