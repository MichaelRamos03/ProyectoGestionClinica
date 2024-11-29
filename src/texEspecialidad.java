
import Controlador.ControladorConsultaVistaEspecialidad;
import Vista.VistaEspecialidad;

/**
 *
 * @author Gaby Laínez
 */
public class texEspecialidad {
    
    public static void main(String[] args) {
        VistaEspecialidad v = new VistaEspecialidad();
        ControladorConsultaVistaEspecialidad c = new ControladorConsultaVistaEspecialidad(v);
        v.iniciar();
    }

}
