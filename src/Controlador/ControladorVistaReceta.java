package Controlador;

import Estructuras.ListaDoble;
import Modelo.Receta;
import ModeloDao.RecetaDao;
import Utilidades.Render;
import Vista.VistaFomularioReceta;
import Vista.VistaReceta;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaby Laínez
 */
public class ControladorVistaReceta extends MouseAdapter implements ActionListener,MouseListener{

    VistaReceta vistaReceta;
    RecetaDao daoReceta;
    Receta seleccionReceta;

    public ControladorVistaReceta(VistaReceta vistaReceta) {
        this.vistaReceta = vistaReceta;
        this.daoReceta = new RecetaDao();
        
        this.vistaReceta.btnAgregarReceta.addActionListener(this);
        this.vistaReceta.btnEditar.addActionListener(this);
        this.vistaReceta.btnEliminar.addActionListener(this);
        this.vistaReceta.tblReceta.addMouseListener(this);
         mostrarReceta(this.daoReceta.selectAll());
    }
    
    
    
     public void mostrarReceta(ListaDoble<Receta>lista){
        
        DefaultTableModel modelo;
        this.vistaReceta.tblReceta.setDefaultRenderer(Object.class, new Render());
        modelo = new DefaultTableModel();
        String titulo[]={"ID RECETA","CANTIDAD","DOSIS","ID CONSULTA","DIAGNOSTICO","   ID EXPEDIENTE   ","NOMBRE"};
        modelo.setColumnIdentifiers(titulo);
      
        
        for (Receta x : lista.toArray()) {
           
            Object dato[]={x.getIdReceta(),x.getCantidad(),x.getDosis(),x.getConsulta().getIdConsulta(),x.getConsulta().getDiagnostico(),x.getConsulta().getExpediente().getIdExpediente(),x.getConsulta().getExpediente().getNombre()};
            modelo.addRow(dato);
        }
        this.vistaReceta.tblReceta.setModel(modelo);
        
    }
    
      private void eliminar() {

        int op = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar"
                + this.seleccionReceta.getIdReceta());

        if (this.daoReceta.delete(seleccionReceta)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("OK", "Registro eliminado",
                    DesktopNotify.SUCCESS, 3000);
             mostrarReceta(this.daoReceta.selectAll());
           
        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No se pudo eliminar",
                    DesktopNotify.ERROR, 3000);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaReceta.tblReceta) {
            ListaDoble<Receta> lista = this.daoReceta.selectAll();
            int colum = this.vistaReceta.tblReceta.getColumnModel().getColumnIndexAtX(e.getX());
            int row = this.vistaReceta.tblReceta.getSelectedRow();
            Object value = this.vistaReceta.tblReceta.getValueAt(row, colum);
            
            if (row >= 0) {
                this.seleccionReceta = lista.get(row);
                System.out.println("Fila seleccionada: " + row);
                System.out.println("Valor de la celda seleccionada: " + value);
                System.out.println("USUARIO seleccionado: " + this.seleccionReceta);
            } else {
         
            }
        }
    }
      
      
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaReceta.btnAgregarReceta){
            VistaFomularioReceta vr = new VistaFomularioReceta();
            ControladorFormularioReceta cr = new ControladorFormularioReceta(this,vr);
            vr.setVisible(true);
        }if(e.getSource() == this.vistaReceta.btnEliminar){
            eliminar();
            
        }
    }

}
