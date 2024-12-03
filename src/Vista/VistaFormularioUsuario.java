package Vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.Color;
import javax.swing.BorderFactory;
import Utilidades.Fondo;



/**
 *
 * @author Gaby Lainez
 */
public class VistaFormularioUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VistaFormularioUsuario
     */
    public VistaFormularioUsuario() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.Fondo.setBorder(new Fondo("/imagenes/fm.jpg"));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        txtNombreUsuario = new RSMaterialComponent.RSTextFieldTwo();
        txtContraseña = new RSMaterialComponent.RSTextFieldTwo();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardarUsuario = new newscomponents.RSButtonFlat_new();
        comboEmpledo = new javax.swing.JComboBox<>();
        lbError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombreUsuario.setBackground(new java.awt.Color(234, 234, 234));
        txtNombreUsuario.setForeground(new java.awt.Color(73, 100, 119));
        txtNombreUsuario.setBorderColor(new java.awt.Color(59, 108, 141));
        txtNombreUsuario.setPhColor(new java.awt.Color(204, 204, 255));
        txtNombreUsuario.setSelectionColor(new java.awt.Color(153, 153, 255));
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyTyped(evt);
            }
        });

        txtContraseña.setBackground(new java.awt.Color(234, 234, 234));
        txtContraseña.setForeground(new java.awt.Color(73, 100, 119));
        txtContraseña.setBorderColor(new java.awt.Color(59, 108, 141));
        txtContraseña.setPhColor(new java.awt.Color(204, 204, 255));
        txtContraseña.setSelectionColor(new java.awt.Color(153, 153, 255));
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyTyped(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(234, 234, 234));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(73, 100, 119));
        jLabel1.setText("NOMBRE USUARIO:");

        jLabel2.setBackground(new java.awt.Color(234, 234, 234));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(73, 100, 119));
        jLabel2.setText("CONTRASEÑA:");

        jLabel3.setBackground(new java.awt.Color(234, 234, 234));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(73, 100, 119));
        jLabel3.setText("EMPLEADO:");

        btnGuardarUsuario.setBackground(new java.awt.Color(73, 100, 119));
        btnGuardarUsuario.setText("GUARDAR");
        btnGuardarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuarioActionPerformed(evt);
            }
        });

        comboEmpledo.setBackground(new java.awt.Color(234, 234, 234));
        comboEmpledo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        comboEmpledo.setToolTipText("");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))))
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboEmpledo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(lbError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btnGuardarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEmpledo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void txtNombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyTyped
       this.txtNombreUsuario.setText(this.txtNombreUsuario.getText().toUpperCase());
       char c = evt.getKeyChar();

// Verifica si el carácter es una letra, un número o un carácter permitido
if (!Character.isLetterOrDigit(c) && c != ' ') {
    evt.consume(); // No permite caracteres no válidos
    this.txtNombreUsuario.setBackground(Color.pink);
    this.txtNombreUsuario.setBorder(BorderFactory.createLineBorder(Color.red));
    this.lbError.setText("ERROR SOLO LETRAS Y NÚMEROS");
    this.lbError.setForeground(Color.red);
} else {
    this.txtNombreUsuario.setBackground(Color.white);
    this.txtNombreUsuario.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215), 1));
    this.lbError.setText(" ");
}
    }//GEN-LAST:event_txtNombreUsuarioKeyTyped

    private void btnGuardarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarUsuarioActionPerformed

    private void txtContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyTyped
      this.txtContraseña.setText(this.txtContraseña.getText().toUpperCase());
       char c = evt.getKeyChar();

// Verifica si el carácter es una letra, un número o un carácter permitido
if (!Character.isLetterOrDigit(c) && c != ' ') {
    evt.consume(); // No permite caracteres no válidos
    this.txtContraseña.setBackground(Color.pink);
    this.txtContraseña.setBorder(BorderFactory.createLineBorder(Color.red));
    this.lbError.setText("ERROR SOLO LETRAS Y NÚMEROS");
    this.lbError.setForeground(Color.red);
} else {
    this.txtContraseña.setBackground(Color.white);
    this.txtContraseña.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215), 1));
    this.lbError.setText(" ");
}
    }//GEN-LAST:event_txtContraseñaKeyTyped

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
            java.util.logging.Logger.getLogger(VistaFormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaFormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaFormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaFormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaFormularioUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    public newscomponents.RSButtonFlat_new btnGuardarUsuario;
    public javax.swing.JComboBox<String> comboEmpledo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel lbError;
    public RSMaterialComponent.RSTextFieldTwo txtContraseña;
    public RSMaterialComponent.RSTextFieldTwo txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}