package com.ceiba.ticket.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExceptionVehiculoEnParqueoNoPuedeIngresarDuplicado;
import com.ceiba.ticket.modelo.entidad.Ticket;
import com.ceiba.ticket.puerto.dao.DaoTicket;
import com.ceiba.ticket.puerto.repositorio.RepositorioTicket;
import com.ceiba.ticket.servicio.testdatabuilder.TicketTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;

public class ServicioCrearTicketTest {

    private static final String EL_VEHICULO_YA_ESTA_EN_PARQUEADERO = "El vehiculo ya se encuentra dentro del parqueadero";

    @Test
    @DisplayName("Debería lanzar una excepcion cuando se intenta crear un ticket para un vehiculo que ya tiene un ticket " +
            "con fecha de salida diferente de null, lo que quiere decir que el vehiculo ya se encuentra a dentro del parqueadero")
    public void shouldThrowExceptionVehiculoEnParqueoNoPuedeIngresarDuplicado() {
        // arrange
        Ticket ticket = new TicketTestDataBuilder().build();
        RepositorioTicket repositorioTicket = Mockito.mock(RepositorioTicket.class);
        DaoTicket daoTicket = Mockito.mock(DaoTicket.class);
        Mockito.when(daoTicket.validarVehiculoIngreso(ticket.getPlacaVehiculo())).thenReturn(false);
        ServicioCrearTicket servicioCrearTicket = new ServicioCrearTicket(repositorioTicket, daoTicket);

        BasePrueba.assertThrows(() -> servicioCrearTicket.ejecutar(ticket),
                ExceptionVehiculoEnParqueoNoPuedeIngresarDuplicado.class,
                EL_VEHICULO_YA_ESTA_EN_PARQUEADERO);
    }

    @Test
    public void shouldValidarSiVehiculoEstaEnParqueoPuedeIngresar(){
        Ticket ticket = new TicketTestDataBuilder().build();
        DaoTicket daoTicket = Mockito.mock(DaoTicket.class);
        System.out.println(ticket.toString());
        System.out.println(daoTicket.validarVehiculoIngreso(ticket.getPlacaVehiculo()));

        assertTrue(daoTicket.validarVehiculoIngreso(ticket.getPlacaVehiculo()));

    }

}
