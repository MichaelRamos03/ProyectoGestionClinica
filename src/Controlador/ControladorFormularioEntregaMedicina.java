

package Controlador;

import Estructuras.ListaCircular;
import Estructuras.ListaDoble;
import Modelo.Empleado;
import Modelo.EntregaMedicina;
import Modelo.Medicamento;
import Modelo.Receta;
import ModeloDao.EmpleadoDao;
import ModeloDao.EntregaMedicinaDao;
import ModeloDao.MedicamentoDao;
import ModeloDao.RecetaDao;
import Vista.VistaFormularioEntregaMedicina;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

/**
 *
 * @author Michael Ramos;
**/
public class ControladorFormularioEntregaMedicina extends MouseAdapter implements ActionListener, MouseListener{

    VistaFormularioEntregaMedicina frmEntregaMedicina;
    ControladorConsultaEntregaMedicina ctr;
    EntregaMedicinaDao daoEntregarMedicina;
    EntregaMedicina entrgrega, entregaSeleccionada;
    EmpleadoDao daoEmpleado;
    MedicamentoDao daoMedicamento;
    RecetaDao daoReceta;

    public ControladorFormularioEntregaMedicina( ControladorConsultaEntregaMedicina ctr,VistaFormularioEntregaMedicina frmEntregaMedicina) {
        this.frmEntregaMedicina = frmEntregaMedicina;
        this.ctr = ctr;
        daoEntregarMedicina = new EntregaMedicinaDao();
        this.daoEmpleado = new EmpleadoDao();
        this.daoMedicamento = new MedicamentoDao();
        this.daoReceta = new RecetaDao();
        entregaSeleccionada = null;
        this.frmEntregaMedicina.btnGuardar.addActionListener(this);
        llenarComboMedicamento();
        llenarComboReceta();
        llenarComboEmpleado();
    }
    
    public ControladorFormularioEntregaMedicina( ControladorConsultaEntregaMedicina ctr,VistaFormularioEntregaMedicina frmEntregaMedicina, EntregaMedicina entregaSeleccionada) {
        this.frmEntregaMedicina = frmEntregaMedicina;
        this.ctr = ctr;
        daoEntregarMedicina = new EntregaMedicinaDao();
        this.daoEmpleado = new EmpleadoDao();
        this.daoMedicamento = new MedicamentoDao();
        this.daoReceta = new RecetaDao();
        this.entregaSeleccionada = entregaSeleccionada;
        this.frmEntregaMedicina.btnGuardar.addActionListener(this);
        llenarComboMedicamento();
        llenarComboReceta();
        llenarComboEmpleado();
        llenarVista();
    }
    
