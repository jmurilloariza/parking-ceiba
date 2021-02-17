package com.ceiba.ticket.modelo.dto;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

public class TicketDtoTest {

    public static final Long IDTICKET = 1L;
    public static final String PLACA = "UNA008";
    public static final Integer TIPOVEHICULO = 1;
    public static final LocalDateTime HORAENTRADA = LocalDateTime.now();
    public static final LocalDateTime HORASALIDA = LocalDateTime.now();
    public static final LocalDateTime CREATEDAT = LocalDateTime.now();
    public static final Double TOTALPAGADO = 15000d;

    @Test
    public void validarDtoTicketValido(){
        DtoTicket dtoTicket = new DtoTicket(
                IDTICKET,
                PLACA,
                TIPOVEHICULO,
                HORAENTRADA,
                HORASALIDA,
                CREATEDAT,
                TOTALPAGADO
        );

        boolean esValido = dtoTicket.getId().equals(IDTICKET) && dtoTicket.getPlacaVehiculo().equals(PLACA) &&
                dtoTicket.getTipoVehiculo().equals(TIPOVEHICULO) && dtoTicket.getHoraEntrada() == HORAENTRADA &&
                dtoTicket.getHoraSalida() == HORASALIDA && dtoTicket.getCreatedAt() == CREATEDAT &&
                dtoTicket.getTotalPagado().equals(TOTALPAGADO);

        assertTrue(esValido);
    }

}
