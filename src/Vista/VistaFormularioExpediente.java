
package Vista;

import utilidades.Fondo;

/**
 *
 * @author Michael Ramos;
 */
public class VistaFormularioExpediente extends javax.swing.JFrame {

  
    public VistaFormularioExpediente() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.Fondo.setBorder(new Fondo("/imagenes/3.jpg"));
    }
    
    public void iniciar() {
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botones = new javax.swing.ButtonGroup();
        Fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfApellido = new RSMaterialComponent.RSTextFieldMaterial();
        tfMedicamentos = new RSMaterialComponent.RSTextFieldMaterial();
        tfTelefono = new RSMaterialComponent.RSTextFieldMaterial();
        tfInformacion = new RSMaterialComponent.RSTextFieldMaterial();
        tfNombre = new RSMaterialComponent.RSTextFieldMaterial();
        dcFechaNacimiento = new newscomponents.RSDateChooserModern();
        rbMujer = new RSMaterialComponent.RSRadioButtonMaterial();
        rbHombre = new RSMaterialComponent.RSRadioButtonMaterial();
        tfAlergias = new RSMaterialComponent.RSTextFieldMaterial();
        tfNotaMedica = new RSMaterialComponent.RSTextFieldMaterial();
        tfTratamientos = new RSMaterialComponent.RSTextFieldMaterial();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 70, 30));

        jLabel2.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel2.setText("Apellido:");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 90, 30));

        jLabel3.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel3.setText("Fecha nacimiento:");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel4.setText("Sexo:");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel5.setText("Telefono:");
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel6.setText("Informacion Medica:");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, -1));

        jLabel7.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel7.setText("Tratamientos:");
        Fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 120, 20));

        jLabel8.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel8.setText("Nota medica:");
        Fondo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 120, 30));

        jLabel9.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel9.setText("Alergias:");
        Fondo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 90, 30));

        jLabel10.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel10.setText("Medicamentos:");
        Fondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, -1, -1));

        tfApellido.setForeground(new java.awt.Color(0, 0, 0));
        tfApellido.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfApellido.setPlaceholder("");
        Fondo.add(tfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 240, 30));

        tfMedicamentos.setForeground(new java.awt.Color(0, 0, 0));
        tfMedicamentos.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfMedicamentos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfMedicamentos.setPlaceholder("");
        Fondo.add(tfMedicamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 590, 220, 30));

        tfTelefono.setForeground(new java.awt.Color(0, 0, 0));
        tfTelefono.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfTelefono.setPlaceholder("");
        Fondo.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 220, 30));

        tfInformacion.setForeground(new java.awt.Color(0, 0, 0));
        tfInformacion.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfInformacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfInformacion.setPlaceholder("");
        Fondo.add(tfInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 220, 30));

        tfNombre.setForeground(new java.awt.Color(0, 0, 0));
        tfNombre.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfNombre.setPhColor(new java.awt.Color(0, 0, 0));
        tfNombre.setPlaceholder("");
        tfNombre.setSelectionColor(new java.awt.Color(0, 0, 0));
        tfNombre.setVelMils(100);
        Fondo.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 240, 30));

        dcFechaNacimiento.setBackground(new java.awt.Color(0, 0, 0));
        Fondo.add(dcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 170, 40));

        rbMujer.setBackground(new java.awt.Color(0, 0, 0));
        rbMujer.setForeground(new java.awt.Color(0, 0, 0));
        rbMujer.setText("Mujer");
        rbMujer.setColorCheck(new java.awt.Color(0, 0, 0));
        rbMujer.setColorUnCheck(new java.awt.Color(0, 0, 0));
        Fondo.add(rbMujer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 110, 30));

        rbHombre.setBackground(new java.awt.Color(0, 0, 0));
        rbHombre.setForeground(new java.awt.Color(0, 0, 0));
        rbHombre.setText("Hombre");
        rbHombre.setColorCheck(new java.awt.Color(0, 0, 0));
        rbHombre.setColorUnCheck(new java.awt.Color(0, 0, 0));
        Fondo.add(rbHombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 110, 30));

        tfAlergias.setForeground(new java.awt.Color(0, 0, 0));
        tfAlergias.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfAlergias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfAlergias.setPlaceholder("");
        Fondo.add(tfAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 220, 30));

        tfNotaMedica.setForeground(new java.awt.Color(0, 0, 0));
        tfNotaMedica.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfNotaMedica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfNotaMedica.setPlaceholder("");
        Fondo.add(tfNotaMedica, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 220, 30));

        tfTratamientos.setForeground(new java.awt.Color(0, 0, 0));
        tfTratamientos.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfTratamientos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfTratamientos.setPlaceholder("");
        Fondo.add(tfTratamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 220, 30));

        btnGuardar.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Fondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 640, 100, 40));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
//            java.util.logging.Logger.getLogger(VistaFormularioExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaFormularioExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaFormularioExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaFormularioExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaFormularioExpediente().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    public javax.swing.ButtonGroup botones;
    public javax.swing.JButton btnGuardar;
    public newscomponents.RSDateChooserModern dcFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public RSMaterialComponent.RSRadioButtonMaterial rbHombre;
    public RSMaterialComponent.RSRadioButtonMaterial rbMujer;
    public RSMaterialComponent.RSTextFieldMaterial tfAlergias;
    public RSMaterialComponent.RSTextFieldMaterial tfApellido;
    public RSMaterialComponent.RSTextFieldMaterial tfInformacion;
    public RSMaterialComponent.RSTextFieldMaterial tfMedicamentos;
    public RSMaterialComponent.RSTextFieldMaterial tfNombre;
    public RSMaterialComponent.RSTextFieldMaterial tfNotaMedica;
    public RSMaterialComponent.RSTextFieldMaterial tfTelefono;
    public RSMaterialComponent.RSTextFieldMaterial tfTratamientos;
    // End of variables declaration//GEN-END:variables
}
