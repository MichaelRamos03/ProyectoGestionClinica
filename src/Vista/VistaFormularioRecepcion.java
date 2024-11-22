/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Empleado;
import utilidades.Fondo;

/**
 *
 * @author karla
 */
public class VistaFormularioRecepcion extends javax.swing.JFrame {

    /**
     * Creates new form VistaRegistarRecepcion
     */
    public VistaFormularioRecepcion() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.jPanel1.setBorder(new Fondo("/imagenes/FondoFormularioRecepcion.jpg"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIdRecepcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboEnfermera = new javax.swing.JComboBox<>();
        txtPresion = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFrecuenciaCardiaca = new javax.swing.JTextField();
        txtTemperatura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaMotivoVisita = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaObservaciones = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        ComboPrioridades = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtIdRecepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 80, -1));

        jLabel1.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Prioridad");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Enfermera Encargada");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, -1, -1));

        jPanel1.add(ComboEnfermera, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, -1, -1));

        txtPresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPresionActionPerformed(evt);
            }
        });
        jPanel1.add(txtPresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 75, -1));
        jPanel1.add(txtAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 80, -1));

        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });
        jPanel1.add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 75, -1));

        jLabel3.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Id Recepcion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Presion (mmHg)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Altura (m)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Peso (lbs)");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Temperatura °C ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Frecuencia Cardiaca (lat/min)");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));

        txtFrecuenciaCardiaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFrecuenciaCardiacaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFrecuenciaCardiaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 70, -1));
        jPanel1.add(txtTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 80, -1));

        jLabel9.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Motivo visita");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        textAreaMotivoVisita.setColumns(20);
        textAreaMotivoVisita.setRows(5);
        jScrollPane1.setViewportView(textAreaMotivoVisita);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 150, 70));

        jLabel10.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Observaciones");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));

        textAreaObservaciones.setColumns(20);
        textAreaObservaciones.setRows(5);
        jScrollPane2.setViewportView(textAreaObservaciones);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 160, 70));

        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Registro de Recepcion");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        ComboPrioridades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(ComboPrioridades, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPresionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresionActionPerformed

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoActionPerformed

    private void txtFrecuenciaCardiacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFrecuenciaCardiacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFrecuenciaCardiacaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VistaFormularioRecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaFormularioRecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaFormularioRecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaFormularioRecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaFormularioRecepcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<Empleado> ComboEnfermera;
    public javax.swing.JComboBox<String> ComboPrioridades;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea textAreaMotivoVisita;
    public javax.swing.JTextArea textAreaObservaciones;
    public javax.swing.JTextField txtAltura;
    public javax.swing.JTextField txtFrecuenciaCardiaca;
    public javax.swing.JTextField txtIdRecepcion;
    public javax.swing.JTextField txtPeso;
    public javax.swing.JTextField txtPresion;
    public javax.swing.JTextField txtTemperatura;
    // End of variables declaration//GEN-END:variables
}
