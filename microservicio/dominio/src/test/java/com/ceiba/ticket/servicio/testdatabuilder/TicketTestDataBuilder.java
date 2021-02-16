package com.ceiba.ticket.servicio.testdatabuilder;

import com.ceiba.ticket.modelo.entidad.Ticket;

import java.time.LocalDateTime;

public class TicketTestDataBuilder {

    public static final Long IDTICKET = 1L;
    public static final String PLACA = "UNA008";
    public static final Integer TIPOVEHICULO = 1;
    public static final LocalDateTime HORAENTRADA = LocalDateTime.now();
    public static final LocalDateTime HORASALIDA = LocalDateTime.now();
    public static final LocalDateTime CREATEDAT = LocalDateTime.now();
    public static final Double TOTALPAGADO = 15000d;

    private Long id;
    private String placaVehiculo;
    private Integer tipoVehiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private LocalDateTime createdAt;
    private Double totalPagado;

    public TicketTestDataBuilder() {
        this.id = IDTICKET;
        this.placaVehiculo = PLACA;
        this.tipoVehiculo = TIPOVEHICULO;
        this.horaEntrada = HORAENTRADA;
        this.horaSalida = HORASALIDA;
        this.createdAt = CREATEDAT;
        this.totalPagado = TOTALPAGADO;
    }

    public TicketTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TicketTestDataBuilder setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
        return this;
    }

    public TicketTestDataBuilder setTipoVehiculo(Integer tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public TicketTestDataBuilder setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
        return this;
    }

    public TicketTestDataBuilder setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
        return this;
    }

    public TicketTestDataBuilder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public TicketTestDataBuilder setTotalPagado(Double totalPagado) {
        this.totalPagado = totalPagado;
        return this;
    }

    public Ticket build(){
        return new Ticket(IDTICKET, PLACA, TIPOVEHICULO);
    }
}
