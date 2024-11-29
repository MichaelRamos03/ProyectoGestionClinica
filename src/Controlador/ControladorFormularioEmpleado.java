package Controlador;

import Estructuras.Cola;
import Estructuras.ColaPrioridad;
import Modelo.Empleado;
import Modelo.Rol;
import ModeloDao.EmpleadoDao;
import ModeloDao.RolDao;
import Vista.VistaFormularioEmpleado;
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
public class ControladorFormularioEmpleado extends MouseAdapter implements ActionListener, MouseListener {

    VistaFormularioEmpleado vistaFormulario;
    EmpleadoDao daoEmpleado;
    ControladorConsultaEmpleado ctl;
    Empleado empleado, empleadoSeleccionado;
    RolDao daoRol;

    public ControladorFormularioEmpleado(ControladorConsultaEmpleado ctl, VistaFormularioEmpleado vistaFormulario) {
        this.ctl = ctl;
        this.vistaFormulario = vistaFormulario;
        this.daoEmpleado = new EmpleadoDao();
        this.daoRol = new RolDao();
        this.vistaFormulario.btnGuardar.addActionListener(this);
        this.empleadoSeleccionado = null;
        LlenarCombo();
        comboRol();
    }

    public ControladorFormularioEmpleado(ControladorConsultaEmpleado ctl, VistaFormularioEmpleado vistaFormulario, Empleado empleadoSeleccionado) {
        this.ctl = ctl;
        this.vistaFormulario = vistaFormulario;
        this.empleadoSeleccionado = empleadoSeleccionado;
        this.daoEmpleado = new EmpleadoDao();
        this.daoRol = new RolDao();
        this.vistaFormulario.btnGuardar.addActionListener(this);
        this.empleadoSeleccionado = empleadoSeleccionado;
        LlenarCombo();
        comboRol();
        llenarVista();
    }

