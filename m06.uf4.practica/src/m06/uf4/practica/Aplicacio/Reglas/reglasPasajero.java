package m06.uf4.practica.Aplicacio.Reglas;

import java.util.regex.Pattern;

/**
 *
 * @author leandroparedes
 */
public class reglasPasajero {
    public static void DNI(String DNI) {
        
        //Regla per al format del DNI
        Pattern patternDNI = Pattern.compile("[0-9]{8}[A-Z]");
        
        //Es comprova el format del DNI
        if (!patternDNI.matcher(DNI).find()) {
            
        } else {
            
            //Si el DNI te un format correcte es pasa a comprovar que la lletra del DNI es correcte
            char lletraDNI = Character.toUpperCase(DNI.charAt(DNI.length() - 1));
            int NumDNI = Integer.parseInt(DNI.substring(0, DNI.length() - 1));
            int resto = NumDNI % 23;
            char lletra = 0;

            //<editor-fold defaultstate="collapsed" desc="Switch lletra DNI">
            switch (resto) {
                case 0:
                    lletra = 'T';
                    break;
                case 1:
                    lletra = 'R';
                    break;
                case 2:
                    lletra = 'W';
                    break;
                case 3:
                    lletra = 'A';
                    break;
                case 4:
                    lletra = 'G';
                    break;
                case 5:
                    lletra = 'M';
                    break;
                case 6:
                    lletra = 'Y';
                    break;
                case 7:
                    lletra = 'F';
                    break;
                case 8:
                    lletra = 'P';
                    break;
                case 9:
                    lletra = 'D';
                    break;
                case 10:
                    lletra = 'X';
                    break;
                case 11:
                    lletra = 'B';
                    break;
                case 12:
                    lletra = 'N';
                    break;
                case 13:
                    lletra = 'J';
                    break;
                case 14:
                    lletra = 'Z';
                    break;
                case 15:
                    lletra = 'S';
                    break;
                case 16:
                    lletra = 'Q';
                    break;
                case 17:
                    lletra = 'V';
                    break;
                case 18:
                    lletra = 'H';
                    break;
                case 19:
                    lletra = 'L';
                    break;
                case 20:
                    lletra = 'C';
                    break;
                case 21:
                    lletra = 'K';
                    break;
                case 22:
                    lletra = 'E';
                    break;
            }
            //</editor-fold>

            if (lletra != lletraDNI) {
                
            }

        }

    }
}
