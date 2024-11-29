package Controlador;


import Modelo.Expediente;
import ModeloDao.ExpedienteDao;
import Vista.VistaFormularioExpediente;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

/**
 *
 * @author Michael Ramos;
 *
 */
public class ControladorFormularioExpediente extends MouseAdapter implements ActionListener, MouseListener {

    VistaFormularioExpediente frmExpediente;
    ExpedienteDao daoExpediente;
    ControladorConsultaExpediente ctlConsultarExpediente;
    Expediente expediente, expedienteSeleccionado;

    public ControladorFormularioExpediente(ControladorConsultaExpediente ctlConsultarExpediente, VistaFormularioExpediente frmExpediente) {
        this.ctlConsultarExpediente = ctlConsultarExpediente;
        this.frmExpediente = frmExpediente;
        this.daoExpediente = new ExpedienteDao();
        this.frmExpediente.btnGuardar.addActionListener(this);
        this.expedienteSeleccionado = null;
    }

    public ControladorFormularioExpediente(ControladorConsultaExpediente ctlConsultarExpediente,VistaFormularioExpediente frmExpediente, Expediente expedienteSeleccionado) {
        this.frmExpediente = frmExpediente;
        this.ctlConsultarExpediente = ctlConsultarExpediente;
        this.expedienteSeleccionado = expedienteSeleccionado;
        this.daoExpediente = new ExpedienteDao();
        this.frmExpediente.btnGuardar.addActionListener(this);
        llenarVista();
    }
    
    public void guardar() {
        if (!this.frmExpediente.tfNombre.getText().isEmpty() 
                && !this.frmExpediente.tfApellido.getText().isEmpty()
                && this.frmExpediente.dcFechaNacimiento.getDate() != null 
                && (this.frmExpediente.rbHombre.isSelected() || this.frmExpediente.rbMujer.isSelected())
                && !this.frmExpediente.tfTelefono.getText().isEmpty() 
                && !this.frmExpediente.tfInformacion.getText().isEmpty()
                && !this.frmExpediente.tfTratamientos.getText().isEmpty() 
                && !this.frmExpediente.tfNotaMedica.getText().isEmpty()
                && !this.frmExpediente.tfAlergias.getText().isEmpty() 
                && !this.frmExpediente.tfMedicamentos.getText().isEmpty()) {

            if (this.expedienteSeleccionado == null) {
                nuevoExpediente();
            } else if (this.expedienteSeleccionado != null) {
                editar();
            }

        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red); // mandamos un mensaje si da error
            DesktopNotify.showDesktopMessage("Error", "Faltan Datos",
                    DesktopNotify.ERROR, 3000);
        }
    }

    private void nuevoExpediente() {
        this.expediente = new Expediente(
                this.frmExpediente.tfNombre.getText(),
                this.frmExpediente.tfApellido.getText(),
                this.frmExpediente.dcFechaNacimiento.getDate(),
                this.frmExpediente.rbHombre.isSelected() ? "Hombre" : "Mujer",
                this.frmExpediente.tfTelefono.getText(),
                this.frmExpediente.tfInformacion.getText(),
                this.frmExpediente.tfTratamientos.getText(),
                this.frmExpediente.tfNotaMedica.getText(),
                this.frmExpediente.tfAlergias.getText(),
                this.frmExpediente.tfMedicamentos.getText()
        );
        
        if (this.daoExpediente.insert(expediente)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("exito", "Expediente guardado",
            DesktopNotify.ERROR, 3000);
            
            this.frmExpediente.dispose();
            this.ctlConsultarExpediente.mostrar(daoExpediente.selectAll());
            
            this.ctlConsultarExpediente.consultaExpediente.btnAgregar.setEnabled(true);
            this.ctlConsultarExpediente.consultaExpediente.btnModificar.setEnabled(true);
            this.ctlConsultarExpediente.consultaExpediente.btnEliminar.setEnabled(true);
            this.expedienteSeleccionado = null;
            
        }  else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No guardo",
            DesktopNotify.ERROR, 3000);
            
        }
    }
    
    private void editar() {
        this.expedienteSeleccionado.setNombre(this.frmExpediente.tfNombre.getText());
        this.expedienteSeleccionado.setApellido(this.frmExpediente.tfApellido.getText());
        this.expedienteSeleccionado.setFechaNacimiento(this.frmExpediente.dcFechaNacimiento.getDate());
        this.expedienteSeleccionado.setTelefono(this.frmExpediente.tfTelefono.getText());
        this.expedienteSeleccionado.setInformacionMedica(this.frmExpediente.tfInformacion.getText());
        this.expedienteSeleccionado.setTratamiento(this.frmExpediente.tfTratamientos.getText());
        this.expedienteSeleccionado.setNotaMedica(this.frmExpediente.tfNotaMedica.getText());
        this.expedienteSeleccionado.setAlergias(this.frmExpediente.tfAlergias.getText());
        this.expedienteSeleccionado.setMedicamentos(this.frmExpediente.tfMedicamentos.getText());
        
        if (daoExpediente.update(expedienteSeleccionado)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("exito", "Actualizado",
            DesktopNotify.ERROR, 3000);
            
            this.frmExpediente.dispose();
            this.ctlConsultarExpediente.mostrar(this.daoExpediente.selectAll());
        } else {
             DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No guardo",
            DesktopNotify.ERROR, 3000);
        }
    }
    
     private void llenarVista() {
         this.frmExpediente.tfNombre.setText(this.expedienteSeleccionado.getNombre());
         this.frmExpediente.tfApellido.setText(this.expedienteSeleccionado.getApellido());
         this.frmExpediente.dcFechaNacimiento.setDate(this.expedienteSeleccionado.getFechaNacimiento());
         this.frmExpediente.tfTelefono.setText(this.expedienteSeleccionado.getTelefono());
         this.frmExpediente.tfInformacion.setText(this.expedienteSeleccionado.getInformacionMedica());
         this.frmExpediente.tfTratamientos.setText(this.expedienteSeleccionado.getTratamiento());
         this.frmExpediente.tfNotaMedica.setText(this.expedienteSeleccionado.getNotaMedica());
         this.frmExpediente.tfAlergias.setText(this.expedienteSeleccionado.getAlergias());
         this.frmExpediente.tfMedicamentos.setText(this.expedienteSeleccionado.getMedicamentos());
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmExpediente.btnGuardar) {
            guardar();
        }
    }
}
