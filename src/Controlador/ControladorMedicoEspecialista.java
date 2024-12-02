package Controlador;

import Estructuras.ListaDoble;
import Modelo.Empleado;
import Modelo.Especialidad;
import Modelo.MedicoEspecialista;
import ModeloDao.EmpleadoDao;
import ModeloDao.EspecialidadDao;
import ModeloDao.MedicoEspecialistaDao;
import Vista.VistaMedicoEspecialista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author equipo
 */
public class ControladorMedicoEspecialista extends MouseAdapter implements ActionListener {

    private VistaMedicoEspecialista vistaMed;
    private MedicoEspecialistaDao daoMedico;
    private EmpleadoDao daoEmpleado;
    private EspecialidadDao daoEspecialidad;
    private ListaDoble<MedicoEspecialista> listamedico;

    public ControladorMedicoEspecialista(VistaMedicoEspecialista vistaMed) {
        this.vistaMed = vistaMed;
        this.daoMedico = new MedicoEspecialistaDao();
        this.daoEmpleado = new EmpleadoDao();
        this.daoEspecialidad = new EspecialidadDao();
        this.listamedico = new ListaDoble<>();

      
        this.vistaMed.setVisible(true);
        this.vistaMed.setDefaultCloseOperation(vistaMed.DISPOSE_ON_CLOSE);
        this.vistaMed.setLocationRelativeTo(null);

       
        this.vistaMed.btnAgregar.addActionListener(this);
        this.vistaMed.btnEliminar.addActionListener(this);
        this.vistaMed.btnModificar.addActionListener(this);
        this.vistaMed.btnSalir.addActionListener(this);
        this.vistaMed.medTabla.addMouseListener(this);
       

      
        llenarComboEmpleado();
        llenarComboEspecialidad();

      
        listamedico = daoMedico.selectAllMedico();
        mostrar(listamedico);
    }

  
    private void llenarComboEmpleado() {
        try {
            EmpleadoDao empleadoDao = new EmpleadoDao(); 
            ListaDoble<Empleado> listaEmpleados = empleadoDao.selectAll(); 

           
            this.vistaMed.cmbxEmpleado.removeAllItems();

       
            if (listaEmpleados.isEmpty()) {
                System.out.println("No hay empleados para cargar en el combo.");
                return;
            }

    
            for (Empleado empleado : listaEmpleados.toArray()) {
                this.vistaMed.cmbxEmpleado.addItem(empleado); 
            }

            System.out.println("Empleados cargados correctamente en el combo.");
        } catch (Exception ex) {
            System.err.println("Error al llenar el combobox de empleados: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

 
private void llenarComboEspecialidad() {
    try {
        EspecialidadDao especialidadDao = new EspecialidadDao();
        ListaDoble<Especialidad> listaEspecialidades = especialidadDao.selectAll();

      
        this.vistaMed.cmbxEspecialidad.removeAllItems();

      
        if (listaEspecialidades.isEmpty()) {
            System.out.println("No hay especialidades para cargar en el combo.");
            return;
        }

      
        for (Especialidad especialidad : listaEspecialidades.toArray()) {
            this.vistaMed.cmbxEspecialidad.addItem(especialidad); 
        }

        System.out.println("Especialidades cargadas correctamente en el combo.");
    } catch (Exception ex) {
        System.err.println("Error al llenar el combobox de especialidades: " + ex.getMessage());
        ex.printStackTrace();
    }
}



    private void mostrar(ListaDoble<MedicoEspecialista> lista) {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] titulos = {"ID Médico", "DUI", "Nombre", "Apellido", "Especialidad", "Estado", "Correo"};
        modelo.setColumnIdentifiers(titulos);

        for (MedicoEspecialista medico : lista.toArray()) {
            Object[] fila = {
                medico.getIdMedicoEspecialista(),
                medico.getIdEmpleado().getDui(),      
                medico.getIdEmpleado().getNombre(),   
                medico.getIdEmpleado().getApellido(), 
                medico.getIdEspecialidad().getEspecialidad(), 
                medico.getIdEmpleado().isEstado() ? "Activo" : "Inactivo", 
                medico.getIdEmpleado().getCorreo()   
            };
            modelo.addRow(fila);
        }

        this.vistaMed.medTabla.setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaMed.btnAgregar) {
            agregarMedico();
        } else if (e.getSource() == this.vistaMed.btnEliminar) {
            eliminarMedico();
        } else if (e.getSource() == this.vistaMed.btnModificar) {
            modificarMedico();
        } else if (e.getSource() == this.vistaMed.btnSalir) {
        salir();
    }
    }

    private void agregarMedico() {
        try {
            MedicoEspecialista medico = new MedicoEspecialista();
            medico.setIdMedicoEspecialista(Integer.parseInt(this.vistaMed.tfId.getText()));
            medico.setIdEmpleado((Empleado) this.vistaMed.cmbxEmpleado.getSelectedItem());
            medico.setIdEspecialidad((Especialidad) this.vistaMed.cmbxEspecialidad.getSelectedItem());

            if (daoMedico.insert(medico)) {
                JOptionPane.showMessageDialog(vistaMed, "Médico agregado correctamente.");
                mostrar(daoMedico.selectAllMedico());
            } else {
                JOptionPane.showMessageDialog(vistaMed, "Error al agregar médico.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaMed, "Datos inválidos. Verifique los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarMedico() {
        try {
            int idMedico = Integer.parseInt(this.vistaMed.tfId.getText());
            MedicoEspecialista medico = new MedicoEspecialista();
            medico.setIdMedicoEspecialista(idMedico);

            if (daoMedico.delete(medico)) {
                JOptionPane.showMessageDialog(vistaMed, "Médico eliminado correctamente.");
                mostrar(daoMedico.selectAllMedico());
            } else {
                JOptionPane.showMessageDialog(vistaMed, "Error al eliminar médico.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaMed, "Seleccione un médico para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarMedico() {
        try {
            MedicoEspecialista medico = new MedicoEspecialista();
            medico.setIdMedicoEspecialista(Integer.parseInt(this.vistaMed.tfId.getText()));
            medico.setIdEmpleado((Empleado) this.vistaMed.cmbxEmpleado.getSelectedItem());
            medico.setIdEspecialidad((Especialidad) this.vistaMed.cmbxEspecialidad.getSelectedItem());

            if (daoMedico.update(medico)) {
                JOptionPane.showMessageDialog(vistaMed, "Médico modificado correctamente.");
                mostrar(daoMedico.selectAllMedico());
            } else {
                JOptionPane.showMessageDialog(vistaMed, "Error al modificar médico.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaMed, "Datos inválidos. Verifique los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = vistaMed.medTabla.getSelectedRow();
        if (fila != -1) {
            this.vistaMed.tfId.setText(vistaMed.medTabla.getValueAt(fila, 0).toString());
            seleccionarComboEmpleado(vistaMed.medTabla.getValueAt(fila, 1).toString());
            seleccionarComboEspecialidad(vistaMed.medTabla.getValueAt(fila, 4).toString());
        }
    }

    private void seleccionarComboEmpleado(String dui) {
        for (int i = 0; i < vistaMed.cmbxEmpleado.getItemCount(); i++) {
            Empleado empleado = (Empleado) vistaMed.cmbxEmpleado.getItemAt(i);
            if (empleado.getDui().equals(dui)) {
                vistaMed.cmbxEmpleado.setSelectedIndex(i);
                break;
            }
        }
    }

    private void seleccionarComboEspecialidad(String especialidad) {
        for (int i = 0; i < vistaMed.cmbxEspecialidad.getItemCount(); i++) {
            Especialidad esp = (Especialidad) vistaMed.cmbxEspecialidad.getItemAt(i);
            if (esp.getEspecialidad().equals(especialidad)) {
                vistaMed.cmbxEspecialidad.setSelectedIndex(i);
                break;
            }
        }
    }

   private void salir() {
    int confirmacion = JOptionPane.showConfirmDialog(vistaMed, "¿Está seguro de que desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
    if (confirmacion == JOptionPane.YES_OPTION) {
        vistaMed.dispose();
    }
}


}