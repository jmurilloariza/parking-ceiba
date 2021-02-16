package com.ceiba.ticket.puerto.dao;

import com.ceiba.ticket.modelo.dto.DtoTicket;

import java.time.LocalDateTime;
import java.util.List;

public interface DaoTicket {

    /**
     * Permite listar tickets
     *
     * @return los tickets
     */
    List<DtoTicket> listar();

    DtoTicket buscarPorId(Long id);

    boolean validarVehiculoIngreso(String placaVehiculo);

    void actualizarPagoTicket(Long id, Double valorPago, LocalDateTime horaSalida);

}
