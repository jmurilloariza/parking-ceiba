package com.ceiba.ticket.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoTicket {

    private Long id;
    private String placaVehiculo;
    private Integer tipoVehiculo;

}
