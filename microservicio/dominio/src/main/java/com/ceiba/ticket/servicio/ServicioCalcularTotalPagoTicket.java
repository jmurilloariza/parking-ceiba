package com.ceiba.ticket.servicio;

import com.ceiba.dominio.DateUtil;
import com.ceiba.dominio.HolidayUtil;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ServicioCalcularTotalPagoTicket {

    private static final Integer AUTOMOVIL = 1;
    private static final Integer MOTOCICLETA = 2;

    private static final Integer PRECIO_HORA_AUTOMOVIL = 1000;
    private static final Integer PRECIO_HORA_MOTOCICLETA = 500;
    private static final Integer PRECIO_MEDIA_HORA_AUTOMOVIL = 600;
    private static final Integer PRECIO_MEDIA_HORA_MOTOCICLETA = 300;

    private final HolidayUtil holidayUtil = new HolidayUtil(LocalDateTime.now().getYear());

    public double ejecutar(Integer tipoVehiculo, LocalDateTime horaEntrada) {
        LocalDateTime horaSalida = LocalDateTime.now();

        boolean recargoPorDomingoFestivo = this.calcularSiTieneRecargoPorDomingoFestivo(horaEntrada);
        double tiempoEnHoras = (long) DateUtil.calcularDiferenciaEntreHoras(horaEntrada, horaSalida);
        double totalPago = this.realizarCalculoTotalApagar(tipoVehiculo, tiempoEnHoras);

        if (recargoPorDomingoFestivo) {
            totalPago = totalPago * 2;
            return totalPago;
        }
        return totalPago;
    }

    private double realizarCalculoTotalApagar(Integer tipoVehiculo, double tiempoEnHoras){
        double minutos = tiempoEnHoras % 1;
        double horas = tiempoEnHoras - minutos;
        double totalPago = 0d;

        if (tipoVehiculo.equals(AUTOMOVIL)) {
            totalPago = (horas * PRECIO_HORA_AUTOMOVIL) + (minutos <= 30 ? PRECIO_MEDIA_HORA_AUTOMOVIL : PRECIO_HORA_AUTOMOVIL);
        } else if (tipoVehiculo.equals(MOTOCICLETA)) {
            totalPago = (horas * PRECIO_HORA_MOTOCICLETA) + (minutos <= 30 ? PRECIO_MEDIA_HORA_MOTOCICLETA : PRECIO_HORA_MOTOCICLETA);
        }

        return totalPago;
    }

    private boolean calcularSiTieneRecargoPorDomingoFestivo(LocalDateTime horaEntrada) {
        return holidayUtil.isHoliday(horaEntrada.getMonthValue() - 1, horaEntrada.getDayOfMonth()) ||
                horaEntrada.getDayOfWeek().getValue() == DayOfWeek.SUNDAY.getValue();
    }

}
