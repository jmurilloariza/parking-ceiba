package com.ceiba.ticket.modelo.entidad;

import com.ceiba.dominio.HolidayUtil;
import com.ceiba.ticket.exception.ValorInvalidoTipoVehiculoException;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Ticket {

    private static final String TICKET_SIN_PLACA = "Se debe ingresar la placa del vehiculo";
    private static final String TICKET_SIN_TIPO_VEHICULO = "Se debe ingresar el tipo de vehiculo";
    private static final String TIPO_VEHICULO_INVALIDO = "Tipo de vehiculo invalido, 1 para automovil ó 2 para motocicleta";
    private static final String PARKING_CERRADO = "El parkeadero aun no abre";

    private static final Integer PRECIO_HORA_AUTOMOVIL = 1000;
    private static final Integer PRECIO_HORA_MOTOCICLETA = 500;
    private static final Integer PRECIO_MEDIA_HORA_AUTOMOVIL = 600;
    private static final Integer PRECIO_MEDIA_HORA_MOTOCICLETA = 300;
    private static final Integer RECARGO_HOLIDAY = 200;

    private static final Integer HORA_APERTURA_LABORES = 6;
    private static final Integer MINUTO_APERTURA_LABORES = 0;
    private static final Integer HORA_CIERRE_LABORES = 23;
    private static final Integer MINUTO_CIERRE_LABORES = 59;

    private static final Integer AUTOMOVIL = 1;
    private static final Integer MOTOCICLETA = 2;

    private Long id;
    private String placaVehiculo;
    private Integer tipoVehiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private LocalDateTime createdAt;
    private Double totalPagado;

    private final HolidayUtil holidayUtil = new HolidayUtil(LocalDateTime.now().getYear());

    public Ticket(Long id, String placaVehiculo, Integer tipoVehiculo) {
        validarObligatorio(placaVehiculo, TICKET_SIN_PLACA);
        validarObligatorio(tipoVehiculo, TICKET_SIN_TIPO_VEHICULO);

        if (!tipoVehiculo.equals(AUTOMOVIL) && !tipoVehiculo.equals(MOTOCICLETA))
            throw new ValorInvalidoTipoVehiculoException(TIPO_VEHICULO_INVALIDO);

//        if (this.calcularDiferenciaEntreHorasEnSegundos(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(),
//                HORA_APERTURA_LABORES, MINUTO_APERTURA_LABORES) >= 0)
//            throw new ValorInvalidoTipoVehiculoException(PARKING_CERRADO);

        this.id = id;
        this.placaVehiculo = placaVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.horaEntrada = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
        this.totalPagado = 0d;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", placa_vehiculo='" + placaVehiculo + '\'' +
                ", tipo_vehiculo='" + tipoVehiculo + '\'' +
                ", hora_entrada=" + horaEntrada +
                ", hora_salida=" + horaSalida +
                ", created_ad=" + createdAt +
                '}';
    }
}
