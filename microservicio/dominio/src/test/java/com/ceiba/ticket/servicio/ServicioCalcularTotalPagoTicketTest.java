package com.ceiba.ticket.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;

public class ServicioCalcularTotalPagoTicketTest {

    @Test
    @DisplayName("Debería calcular el monto a pagar dado un tipo de vehiculo y una fecha de entrada al parqueadero")
    public void calculaTotalPagoTicketDadaUnFechaTipoVehiculo() {
        ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket = new ServicioCalcularTotalPagoTicket();
        LocalDateTime horaEntrada = LocalDateTime.now().minusHours(3);
        Integer tipoVehiculo = 1;

        double totalPagoCalculado = servicioCalcularTotalPagoTicket.ejecutar(tipoVehiculo, horaEntrada);
        double totalPagoEsperado = 3600;

        Assert.assertEquals(totalPagoEsperado, totalPagoCalculado, 2);
    }

}
