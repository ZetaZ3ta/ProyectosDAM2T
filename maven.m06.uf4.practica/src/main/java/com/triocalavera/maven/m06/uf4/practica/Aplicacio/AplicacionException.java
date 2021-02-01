package com.triocalavera.maven.m06.uf4.practica.Aplicacio;

/**
 *
 * @author IvánJM
 */
public class AplicacionException extends Exception {

    /**
     * Con esta clase lanzaremos todas las excepciones de la capa de aplicacion
     * @param message
     */
    public AplicacionException(String message) {
        super(message);
    }
}
