
package Vista;

import Controlador.ControladorConsultaExpediente;
import Controlador.ControladorMedicamentos;
import Controlador.ControladorRol;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import utilidades.Fondo;

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
        jMenuBar1 = new javax.swing.JMenuBar();
        menuRol = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        menuExpediente = new javax.swing.JMenu();
        menuMedicamento = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1190, 841));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 490));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));

        menuRol.setBorder(null);
        menuRol.setForeground(new java.awt.Color(51, 51, 51));
        menuRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/administracion.png"))); // NOI18N
        menuRol.setText("Rol");
        menuRol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuRol.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        menuRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuRol.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        menuRol.setPreferredSize(new java.awt.Dimension(110, 40));
        menuRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuRolMousePressed(evt);
            }
        });
        jMenuBar1.add(menuRol);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consulta.png"))); // NOI18N
        jMenu4.setText("Especialidad");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu4.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(140, 40));
        jMenuBar1.add(jMenu4);

        menuExpediente.setBackground(new java.awt.Color(0, 0, 0));
        menuExpediente.setBorder(null);
        menuExpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/expediente.png"))); // NOI18N
        menuExpediente.setText("Expediente");
        menuExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuExpediente.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        menuExpediente.setPreferredSize(new java.awt.Dimension(130, 40));
        menuExpediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuExpedienteMousePressed(evt);
            }
        });
        jMenuBar1.add(menuExpediente);

        menuMedicamento.setBorder(null);
        menuMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/medicamentos.png"))); // NOI18N
        menuMedicamento.setText("Medicamento");
        menuMedicamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuMedicamento.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        menuMedicamento.setPreferredSize(new java.awt.Dimension(130, 40));
        menuMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuMedicamentoMousePressed(evt);
            }
        });
        jMenuBar1.add(menuMedicamento);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuRolMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRolMousePressed
        VistaRoles frm = new VistaRoles();
        ControladorRol ctrl = new ControladorRol(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_menuRolMousePressed

    private void menuExpedienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuExpedienteMousePressed
        VistaConsultaExpediente v = new VistaConsultaExpediente();
        ControladorConsultaExpediente c = new ControladorConsultaExpediente(v);
        v.iniciar();
    }//GEN-LAST:event_menuExpedienteMousePressed

    private void menuMedicamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMedicamentoMousePressed
        VistaCrudMedicamentos vista = new VistaCrudMedicamentos();
        ControladorMedicamentos controlador = new ControladorMedicamentos(vista);
    }//GEN-LAST:event_menuMedicamentoMousePressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuExpediente;
    private javax.swing.JMenu menuMedicamento;
    private javax.swing.JMenu menuRol;
    // End of variables declaration//GEN-END:variables
}
