package com.ceiba.ticket.controlador;

import com.ceiba.ticket.consulta.ManejadorListarTickets;
import com.ceiba.ticket.modelo.dto.DtoTicket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@Api(tags={"Controlador consulta tickets"})
public class ConsultaControladorTicket {

    private final ManejadorListarTickets manejadorListarTickets;

    public ConsultaControladorTicket(ManejadorListarTickets manejadorListarTickets) {
        this.manejadorListarTickets = manejadorListarTickets;
    }

    @GetMapping
    @ApiOperation("Listar tikcets")
    public List<DtoTicket> listarTickets(){
        return this.manejadorListarTickets.ejecutar();
    }
}
