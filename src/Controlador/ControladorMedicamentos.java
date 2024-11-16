/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.ListaCircular;
import Modelo.Medicamento;
import ModeloDao.MedicamentoDao;
import Vista.VistaCrudMedicamentos;
import Vista.VistaModificarMedicamento;

import Vista.VistaRegistrarMedicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karla
 */
public class ControladorMedicamentos extends MouseAdapter implements ActionListener, MouseListener {

    private VistaCrudMedicamentos vistaMedicamentos;
    private VistaRegistrarMedicamento vistaRegistrar;
    private VistaModificarMedicamento vistaModificar;

    private ControladorAgregarMedicamento controladorAgregar;
    private ControladorModificarMedicamento controladorModificar;
    private MedicamentoDao daoMedicamento;

    private Medicamento medicamento;
    private int filaMedicamentoSeleccionado;
    private Medicamento medicamentoSeleccionado;
    private ListaCircular<Medicamento> medicamentoList;
    private DefaultTableModel md;

    public ControladorMedicamentos(VistaCrudMedicamentos vistaMedicamentos) {
        this.vistaMedicamentos = vistaMedicamentos;
        this.vistaMedicamentos.setVisible(true);
        this.vistaMedicamentos.setDefaultCloseOperation(vistaMedicamentos.EXIT_ON_CLOSE);
        this.vistaMedicamentos.setLocationRelativeTo(null);
        this.vistaMedicamentos.btnRegistrarMedicamento.addActionListener(this);
        this.vistaMedicamentos.btnModificar.addActionListener(this);
        this.vistaMedicamentos.btnModificar.setEnabled(false);
        this.vistaMedicamentos.btnEliminar.addActionListener(this);
        this.vistaMedicamentos.btnEliminar.setEnabled(false);
        this.vistaMedicamentos.btnBuscar.addActionListener(this);

        this.md = new DefaultTableModel();
        this.md.addColumn("id");
        this.md.addColumn("Nombre");
        this.md.addColumn("Cantidad Disponible");
        this.md.addColumn("Fecha Caducidad");
        this.md.addColumn("Descripcion");
        this.md.addColumn("Precio");
        this.vistaMedicamentos.tablaMedicamentos.setModel(md);
        //escuchando la tabla
        this.vistaMedicamentos.tablaMedicamentos.addMouseListener(this);

        this.daoMedicamento = new MedicamentoDao();

        this.medicamentoList = new ListaCircular<Medicamento>();

        this.vistaRegistrar = new VistaRegistrarMedicamento();

        this.controladorAgregar = new ControladorAgregarMedicamento(this.vistaRegistrar, this, medicamentoList);

        mostrarDatos();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaMedicamentos.tablaMedicamentos) {
            this.filaMedicamentoSeleccionado = this.vistaMedicamentos.tablaMedicamentos.getSelectedRow();

            if (filaMedicamentoSeleccionado >= 0) {
                this.medicamentoSeleccionado = new Medicamento();
                //buscando por nombre del medicamento(metodo del compare to)
                String nombre = this.vistaMedicamentos.tablaMedicamentos.getValueAt(filaMedicamentoSeleccionado, 1).toString();
                this.medicamentoSeleccionado.setNombre(nombre);
                //int id=Integer.parseInt(this.vistaMedicamentos.tablaMedicamentos.getValueAt(filaMedicamentoSeleccionado,0).toString());
                //obteniendo el medicamento desde el metodo buscarDato
                this.medicamentoSeleccionado = this.medicamentoList.buscarDato(this.medicamentoSeleccionado);

               // this.vistaMedicamentos.btnRegistrarMedicamento.setEnabled(false);
                this.vistaMedicamentos.btnEliminar.setEnabled(true);
                this.vistaMedicamentos.btnModificar.setEnabled(true);
            } else if (filaMedicamentoSeleccionado < 0) {
                this.vistaMedicamentos.btnRegistrarMedicamento.setEnabled(true);
                this.vistaMedicamentos.btnEliminar.setEnabled(false);
                this.vistaMedicamentos.btnModificar.setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaMedicamentos.btnRegistrarMedicamento) {
            System.out.println("entra");

            this.vistaRegistrar.setVisible(true);

        }
        if (e.getSource() == this.vistaMedicamentos.btnModificar) {

            if (this.medicamentoSeleccionado != null) {
                this.vistaModificar = new VistaModificarMedicamento();
                this.controladorModificar = new ControladorModificarMedicamento(this.vistaModificar, this, this.medicamentoSeleccionado, this.medicamentoList);

                this.vistaModificar.setVisible(true);
            }

        }

        if (e.getSource() == this.vistaMedicamentos.btnEliminar) {
            eliminarMedicamento(this.medicamentoSeleccionado);
        }
        if (e.getSource() == this.vistaMedicamentos.btnBuscar) {
            buscar();
        }
    }

