package com.ceiba.ticket.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoTicket {

    private Long id;
    private String placaVehiculo;
    private Integer tipoVehiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private LocalDateTime createdAd;
    private Double totalPagado;

}
