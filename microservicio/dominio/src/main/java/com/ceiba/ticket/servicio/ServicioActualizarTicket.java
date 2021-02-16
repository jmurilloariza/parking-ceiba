package com.ceiba.ticket.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.ticket.modelo.entidad.Ticket;
import com.ceiba.ticket.puerto.repositorio.RepositorioTicket;

public class ServicioActualizarTicket {

    private static final String EL_TICKET_NO_EXISTE = "No existe un ticket con este ID";

    private final RepositorioTicket repositorioTicket;

    public ServicioActualizarTicket(RepositorioTicket repositorioTicket) {
        this.repositorioTicket = repositorioTicket;
    }

    public void ejecutar(Ticket ticket) {
        boolean existe = this.validarExistencia(ticket);
        if (!existe) throw new ExcepcionSinDatos(EL_TICKET_NO_EXISTE);
        this.repositorioTicket.actualizar(ticket);
    }

    private boolean validarExistencia(Ticket ticket) {
        return this.repositorioTicket.existe(ticket.getId());
    }
}
