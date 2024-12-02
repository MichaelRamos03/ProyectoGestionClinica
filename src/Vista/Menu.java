
package Vista;

import Controlador.ControladorConsulta;
import Controlador.ControladorConsultaEmpleado;
import Controlador.ControladorConsultaEntregaMedicina;
import Controlador.ControladorConsultaExpediente;
import Controlador.ControladorConsultaVistaEspecialidad;
import Controlador.ControladorMedicamentos;
import Controlador.ControladorRecepcion;
import Controlador.ControladorRol;
import javax.swing.JFrame;
import Utilidades.Fondo;

/**
 *
 * @author Michael Ramos;
 */
public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(this);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.Fondo.setBorder(new Fondo("/imagenes/7.jpg"));
        this.setContentPane(Fondo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        rSLabelHora1 = new rojeru_san.componentes.RSLabelHora();
        rSLabelFecha1 = new rojeru_san.componentes.RSLabelFecha();
        jMenuBar1 = new javax.swing.JMenuBar();
        Rol = new javax.swing.JMenu();
        Especialidad = new javax.swing.JMenu();
        Expediente = new javax.swing.JMenu();
        Medicamento = new javax.swing.JMenu();
        Recepcion = new javax.swing.JMenu();
        Empleados = new javax.swing.JMenu();
        Consultas = new javax.swing.JMenu();
        Farmacia = new javax.swing.JMenu();
        Usuarios = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelHora1.setForeground(new java.awt.Color(0, 0, 0));
        rSLabelHora1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N

        rSLabelFecha1.setForeground(new java.awt.Color(0, 0, 0));
        rSLabelFecha1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 717, Short.MAX_VALUE)
                .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addGap(0, 408, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSLabelHora1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(rSLabelFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 490));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1203, 70));

        Rol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        Rol.setForeground(new java.awt.Color(51, 51, 51));
        Rol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/administracion.png"))); // NOI18N
        Rol.setText("Rol");
        Rol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rol.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        Rol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Rol.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Rol.setPreferredSize(new java.awt.Dimension(110, 40));
        Rol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RolMousePressed(evt);
            }
        });
        jMenuBar1.add(Rol);

        Especialidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        Especialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consulta.png"))); // NOI18N
        Especialidad.setText("Especialidad");
        Especialidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Especialidad.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        Especialidad.setPreferredSize(new java.awt.Dimension(140, 40));
        Especialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EspecialidadMousePressed(evt);
            }
        });
        jMenuBar1.add(Especialidad);

        Expediente.setBackground(new java.awt.Color(0, 0, 0));
        Expediente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        Expediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/expediente.png"))); // NOI18N
        Expediente.setText("Expediente");
        Expediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Expediente.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        Expediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExpedienteMousePressed(evt);
            }
        });
        jMenuBar1.add(Expediente);

        Medicamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        Medicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/medicamentos.png"))); // NOI18N
        Medicamento.setText("Medicamento");
        Medicamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Medicamento.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        Medicamento.setPreferredSize(new java.awt.Dimension(130, 40));
        Medicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MedicamentoMousePressed(evt);
            }
        });
        jMenuBar1.add(Medicamento);

        Recepcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        Recepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escritorio.png"))); // NOI18N
        Recepcion.setText("Recepción");
        Recepcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Recepcion.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        Recepcion.setPreferredSize(new java.awt.Dimension(130, 40));
        Recepcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RecepcionMousePressed(evt);
            }
        });
        jMenuBar1.add(Recepcion);

        Empleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        Empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/empleado.png"))); // NOI18N
        Empleados.setText("Empleados");
        Empleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Empleados.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        Empleados.setPreferredSize(new java.awt.Dimension(140, 40));
        Empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EmpleadosMousePressed(evt);
            }
        });
        jMenuBar1.add(Empleados);

        Consultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        Consultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consulta_1.png"))); // NOI18N
        Consultas.setText("Consulta");
        Consultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Consultas.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        Consultas.setPreferredSize(new java.awt.Dimension(140, 40));
        Consultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ConsultasMousePressed(evt);
            }
        });
        jMenuBar1.add(Consultas);

        Farmacia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        Farmacia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/farmacia.png"))); // NOI18N
        Farmacia.setText("Farmacia");
        Farmacia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Farmacia.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        Farmacia.setPreferredSize(new java.awt.Dimension(140, 40));
        Farmacia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FarmaciaMousePressed(evt);
            }
        });
        jMenuBar1.add(Farmacia);

        Usuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        Usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nueva-cuenta.png"))); // NOI18N
        Usuarios.setText("Usuario");
        Usuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Usuarios.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        Usuarios.setPreferredSize(new java.awt.Dimension(140, 40));
        jMenuBar1.add(Usuarios);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RolMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RolMousePressed
        VistaRoles frm = new VistaRoles();
        ControladorRol ctrl = new ControladorRol(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_RolMousePressed

    private void ExpedienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpedienteMousePressed
        VistaConsultaExpediente v = new VistaConsultaExpediente();
        ControladorConsultaExpediente c = new ControladorConsultaExpediente(v);
        v.iniciar();
    }//GEN-LAST:event_ExpedienteMousePressed

    private void MedicamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicamentoMousePressed
        VistaCrudMedicamentos vista = new VistaCrudMedicamentos();
        ControladorMedicamentos controlador = new ControladorMedicamentos(vista);
    }//GEN-LAST:event_MedicamentoMousePressed

    private void RecepcionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecepcionMousePressed
        
        VistaRecepcion vistaRecepcion= new VistaRecepcion();
        ControladorRecepcion controladorRecepcion= new ControladorRecepcion(vistaRecepcion);
    }//GEN-LAST:event_RecepcionMousePressed

    private void EmpleadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadosMousePressed
        VistaConsultaEmpleado v = new VistaConsultaEmpleado();
        ControladorConsultaEmpleado  c = new ControladorConsultaEmpleado(v);
        v.iniciar();
    }//GEN-LAST:event_EmpleadosMousePressed

    private void FarmaciaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FarmaciaMousePressed
        VistaConsultaEntregaMedicina vista = new VistaConsultaEntregaMedicina();
        ControladorConsultaEntregaMedicina ct = new ControladorConsultaEntregaMedicina(vista);
        vista.iniciar();
    }//GEN-LAST:event_FarmaciaMousePressed

    private void ConsultasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsultasMousePressed
        VistaConsulta frm = new VistaConsulta();
        ControladorConsulta ctrl = new ControladorConsulta(frm);
    }//GEN-LAST:event_ConsultasMousePressed

    private void EspecialidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EspecialidadMousePressed
         VistaEspecialidad v = new VistaEspecialidad();
        ControladorConsultaVistaEspecialidad c = new ControladorConsultaVistaEspecialidad(v);
        v.iniciar();
    }//GEN-LAST:event_EspecialidadMousePressed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Menu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenu Empleados;
    private javax.swing.JMenu Especialidad;
    private javax.swing.JMenu Expediente;
    private javax.swing.JMenu Farmacia;
    private javax.swing.JPanel Fondo;
    private javax.swing.JMenu Medicamento;
    private javax.swing.JMenu Recepcion;
    public javax.swing.JMenu Rol;
    private javax.swing.JMenu Usuarios;
    private javax.swing.JMenuBar jMenuBar1;
    private rojeru_san.componentes.RSLabelFecha rSLabelFecha1;
    private rojeru_san.componentes.RSLabelHora rSLabelHora1;
    // End of variables declaration//GEN-END:variables
}
