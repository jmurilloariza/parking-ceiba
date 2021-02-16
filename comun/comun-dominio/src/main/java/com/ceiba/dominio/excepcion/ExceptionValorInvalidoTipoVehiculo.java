package com.ceiba.dominio.excepcion;

public class ExceptionValorInvalidoTipoVehiculo extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExceptionValorInvalidoTipoVehiculo(String message) {
        super(message);
    }
}
