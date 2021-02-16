package com.ceiba.dominio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateUtil {

    public DateUtil() {
    }

    public static double calcularDiferenciaEntreHoras(LocalDateTime horaInicio, LocalDateTime horaFin) {
        int horasInicio = horaInicio.getHour();
        int minutosInicio = horaInicio.getMinute();
        int horasSalida = horaFin.getHour();
        int minutosSalida = horaFin.getMinute();

        LocalTime startLocalTime = LocalTime.of(horasInicio, minutosInicio);
        LocalTime endLocalTime = LocalTime.of(horasSalida, minutosSalida);
        long tiempoTotalEnSegundos = Duration.between(startLocalTime, endLocalTime).getSeconds();

        return Math.round((tiempoTotalEnSegundos / 3600d) * 1000.0) / 1000.0;
    }

}
