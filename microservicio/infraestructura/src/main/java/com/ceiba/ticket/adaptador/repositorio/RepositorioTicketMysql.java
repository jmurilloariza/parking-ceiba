package com.ceiba.ticket.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.ticket.modelo.entidad.Ticket;
import com.ceiba.ticket.puerto.repositorio.RepositorioTicket;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTicketMysql implements RepositorioTicket {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "ticket", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace= "ticket", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace= "ticket", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace= "ticket", value="existe")
    private static String sqlExiste;

    public RepositorioTicketMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Ticket ticket) {
        return this.customNamedParameterJdbcTemplate.crear(ticket, sqlCrear);
    }

    @Override
    public void actualizar(Ticket ticket) {
        this.customNamedParameterJdbcTemplate.actualizar(ticket, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }
}
