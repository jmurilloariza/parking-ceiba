package com.ceiba.ticket.comando.fabrica;

import com.ceiba.ticket.comando.ComandoTicket;
import com.ceiba.ticket.modelo.dto.DtoTicket;
import com.ceiba.ticket.modelo.entidad.Ticket;
import org.springframework.stereotype.Component;

@Component
public class FabricaTicket {

    public Ticket crear(ComandoTicket comandoTicket){
        return new Ticket(
                comandoTicket.getId(),
                comandoTicket.getPlacaVehiculo(),
                comandoTicket.getTipoVehiculo()
        );
    }

    public DtoTicket crear(Ticket ticket){
        return new DtoTicket(
                ticket.getId(),
                ticket.getPlacaVehiculo(),
                ticket.getTipoVehiculo(),
                ticket.getHoraEntrada(),
                ticket.getHoraSalida(),
                ticket.getCreatedAt(),
                ticket.getTotalPagado()
        );
    }

}
