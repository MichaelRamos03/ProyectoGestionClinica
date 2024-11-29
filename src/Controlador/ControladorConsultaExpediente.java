
package Controlador;

import Estructuras.ABinarioBusqueda;
import Estructuras.ListaDoble;
import Modelo.Expediente;
import ModeloDao.ExpedienteDao;
import Vista.VistaConsultaExpediente;
import Vista.VistaFormularioExpediente;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectoclase.utilidades.Render;

/**
 *
 * @author Michael Ramos;
 *
 */

public class ControladorConsultaExpediente extends MouseAdapter implements ActionListener, MouseListener {

    VistaConsultaExpediente consultaExpediente;
    Expediente expedienteSeleccionado;
    ExpedienteDao daoExpediente;

    public ControladorConsultaExpediente(VistaConsultaExpediente consultaExpediente) {
        this.consultaExpediente = consultaExpediente;
        this.daoExpediente = new ExpedienteDao();
        this.consultaExpediente.btnAgregar.addActionListener(this);
        this.consultaExpediente.btnModificar.addActionListener(this);
        this.consultaExpediente.btnEliminar.addActionListener(this);
        this.consultaExpediente.btnBuscar.addActionListener(this);
        this.consultaExpediente.tbDatos.addMouseListener(this);
        
        mostrar(this.daoExpediente.selectAll());
    }

    public void mostrar(ListaDoble<Expediente> lista) {

        DefaultTableModel modelo;
        this.consultaExpediente.tbDatos.setDefaultRenderer(Object.class, new Render());
        modelo = new DefaultTableModel();
        String titulos[] = {"N","NOMBRE", "APELLIDO", "FECHA DE NACIMIENTO", "SEXO", "TELEFONO", "INFORMACION MEDICA", "TRATAMIENTOS", "NOTA DEL MEDICO", "ALERGIAS", "MEDICAMENTOS"};
        modelo.setColumnIdentifiers(titulos);
        int i = 0;

        for (Expediente x : lista.toArray()) {
            i++;
            Object datos[] = {i, x.getNombre(), x.getApellido(), x.getFechaNacimiento(), x.getSexo(), x.getTelefono(), x.getInformacionMedica(), x.getTratamiento(), x.getNotaMedica(), x.getAlergias(), x.getMedicamentos()};
            modelo.addRow(datos);
        }
        this.consultaExpediente.tbDatos.setModel(modelo);
    }

    private void modificar() {
        if (this.expedienteSeleccionado != null) {
            VistaFormularioExpediente frm = new VistaFormularioExpediente();
            ControladorFormularioExpediente ctl = new ControladorFormularioExpediente(this, frm, expedienteSeleccionado);
            frm.iniciar();
        }
    }

    private void eliminar() {

        int op = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar"
                + expedienteSeleccionado.getIdExpediente());

        if (daoExpediente.delete(expedienteSeleccionado)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("OK", "Registro eliminado",
                    DesktopNotify.SUCCESS, 3000);
            mostrar(daoExpediente.selectAll());
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No se pudo eliminar",
                    DesktopNotify.ERROR, 3000);
        }
    }

    public void buscar() {
         // Verificar que el campo de búsqueda no esté vacío
        if (!this.consultaExpediente.txtBuscar.getText().isEmpty()) {
            DefaultTableModel modelo;
            this.consultaExpediente.tbDatos.setDefaultRenderer(Object.class, new Render());
            modelo = new DefaultTableModel();
             String nombre = this.consultaExpediente.txtBuscar.getText();
             
            // Obtener la lista de expedientes desde el DAO
            ABinarioBusqueda<Expediente> listaBusqueda = daoExpediente.buscar();
            Expediente expediente = new Expediente();
            
            // Establecer el ID del expediente a buscar
            expediente.setNombre(nombre);
            
             // Buscar el expediente en el árbol binario
            if (listaBusqueda.buscar(expediente) != null) {
                expediente = (Expediente) listaBusqueda.buscar(expediente).getClave();
                // Definir los títulos de las columnas de la tabla
                String titulos[] = {"ID", "Nombre", "Apellido", "Fecha Nacimiento", "Sexo",
                    "Teléfono", "Información Médica", "Tratamiento",
                    "Nota Médica", "Alergias", "Medicamentos"};
                modelo.setColumnIdentifiers(titulos);

                // Agregar los datos del expediente al modelo de la tabla
                Object datos[] = {expediente.getIdExpediente(), expediente.getNombre(),
                    expediente.getApellido(), expediente.getFechaNacimiento(),
                    expediente.getSexo(), expediente.getTelefono(),
                    expediente.getInformacionMedica(), expediente.getTratamiento(),
                    expediente.getNotaMedica(), expediente.getAlergias(),
                    expediente.getMedicamentos()};
                modelo.addRow(datos);

                // Mostrar los datos en la tabla
                this.consultaExpediente.tbDatos.setModel(modelo);
            } else {
                mostrar(this.daoExpediente.selectAll());
                JOptionPane.showMessageDialog(null, "DATO NO ENCONTRADO");
            }
        }else{
            JOptionPane.showMessageDialog(this.consultaExpediente, "campo vacío");
            mostrar(this.daoExpediente.selectAll());
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.consultaExpediente.tbDatos) {
            System.out.println("Evento mouseClicked ejecutado");
            ListaDoble<Expediente> lista = daoExpediente.selectAll();
            int column = this.consultaExpediente.tbDatos.getColumnModel().getColumnIndexAtX(e.getX());
            int row = this.consultaExpediente.tbDatos.getSelectedRow();
            Object value = this.consultaExpediente.tbDatos.getValueAt(row, column);

            if (row >= 0) {
                this.expedienteSeleccionado = lista.get(row);
                System.out.println("Fila seleccionada: " + row);
                System.out.println("Valor de la celda seleccionada: " + value);
                System.out.println("Expediente seleccionado: " + this.expedienteSeleccionado);
            } else {
                this.consultaExpediente.btnModificar.setEnabled(true);
                this.consultaExpediente.btnAgregar.setEnabled(false);
                this.consultaExpediente.btnEliminar.setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.consultaExpediente.btnAgregar) {
            VistaFormularioExpediente frmExpediente = new VistaFormularioExpediente();
            ControladorFormularioExpediente ctlExpediente = new ControladorFormularioExpediente(this, frmExpediente);
            frmExpediente.iniciar();
        } else if (e.getSource() == this.consultaExpediente.btnModificar) {
            modificar();
        } else if (e.getSource() == this.consultaExpediente.btnEliminar) {
            eliminar();
        } else if (e.getSource() == this.consultaExpediente.btnBuscar) {
            buscar();
        }
    }

}
