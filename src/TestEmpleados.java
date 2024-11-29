
import Controlador.ControladorConsultaEmpleado;
import Vista.VistaConsultaEmpleado;


/**
 *
 * @author Michael Ramos;
**/
public class TestEmpleados {
    
    public static void main(String[] args) {
        VistaConsultaEmpleado v = new VistaConsultaEmpleado();
        ControladorConsultaEmpleado  c = new ControladorConsultaEmpleado(v);
        v.iniciar();
    }
    
}
