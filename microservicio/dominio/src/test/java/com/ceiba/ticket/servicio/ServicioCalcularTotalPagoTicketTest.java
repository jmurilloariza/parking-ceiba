package com.ceiba.ticket.servicio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;

public class ServicioCalcularTotalPagoTicketTest {

    private ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket;
    private LocalDateTime horaEntrada;

    @Before
    public void before(){
        this.servicioCalcularTotalPagoTicket  = new ServicioCalcularTotalPagoTicket();
        this.horaEntrada = LocalDateTime.now();
    }

    @Test
    @DisplayName("Debería calcular el monto a pagar dado un tipo de vehiculo vehiculo y una fecha de entrada al parqueadero")
    public void calculaTotalPagoTicketDadaUnFechaTipoVehiculoAutomovil() {
        Integer tipoVehiculo = 1;

        double totalPagoCalculado = this.servicioCalcularTotalPagoTicket.ejecutar(tipoVehiculo, this.horaEntrada);
        double totalPagoEsperado = 600;

        Assert.assertEquals(totalPagoEsperado, totalPagoCalculado, 2);
    }

    @Test
    @DisplayName("Debería calcular el monto a pagar dado un tipo de vehiculo motocicleta y una fecha de entrada al parqueadero")
    public void calculaTotalPagoTicketDadaUnFechaTipoVehiculoMotocicleta() {
        Integer tipoVehiculo = 2;

        double totalPagoCalculado = this.servicioCalcularTotalPagoTicket.ejecutar(tipoVehiculo, this.horaEntrada);
        double totalPagoEsperado = 300;

        Assert.assertEquals(totalPagoEsperado, totalPagoCalculado, 2);
    }

    @Test
    @DisplayName("Debería calcular el monto a pagar dado un tipo de vehiculo motocicleta y una fecha de entrada al parqueadero en " +
            "un dia festivo")
    public void calculaTotalPagoTicketDadaUnFechaTipoVehiculoDiaFestivo() {
        ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket = new ServicioCalcularTotalPagoTicket();
        Integer tipoVehiculo = 2;

        double totalPagoCalculado = servicioCalcularTotalPagoTicket.ejecutar(tipoVehiculo, this.horaEntrada);
        double totalPagoEsperado = 300;

        Assert.assertEquals(totalPagoEsperado, totalPagoCalculado, 2);
    }

}
