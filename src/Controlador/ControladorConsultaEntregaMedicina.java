package Controlador;

import Estructuras.ListaDoble;
import Modelo.EntregaMedicina;
import ModeloDao.EntregaMedicinaDao;
import Vista.VistaConsultaEntregaMedicina;
import Vista.VistaFormularioEntregaMedicina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import proyectoclase.utilidades.Render;

/**
 *
 * @author Michael Ramos;
*
 */
public class ControladorConsultaEntregaMedicina extends MouseAdapter implements ActionListener, MouseListener {

    VistaConsultaEntregaMedicina consultaEntregaMedicina;
    EntregaMedicina entregaMedicinaSeleccionado;
    EntregaMedicinaDao daoEntregaMedicina;

    public ControladorConsultaEntregaMedicina(VistaConsultaEntregaMedicina consultaEntregaMedicina) {
        this.consultaEntregaMedicina = consultaEntregaMedicina;
        this.daoEntregaMedicina = new EntregaMedicinaDao();
        this.consultaEntregaMedicina.btnAgregar.addActionListener(this);
        this.consultaEntregaMedicina.btnEditar.addActionListener(this);
        this.consultaEntregaMedicina.btnEliminar.addActionListener(this);
        this.consultaEntregaMedicina.btnBuscar.addActionListener(this);
        this.consultaEntregaMedicina.tbDatos.addMouseListener(this);
        mostrar(daoEntregaMedicina.selectAll());
    }
    
    public void mostrar(ListaDoble<EntregaMedicina> lista){
        DefaultTableModel modelo;
        this.consultaEntregaMedicina.tbDatos.setDefaultRenderer(Object.class, new Render());
        modelo = new DefaultTableModel();
        String titulo[] = {"N","NOMBRE DEL MEDICAMENTO","DOSIS","CANTIDAD","DUI DEL EMPLEADO", "NOMBRE DEL EMPLEADO"};
        modelo.setColumnIdentifiers(titulo);
        int i = 0;
        
        for (EntregaMedicina x : lista.toArray() ) {
            i++;
            Object datos[] = {i,
                    x.getMedicamento().getNombre(), 
                    x.getReceta().getDosis(),
                    x.getReceta().getCantidad(), 
                    x.getEmpleado().getDui(),
                    x.getEmpleado().getNombre()
            };
            modelo.addRow(datos);
        }
        this.consultaEntregaMedicina.tbDatos.setModel(modelo);
    }
    
    private void modificar(){
         if (entregaMedicinaSeleccionado != null) {
             VistaFormularioEntregaMedicina frm = new VistaFormularioEntregaMedicina();
             ControladorFormularioEntregaMedicina ctr = new ControladorFormularioEntregaMedicina(this,frm, entregaMedicinaSeleccionado);
         frm.iniciar();
         }
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.consultaEntregaMedicina.btnAgregar) {
            VistaFormularioEntregaMedicina v = new VistaFormularioEntregaMedicina();
            ControladorFormularioEntregaMedicina crt = new ControladorFormularioEntregaMedicina(this, v);
            v.iniciar();
        }
    }

}
