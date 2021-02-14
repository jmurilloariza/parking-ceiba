package com.ceiba.ticket.modelo.entidad;

import com.ceiba.dominio.HolidayUtil;
import com.ceiba.ticket.exception.ValorInvalidoTicketException;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    private final Long id;
    private final String placaVehiculo;
    private final Integer tipoVehiculo;
    private final LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private final LocalDateTime createdAd;
    private Double totalPagado;
    private final HolidayUtil holidayUtil = new HolidayUtil(LocalDateTime.now().getYear());

    public Ticket(Long id, String placaVehiculo, Integer tipoVehiculo) {
        validarObligatorio(placaVehiculo, TICKET_SIN_PLACA);
        validarObligatorio(tipoVehiculo, TICKET_SIN_TIPO_VEHICULO);

        if (!tipoVehiculo.equals(AUTOMOVIL) && !tipoVehiculo.equals(MOTOCICLETA))
            throw new ValorInvalidoTicketException(TIPO_VEHICULO_INVALIDO);

        if (this.calcularDiferenciaEntreHorasEnSegundos(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(),
                HORA_APERTURA_LABORES, MINUTO_APERTURA_LABORES) >= 0)
            throw new ValorInvalidoTicketException(PARKING_CERRADO);

        this.id = id;
        this.placaVehiculo = placaVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.horaEntrada = LocalDateTime.now();
        this.horaSalida = null;
        this.createdAd = LocalDateTime.now();
        this.totalPagado = 0d;
    }

    public void calcularTotalPago() {
        this.horaSalida = LocalDateTime.now();
        double totalPago = 0;
        boolean recargoPorDomingoFestivo = this.calcularSiTieneRecargoPorDomingoFestivo();

        int horaEntradaNumero = this.horaEntrada.getHour();
        int minutosEntradaNumero = this.horaEntrada.getMinute();
        int horaSalidaNumero = this.horaSalida.getHour();
        int minutoSalidaNumero = this.horaSalida.getMinute();

        long tiempoTotalEnSegundos = this.calcularDiferenciaEntreHorasEnSegundos(horaEntradaNumero, minutosEntradaNumero,
                horaSalidaNumero, minutoSalidaNumero);

        double tiempoEnHoras = Math.round((tiempoTotalEnSegundos / 3600d) * 1000.0) / 1000.0;
        double minutos = tiempoEnHoras % 1;
        double horas = tiempoEnHoras - minutos;

        if (this.tipoVehiculo.equals(AUTOMOVIL)) {
            totalPago = (horas * PRECIO_HORA_AUTOMOVIL) + (minutos <= 30 ? PRECIO_MEDIA_HORA_AUTOMOVIL : PRECIO_HORA_AUTOMOVIL);
        } else if (this.tipoVehiculo.equals(MOTOCICLETA)) {
            totalPago = (horas * PRECIO_HORA_MOTOCICLETA) + (minutos <= 30 ? PRECIO_MEDIA_HORA_MOTOCICLETA : PRECIO_HORA_MOTOCICLETA);
        }

        if (recargoPorDomingoFestivo)
            this.totalPagado = totalPago * 2;
        else
            this.totalPagado = totalPago;
    }

    private boolean calcularSiTieneRecargoPorDomingoFestivo() {
        return holidayUtil.isHoliday(this.horaEntrada.getMonthValue() - 1, this.horaEntrada.getDayOfMonth()) ||
                this.horaEntrada.getDayOfWeek().getValue() == DayOfWeek.SUNDAY.getValue();
    }

    private long calcularDiferenciaEntreHorasEnSegundos(int horaEntradaNumero, int minutosEntradaNumero,
                                                        int horaSalidaNumero, int minutoSalidaNumero) {
        LocalTime startLocalTime = LocalTime.of(horaEntradaNumero, minutosEntradaNumero);
        LocalTime endLocalTime = LocalTime.of(horaSalidaNumero, minutoSalidaNumero);
        return Duration.between(startLocalTime, endLocalTime).getSeconds();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", placa_vehiculo='" + placaVehiculo + '\'' +
                ", tipo_vehiculo='" + tipoVehiculo + '\'' +
                ", hora_entrada=" + horaEntrada +
                ", hora_salida=" + horaSalida +
                ", created_ad=" + createdAd +
                '}';
    }
}