    public void guardar() {

        if (!this.vistaFormulario.tfDui.getText().isEmpty()
                && !this.vistaFormulario.tfNombre.getText().isEmpty()
                && !this.vistaFormulario.tfApellido.getText().isEmpty()
                && (this.vistaFormulario.rbHombre.isSelected() || this.vistaFormulario.rbMujer.isSelected())
                && this.vistaFormulario.rsFecha.getDatoFecha() != null
                && !this.vistaFormulario.tfCorreo.getText().isEmpty()
                && this.vistaFormulario.cbRol.getSelectedIndex() != 0
                && this.vistaFormulario.cbPrioridad.getSelectedIndex() != 0) {

            if (this.empleadoSeleccionado == null) {
                nuevoEmpleado();
            } else {
                editar();
            }

        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Faltan Datos o Inserte datos validos",
                    DesktopNotify.ERROR, 3000);
        }
    }

    public void nuevoEmpleado() {
        Cola<Rol> lista = this.daoRol.selectAllTo("rol", this.vistaFormulario.cbRol.getSelectedItem().toString());

        this.empleado = new Empleado(
                this.vistaFormulario.tfDui.getText(),
                this.vistaFormulario.tfNombre.getText(),
                this.vistaFormulario.tfApellido.getText(),
                this.vistaFormulario.rbHombre.isSelected() ? "Hombre" : "Mujer",
                this.vistaFormulario.rsFecha.getDatoFecha(),
                this.vistaFormulario.tfCorreo.getText(),
                this.vistaFormulario.chEstado.isSelected(),
                new Rol(lista.get(0).getIdRol(), this.vistaFormulario.cbRol.getSelectedItem().toString()),
                prioridad(this.vistaFormulario.cbPrioridad.getSelectedIndex())
        );

        if (this.daoEmpleado.insert(empleado)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("exito", "Expediente guardado",
                    DesktopNotify.ERROR, 3000);

            this.vistaFormulario.dispose();
            this.ctl.mostrar(daoEmpleado.selectAll());

            this.ctl.vistaConsulta.btnAgregar.setEnabled(true);
            this.ctl.vistaConsulta.btnEditar.setEnabled(true);
            this.ctl.vistaConsulta.btnEliminar.setEnabled(true);
            this.empleadoSeleccionado = null;

        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No guardo",
                    DesktopNotify.ERROR, 3000);

        }
    }

    private void editar() {

        Cola<Rol> lista = this.daoRol.selectAllTo("rol", this.vistaFormulario.cbRol.getSelectedItem().toString());

        this.empleadoSeleccionado.setDui(this.vistaFormulario.tfDui.getText());
        this.empleadoSeleccionado.setNombre(this.vistaFormulario.tfNombre.getText());
        this.empleadoSeleccionado.setApellido(this.vistaFormulario.tfApellido.getText());

        if (this.vistaFormulario.rbHombre.isSelected()) {
            this.empleadoSeleccionado.setGenero("Hombre");
        } else if (this.vistaFormulario.rbMujer.isSelected()) {
            this.empleadoSeleccionado.setGenero("Mujer");
        }
        this.empleadoSeleccionado.setFechaNacimiento(this.vistaFormulario.rsFecha.getDatoFecha());
        this.empleadoSeleccionado.setCorreo(this.vistaFormulario.tfCorreo.getText());
        this.empleadoSeleccionado.setEstado(this.vistaFormulario.chEstado.isSelected());
        this.empleadoSeleccionado.setRol(new Rol(lista.get(0).getIdRol(), this.vistaFormulario.cbRol.getSelectedItem().toString()));
        this.empleadoSeleccionado.setPrioridad(this.vistaFormulario.cbPrioridad.getSelectedItem().toString());

        if (daoEmpleado.update(empleadoSeleccionado)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("exito", "Actualizado",
                    DesktopNotify.ERROR, 3000);

            this.vistaFormulario.dispose();
            this.ctl.mostrar(this.daoEmpleado.selectAll());
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No guardo",
                    DesktopNotify.ERROR, 3000);
        }
    }

    private void llenarVista() {
        this.vistaFormulario.tfDui.setText(this.empleadoSeleccionado.getDui());
        this.vistaFormulario.tfNombre.setText(this.empleadoSeleccionado.getNombre());
        this.vistaFormulario.tfApellido.setText(this.empleadoSeleccionado.getApellido());
        if ("Hombre".equals(this.empleadoSeleccionado.getGenero())) {
            this.vistaFormulario.rbHombre.setSelected(true);
        } else if ("Mujer".equals(this.empleadoSeleccionado.getGenero())) {
            this.vistaFormulario.rbMujer.setSelected(true);
        }
        this.vistaFormulario.rsFecha.setDatoFecha(this.empleadoSeleccionado.getFechaNacimiento());
        this.vistaFormulario.tfCorreo.setText(this.empleadoSeleccionado.getCorreo());
        this.vistaFormulario.cbRol.setSelectedItem(this.empleadoSeleccionado.getRol().getRol());
        this.vistaFormulario.cbPrioridad.setSelectedItem(this.empleadoSeleccionado.getPrioridad());
        this.vistaFormulario.chEstado.setSelected(this.empleadoSeleccionado.isEstado());
    }

    public String prioridad(int n) {

        switch (n) {
            case 1:
                return "Alta";
            case 2:
                return "Media";
            case 3:
                return "Baja";
            default:
                return "Sin asignar";
        }
    }

    public void LlenarCombo() {
        this.vistaFormulario.cbPrioridad.removeAllItems();
        this.vistaFormulario.cbPrioridad.addItem("Sin asignar");
        this.vistaFormulario.cbPrioridad.addItem("Alta");
        this.vistaFormulario.cbPrioridad.addItem("Media");
        this.vistaFormulario.cbPrioridad.addItem("Baja");
    }

    public void comboRol() {
        Cola<Rol> lista = daoRol.selectAll();
        for (Rol x : lista.toArray()) {
            this.vistaFormulario.cbRol.addItem(x.getRol());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaFormulario.btnGuardar) {
            guardar();
        } 
    }
}
