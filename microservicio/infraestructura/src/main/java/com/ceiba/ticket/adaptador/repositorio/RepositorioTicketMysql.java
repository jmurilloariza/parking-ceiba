package com.ceiba.ticket.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.ticket.modelo.entidad.Ticket;
import com.ceiba.ticket.puerto.repositorio.RepositorioTicket;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTicketMysql implements RepositorioTicket {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "ticket", value="crear")
    private static String sqlCrear;

    public RepositorioTicketMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Ticket ticket) {
        return this.customNamedParameterJdbcTemplate.crear(ticket, sqlCrear);
    }

}
