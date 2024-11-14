

package Controlador;

import Estructuras.ListaDoble;
import Modelo.Expediente;
import ModeloDao.ExpedienteDao;
import Vista.VistaConsultaExpediente;
import Vista.VistaFormularioExpediente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import proyectoclase.utilidades.Render;

/**
 *
 * @author Michael Ramos;
**/
public class ControladorConsultaExpediente extends MouseAdapter implements ActionListener,MouseListener{

    VistaConsultaExpediente consultaExpediente;
    Expediente expedienteSeleccionado;
    ExpedienteDao daoExpediente;
    

    public ControladorConsultaExpediente(VistaConsultaExpediente consultaExpediente) {
        this.consultaExpediente = consultaExpediente;
        this.daoExpediente = new ExpedienteDao();
        this.consultaExpediente.btnAgregar.addActionListener(this);
        this.consultaExpediente.btnModificar.addActionListener(this);
        this.consultaExpediente.btnEliminar.addActionListener(this);
        this.consultaExpediente.tbDatos.addMouseListener(this); 
        
        mostrar(this.daoExpediente.selectAll());
    }
    
    public void mostrar(ListaDoble<Expediente> lista){
    
        DefaultTableModel modelo;
        this.consultaExpediente .tbDatos.setDefaultRenderer(Object.class, new Render());
        modelo = new DefaultTableModel();
        String titulos[] = {"NOMBRE","APELLIDO","FECHA DE NACIMIENTO","SEXO","TELEFONO","INFORMACION MEDICA","TRATAMIENTOS","NOTA DEL MEDICO","ALERGIAS","MEDICAMENTOS"};
        modelo.setColumnIdentifiers(titulos);
        int i = 0;
        
        for (Expediente x : lista.toArray()) {
            i++;
            Object datos[] = { i, x.getNombre(), x.getApellido(), x.getFechaNacimiento(), x.getSexo(), x.getTelefono(), x.getInformacionMedica(), x.getTratamiento() ,x.getNotaMedica(), x.getAlergias(), x.getMedicamentos()};
            modelo.addRow(datos);
        }
        this.consultaExpediente.tbDatos.setModel(modelo);
    }
    
    private void modificar(){
        if (this.expedienteSeleccionado != null) {
            VistaFormularioExpediente frm = new VistaFormularioExpediente();
            ControladorFormularioExpediente ctl= new ControladorFormularioExpediente(this,frm, expedienteSeleccionado);
            frm.iniciar();
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
            ControladorFormularioExpediente ctlExpediente = new ControladorFormularioExpediente(this,frmExpediente);
            frmExpediente.iniciar();
        } else if (e.getSource() == this.consultaExpediente.btnModificar) {
            modificar();
        }
    }



}
