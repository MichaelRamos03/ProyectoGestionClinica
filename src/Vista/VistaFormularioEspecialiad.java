/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import Utilidades.Fondo;

/**
 *
 * @author laine
 */
public class VistaFormularioEspecialiad extends javax.swing.JFrame {

    /**
     * Creates new form VistaEspecialiad
     */
    public VistaFormularioEspecialiad() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.Fondo.setBorder(new Fondo("/imagenes/especialidad.jpg"));
    }
    
     public void iniciar() {
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        Fondo = new javax.swing.JPanel();
        ESPECIALIDAD = new RSMaterialComponent.RSLabelTextIcon();
        txtEspecialidad = new RSMaterialComponent.RSTextFieldTwo();
        btnGuardar = new RSMaterialComponent.RSButtonIconOne();
        lbError = new javax.swing.JLabel();

        rSLabelTextIcon1.setText("rSLabelTextIcon1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ESPECIALIDAD.setForeground(new java.awt.Color(0, 153, 204));
        ESPECIALIDAD.setText("ESPECIALIDAD:");
        ESPECIALIDAD.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FOLDER_SHARED);

        txtEspecialidad.setForeground(new java.awt.Color(0, 0, 0));
        txtEspecialidad.setBorderColor(new java.awt.Color(0, 153, 255));
        txtEspecialidad.setPlaceholder(" Agregar Especialidad");
        txtEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecialidadActionPerformed(evt);
            }
        });
        txtEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEspecialidadKeyTyped(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(0, 153, 204));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FILE_UPLOAD);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(ESPECIALIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ESPECIALIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
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

    private void txtEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEspecialidadActionPerformed

    private void txtEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEspecialidadKeyTyped

        this.txtEspecialidad.setText(this.txtEspecialidad.getText().toUpperCase());
        char c = evt.getKeyChar();
        
        
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume();
            this.txtEspecialidad.setBackground(Color.pink);
            this.txtEspecialidad.setBorder(BorderFactory.createLineBorder(Color.red));
            this.lbError.setText("---> ERROR SOLO LETRAS <---");
            
        } else {
            this.txtEspecialidad.setBackground(Color.white);
            this.txtEspecialidad.setText(this.txtEspecialidad.getText().toUpperCase());
            this.txtEspecialidad.setBorder(BorderFactory.createLineBorder(new Color(0,120,215),1));
            this.lbError.setText(" ");
        }
    }//GEN-LAST:event_txtEspecialidadKeyTyped

    /**
     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(VistaFormularioEspecialiad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaFormularioEspecialiad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaFormularioEspecialiad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaFormularioEspecialiad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaFormularioEspecialiad().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSLabelTextIcon ESPECIALIDAD;
    public javax.swing.JPanel Fondo;
    public RSMaterialComponent.RSButtonIconOne btnGuardar;
    private javax.swing.JLabel lbError;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    public RSMaterialComponent.RSTextFieldTwo txtEspecialidad;
    // End of variables declaration//GEN-END:variables
}
