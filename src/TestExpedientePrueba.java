
import Controlador.ControladorConsultaExpediente;
import Vista.VistaConsultaExpediente;



/**
 *
 * @author Michael Ramos;
**/
public class TestExpedientePrueba {
    
    public static void main(String[] args) {
        
         VistaConsultaExpediente v = new VistaConsultaExpediente();
        ControladorConsultaExpediente c = new ControladorConsultaExpediente(v);
        v.iniciar();
        
        
        
    }
}
