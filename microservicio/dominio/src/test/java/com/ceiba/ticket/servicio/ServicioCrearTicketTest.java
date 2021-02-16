package com.ceiba.ticket.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExceptionVehiculoEnParqueoNoPuedeIngresarDuplicado;
import com.ceiba.ticket.modelo.entidad.Ticket;
import com.ceiba.ticket.puerto.dao.DaoTicket;
import com.ceiba.ticket.puerto.repositorio.RepositorioTicket;
import com.ceiba.ticket.servicio.testdatabuilder.TicketTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServicioCrearTicketTest {

    private static final String EL_VEHICULO_YA_ESTA_EN_PARQUEADERO = "El vehiculo ya se encuentra dentro del parqueadero";

    @Test
    public void deberiaCrearUnTicket() {
        // arrange
        Ticket ticket = new TicketTestDataBuilder().build();
        DaoTicket daoTicket = Mockito.mock(DaoTicket.class);
        Mockito.when(daoTicket.validarVehiculoIngreso(ticket.getPlacaVehiculo())).thenReturn(false);
        System.out.println(daoTicket.validarVehiculoIngreso(ticket.getPlacaVehiculo()));
        ServicioCrearTicket servicioCrearTicket = Mockito.mock(ServicioCrearTicket.class);

        BasePrueba.assertThrows(() -> servicioCrearTicket.ejecutar(ticket),
                ExceptionVehiculoEnParqueoNoPuedeIngresarDuplicado.class,
                EL_VEHICULO_YA_ESTA_EN_PARQUEADERO);

    }

}
