package com.ceiba.ticket.comando.manejador;

import com.ceiba.ticket.comando.fabrica.FabricaTicket;
import com.ceiba.ticket.modelo.dto.DtoTicket;
import com.ceiba.ticket.puerto.dao.DaoTicket;
import com.ceiba.ticket.servicio.ServicioCalcularTotalPagoTicket;
import com.ceiba.ticket.servicio.ServicioPagarTicket;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPagarTicket {

    private final DaoTicket daoTicket;
    private final FabricaTicket fabricaTicket;
    private final ServicioPagarTicket servicioPagarTicket;
    private final ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket;

    public ManejadorPagarTicket(DaoTicket daoTicket, FabricaTicket fabricaTicket, ServicioPagarTicket servicioPagarTicket, ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket) {
        this.daoTicket = daoTicket;
        this.fabricaTicket = fabricaTicket;
        this.servicioPagarTicket = servicioPagarTicket;
        this.servicioCalcularTotalPagoTicket = servicioCalcularTotalPagoTicket;
    }

    public DtoTicket ejecutar(Long id){
        DtoTicket dtoTicket = this.daoTicket.buscarPorId(id);

        return dtoTicket;
    }
}
