package m06.uf4.practica.Aplicacio.Reglas;

import java.util.regex.Pattern;
import m06.uf4.practica.Aplicacio.AplicacionException;

/**
 *
 * @author leandroparedes
 */
public class reglasPasajero {

    /**
     * Método para validar un DNI correcto.
     * Comprueba que el formato del DNI sea correcto (8 numeros y una letra)
     * Y tambien comprueba que la letra sea correcta segun los numeros que tenga.
     * @param Dni
     * @throws AplicacionException
     */
    public static void DNI(String Dni) throws AplicacionException {
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            Pattern regla = Pattern.compile("^[0-9]{8}[" + letras + "]$");
            if (regla.matcher(Dni).find()) {
                if (!(letras.charAt(Integer.parseInt(Dni.substring(0, 8)) % 23) == Dni.charAt(8))) throw new AplicacionException("Error al introducir DNI: La letra del DNI es incorrecta.");  
            } else  throw new AplicacionException("Error al introducir DNI: El formato de entrada es incorrecto.");

        }
    
}
