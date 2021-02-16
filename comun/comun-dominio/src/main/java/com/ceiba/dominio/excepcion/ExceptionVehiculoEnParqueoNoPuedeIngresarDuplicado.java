package com.ceiba.dominio.excepcion;

public class ExceptionVehiculoEnParqueoNoPuedeIngresarDuplicado extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExceptionVehiculoEnParqueoNoPuedeIngresarDuplicado(String message) {
        super(message);
    }

}
