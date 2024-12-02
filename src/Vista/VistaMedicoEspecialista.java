/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import Utilidades.Fondo;

/**
 *
 * @author equipo
 */
public class VistaMedicoEspecialista extends javax.swing.JFrame {

    /**
     * Creates new form VistaMedicoEspecialista
     */
    public VistaMedicoEspecialista() {
        initComponents();
         this.setLocationRelativeTo(this);
        this.panelMedico.setBorder(new Fondo("/imagenes/medico2.jpg"));
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMedico = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfId = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbxEspecialidad = new javax.swing.JComboBox<>();
        cmbxEmpleado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        medTabla = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMedico.setBackground(new java.awt.Color(255, 255, 255));
        panelMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                panelMedicoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Medico Especialista");

        jLabel2.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel2.setText("id:");

        tfId.setForeground(new java.awt.Color(0, 0, 0));
        tfId.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfId.setPhColor(new java.awt.Color(0, 0, 0));
        tfId.setPlaceholder("");
        tfId.setSelectionColor(new java.awt.Color(0, 0, 0));
        tfId.setVelMils(100);
        tfId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfIdKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel3.setText("Especialidad:");

        jLabel4.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel4.setText("Empleados:");

        cmbxEspecialidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbxEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cirujano", "Dentista", "Anestesiologo" }));
        cmbxEspecialidad.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cmbxEspecialidad.setDoubleBuffered(true);
        cmbxEspecialidad.setMaximumSize(new java.awt.Dimension(32807, 32767));
        cmbxEspecialidad.setMinimumSize(new java.awt.Dimension(55, 25));
        cmbxEspecialidad.setPreferredSize(new java.awt.Dimension(290, 42));

        cmbxEmpleado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbxEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Michael", "Gaby", "Nelson" }));
        cmbxEmpleado.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        cmbxEmpleado.setDoubleBuffered(true);
        cmbxEmpleado.setMaximumSize(new java.awt.Dimension(32807, 32767));
        cmbxEmpleado.setMinimumSize(new java.awt.Dimension(55, 25));
        cmbxEmpleado.setPreferredSize(new java.awt.Dimension(290, 42));

        medTabla.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        medTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(medTabla);

        btnAgregar.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnModificar.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnEliminar.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSalir.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelMedicoLayout = new javax.swing.GroupLayout(panelMedico);
        panelMedico.setLayout(panelMedicoLayout);
        panelMedicoLayout.setHorizontalGroup(
            panelMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMedicoLayout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addGroup(panelMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMedicoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMedicoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelMedicoLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panelMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelMedicoLayout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51))
        );
        panelMedicoLayout.setVerticalGroup(
            panelMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedicoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(panelMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(cmbxEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(panelMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdKeyTyped
       this.tfId.setText(this.tfId.getText().toUpperCase()); 
       char c = evt.getKeyChar(); if (!Character.isLetterOrDigit(c) && c != ' ') { evt.consume();
       this.tfId.setBackground(Color.CYAN); this.tfId.setBorder(BorderFactory.createLineBorder(Color.red));
       } else { this.tfId.setBackground(Color.white); 
               this.tfId.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215), 1)); }
    }//GEN-LAST:event_tfIdKeyTyped

    private void panelMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelMedicoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_panelMedicoKeyTyped

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(VistaMedicoEspecialista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaMedicoEspecialista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaMedicoEspecialista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaMedicoEspecialista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaMedicoEspecialista().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<Object> cmbxEmpleado;
    public javax.swing.JComboBox<Object> cmbxEspecialidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable medTabla;
    public javax.swing.JPanel panelMedico;
    public RSMaterialComponent.RSTextFieldMaterial tfId;
    // End of variables declaration//GEN-END:variables
}
