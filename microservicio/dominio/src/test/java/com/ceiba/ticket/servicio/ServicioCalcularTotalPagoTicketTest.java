package com.ceiba.ticket.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;

public class ServicioCalcularTotalPagoTicketTest {

    @Test
    @DisplayName("Debería calcular el monto a pagar dado un tipo de vehiculo vehiculo y una fecha de entrada al parqueadero")
    public void calculaTotalPagoTicketDadaUnFechaTipoVehiculoAutomovil() {
        ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket = new ServicioCalcularTotalPagoTicket();
        LocalDateTime horaEntrada = LocalDateTime.now().minusHours(3);
        Integer tipoVehiculo = 1;

        double totalPagoCalculado = servicioCalcularTotalPagoTicket.ejecutar(tipoVehiculo, horaEntrada);
        double totalPagoEsperado = 3600;

        Assert.assertEquals(totalPagoEsperado, totalPagoCalculado, 2);
    }

    @Test
    @DisplayName("Debería calcular el monto a pagar dado un tipo de vehiculo motocicleta y una fecha de entrada al parqueadero")
    public void calculaTotalPagoTicketDadaUnFechaTipoVehiculoMotocicleta() {
        ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket = new ServicioCalcularTotalPagoTicket();
        LocalDateTime horaEntrada = LocalDateTime.now().minusHours(3);
        System.out.println(horaEntrada);
        Integer tipoVehiculo = 2;

        double totalPagoCalculado = servicioCalcularTotalPagoTicket.ejecutar(tipoVehiculo, horaEntrada);
        double totalPagoEsperado = 1800;

        Assert.assertEquals(totalPagoEsperado, totalPagoCalculado, 2);
    }

    @Test
    @DisplayName("Debería calcular el monto a pagar dado un tipo de vehiculo motocicleta y una fecha de entrada al parqueadero en " +
            "un dia festivo")
    public void calculaTotalPagoTicketDadaUnFechaTipoVehiculoDiaFestivo() {
        ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket = new ServicioCalcularTotalPagoTicket();
        LocalDateTime horaEntrada = LocalDateTime.parse("2021-05-01T11:00:06.705").minusHours(3);
        Integer tipoVehiculo = 2;

        double totalPagoCalculado = servicioCalcularTotalPagoTicket.ejecutar(tipoVehiculo, horaEntrada);
        double totalPagoEsperado = 3600;

        Assert.assertEquals(totalPagoEsperado, totalPagoCalculado, 2);
    }

}
