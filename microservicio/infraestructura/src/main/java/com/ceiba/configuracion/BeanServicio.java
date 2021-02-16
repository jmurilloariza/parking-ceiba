package com.ceiba.configuracion;

import com.ceiba.ticket.puerto.dao.DaoTicket;
import com.ceiba.ticket.puerto.repositorio.RepositorioTicket;
import com.ceiba.ticket.servicio.ServicioCalcularTotalPagoTicket;
import com.ceiba.ticket.servicio.ServicioCrearTicket;
import com.ceiba.ticket.servicio.ServicioEliminarTicket;
import com.ceiba.ticket.servicio.ServicioPagarTicket;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearTicket servicioCrearTicket(RepositorioTicket repositorioTicket, DaoTicket daoTicket){
        return new ServicioCrearTicket(repositorioTicket, daoTicket);
    }

    @Bean
    public ServicioEliminarTicket servicioEliminarTicket(RepositorioTicket repositorioTicket){
        return new ServicioEliminarTicket(repositorioTicket);
    }

    @Bean
    public ServicioPagarTicket servicioPagarTicket(RepositorioTicket repositorioTicket){
        return new ServicioPagarTicket(repositorioTicket);
    }

    @Bean
    public ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket(){
        return new ServicioCalcularTotalPagoTicket();
    }

}
