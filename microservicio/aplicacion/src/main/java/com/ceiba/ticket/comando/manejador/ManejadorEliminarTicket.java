package com.ceiba.ticket.comando.manejador;

import com.ceiba.ticket.servicio.ServicioEliminarTicket;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarTicket {

    private final ServicioEliminarTicket servicioEliminarTicket;

    public ManejadorEliminarTicket(ServicioEliminarTicket servicioEliminarTicket) {
        this.servicioEliminarTicket = servicioEliminarTicket;
    }

    public void ejecutar(Long id) {
        this.servicioEliminarTicket.ejecutar(id);
    }
}
