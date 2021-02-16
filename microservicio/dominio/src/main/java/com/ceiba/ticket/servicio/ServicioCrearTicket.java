package com.ceiba.ticket.servicio;

import com.ceiba.dominio.excepcion.ExceptionVehiculoEnParqueoNoPuedeIngresarDuplicado;
import com.ceiba.ticket.modelo.entidad.Ticket;
import com.ceiba.ticket.puerto.dao.DaoTicket;
import com.ceiba.ticket.puerto.repositorio.RepositorioTicket;

public class ServicioCrearTicket {

    private static final String EL_VEHICULO_YA_ESTA_EN_PARQUEADERO = "El vehiculo ya se encuentra dentro del parqueadero";

    private final RepositorioTicket repositorioTicket;
    private final DaoTicket daoTicket;

    public ServicioCrearTicket(RepositorioTicket repositorioTicket, DaoTicket daoTicket) {
        this.repositorioTicket = repositorioTicket;
        this.daoTicket = daoTicket;
    }

    public Long ejecutar(Ticket ticket) {
        this.validarSiVehiculoEstaEnParqueo(ticket.getPlacaVehiculo());
        return this.repositorioTicket.crear(ticket);
    }

    private void validarSiVehiculoEstaEnParqueo(String placa) {
        boolean noDentroDelParqueadero = this.daoTicket.validarVehiculoIngreso(placa);

        if (!noDentroDelParqueadero) {
            throw new ExceptionVehiculoEnParqueoNoPuedeIngresarDuplicado(EL_VEHICULO_YA_ESTA_EN_PARQUEADERO);
        }
    }
}
