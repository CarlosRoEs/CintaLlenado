
package cadenaLlenado;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Carlosr Rodríguez Escudero
 * @version 1.0
 */
public class Ejecutable {
    
//    Instanciamos un logger estático para la clase
    private static Logger log = Logger.getLogger(Ejecutable.class);
    
    public static void main(String[] args) {
        
        PropertyConfigurator.configure("log4j.properties");
        Boton boton = new Boton();
        
//        Llamamos al método para el llenado de los recipientes
        boton.encendidoCinta(boton.getEstado());  
    }
}
