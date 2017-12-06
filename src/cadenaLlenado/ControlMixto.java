
package cadenaLlenado;

import org.apache.log4j.Logger;
import producto.Caramelo;

/**
 * Se realiza el llenado mixto por medio de dos hilos sabor fresa y sabor menta.
 * @author Carlos Rodriguez Escudero
 * @version 1.0
 */
public class ControlMixto {

//    Instanciamos un logger estático para la clase
    private static Logger log = Logger.getLogger(ControlMixto.class);
    
    int contadorCaramelos = 0;

    Caramelo carameloFresa = new Caramelo("fresa");
    Caramelo carameloMenta = new Caramelo ("menta");

    public void llenadoMixto() {

        new VariedadCaramelos();

        for (int i = 0; i < 5; i++) {
            try {
                contadorCaramelos++;
                log.debug(carameloFresa.toString() + ": " + contadorCaramelos + " carmelo.");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                log.error("Rellenado caramelo " + carameloFresa.toString()+ " interrumpido." + ex);
            }
        }
    }

    class VariedadCaramelos extends Thread {
        
        int contadorCaramelos;
        
        public VariedadCaramelos() {
            super(carameloMenta.toString());
            start();

        }
        @Override
        public void run() {

//            Se introduciran caramelos hasta que rellene el recipiente.
            for (int i = 0; i < 5; i++) {
                try {
                    contadorCaramelos++;
                    log.debug(carameloMenta.toString() + ": " + contadorCaramelos + " carmelo.");
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    log.error("Rellenado caramelo " + carameloMenta.toString() + " interrumpido." + ex);
                }
            }
        }
    }
}
