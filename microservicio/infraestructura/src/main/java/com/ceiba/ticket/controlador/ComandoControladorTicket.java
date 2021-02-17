package com.ceiba.ticket.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.ticket.comando.ComandoTicket;
import com.ceiba.ticket.comando.manejador.ManejadorCrearTicket;
import com.ceiba.ticket.comando.manejador.ManejadorPagarTicket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@Api(tags = {"Controlador comando ticket"})
public class ComandoControladorTicket {

    private final ManejadorCrearTicket manejadorCrearTicket;
    private final ManejadorPagarTicket manejadorPagarTicket;

    @Autowired
    public ComandoControladorTicket(ManejadorCrearTicket manejadorCrearTicket, ManejadorPagarTicket manejadorPagarTicket) {
        this.manejadorCrearTicket = manejadorCrearTicket;
        this.manejadorPagarTicket = manejadorPagarTicket;
    }

    @PostMapping
    @ApiOperation("Crear Ticket")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTicket comandoTicket) {
        return this.manejadorCrearTicket.ejecutar(comandoTicket);
    }

    @PostMapping(value="/pagar/{id}")
    @ApiOperation("Pagar ticket")
    public ComandoRespuesta<Double> pagarTicket(@PathVariable Long id){
        return this.manejadorPagarTicket.ejecutar(id);
    }

}
