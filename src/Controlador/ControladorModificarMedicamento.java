/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.ListaCircular;
import Modelo.Medicamento;
import ModeloDao.MedicamentoDao;
import Vista.VistaModificarMedicamento;
import Vista.VistaRegistrarMedicamento;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author karla
 */
public class ControladorModificarMedicamento extends MouseAdapter implements ActionListener, MouseListener {

    private VistaModificarMedicamento vistaModificar;
    private ControladorMedicamentos controladorMedicamento;
    private Medicamento medicamentoSeleccionado;
    private MedicamentoDao medicamentoDao;
    private ListaCircular<Medicamento> listaC;

    public ControladorModificarMedicamento(VistaModificarMedicamento vistaModificar, ControladorMedicamentos controladorMedicamento, Medicamento medicamento, ListaCircular<Medicamento> listaCircular) {
        this.vistaModificar = vistaModificar;
        this.vistaModificar.setDefaultCloseOperation(vistaModificar.DISPOSE_ON_CLOSE);
        this.medicamentoSeleccionado = medicamento;
        this.listaC = listaCircular;
        this.controladorMedicamento = controladorMedicamento;
        this.vistaModificar.setLocationRelativeTo(null);

        this.vistaModificar.btnModificar.addActionListener(this);
        this.medicamentoDao = new MedicamentoDao();
        llenarVistaMedicamento();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vistaModificar.btnModificar) {
            System.out.println("ENTRA VISTA REGISTRAR");

            String nombre = this.vistaModificar.txtNombreMedicamento.getText();
            String cantidad = (this.vistaModificar.txtCantidad.getText());
            String precio = (this.vistaModificar.txtPrecio.getText());
            String descripcion = this.vistaModificar.textAreaDescripcion.getText();
            Date fechaCaducidad = this.vistaModificar.fechaCaducidad.getDate();

            if (validarDatos(nombre, cantidad, precio, descripcion, fechaCaducidad)) {

                int cant = Integer.parseInt(cantidad);
                Double precio1 = Double.parseDouble(precio);

                Medicamento medicamentoModificado = new Medicamento();
                medicamentoModificado.setIdMedicamento(this.medicamentoSeleccionado.getIdMedicamento());
                medicamentoModificado.setNombre(nombre);
                medicamentoModificado.setCantidadDisponible(cant);
                medicamentoModificado.setPrecio(precio1);
                medicamentoModificado.setFechaCaducidad(fechaCaducidad);
                medicamentoModificado.setDescripcion(descripcion);

                if (this.medicamentoSeleccionado.getNombre().equals(medicamentoModificado.getNombre())
                        || !this.medicamentoDao.verificarExiste(medicamentoModificado.getNombre())) {
                    // Actualiza el medicamento si el nombre no cambia o el nuevo nombre no existe
                    this.medicamentoDao.update(medicamentoModificado);

                    // Notificación de éxito
                    DesktopNotify.setDefaultTheme(NotifyTheme.Green);
                    DesktopNotify.showDesktopMessage("Medicamento", "Actualizado",
                            DesktopNotify.SUCCESS, 5000);
                    this.vistaModificar.dispose();
                    limpiarDatos();
                } else {
                    // Notificación de error si el nuevo nombre ya existe
                    DesktopNotify.setDefaultTheme(NotifyTheme.Red);
                    DesktopNotify.showDesktopMessage("Medicamento " + medicamentoModificado.getNombre(),
                            "El nombre del medicamento ya existe.",
                            DesktopNotify.FAIL, 7000);
                }

            }

            this.controladorMedicamento.mostrarDatos();
        }

    }

    private void llenarVistaMedicamento() {

        System.out.println("Id Medicamento:" + this.medicamentoSeleccionado.getIdMedicamento());
        this.vistaModificar.txtNombreMedicamento.setText(this.medicamentoSeleccionado.getNombre());
        this.vistaModificar.txtCantidad.setText(String.valueOf(this.medicamentoSeleccionado.getCantidadDisponible()));
        this.vistaModificar.fechaCaducidad.setDate(this.medicamentoSeleccionado.getFechaCaducidad());
        this.vistaModificar.txtPrecio.setText(String.valueOf(this.medicamentoSeleccionado.getPrecio()));
        this.vistaModificar.textAreaDescripcion.setText(this.medicamentoSeleccionado.getDescripcion());
    }

    public Boolean validarDatos(String nombre, String cantidad, String precio, String descripcion, Date fechaCaducidad) {
        // validaciones nombre
        nombre = nombre.replace(" ", "");
        if (nombre.equals("") || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "[Nombre vacio] Complete el campo de nombre ");
            return false;
        }
        for (int i = 0; i < nombre.length(); i++) {
            if (!Character.isLetter(nombre.charAt(i))) {

                JOptionPane.showMessageDialog(null, "El nombre solo debe de contener letras, no se permiten caracteres especiales");
                return false;
            }

        }
        // validaciones cantidad
        cantidad = cantidad.replace(" ", "");
        if (cantidad.equals("") || cantidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cantidad Vacia ingrese una cantidad valida");
            return false;
        }

        for (int i = 0; i < cantidad.length(); i++) {
            if (!Character.isDigit(cantidad.charAt(i))) {
                JOptionPane.showMessageDialog(null, "La cantidad solo debe tener numeros enteros");
                return false;
            }
        }

        //validacion precio
        precio = precio.replace(" ", "");
        if (precio.equals("") || precio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Precio vacio,Ingrese un Precio valido");
            return false;
        }
        if (precio.equals("0")) {
            JOptionPane.showMessageDialog(null, "El precio debe ser mayor a cero");
            return false;
        }

        int contadorPuntos = 0; // Contador para los puntos decimales
        for (int i = 0; i < precio.length(); i++) {
            char c = precio.charAt(i);
            if (c == '.') {
                contadorPuntos++;
                if (contadorPuntos > 1) { // Más de un punto decimal
                    JOptionPane.showMessageDialog(null, "El precio solo puede tener un punto decimal");
                    return false;
                }
            } else if (!Character.isDigit(c)) { // No es un dígito ni un punto decimal
                JOptionPane.showMessageDialog(null, "El precio solo debe contener números");
                return false;
            }
        }

        if (fechaCaducidad == null) {
            JOptionPane.showMessageDialog(null, "Ingrese un fecha");
            return false;
        }

        descripcion = descripcion.replace(" ", "");
        if (descripcion.equals("") || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La descripcion No puede estar vacia");
            return false;
        }

        return true;
    }

    public void limpiarDatos() {
        this.vistaModificar.txtNombreMedicamento.setText("");
        this.vistaModificar.txtCantidad.setText("");
        this.vistaModificar.txtPrecio.setText("");
        this.vistaModificar.textAreaDescripcion.setText("");
        this.vistaModificar.fechaCaducidad.setDate(null);
    }
}
