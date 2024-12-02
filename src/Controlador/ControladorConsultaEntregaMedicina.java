package Controlador;

import Estructuras.ABinarioBusqueda;
import Estructuras.ListaDoble;
import Modelo.EntregaMedicina;
import ModeloDao.EntregaMedicinaDao;
import Vista.VistaConsultaEntregaMedicina;
import Vista.VistaFormularioEntregaMedicina;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Utilidades.Render;

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
    
     private void eliminar() {

        int op = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar"
                + entregaMedicinaSeleccionado.getIdEntregaMedicina());

        if (daoEntregaMedicina.delete(entregaMedicinaSeleccionado)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("OK", "Registro eliminado",
                    DesktopNotify.SUCCESS, 3000);
            mostrar(daoEntregaMedicina.selectAll());
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No se pudo eliminar",
                    DesktopNotify.ERROR, 3000);
        }
    }
     
     public void buscar() {
         // Verificar que el campo de búsqueda no esté vacío
        if (!this.consultaEntregaMedicina.txtBuscar.getText().isEmpty()) {
            DefaultTableModel modelo;
            this.consultaEntregaMedicina.tbDatos.setDefaultRenderer(Object.class, new Render());
            modelo = new DefaultTableModel();
             String id = this.consultaEntregaMedicina.txtBuscar.getText();
             
            // Obtener la lista de expedientes desde el DAO
            ABinarioBusqueda<EntregaMedicina> listaBusqueda = daoEntregaMedicina.buscar();
            EntregaMedicina x = new EntregaMedicina();
            
            // Establecer el ID del expediente a buscar
            x.setIdEntregaMedicina(Integer.parseInt(id));
            
             // Buscar el expediente en el árbol binario
            if (listaBusqueda.buscar(x) != null) {
                x = (EntregaMedicina) listaBusqueda.buscar(x).getClave();
                // Definir los títulos de las columnas de la tabla
                String titulo[] = {"ID","NOMBRE DEL MEDICAMENTO","DOSIS","CANTIDAD","DUI DEL EMPLEADO", "NOMBRE DEL EMPLEADO"};
                modelo.setColumnIdentifiers(titulo);

                // Agregar los datos del expediente al modelo de la tabla
                Object datos[] = {
                    x.getIdEntregaMedicina(),
                    x.getMedicamento().getNombre(), 
                    x.getReceta().getDosis(),
                    x.getReceta().getCantidad(), 
                    x.getEmpleado().getDui(),
                    x.getEmpleado().getNombre()
                 };
                modelo.addRow(datos);

                // Mostrar los datos en la tabla
                this.consultaEntregaMedicina.tbDatos.setModel(modelo);
            } else {
                mostrar(this.daoEntregaMedicina.selectAll());
                JOptionPane.showMessageDialog(null, "DATO NO ENCONTRADO");
            }
        }else{
            JOptionPane.showMessageDialog(this.consultaEntregaMedicina, "campo vacío");
            mostrar(this.daoEntregaMedicina.selectAll());
        }

    }
     
     @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.consultaEntregaMedicina.tbDatos) {
            ListaDoble<EntregaMedicina> lista = daoEntregaMedicina.selectAll();
            int colum = this.consultaEntregaMedicina.tbDatos.getColumnModel().getColumnIndexAtX(e.getX());
            int row = this.consultaEntregaMedicina.tbDatos.getSelectedRow();
            Object value = this.consultaEntregaMedicina.tbDatos.getValueAt(row, colum);
            
            if (row >= 0) {
                this.entregaMedicinaSeleccionado = lista.get(row);
                System.out.println("Fila seleccionada: " + row);
                System.out.println("Valor de la celda seleccionada: " + value);
                System.out.println("Expediente seleccionado: " + this.entregaMedicinaSeleccionado);
            } else {
                this.consultaEntregaMedicina.btnEditar.setEnabled(true);
                this.consultaEntregaMedicina.btnAgregar.setEnabled(false);
                this.consultaEntregaMedicina.btnEliminar.setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.consultaEntregaMedicina.btnAgregar) {
            VistaFormularioEntregaMedicina v = new VistaFormularioEntregaMedicina();
            ControladorFormularioEntregaMedicina crt = new ControladorFormularioEntregaMedicina(this, v);
            v.iniciar();
        }else if (e.getSource() == this.consultaEntregaMedicina.btnEliminar) {
            eliminar();
        } if (e.getSource() == this.consultaEntregaMedicina.btnBuscar) {
            buscar();
        } else if (e.getSource() == this.consultaEntregaMedicina.btnEditar) {
            modificar();
        }
    }

}
