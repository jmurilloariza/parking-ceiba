package com.ceiba.configuracion;

import com.ceiba.ticket.puerto.dao.DaoTicket;
import com.ceiba.ticket.puerto.repositorio.RepositorioTicket;
import com.ceiba.ticket.servicio.ServicioCalcularTotalPagoTicket;
import com.ceiba.ticket.servicio.ServicioCrearTicket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearTicket servicioCrearTicket(RepositorioTicket repositorioTicket, DaoTicket daoTicket){
        return new ServicioCrearTicket(repositorioTicket, daoTicket);
    }

    @Bean
    public ServicioCalcularTotalPagoTicket servicioCalcularTotalPagoTicket(){
        return new ServicioCalcularTotalPagoTicket();
    }

}
