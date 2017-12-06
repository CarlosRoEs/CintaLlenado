
package producto;

//import org.apache.log4j.Logger;

/**
 *
 * @author Carlos Rodriguez Escudero
 * @version 1.0
 */
public class Caramelo {
    
//    Instanciamos un logger estático para la clase
//    private static Logger log = Logger.getLogger(Caramelo.class);
    
//    Atributos.
    private String sabor;

//    Constructor.
    public Caramelo() {
    }

    public Caramelo(String sabor) {
        this.sabor = sabor;
    }

//    Métodos getters y setters.
    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
//    Sobreescribimos el metodo toString.
    @Override
    public String toString(){
        
        return "Sabor " + getSabor();
    } 
}
