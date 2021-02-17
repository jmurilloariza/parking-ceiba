package com.ceiba.ticket.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.dominio.excepcion.ExceptionValorInvalidoTipoVehiculo;
import com.ceiba.ticket.modelo.entidad.Ticket;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketTest {

    private static final String TICKET_SIN_PLACA = "Se debe ingresar la placa del vehiculo";
    private static final String TICKET_SIN_TIPO_VEHICULO = "Se debe ingresar el tipo de vehiculo";
    private static final String TIPO_VEHICULO_INVALIDO = "Tipo de vehiculo invalido, 1 para automovil o 2 para motocicleta";
    private static final String PARKING_CERRADO = "El parkeadero aun no abre";

    private final Long IDTICKET = 3L;
    private final String PLACA = "FNS009";
    private final Integer TIPOVEHICULO = 5;

    @Test
    @DisplayName("Debería lanzar una excepcion de Valor Obligatorio cuando el dato tipo_vehiculo se envia null")
    public void shouldThrowExcepcionValorObligatorioTipoVehiculo(){
        ExcepcionValorObligatorio exception = assertThrows(ExcepcionValorObligatorio.class, () ->
            new Ticket(IDTICKET, PLACA, null)
        );

        Assert.assertEquals(TICKET_SIN_TIPO_VEHICULO, exception.getMessage());

    }

    @Test
    @DisplayName("Debería lanzar una excepcion de Valor Obligatorio cuando el dato placa_vehiculo se envia null")
    public void shouldThrowExcepcionValorObligatorioPlacaVehiculo(){
        ExcepcionValorObligatorio exception = assertThrows(ExcepcionValorObligatorio.class, () ->
            new Ticket(IDTICKET, null, TIPOVEHICULO)
        );

        Assert.assertEquals(TICKET_SIN_PLACA, exception.getMessage());
    }

    @Test
    @DisplayName("Debería lanzar una excepcion de tipo de vehiculo invalido cuando es diferente de 1 o 2")
    public void shouldThrowExcepcionTipoVehiculoInvalido(){
        Integer tipoVehiculo = 4;
        ExceptionValorInvalidoTipoVehiculo exception = assertThrows(ExceptionValorInvalidoTipoVehiculo.class, () ->
            new Ticket(IDTICKET, PLACA, tipoVehiculo)
        );

        Assert.assertEquals(TIPO_VEHICULO_INVALIDO, exception.getMessage());
    }

}
