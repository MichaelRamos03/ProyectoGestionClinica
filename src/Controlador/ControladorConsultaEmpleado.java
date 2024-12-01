
package Controlador;

import Estructuras.ABinarioBusqueda;
import Estructuras.ListaDoble;
import Modelo.Empleado;
import ModeloDao.EmpleadoDao;
import RSMaterialComponent.RSSwitch;
import Vista.VistaConsultaEmpleado;
import Vista.VistaFormularioEmpleado;
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
**/
public class ControladorConsultaEmpleado extends MouseAdapter implements ActionListener, MouseListener{
    
    
    VistaConsultaEmpleado vistaConsulta;
    Empleado empleadoSeleccionado;
    EmpleadoDao daoEmpleado;

    public ControladorConsultaEmpleado(VistaConsultaEmpleado vistaConsulta) {
        this.vistaConsulta = vistaConsulta;
        this.daoEmpleado = new EmpleadoDao();
        this.vistaConsulta.btnAgregar.addActionListener(this);
        this.vistaConsulta.btnEditar.addActionListener(this);
        this.vistaConsulta.btnEliminar.addActionListener(this);
        this.vistaConsulta.btnBuscar.addActionListener(this);
        this.vistaConsulta.tbDatos.addMouseListener(this);
        
        mostrar(daoEmpleado.selectAll());
    }
    
    
    
     public void mostrar(ListaDoble<Empleado> lista) {

        DefaultTableModel modelo;
        this.vistaConsulta.tbDatos.setDefaultRenderer(Object.class, new Render());
        modelo = new DefaultTableModel();
        String titulos[] = {"N","DUI","NOMBRE", "APELLIDO", "GENERO", "FECHA NACIMIENTO", "CORREO", "ESTADO", "ROL"};
        modelo.setColumnIdentifiers(titulos);
        int i = 0;

        for (Empleado x : lista.toArray()) {
            i++;
            RSSwitch activo = new RSMaterialComponent.RSSwitch();
            activo.setSize(60, 30);
            activo.setName("Activo" + i); 
            activo.setActivado(x.isEstado()); 
            activo.addMouseListener(this); 
            Object datos[] = {i, x.getDui(),
                                 x.getNombre(), 
                                 x.getApellido(), 
                                 x.getGenero(), 
                                 x.getFechaNacimiento(),
                                 x.getCorreo(), 
                                 activo,
                                 x.getRol().
                                 getRol(),
//                                 x.getPrioridad()
                                };
            modelo.addRow(datos);
        }
        this.vistaConsulta.tbDatos.setModel(modelo);
    }
     
     private void modificar(){
         if (empleadoSeleccionado != null) {
         VistaFormularioEmpleado frm = new VistaFormularioEmpleado();
         ControladorFormularioEmpleado ctr = new ControladorFormularioEmpleado(this,frm, empleadoSeleccionado);
         frm.iniciar();
         }
     }
     
     private void eliminar() {

        int op = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar"
                + empleadoSeleccionado.getIdEmpleado());

        if (daoEmpleado.delete(empleadoSeleccionado)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("OK", "Registro eliminado",
                    DesktopNotify.SUCCESS, 3000);
            mostrar(daoEmpleado.selectAll());
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No se pudo eliminar",
                    DesktopNotify.ERROR, 3000);
        }
    }
     
      public void buscar() {
         // Verificar que el campo de búsqueda no esté vacío
        if (!this.vistaConsulta.txtBuscar.getText().isEmpty()) {
            DefaultTableModel modelo;
            this.vistaConsulta.tbDatos.setDefaultRenderer(Object.class, new Render());
            modelo = new DefaultTableModel();
             String nombre = this.vistaConsulta.txtBuscar.getText();
             
            // Obtener la lista de empleados desde el DAO
            ABinarioBusqueda<Empleado> listaBusqueda = daoEmpleado.buscar();
            Empleado empleado = new Empleado();
            
            // Establecer el ID del empleado a buscar
            empleado.setNombre(nombre);
            
             // Buscar el empleado en el árbol binario
            if (listaBusqueda.buscar(empleado) != null) {
                empleado = (Empleado) listaBusqueda.buscar(empleado).getClave();
                // Definir los títulos de las columnas de la tabla
                String titulos[] = {"DUI","NOMBRE", "APELLIDO", "GENERO", 
                    "FECHA NACIMIENTO", "CORREO", "ESTADO", "ROL"};
                modelo.setColumnIdentifiers(titulos);

                // Agregar los datos del empleado al modelo de la tabla

            RSSwitch activo = new RSMaterialComponent.RSSwitch();
            activo.setSize(60, 30);
            activo.setActivado(empleado.isEstado()); 
            activo.addMouseListener(this); 
            Object datos[] = { empleado.getDui(),
                                 empleado.getNombre(), 
                                 empleado.getApellido(), 
                                 empleado.getGenero(),
                                 empleado.getFechaNacimiento(),
                                 empleado.getCorreo(),
                                 activo,
                                 empleado.getRol().
                                 getRol(),
                                };
                modelo.addRow(datos);
///
                // Mostrar los datos en la tabla
                this.vistaConsulta.tbDatos.setModel(modelo);
                this.vistaConsulta.txtBuscar.setText("");
            } else {
                mostrar(this.daoEmpleado.selectAll());
                JOptionPane.showMessageDialog(null, "DATO NO ENCONTRADO");
            }
        }else{
            JOptionPane.showMessageDialog(this.vistaConsulta, "campo vacío");
            mostrar(this.daoEmpleado.selectAll());
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaConsulta.tbDatos) {
            ListaDoble<Empleado> lista = daoEmpleado.selectAll();
            int colum = this.vistaConsulta.tbDatos.getColumnModel().getColumnIndexAtX(e.getX());
            int row = this.vistaConsulta.tbDatos.getSelectedRow();
            Object value = this.vistaConsulta.tbDatos.getValueAt(row, colum);
            
            if (row >= 0) {
                this.empleadoSeleccionado = lista.get(row);
                System.out.println("Fila seleccionada: " + row);
                System.out.println("Valor de la celda seleccionada: " + value);
                System.out.println("Expediente seleccionado: " + this.empleadoSeleccionado);
            } else {
                this.vistaConsulta.btnEditar.setEnabled(true);
                this.vistaConsulta.btnAgregar.setEnabled(false);
                this.vistaConsulta.btnEliminar.setEnabled(true);
            }
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaConsulta.btnAgregar) {
            VistaFormularioEmpleado v = new VistaFormularioEmpleado();
            ControladorFormularioEmpleado ctr = new ControladorFormularioEmpleado(this,v);
            v.iniciar();     
        }else if (e.getSource() == this.vistaConsulta.btnEliminar) {
            eliminar();
        } if (e.getSource() == this.vistaConsulta.btnBuscar) {
            buscar();
        } else if (e.getSource() == this.vistaConsulta.btnEditar) {
            modificar();
        } 
    }

}