    public boolean validarBuscarMedicamento(String medicamentoBuscarTxt) {
        medicamentoBuscarTxt.replace(" ", "");
        if (medicamentoBuscarTxt.equals("") || medicamentoBuscarTxt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de busqueda no debe estar vacio,Coloque un nombre válido");
            return false;
        }
        for (int i = 0; i < medicamentoBuscarTxt.length(); i++) {
            if (!Character.isLetter(medicamentoBuscarTxt.charAt(i))) {
                JOptionPane.showMessageDialog(null, "El nombre de medicamento a buscar solo debe contener letras");
                return false;
            }
        }
        return true;
    }

    public void mostrarDatos() {
        DefaultTableModel md = new DefaultTableModel();
        String columnas[] = {"Id", "Nombre", "Cantidad Disponible", "Fecha-caducidad", "Descripcion", "Precio"};
        md.setColumnIdentifiers(columnas);
        this.medicamentoList = this.daoMedicamento.mostrar();
        if(this.medicamentoList.toArray() !=null){
        for (Medicamento m : this.medicamentoList.toArray()) {
            Object datos[] = {m.getIdMedicamento(), m.getNombre(), m.getCantidadDisponible(), m.getFechaCaducidad(), m.getDescripcion(), m.getPrecio()};
            md.addRow(datos);

        }
        }
        this.vistaMedicamentos.tablaMedicamentos.setModel(md);

    }

    public void eliminarMedicamento(Medicamento medicamento) {
        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de eliminar el medicamento: " + medicamento.getNombre() + "?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
        // NO hace falta la  eliminacion desde la listaCicurlar 
        this.medicamentoList.eliminar(medicamento);

        // eliminando desde la bd;
        this.daoMedicamento.delete(medicamento);
        JOptionPane.showMessageDialog(null, "Medicamento: " + medicamento.getNombre() + " Eliminado con exito");
        mostrarDatos();
        this.vistaMedicamentos.btnRegistrarMedicamento.setEnabled(true);
        this.vistaMedicamentos.btnEliminar.setEnabled(false);
        this.vistaMedicamentos.btnModificar.setEnabled(false);
    }
    }

    public void buscar() {
        this.vistaMedicamentos.btnRegistrarMedicamento.setEnabled(true);
        this.vistaMedicamentos.btnEliminar.setEnabled(false);
        this.vistaMedicamentos.btnModificar.setEnabled(false);
        String medicamentoBuscarTxt = this.vistaMedicamentos.txtBuscar.getText();

        if (validarBuscarMedicamento(medicamentoBuscarTxt)) {
            Medicamento medicamentoBuscar = new Medicamento();
            medicamentoBuscar.setNombre(medicamentoBuscarTxt);
            medicamentoBuscar = this.medicamentoList.buscarDato(medicamentoBuscar);
            // si es diferente de nulo es porque si lo encontro con el mismo nombre
            if (medicamentoBuscar != null) {
                JOptionPane.showMessageDialog(null, "Se encontro el medicamento\n" + "Nombre: " + medicamentoBuscar.getNombre() + "\nCantidad: " + medicamentoBuscar.getCantidadDisponible() + "\n" + "Precio: " + medicamentoBuscar.getPrecio() + "\nFecha Vencimiento: " + medicamentoBuscar.getFechaCaducidad() + "\nDescripcion: " + medicamentoBuscar.getDescripcion());

            } else {
                JOptionPane.showMessageDialog(null, "NO Se encontro el medicamento");

            }

        }
        this.vistaMedicamentos.txtBuscar.setText("");
    }

    
   
}
