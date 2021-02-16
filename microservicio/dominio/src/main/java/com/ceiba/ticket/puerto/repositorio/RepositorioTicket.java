package com.ceiba.ticket.puerto.repositorio;

import com.ceiba.ticket.modelo.entidad.Ticket;

public interface RepositorioTicket {

    /**
     * Permite crear un ticket
     * @param ticket
     * @return el id generado
     */
    Long crear(Ticket ticket);

    /**
     * Permite actualizar un ticket
     * @param ticket
     */
    void actualizar(Ticket ticket);

    /**
     * Permite eliminar un ticket
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un ticket por Id
     * @param id
     */
    boolean existe(Long id);
}
