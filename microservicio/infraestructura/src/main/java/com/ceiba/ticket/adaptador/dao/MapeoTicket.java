package com.ceiba.ticket.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.ticket.modelo.dto.DtoTicket;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class MapeoTicket implements RowMapper<DtoTicket>, MapperResult {

    @Override
    public DtoTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String placaVehiculo = rs.getString("placa_vehiculo");
        Integer tipoVehiculo = rs.getInt("tipo_vehiculo");
        LocalDateTime horaEntrada = extraerLocalDateTime(rs, "hora_entrada");
        LocalDateTime horaSalida = extraerLocalDateTime(rs, "hora_salida");
        LocalDateTime createdAt = extraerLocalDateTime(rs, "created_at");
        Double totalPagado = rs.getDouble("total_pagado");

        return new DtoTicket(id, placaVehiculo, tipoVehiculo, horaEntrada, horaSalida, createdAt, totalPagado);
    }
}
