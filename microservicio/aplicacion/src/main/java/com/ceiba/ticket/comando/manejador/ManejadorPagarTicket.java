package com.ceiba.ticket.comando.manejador;

import com.ceiba.ticket.modelo.dto.DtoTicket;
import com.ceiba.ticket.puerto.dao.DaoTicket;
import com.ceiba.ticket.servicio.ServicioCalcularTotalPagoTicket;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ManejadorPagarTicket {

    private final DaoTicket daoTicket;
    private final ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket;

    public ManejadorPagarTicket(DaoTicket daoTicket, ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket) {
        this.daoTicket = daoTicket;
        this.servicioCalcularTotalPagoTicket = servicioCalcularTotalPagoTicket;
    }

    public Double ejecutar(Long id){
        DtoTicket dtoTicket = this.daoTicket.buscarPorId(id);
        Double valorPago = servicioCalcularTotalPagoTicket.ejecutar(dtoTicket.getTipoVehiculo(), dtoTicket.getHoraEntrada());
        LocalDateTime horaSalida = LocalDateTime.now();

        daoTicket.actualizarPagoTicket(id, valorPago, horaSalida);
        return valorPago;
    }
}
