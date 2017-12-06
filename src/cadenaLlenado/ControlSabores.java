
package cadenaLlenado;

import org.apache.log4j.Logger;
import producto.Caramelo;

/**
 * Se sincronizan los hilos para que cada sabor vaya en un recipiente distinto.
 * @author Carlos Rodríguez Escudero
 * @version 1.0
 */
public class ControlSabores {
    
//    Instanciamos un logger estático para la clase
    private static Logger log = Logger.getLogger(ControlSabores.class);

    Caramelo carameloFresa = new Caramelo("fresa");
    Caramelo carameloMenta = new Caramelo("menta");

    public void llenadoSabores() {

        SaboresCaramelos sabor = new SaboresCaramelos();

        CarameloSabores menta = new CarameloSabores("Caramelo menta", sabor);

        menta.start();
        System.out.println("Comienza el proceso de llenado del caramelo de " + carameloFresa.toString() + ".");
        sabor.sabores("Caramelo " + carameloFresa.toString() + ".");
        System.out.println("Llenado caramelo " + carameloFresa.toString() + " terminado.");

        try {
            System.out.println("Comienza el proceso de llenado del caramelo de " + carameloMenta.toString() + ".");
            menta.join();
            System.out.println("Llenado caramelo de " + carameloMenta.toString() + " terminado");
        } catch (Exception e) {
            log.error("Proceso de llenado del caramelo de " + carameloMenta.toString() + " interrumpido." + e.getMessage());
        }
    }

    class SaboresCaramelos {

        /**
         * 
         * @param sabor Debemos de pasarle un tipo de sabor
         */
        public synchronized void sabores(String sabor) {
            try {
                for (int i = 1; i <= 5; i++) {

                    log.debug(sabor + ": " + i);
                }
            } catch (Exception e) {
                log.error("Proceso de llenado interrumpido: " + e.getMessage());
            }
        }
    }

    class CarameloSabores extends Thread {

        private String sabor;
        SaboresCaramelos sabores;

        CarameloSabores(String sabor, SaboresCaramelos sabores) {
            this.sabor = sabor;
            this.sabores = sabores;
        }

        public void run() {
            sabores.sabores(sabor);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                log.error("Llenado interrumpido" + ex.getMessage());
            }

        }
    }
}
