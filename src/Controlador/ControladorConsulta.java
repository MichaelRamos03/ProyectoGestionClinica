/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.ColaPrioridad;
import Estructuras.Lista;
import Estructuras.ListaDoble;
import Modelo.Consulta;
import Modelo.Expediente;
import Modelo.MedicoEspecialista;
import Modelo.Recepcion;
import ModeloDao.ConsultaDao;
import ModeloDao.ExpedienteDao;
import ModeloDao.MedicoEspecialistaDao;
import ModeloDao.RecepcionDao;
import Vista.VistaConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectoclase.utilidades.Render;

/**
 *
 * @author MINEDUCYT
 */
public class ControladorConsulta extends MouseAdapter implements ActionListener, MouseListener {

    VistaConsulta frm;
    Consulta c;
    Expediente ep;
    MedicoEspecialista me;
    Recepcion re;
    ConsultaDao daoConsulta;
    ExpedienteDao daoExpediente;
    MedicoEspecialistaDao daoMedicoEspecialista;
    RecepcionDao daoRecepcion;
    ColaPrioridad<Recepcion> cola;
    Lista<Consulta> listamost;

    public ControladorConsulta(VistaConsulta frm) {
        this.frm = frm;
        this.daoConsulta = new ConsultaDao();
        this.daoExpediente = new ExpedienteDao();
        this.daoMedicoEspecialista = new MedicoEspecialistaDao();
        this.daoRecepcion = new RecepcionDao();
        this.frm.setVisible(true);
        this.frm.btnAgregar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        this.cola = new ColaPrioridad(4);

        this.frm.tbDatos.addMouseListener(this);
        llenarComboEspecialista();
        llenarComboExpediente();
        llenarComboRecepcion();
        listamost = daoConsulta.selectAll();

        mostrar(listamost);
    }

    private void llenarComboExpediente() {
        ListaDoble<Expediente> tipo = this.daoExpediente.selectAll();
        for (Expediente x : tipo.toArray()) {
            this.frm.comboExpediente.addItem(x);
        }
    }

    private void llenarComboEspecialista() {
        ListaDoble<MedicoEspecialista> lista = this.daoMedicoEspecialista.selectAll();

        for (MedicoEspecialista x : lista.toArray()) {
            this.frm.comboMedico.addItem(x);
        }
    }