     public void guardar() {        
        if (this.frmEntregaMedicina.cbMedicamento.getSelectedIndex() != 0     
                && this.frmEntregaMedicina.cbEmpleado.getSelectedIndex() != 0                
                && this.frmEntregaMedicina.cbReceta.getSelectedIndex() != 0) {

            if (this.entregaSeleccionada == null) {
               nuevaEntrega();
            } else {
                editar();
            }

        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Faltan Datos o Inserte datos validos",
                    DesktopNotify.ERROR, 3000);
        }
    }
     
      public void nuevaEntrega() {
          ListaDoble<Empleado> lista = this.daoEmpleado.selectAllTo("dui", this.frmEntregaMedicina.cbEmpleado.getSelectedItem().toString());
          ListaDoble<Receta> listaRec = this.daoReceta.selectAllTo("id_receta", this.frmEntregaMedicina.cbReceta.getSelectedItem().toString());
          ListaCircular<Medicamento> listaMed = this.daoMedicamento.selectAllTo("nombre", this.frmEntregaMedicina.cbMedicamento.getSelectedItem().toString());

        this.entrgrega = new EntregaMedicina(
                new Medicamento(listaMed.get(0).getIdMedicamento(),this.frmEntregaMedicina.cbMedicamento.getSelectedItem().toString()),
                new Receta(listaRec.get(0).getIdReceta(),Integer.parseInt(this.frmEntregaMedicina.cbReceta.getSelectedItem().toString())),
                new Empleado(lista.get(0).getIdEmpleado(), this.frmEntregaMedicina.cbEmpleado.getSelectedItem().toString())

        );

        if (this.daoEntregarMedicina.insert(entrgrega)) {
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("exito", "Entrega guardada",
                    DesktopNotify.ERROR, 3000);

            this.frmEntregaMedicina.dispose();
            this.ctr.mostrar(daoEntregarMedicina.selectAll());

            this.ctr.consultaEntregaMedicina.btnAgregar.setEnabled(true);
            this.ctr.consultaEntregaMedicina.btnEditar.setEnabled(true);
            this.ctr.consultaEntregaMedicina.btnEliminar.setEnabled(true);
            this.entregaSeleccionada = null;

        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "No guardo",
                    DesktopNotify.ERROR, 3000);

        }
    }
      
    private void editar(){
        
        ListaDoble<Empleado> lista = this.daoEmpleado.selectAllTo("dui", this.frmEntregaMedicina.cbEmpleado.getSelectedItem().toString());
        ListaDoble<Receta> listaRec = this.daoReceta.selectAllTo("id_receta", this.frmEntregaMedicina.cbReceta.getSelectedItem().toString());
        ListaCircular<Medicamento> listaMed = this.daoMedicamento.selectAllTo("nombre", this.frmEntregaMedicina.cbMedicamento.getSelectedItem().toString());
        
        this.entregaSeleccionada.setMedicamento(new Medicamento(listaMed.get(0).getIdMedicamento(),this.frmEntregaMedicina.cbMedicamento.getSelectedItem().toString()));
        this.entregaSeleccionada.setReceta( new Receta(listaRec.get(0).getIdReceta(),Integer.parseInt(this.frmEntregaMedicina.cbReceta.getSelectedItem().toString())));
        this.entregaSeleccionada.setEmpleado(new Empleado(lista.get(0).getIdEmpleado(), this.frmEntregaMedicina.cbEmpleado.getSelectedItem().toString()));
        
         if (daoEntregarMedicina.update(entregaSeleccionada)) {
                DesktopNotify.setDefaultTheme(NotifyTheme.Green);
                DesktopNotify.showDesktopMessage("exito", "Actualizado",
                        DesktopNotify.ERROR, 3000);

                this.frmEntregaMedicina.dispose();
                this.ctr.mostrar(this.daoEntregarMedicina.selectAll());
            } else {
                DesktopNotify.setDefaultTheme(NotifyTheme.Red);
                DesktopNotify.showDesktopMessage("Error", "No guardo",
                        DesktopNotify.ERROR, 3000);
            }
    
    }
    
    private void llenarVista(){
        this.frmEntregaMedicina.cbMedicamento.setSelectedItem(this.entregaSeleccionada.getMedicamento().getNombre());
        this.frmEntregaMedicina.cbReceta.setSelectedItem(this.entregaSeleccionada.getReceta().getIdReceta());
        this.frmEntregaMedicina.cbEmpleado.setSelectedItem(this.entregaSeleccionada.getEmpleado().getDui());
    }
      
    public void llenarComboEmpleado(){
          ListaDoble<Empleado> lista = daoEmpleado.selectAll();
         for (Empleado x : lista.toArray()) {
            this.frmEntregaMedicina.cbEmpleado.addItem(x.getDui());
        }
    }
    
    public void llenarComboReceta(){
          ListaDoble<Receta> lista = daoReceta.selectAll();
         for (Receta x : lista.toArray()) {
            this.frmEntregaMedicina.cbReceta.addItem(x.getIdReceta());
        } 
    }
      
    public void llenarComboMedicamento(){
         ListaCircular<Medicamento> lista = daoMedicamento.mostrar();
         for (Medicamento x : lista.toArray()) {
            this.frmEntregaMedicina.cbMedicamento.addItem(x.getNombre());
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmEntregaMedicina.btnGuardar) {
            guardar();
        }
    }

}
