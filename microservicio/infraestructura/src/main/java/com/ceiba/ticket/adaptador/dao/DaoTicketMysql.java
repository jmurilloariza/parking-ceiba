package com.ceiba.ticket.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.ticket.modelo.dto.DtoTicket;
import com.ceiba.ticket.puerto.dao.DaoTicket;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoTicketMysql implements DaoTicket {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "ticket", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "ticket", value = "buscarPorId")
    private static String sqlBuscaId;

    @SqlStatement(namespace = "ticket", value = "validarVehiculoIngreso")
    private static String sqlBuscaVehiculoFechaSalidaNull;

    @SqlStatement(namespace = "ticket", value = "actualizarPagoHoraPago")
    private static String sqlActualizarValorPagoHoraPago;

    public DaoTicketMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTicket> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTicket());
    }

    @Override
    public DtoTicket buscarPorId(Long id) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscaId, parametros, new MapeoTicket());
    }

    @Override
    public boolean validarVehiculoIngreso(String placaVehiculo) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("placa_vehiculo", placaVehiculo);

        List<DtoTicket> tickets = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscaVehiculoFechaSalidaNull, parametros, new MapeoTicket());

        return tickets.isEmpty();
    }

    @Override
    public void actualizarPagoTicket(Long id, Double valorPago, LocalDateTime horaSalida) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("hora_salida", horaSalida);
        paramSource.addValue("total_pagado", valorPago);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarValorPagoHoraPago, paramSource);

    }
}
