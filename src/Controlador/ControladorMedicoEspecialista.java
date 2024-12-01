
package Controlador;
import Estructuras.ListaDoble;
import Vista.VistaMedicoEspecialista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author equipo
 */
public class ControladorMedicoEspecialista extends MouseAdapter implements ActionListener, MouseListener {

    private VistaMedicoEspecialista vistaMed;
    private DefaultTableModel md;
    private ListaDoble listaDoble;

    public ControladorMedicoEspecialista(VistaMedicoEspecialista vistaMed) {
        this.vistaMed = vistaMed;
        this.vistaMed.setVisible(true);
        this.vistaMed.setDefaultCloseOperation(vistaMed.DISPOSE_ON_CLOSE);
        this.vistaMed.setLocationRelativeTo(null);
        this.listaDoble = new ListaDoble();
        this.vistaMed.btnEliminar.addActionListener(this);
        this.vistaMed.btnGuardar.addActionListener(this);
        this.vistaMed.btnModificar.addActionListener(this);
        this.vistaMed.btnMostrar.addActionListener(this);
        this.vistaMed.btnSalir.addActionListener(this);
        this.vistaMed.btnBuscar.addActionListener(this);
        this.vistaMed.cmbxEmpleado.addActionListener(this);
        this.vistaMed.cmbxEspecialidad.addActionListener(this);
        this.vistaMed.tfBuscar.addActionListener(this);
        this.vistaMed.tfId.addActionListener(this);

        this.md = new DefaultTableModel();
        
        this.md.addColumn("ID MEDICO");
        this.md.addColumn("DUI");
        this.md.addColumn("NOMBRE");
        this.md.addColumn("APELLIDO");
        this.md.addColumn("ESPECIALIDAD");
        this.md.addColumn("ESTADO");
        this.md.addColumn("CORREO");
        
                this.vistaMed.medTabla.setModel(md);
        this.vistaMed.medTabla.addMouseListener(this);

        mostrarDatos();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaMed.btnGuardar) {

        } else if (e.getSource() == this.vistaMed.btnModificar) {

        }
    }

    private void mostrarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
