/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Estructuras.ABinarioBusqueda;
import Estructuras.ColaPrioridad;
import Modelo.Consulta;
import Modelo.Recepcion;
import ModeloDao.RecepcionDao;
import Utilidades.PaginaItext;
import Utilidades.PdfItext;
import Vista.VistaFormularioRecepcion;
import Vista.VistaRecepcion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karla
 */
public class ControladorRecepcion extends MouseAdapter implements ActionListener, MouseListener {

    private VistaRecepcion vistaRecepcion;
    private ControladorFormularioRecepcion controladorFormulario;
    private Recepcion recepcionSeleccionada;
    private int filaRecepcionSelect;
    private ColaPrioridad<Recepcion> colaPrioridad;
    private DefaultTableModel md;
    private RecepcionDao recepcionDao;

    public ControladorRecepcion(VistaRecepcion vistaRecepcion) {
        this.vistaRecepcion = vistaRecepcion;
        this.vistaRecepcion.setVisible(true);
        this.vistaRecepcion.setLocationRelativeTo(null);
        this.vistaRecepcion.setDefaultCloseOperation(vistaRecepcion.DISPOSE_ON_CLOSE);
        this.vistaRecepcion.btnAgregarRecepcion.addActionListener(this);
        this.vistaRecepcion.btnEliminarRecepcion.addActionListener(this);
        this.vistaRecepcion.btnEliminarRecepcion.setEnabled(false);
        this.vistaRecepcion.btnModificar.addActionListener(this);
        this.vistaRecepcion.btnModificar.setEnabled(false);
        this.vistaRecepcion.btnBuscarRecepcion.addActionListener(this);
        this.vistaRecepcion.ComboBuscarPrioridad.addActionListener(this);
        this.vistaRecepcion.btnMostrarTodos.addActionListener(this);

        //this.vistaRecepcion.btnReporteConsultas.addActionListener(this);
        this.recepcionDao = new RecepcionDao();
        this.colaPrioridad = new ColaPrioridad(4);

        this.md = new DefaultTableModel();
        this.md.addColumn("id");
        this.md.addColumn("Presion");
        this.md.addColumn("Altura");
        this.md.addColumn("Peso");
        this.md.addColumn("Temperatura");
        this.md.addColumn("Frecuencia Cardiaca");
        this.md.addColumn("Motivo visita");
        this.md.addColumn("Observaciones");
        this.md.addColumn("Empleado encargado");
        this.md.addColumn("Prioridad");

        this.vistaRecepcion.tablaRecepciones.setModel(md);
        this.vistaRecepcion.tablaRecepciones.addMouseListener(this);

        mostrarDatos();
        llenarComboPrioridadesEnRecepcion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaRecepcion.btnAgregarRecepcion) {

            VistaFormularioRecepcion vistaRecepcion = new VistaFormularioRecepcion();
            ControladorFormularioRecepcion controladorFormulario = new ControladorFormularioRecepcion(vistaRecepcion, this, this.colaPrioridad);
        }

        if (e.getSource() == this.vistaRecepcion.btnEliminarRecepcion) {
            eliminarRecepcion(this.recepcionSeleccionada);

        }

        if (e.getSource() == this.vistaRecepcion.btnModificar) {
            if (this.recepcionSeleccionada != null) {
                VistaFormularioRecepcion vistaRecepcion = new VistaFormularioRecepcion();
                ControladorFormularioRecepcion controladorFormulario = new ControladorFormularioRecepcion(vistaRecepcion, this, this.colaPrioridad, this.recepcionSeleccionada);

            }

        }

