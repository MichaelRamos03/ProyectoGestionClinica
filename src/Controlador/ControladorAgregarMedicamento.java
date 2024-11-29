/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.ListaCircular;
import Modelo.Medicamento;
import ModeloDao.MedicamentoDao;
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
public class ControladorAgregarMedicamento extends MouseAdapter implements ActionListener, MouseListener {

    private VistaRegistrarMedicamento vistaRegistrar;
    private ControladorMedicamentos controladorMedicamento;
    private Medicamento medicamento;
    private MedicamentoDao medicamentoDao;
    private ListaCircular<Medicamento> medicamentoList;

    public ControladorAgregarMedicamento(VistaRegistrarMedicamento vistaRegistrar, ControladorMedicamentos controladorMedicamento, ListaCircular<Medicamento> medicamentoList) {
        this.vistaRegistrar = vistaRegistrar;
        this.vistaRegistrar.setDefaultCloseOperation(vistaRegistrar.DISPOSE_ON_CLOSE);
        this.medicamentoList = medicamentoList;
        this.controladorMedicamento = controladorMedicamento;
        this.vistaRegistrar.setLocationRelativeTo(null);
        this.vistaRegistrar.btnRegistrar.addActionListener(this);
        this.medicamentoDao = new MedicamentoDao();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vistaRegistrar.btnRegistrar) {
            System.out.println("ENTRA VISTA REGISTRAR");
            String nombre = this.vistaRegistrar.txtNombreMedicamento.getText();
            String cantidad = (this.vistaRegistrar.txtCantidad.getText());
            String precio = (this.vistaRegistrar.txtPrecio.getText());
            String descripcion = this.vistaRegistrar.textAreaDescripcion.getText();
            Date fechaCaducidad = this.vistaRegistrar.fechaCaducidad.getDate();
            if (validarDatos(nombre, cantidad, precio, descripcion, fechaCaducidad)) {

                int cant = Integer.parseInt(cantidad);
                Double precio1 = Double.parseDouble(precio);

                Medicamento nuevoMedicamento = new Medicamento();
                nuevoMedicamento.setNombre(nombre);
                nuevoMedicamento.setCantidadDisponible(cant);
                nuevoMedicamento.setPrecio(precio1);
                nuevoMedicamento.setFechaCaducidad(fechaCaducidad);
                nuevoMedicamento.setDescripcion(descripcion);
                if(!this.medicamentoDao.verificarExiste(nuevoMedicamento.getNombre())){
                    this.medicamentoList.insertar(nuevoMedicamento);
                 this.medicamentoDao.insert(nuevoMedicamento);
                   // JOptionPane.showMessageDialog(null, "El medicamento: " + nuevoMedicamento.getNombre() + " Ha sido registrado exitosamente");
                  DesktopNotify.setDefaultTheme(NotifyTheme.Green);
                  DesktopNotify.showDesktopMessage("Medicamento ", nuevoMedicamento.getNombre()+" Registrado con exito",
                    DesktopNotify.SUCCESS, 5000);
                }else{
                    DesktopNotify.setDefaultTheme(NotifyTheme.Red);
                  DesktopNotify.showDesktopMessage("Medicamento "+ nuevoMedicamento.getNombre(), " El nombre del medicamento ya existe",
                    DesktopNotify.FAIL, 7000);
                }
                
                
                this.controladorMedicamento.mostrarDatos();
                limpiarDatos();
                this.vistaRegistrar.dispose();
            }
        }

    }

    public Boolean validarDatos(String nombre, String cantidad, String precio, String descripcion, Date fechaCaducidad) {
        // validaciones nombre
        nombre = nombre.replace(" ", "");
        if (nombre.equals("") || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "[Nombre vacio] Complete el campo de nombre ");
            return false;
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
        if(precio.equals("0")){
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

    
     public void limpiarDatos(){
        this.vistaRegistrar.txtNombreMedicamento.setText("");
        this.vistaRegistrar.txtCantidad.setText("");
        this.vistaRegistrar.txtPrecio.setText("");
        this.vistaRegistrar.textAreaDescripcion.setText("");
        this.vistaRegistrar.fechaCaducidad.setDate(null);
    }
}
