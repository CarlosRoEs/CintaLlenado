
package cadenaLlenado;

import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *
 * @author Carlos Rodriguez Escudero.
 * @version 1.0
 */
public class Boton {

//    Instanciamos un logger estático para la clase
    private static Logger log = Logger.getLogger(Boton.class);

//    Atributos.
//    Existen dos tipos de llenado mixto y por sabores.
    private String tipoLlenado;
    private String estado;

//    Constructores.
    public Boton() {
    }

    public Boton(String tipoLlenado, String estado) {
        this.tipoLlenado = tipoLlenado;
        this.estado = estado;
    }

//    Metodos getters y setters
    public String getTipoLlenado() {
        return tipoLlenado;
    }

    public void setTipoLlenado(String tipoLlenado) {
        this.tipoLlenado = tipoLlenado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Realiza el encendido y el llenado de los recipientes. Para el encendido y
     * apagado de la cinta se debe utilizar las opciones 1 y 0. Para la elección
     * del tipo la rellenado se utilizarán las opciones de mixto, sabor y
     * terminar.
     *
     * @param estadoCinta Le pasamos el estado de la cinta en este caso los
     * valores permitidos son 1 y 0.
     * @return estado. Nos retornara si la cinta esta encendia o apagada.
     */
    public String encendidoCinta(String estadoCinta) {

//        encendido = 1; apagado = 0.
        estado = estadoCinta;

//        Instanciamos el objeto scanner.
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca estado de la cinta.");
        estado = sc.next();

        log.debug("Dato almacenado en la variable estado: " + estado);
        String llenadoTipo;

        if (estado.equalsIgnoreCase("on")) {
            log.info("Cinta en funcionamiento.");
            System.out.println("Seleccione el tipo de llenado.");
            llenadoTipo = sc.next();
            log.debug("Dato guardado en variable llenadoTipo: " + llenadoTipo);
            boolean seleccionCorrecta = false;
//            Realizará un bucle hasta que introduzca las opciones correctas
            while (!seleccionCorrecta) {

//                tipos de llenado: mixto, sabor y terminar
                switch (llenadoTipo) {
                    case "mixto":
                        System.out.println("Ha seleccionado la opicón de llenado " + llenadoTipo + ".");
                        System.out.println("Comienza el llenado del tubo de caramelos.");
//                        Instanciamos el objeto de tipo ControlMixto.
                        ControlMixto control = new ControlMixto();
                        control.llenadoMixto();
                        log.info("Termina el proceso de llenado.");
                        seleccionCorrecta = true;
                        System.exit(0);

                        break;

                    case "sabor":
                        System.out.println("Ha seleccionado la opción de llenado " + llenadoTipo + ".");
                        System.out.println("Comienza el llenado del tubo de caramelos.");
//                        Instanciamos el objeto de tipo ControlSabores.
                        ControlSabores sabor = new ControlSabores();
                        sabor.llenadoSabores();
                        log.info("Termina el proceso de llenado.");
                        seleccionCorrecta = true;
                        System.exit(0);

                        break;

                    case "terminar":
                        log.info("Cerramos la cinta de llenado.");
                        seleccionCorrecta = true;
                        System.exit(0);
                        

                        break;

                    default:
                        System.out.println("Por favor, debes seleccionar una opción correcta para el tipo de llenado.");
                        System.out.println("Seleccione el tipo de llenado.");
                        llenadoTipo = sc.next();

                        break;
                }
            }

        } else if (estado.equalsIgnoreCase("off")) {
            log.info("Cinta apagada. Salimos de la aplicación.");
            System.exit(0);
        } else {
            log.warn("Error al encender/apagar la cinta. Salimos de la aplicación.");
            System.exit(0);
        }
        return estado;
    }
}