        if (e.getSource() == this.vistaRecepcion.btnBuscarRecepcion) {
            buscar();
        }
        if (e.getSource() == this.vistaRecepcion.btnMostrarTodos) {
            mostrarDatos();
        }

        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaRecepcion.tablaRecepciones) {
            this.filaRecepcionSelect = this.vistaRecepcion.tablaRecepciones.getSelectedRow();

            if (filaRecepcionSelect >= 0) {
                this.recepcionSeleccionada = new Recepcion();
                //buscando por nombre del medicamento(metodo del compare to)
                int id = (int) this.vistaRecepcion.tablaRecepciones.getValueAt(filaRecepcionSelect, 0);
                this.recepcionSeleccionada.setIdRecepcion(id);
                //int id=Integer.parseInt(this.vistaMedicamentos.tablaMedicamentos.getValueAt(filaMedicamentoSeleccionado,0).toString());
                //obteniendo el medicamento desde el metodo buscarDato
                this.recepcionSeleccionada = this.recepcionDao.buscarRecepcion(id);

                // this.vistaMedicamentos.btnRegistrarMedicamento.setEnabled(false);
                this.vistaRecepcion.btnEliminarRecepcion.setEnabled(true);
                this.vistaRecepcion.btnModificar.setEnabled(true);
            } else if (filaRecepcionSelect < 0) {
                this.vistaRecepcion.btnAgregarRecepcion.setEnabled(true);
                this.vistaRecepcion.btnEliminarRecepcion.setEnabled(false);
                this.vistaRecepcion.btnModificar.setEnabled(false);
            }
        }
    }

    public void mostrarDatos() {
        DefaultTableModel tabla = new DefaultTableModel();

        String columnas[] = {"Id", "Presión (mmHg)", "Altura (m)", "Peso (lbs)", "Temperatura °C", "Frecuencia Cardíaca (lat/min)", "Motivo visita", "Observaciones", "Empleado encargado", "Prioridad"};
        tabla.setColumnIdentifiers(columnas);
        this.colaPrioridad = this.recepcionDao.mostrar();
        if (this.colaPrioridad != null) {
            for (Recepcion r : this.colaPrioridad.toArray()) {
                Object datos[] = {r.getIdRecepcion(), r.getPresion(), r.getAltura(), r.getPeso(), r.getTemperatura(), r.getFrecuenciaCardiaca(), r.getMotivoVisita(), r.getObservaciones(), r.getEmpleado().getNombre() + " " + r.getEmpleado().getApellido(), r.getPrioridad()};
                tabla.addRow(datos);
            }
        }
        this.vistaRecepcion.tablaRecepciones.setModel(tabla);
    }

    public void eliminarRecepcion(Recepcion r) {
        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de eliminar la recepcion: " + r.getIdRecepcion() + "?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {

            // eliminando desde la bd;
            this.recepcionDao.delete(r);
            // JOptionPane.showMessageDialog(null, "Medicamento: " + medicamento.getNombre() + " Eliminado con exito");
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Recepcion", r.getIdRecepcion() + " Eliminado con exito",
                    DesktopNotify.SUCCESS, 5000);
            mostrarDatos();
            this.vistaRecepcion.btnAgregarRecepcion.setEnabled(true);
            this.vistaRecepcion.btnEliminarRecepcion.setEnabled(false);
            this.vistaRecepcion.btnModificar.setEnabled(false);
        }
    }

    public void llenarComboPrioridadesEnRecepcion() {
        this.vistaRecepcion.ComboBuscarPrioridad.removeAllItems();
        this.vistaRecepcion.ComboBuscarPrioridad.addItem("Maxima Urgencia");
        this.vistaRecepcion.ComboBuscarPrioridad.addItem("Alta");
        this.vistaRecepcion.ComboBuscarPrioridad.addItem("Media");
        this.vistaRecepcion.ComboBuscarPrioridad.addItem("Baja");

    }

    public String prioridad(int seleccion) {
        switch (seleccion) {
            case 1:
                return "Alta";
            case 2:
                return "Media";
            case 3:
                return "Baja";
            default:
                return "Maxima Urgencia";
        }
    }

    public void buscar() {
        int seleccion = this.vistaRecepcion.ComboBuscarPrioridad.getSelectedIndex();
        String prioridadBuscar = prioridad(seleccion);
        ABinarioBusqueda<Recepcion> recepcionesPr = this.recepcionDao.buscarTodasRecepcionesPrioridad(prioridadBuscar);

        if (!recepcionesPr.isEmpty()) {
            DefaultTableModel tabla = new DefaultTableModel();

            String columnas[] = {"Id", "Presión (mmHg)", "Altura (m)", "Peso (lbs)", "Temperatura °C", "Frecuencia Cardíaca (lat/min)", "Motivo visita", "Observaciones", "Empleado encargado", "Prioridad"};
            tabla.setColumnIdentifiers(columnas);
            //  this.colaPrioridad=this.recepcionDao.mostrar();
            for (Object r : recepcionesPr.PostOrdenIDN()) {
                Recepcion r1 = (Recepcion) r;
                Object datos[] = {r1.getIdRecepcion(), r1.getPresion(), r1.getAltura(), r1.getPeso(), r1.getTemperatura(), r1.getFrecuenciaCardiaca(), r1.getMotivoVisita(), r1.getObservaciones(), r1.getEmpleado().getNombre() + " " + r1.getEmpleado().getApellido(), r1.getPrioridad()};
                tabla.addRow(datos);
            }

            this.vistaRecepcion.tablaRecepciones.setModel(tabla);
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("Recepciones con prioridad: " + prioridadBuscar, "Encontradas con exito",
                    DesktopNotify.SUCCESS, 6000);

        } else {
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Recepciones con prioridad: " + prioridadBuscar, "No se encontraron en el sistema",
                    DesktopNotify.INFORMATION, 6000);

        }
    }

    // para el reporte (cambiarlo a vista de consultas)
    private void pdf() {
        try {
             if(this.recepcionDao.getConsultasPDF().toArray()!=null){
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Reporte_Consultas.pdf"));
            document.open();

           
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            String fechaActual = formatoFecha.format(new Date());

           
            document.add(new Paragraph("Reporte de Consultas por sus ingresos de cada especialidad", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            document.add(new Paragraph("Fecha: " + fechaActual + "\n\n", FontFactory.getFont(FontFactory.HELVETICA, 12)));

           
            PdfPTable tabla = new PdfPTable(2); 
            tabla.addCell("Especialidad");
            tabla.addCell("Ingresos");

          
            for (Consulta c : this.recepcionDao.getConsultasPDF().toArray()) {
                tabla.addCell(c.getMedicoEspecialista().getIdEspecialidad().getEspecialidad());
                tabla.addCell(String.valueOf(c.getPrecio()));
            }
           
           
            document.add(tabla);
            document.close();

           
            Desktop.getDesktop().open(new File("Reporte_Consultas.pdf"));
             }else{
                 DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Reporete sin consultas","No se encontraron consultas registradas",
                    DesktopNotify.INFORMATION, 5000);
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
