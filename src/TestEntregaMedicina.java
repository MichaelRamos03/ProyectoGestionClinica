
import Controlador.ControladorConsultaEntregaMedicina;
import Vista.VistaConsultaEntregaMedicina;

/**
 *
 * @author Michael Ramos;
*
 */
public class TestEntregaMedicina {

    public static void main(String[] args) {
        VistaConsultaEntregaMedicina vista = new VistaConsultaEntregaMedicina();
        ControladorConsultaEntregaMedicina ct = new ControladorConsultaEntregaMedicina(vista);
        vista.iniciar();
    }

}