    private void llenarComboRecepcion() {
        cola = this.daoRecepcion.mostrar();

        for (Recepcion x : this.cola.toArray()) {
            this.frm.comboRecepcion.addItem(x);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frm.btnAgregar) {
            c = new Consulta();
            ep = new Expediente();
            me = new MedicoEspecialista();
            re = new Recepcion();

            c.setIdConsulta(Integer.parseInt(this.frm.txtId.getText()));
            c.setConsultorio(Integer.parseInt(this.frm.txtConsultorio.getText()));
            c.setDiagnostico(this.frm.txtDiag.getText());
//            ep.setIdExpediente((this.frm.comboExpediente.getSelectedIndex()));
//            c.setExpediente(ep);
//            me.setIdMedicoEspecialista((this.frm.comboMedico.getSelectedIndex()));
//            c.setMedicoEspecialista(me);
            Expediente expedienteSeleccionado = (Expediente) this.frm.comboExpediente.getSelectedItem();
            MedicoEspecialista medicoSeleccionado = (MedicoEspecialista) this.frm.comboMedico.getSelectedItem();
            Recepcion recepcionSeleccionada = (Recepcion) this.frm.comboRecepcion.getSelectedItem();

            c.setExpediente(expedienteSeleccionado);
            c.setMedicoEspecialista(medicoSeleccionado);
            c.setRecepcion(recepcionSeleccionada);

            this.daoConsulta.insert(c);
            mostrar(this.daoConsulta.selectAll());

        } else if (e.getSource() == this.frm.btnEliminar) {
            // Eliminar la consulta
            int idConsulta = Integer.parseInt(this.frm.txtId.getText()); // Obtener el ID de la consulta

            c = new Consulta();
            c.setIdConsulta(idConsulta);

            if (this.daoConsulta.delete(c)) {
                JOptionPane.showMessageDialog(frm, "Consulta eliminada exitosamente.");
                mostrar(this.daoConsulta.selectAll());
            } else {
                JOptionPane.showMessageDialog(frm, "Error al eliminar la consulta.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == this.frm.btnEditar) {
         
            c = new Consulta();

            // Obtén el ID de la consulta desde la vista (sin modificarlo)
            c.setIdConsulta(Integer.parseInt(this.frm.txtId.getText()));

            // Configura los demás campos
            c.setConsultorio(Integer.parseInt(this.frm.txtConsultorio.getText()));
            c.setDiagnostico(this.frm.txtDiag.getText());

            // Obtén los objetos seleccionados en los combo boxes
            Expediente expedienteSeleccionado = (Expediente) this.frm.comboExpediente.getSelectedItem();
            MedicoEspecialista medicoSeleccionado = (MedicoEspecialista) this.frm.comboMedico.getSelectedItem();
            Recepcion recepcionSeleccionada = (Recepcion) this.frm.comboRecepcion.getSelectedItem();

            c.setExpediente(expedienteSeleccionado);
            c.setMedicoEspecialista(medicoSeleccionado);
            c.setRecepcion(recepcionSeleccionada);

            // Llama al método update
            if (this.daoConsulta.update(c)) {
                JOptionPane.showMessageDialog(frm, "Consulta actualizada exitosamente.");
                mostrar(this.daoConsulta.selectAll());
            } else {
                JOptionPane.showMessageDialog(frm, "Error al actualizar la consulta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void mostrar(Lista<Consulta> lista) {

        DefaultTableModel modelo;
        this.frm.tbDatos.setDefaultRenderer(Object.class, new Render());
        modelo = new DefaultTableModel();
        // Títulos de columnas: ID, Consultorio, Diagnóstico, Expediente, Especialidad
        String titulos[] = {"ID", "Consultorio", "Diagnóstico", "Expediente", "Especialidad", "Recepcion"};
        modelo.setColumnIdentifiers(titulos);
        int i = 0;
        ArrayList<Consulta> list = lista.toArray();

        for (Consulta x : list) {
            i++;

            Object datos[] = {
                x.getIdConsulta(),
                x.getConsultorio(),
                x.getDiagnostico(),
                x.getExpediente().getIdExpediente(),
                x.getMedicoEspecialista().getIdMedicoEspecialista(),
                x.getExpediente().getIdExpediente()
            };

            modelo.addRow(datos);
        }

        this.frm.tbDatos.setModel(modelo);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int filaSeleccionada = frm.tbDatos.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Recuperar valores de la fila seleccionada
            int idConsulta = Integer.parseInt(frm.tbDatos.getValueAt(filaSeleccionada, 0).toString());
            int consultorio = Integer.parseInt(frm.tbDatos.getValueAt(filaSeleccionada, 1).toString());
            String diagnostico = frm.tbDatos.getValueAt(filaSeleccionada, 2).toString();
            int idExpediente = Integer.parseInt(frm.tbDatos.getValueAt(filaSeleccionada, 3).toString());
            int idMedico = Integer.parseInt(frm.tbDatos.getValueAt(filaSeleccionada, 4).toString());
            int idRecepcion = Integer.parseInt(frm.tbDatos.getValueAt(filaSeleccionada, 5).toString());

            // Configurar los campos de texto
            frm.txtId.setText(String.valueOf(idConsulta));
            frm.txtConsultorio.setText(String.valueOf(consultorio));
            frm.txtDiag.setText(diagnostico);

            // Seleccionar el expediente correspondiente en el combo
            for (int i = 0; i < frm.comboExpediente.getItemCount(); i++) {
                Expediente expediente = frm.comboExpediente.getItemAt(i);
                if (expediente.getIdExpediente() == idExpediente) {
                    frm.comboExpediente.setSelectedIndex(i);
                    break;
                }
            }

            // Seleccionar el médico correspondiente en el combo
            for (int i = 0; i < frm.comboMedico.getItemCount(); i++) {
                MedicoEspecialista medico = frm.comboMedico.getItemAt(i);
                if (medico.getIdMedicoEspecialista() == idMedico) {
                    frm.comboMedico.setSelectedIndex(i);
                    break;
                }
            }

            // Seleccionar la recepción correspondiente en el combo
            for (int i = 0; i < frm.comboRecepcion.getItemCount(); i++) {
                Recepcion recepcion = frm.comboRecepcion.getItemAt(i);
                if (recepcion.getIdRecepcion() == idRecepcion) {
                    frm.comboRecepcion.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

}
