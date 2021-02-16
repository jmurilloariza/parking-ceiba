package com.ceiba.ticket.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.ticket.comando.ComandoTicket;
import com.ceiba.ticket.comando.manejador.ManejadorCrearTicket;
import com.ceiba.ticket.comando.manejador.ManejadorEliminarTicket;
import com.ceiba.ticket.comando.manejador.ManejadorPagarTicket;
import com.ceiba.ticket.modelo.dto.DtoTicket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@Api(tags = {"Controlador comando ticket"})
public class ComandoControladorTicket {

    private final ManejadorCrearTicket manejadorCrearTicket;
    private final ManejadorEliminarTicket manejadorEliminarTicket;
    private final ManejadorPagarTicket manejadorPagarTicket;

    @Autowired
    public ComandoControladorTicket(ManejadorCrearTicket manejadorCrearTicket, ManejadorEliminarTicket manejadorEliminarTicket, ManejadorPagarTicket manejadorPagarTicket) {
        this.manejadorCrearTicket = manejadorCrearTicket;
        this.manejadorEliminarTicket = manejadorEliminarTicket;
        this.manejadorPagarTicket = manejadorPagarTicket;
    }

    @PostMapping
    @ApiOperation("Crear Ticket")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTicket comandoTicket) {
        return this.manejadorCrearTicket.ejecutar(comandoTicket);
    }

    @PostMapping(value="/pagar/{id}")
    @ApiOperation("Pagar ticket")
    public DtoTicket pagarTicket(@PathVariable Long id){
        return this.manejadorPagarTicket.ejecutar(id);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Usuario")
    public void eliminar(@PathVariable Long id) {
        this.manejadorEliminarTicket.ejecutar(id);
    }
}
