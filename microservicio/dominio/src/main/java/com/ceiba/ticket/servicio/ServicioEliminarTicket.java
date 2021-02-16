package com.ceiba.ticket.servicio;

import com.ceiba.ticket.puerto.repositorio.RepositorioTicket;

public class ServicioEliminarTicket {

    private final RepositorioTicket repositorioTicket;

    public ServicioEliminarTicket(RepositorioTicket repositorioTicket) {
        this.repositorioTicket = repositorioTicket;
    }

    public void ejecutar(Long id) {
        this.repositorioTicket.eliminar(id);
    }
}
