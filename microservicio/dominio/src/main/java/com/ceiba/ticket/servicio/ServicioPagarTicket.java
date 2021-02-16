package com.ceiba.ticket.servicio;

import com.ceiba.ticket.modelo.entidad.Ticket;
import com.ceiba.ticket.puerto.repositorio.RepositorioTicket;

public class ServicioPagarTicket {

    private final RepositorioTicket repositorioTicket;

    public ServicioPagarTicket(RepositorioTicket repositorioTicket) {
        this.repositorioTicket = repositorioTicket;
    }

    public Ticket ejecutar(Ticket ticket){
        repositorioTicket.actualizar(ticket);
        return ticket;
    }
}
