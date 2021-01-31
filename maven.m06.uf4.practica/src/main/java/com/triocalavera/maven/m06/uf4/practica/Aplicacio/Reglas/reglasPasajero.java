package com.triocalavera.maven.m06.uf4.practica.Aplicacio.Reglas;

import com.triocalavera.maven.m06.uf4.practica.Aplicacio.AplicacionException;
import java.util.regex.Pattern;


/**
 *
 * @author leandroparedes
 */
public class reglasPasajero {

               public static void DNI(String Dni) throws AplicacionException {
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            Pattern regla = Pattern.compile("^[0-9]{8}[" + letras + "]$");
            if (regla.matcher(Dni).find()) {
                if (!(letras.charAt(Integer.parseInt(Dni.substring(0, 8)) % 23) == Dni.charAt(8))) throw new AplicacionException("Error al introducir DNI: La letra del DNI es incorrecta.");  
            } else  throw new AplicacionException("Error al introducir DNI: El formato de entrada es incorrecto.");

        }
    
}
