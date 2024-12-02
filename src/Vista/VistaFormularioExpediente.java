
package Vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import utilidades.Fondo;

/**
 *
 * @author Michael Ramos;
 */
public class VistaFormularioExpediente extends javax.swing.JFrame {

  
    public VistaFormularioExpediente() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.Fondo.setBorder(new Fondo("/imagenes/3.jpg"));
    }
    
    public void iniciar() {
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botones = new javax.swing.ButtonGroup();
        textField1 = new necesario.TextField();
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
        lbError = new javax.swing.JLabel();

        textField1.setText("textField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 70, 30));

        jLabel2.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel2.setText("Apellido:");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 90, 30));

        jLabel3.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel3.setText("Fecha nacimiento:");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel4.setText("Sexo:");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel5.setText("Telefono:");
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel6.setText("Informacion Medica:");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel7.setText("Tratamientos:");
        Fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 120, 20));

        jLabel8.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel8.setText("Nota medica:");
        Fondo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 120, 30));

        jLabel9.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel9.setText("Alergias:");
        Fondo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 90, 30));

        jLabel10.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel10.setText("Medicamentos:");
        Fondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, -1, -1));

        tfApellido.setForeground(new java.awt.Color(0, 0, 0));
        tfApellido.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfApellido.setPlaceholder("");
        tfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfApellidoKeyTyped(evt);
            }
        });
        Fondo.add(tfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 240, 30));

        tfMedicamentos.setForeground(new java.awt.Color(0, 0, 0));
        tfMedicamentos.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfMedicamentos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfMedicamentos.setPlaceholder("");
        tfMedicamentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMedicamentosKeyTyped(evt);
            }
        });
        Fondo.add(tfMedicamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 220, 30));

        tfTelefono.setForeground(new java.awt.Color(0, 0, 0));
        tfTelefono.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfTelefono.setPlaceholder("");
        tfTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefonoKeyTyped(evt);
            }
        });
        Fondo.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 220, 30));

        tfInformacion.setForeground(new java.awt.Color(0, 0, 0));
        tfInformacion.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfInformacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfInformacion.setPlaceholder("");
        tfInformacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfInformacionKeyTyped(evt);
            }
        });
        Fondo.add(tfInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 220, 30));

        tfNombre.setForeground(new java.awt.Color(0, 0, 0));
        tfNombre.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfNombre.setPhColor(new java.awt.Color(0, 0, 0));
        tfNombre.setPlaceholder("");
        tfNombre.setSelectionColor(new java.awt.Color(0, 0, 0));
        tfNombre.setVelMils(100);
        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombreKeyTyped(evt);
            }
        });
        Fondo.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 240, 30));

        dcFechaNacimiento.setBackground(new java.awt.Color(0, 0, 0));
        Fondo.add(dcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 170, 40));

        rbMujer.setBackground(new java.awt.Color(0, 0, 0));
        botones.add(rbMujer);
        rbMujer.setForeground(new java.awt.Color(0, 0, 0));
        rbMujer.setText("Mujer");
        rbMujer.setColorCheck(new java.awt.Color(0, 0, 0));
        rbMujer.setColorUnCheck(new java.awt.Color(0, 0, 0));
        Fondo.add(rbMujer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 110, 40));

        rbHombre.setBackground(new java.awt.Color(0, 0, 0));
        botones.add(rbHombre);
        rbHombre.setForeground(new java.awt.Color(0, 0, 0));
        rbHombre.setText("Hombre");
        rbHombre.setColorCheck(new java.awt.Color(0, 0, 0));
        rbHombre.setColorUnCheck(new java.awt.Color(0, 0, 0));
        Fondo.add(rbHombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 110, 40));

        tfAlergias.setForeground(new java.awt.Color(0, 0, 0));
        tfAlergias.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfAlergias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfAlergias.setPlaceholder("");
        tfAlergias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAlergiasKeyTyped(evt);
            }
        });
        Fondo.add(tfAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 220, 30));

        tfNotaMedica.setForeground(new java.awt.Color(0, 0, 0));
        tfNotaMedica.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfNotaMedica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfNotaMedica.setPlaceholder("");
        tfNotaMedica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNotaMedicaKeyTyped(evt);
            }
        });
        Fondo.add(tfNotaMedica, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 220, 30));

        tfTratamientos.setForeground(new java.awt.Color(0, 0, 0));
        tfTratamientos.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfTratamientos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfTratamientos.setPlaceholder("");
        tfTratamientos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTratamientosKeyTyped(evt);
            }
        });
        Fondo.add(tfTratamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 220, 30));

        btnGuardar.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Fondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 680, 100, 40));

        lbError.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        lbError.setForeground(new java.awt.Color(255, 0, 0));
        Fondo.add(lbError, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 620, 280, 30));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyTyped
        this.tfNombre.setText(this.tfNombre.getText().toUpperCase());
        char c = evt.getKeyChar();
        
        
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
            this.tfNombre.setBackground(Color.pink);
            this.tfNombre.setBorder(BorderFactory.createLineBorder(Color.red));
            this.lbError.setText("---> ERROR SOLO LETRAS <---");
            
        } else {
            this.tfNombre.setBackground(Color.white);
            this.tfNombre.setText(this.tfNombre.getText().toUpperCase());
            this.tfNombre.setBorder(BorderFactory.createLineBorder(new Color(0,120,215),1));
            this.lbError.setText(" ");
        }
    }//GEN-LAST:event_tfNombreKeyTyped

    private void tfApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfApellidoKeyTyped
        
        this.tfApellido.setText(this.tfApellido.getText().toUpperCase());
        char c = evt.getKeyChar();
        
        
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
            this.tfApellido.setBackground(Color.pink);
            this.tfApellido.setBorder(BorderFactory.createLineBorder(Color.red));
            this.lbError.setText("---> ERROR SOLO LETRAS <---");
            
        } else {
            this.tfApellido.setBackground(Color.white);
            this.tfApellido.setText(this.tfApellido.getText().toUpperCase());
            this.tfApellido.setBorder(BorderFactory.createLineBorder(new Color(0,120,215),1));
            this.lbError.setText(" ");
        }
    }//GEN-LAST:event_tfApellidoKeyTyped

    private void tfTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoKeyTyped
         this.tfTelefono.setText(this.tfTelefono.getText().toUpperCase());
        char c = evt.getKeyChar();
        
        
        if (!Character.isDigit(c) && c != '-') {
            evt.consume();
            this.tfTelefono.setBackground(Color.pink);
            this.tfTelefono.setBorder(BorderFactory.createLineBorder(Color.red));
            this.lbError.setText("---> ERROR SOLO NUMEROS Y UN GUION <---");
            
        } else {
            this.tfTelefono.setBackground(Color.white);
            this.tfTelefono.setText(this.tfTelefono.getText().toUpperCase());
            this.tfTelefono.setBorder(BorderFactory.createLineBorder(new Color(0,120,215),1));
            this.lbError.setText(" ");
        }
    }//GEN-LAST:event_tfTelefonoKeyTyped

    private void tfInformacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfInformacionKeyTyped
        
        this.tfInformacion.setText(this.tfInformacion.getText().toUpperCase());
        char c = evt.getKeyChar();
        
        
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
            this.tfInformacion.setBackground(Color.pink);
            this.tfInformacion.setBorder(BorderFactory.createLineBorder(Color.red));
            this.lbError.setText("---> ERROR SOLO LETRAS <---");
            
        } else {
            this.tfInformacion.setBackground(Color.white);
            this.tfInformacion.setText(this.tfInformacion.getText().toUpperCase());
            this.tfInformacion.setBorder(BorderFactory.createLineBorder(new Color(0,120,215),1));
            this.lbError.setText(" ");
        }
    }//GEN-LAST:event_tfInformacionKeyTyped

    private void tfTratamientosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTratamientosKeyTyped
        
        this.tfTratamientos.setText(this.tfTratamientos.getText().toUpperCase());
        char c = evt.getKeyChar();
        
        
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
            this.tfTratamientos.setBackground(Color.pink);
            this.tfTratamientos.setBorder(BorderFactory.createLineBorder(Color.red));
            this.lbError.setText("---> ERROR SOLO LETRAS <---");
            
        } else {
            this.tfTratamientos.setBackground(Color.white);
            this.tfTratamientos.setText(this.tfTratamientos.getText().toUpperCase());
            this.tfTratamientos.setBorder(BorderFactory.createLineBorder(new Color(0,120,215),1));
            this.lbError.setText(" ");
        }
    }//GEN-LAST:event_tfTratamientosKeyTyped

    private void tfNotaMedicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNotaMedicaKeyTyped
    
        this.tfNotaMedica.setText(this.tfNotaMedica.getText().toUpperCase());
        char c = evt.getKeyChar();
        
        
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
            this.tfNotaMedica.setBackground(Color.pink);
            this.tfNotaMedica.setBorder(BorderFactory.createLineBorder(Color.red));
            this.lbError.setText("---> ERROR SOLO LETRAS <---");
            
        } else {
            this.tfNotaMedica.setBackground(Color.white);
            this.tfNotaMedica.setText(this.tfNotaMedica.getText().toUpperCase());
            this.tfNotaMedica.setBorder(BorderFactory.createLineBorder(new Color(0,120,215),1));
            this.lbError.setText(" ");
        }
    }//GEN-LAST:event_tfNotaMedicaKeyTyped

    private void tfAlergiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAlergiasKeyTyped
        
        this.tfAlergias.setText(this.tfAlergias.getText().toUpperCase());
        char c = evt.getKeyChar();
        
        
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
            this.tfAlergias.setBackground(Color.pink);
            this.tfAlergias.setBorder(BorderFactory.createLineBorder(Color.red));
            this.lbError.setText("---> ERROR SOLO LETRAS <---");
            
        } else {
            this.tfAlergias.setBackground(Color.white);
            this.tfAlergias.setText(this.tfAlergias.getText().toUpperCase());
            this.tfAlergias.setBorder(BorderFactory.createLineBorder(new Color(0,120,215),1));
            this.lbError.setText(" ");
        }
    }//GEN-LAST:event_tfAlergiasKeyTyped

    private void tfMedicamentosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMedicamentosKeyTyped
       
        this.tfMedicamentos.setText(this.tfMedicamentos.getText().toUpperCase());
        char c = evt.getKeyChar();
        
        
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
            this.tfMedicamentos.setBackground(Color.pink);
            this.tfMedicamentos.setBorder(BorderFactory.createLineBorder(Color.red));
            this.lbError.setText("---> ERROR SOLO LETRAS <---");
            
        } else {
            this.tfMedicamentos.setBackground(Color.white);
            this.tfMedicamentos.setText(this.tfMedicamentos.getText().toUpperCase());
            this.tfMedicamentos.setBorder(BorderFactory.createLineBorder(new Color(0,120,215),1));
            this.lbError.setText(" ");
        }
    }//GEN-LAST:event_tfMedicamentosKeyTyped

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
    private javax.swing.JLabel lbError;
    public RSMaterialComponent.RSRadioButtonMaterial rbHombre;
    public RSMaterialComponent.RSRadioButtonMaterial rbMujer;
    private necesario.TextField textField1;
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
