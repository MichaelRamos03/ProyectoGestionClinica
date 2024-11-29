
package Vista;

import javax.swing.JFrame;
import utilidades.Fondo;

/**
 *
 * @author Michael Ramos;
 */     
public class VistaFormularioEmpleado extends javax.swing.JFrame {

    public VistaFormularioEmpleado() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.Fondo.setBorder(new Fondo("/imagenes/2.jpg"));
    }

    public void iniciar() {
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoGenero = new javax.swing.ButtonGroup();
        Fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        chEstado = new RSMaterialComponent.RSCheckBoxMaterial();
        tfDui = new RSMaterialComponent.RSTextFieldMaterial();
        tfNombre = new RSMaterialComponent.RSTextFieldMaterial();
        tfApellido = new RSMaterialComponent.RSTextFieldMaterial();
        tfCorreo = new RSMaterialComponent.RSTextFieldMaterial();
        rsFecha = new rojeru_san.componentes.RSDateChooser();
        cbRol = new RSMaterialComponent.RSComboBox();
        jLabel7 = new javax.swing.JLabel();
        rbHombre = new RSMaterialComponent.RSRadioButtonMaterial();
        rbMujer = new RSMaterialComponent.RSRadioButtonMaterial();
        btnGuardar = new newscomponents.RSButtonIcon_new();
        jLabel8 = new javax.swing.JLabel();
        cbPrioridad = new RSMaterialComponent.RSComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel1.setText("Dui:");

        jLabel2.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel2.setText("Apellido:");

        jLabel3.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel4.setText("Correo:");

        jLabel5.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de nacimiento:");

        jLabel6.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel6.setText("Genero:");

        chEstado.setForeground(new java.awt.Color(0, 0, 0));
        chEstado.setText("Activo");
        chEstado.setColorCheck(new java.awt.Color(102, 0, 102));
        chEstado.setColorUnCheck(new java.awt.Color(255, 255, 255));
        chEstado.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        chEstado.setRippleColor(new java.awt.Color(204, 204, 204));
        chEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chEstadoActionPerformed(evt);
            }
        });

        tfDui.setBackground(new java.awt.Color(63, 118, 157));
        tfDui.setForeground(new java.awt.Color(0, 0, 0));
        tfDui.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfDui.setPlaceholder("");

        tfNombre.setBackground(new java.awt.Color(63, 118, 157));
        tfNombre.setForeground(new java.awt.Color(0, 0, 0));
        tfNombre.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfNombre.setPlaceholder("");

        tfApellido.setBackground(new java.awt.Color(63, 118, 157));
        tfApellido.setForeground(new java.awt.Color(0, 0, 0));
        tfApellido.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfApellido.setPlaceholder("");

        tfCorreo.setBackground(new java.awt.Color(59, 106, 150));
        tfCorreo.setForeground(new java.awt.Color(0, 0, 0));
        tfCorreo.setColorMaterial(new java.awt.Color(0, 0, 0));
        tfCorreo.setPlaceholder("");

        rsFecha.setColorBackground(new java.awt.Color(0, 0, 0));
        rsFecha.setColorButtonHover(new java.awt.Color(0, 0, 0));
        rsFecha.setColorForeground(new java.awt.Color(0, 0, 0));

        cbRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cbRol.setColorArrow(new java.awt.Color(0, 0, 0));
        cbRol.setColorBorde(new java.awt.Color(255, 255, 255));
        cbRol.setColorFondo(new java.awt.Color(0, 0, 0));
        cbRol.setColorSeleccion(new java.awt.Color(102, 0, 153));

        jLabel7.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel7.setText("Rol:");

        grupoGenero.add(rbHombre);
        rbHombre.setForeground(new java.awt.Color(0, 0, 0));
        rbHombre.setText("Hombre");
        rbHombre.setColorCheck(new java.awt.Color(255, 255, 255));
        rbHombre.setColorUnCheck(new java.awt.Color(0, 0, 0));

        grupoGenero.add(rbMujer);
        rbMujer.setForeground(new java.awt.Color(0, 0, 0));
        rbMujer.setText("Mujer");
        rbMujer.setColorCheck(new java.awt.Color(255, 255, 255));
        rbMujer.setColorUnCheck(new java.awt.Color(0, 0, 0));

        btnGuardar.setBackground(new java.awt.Color(0, 153, 204));
        btnGuardar.setText("Guardar");
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);

        jLabel8.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jLabel8.setText("Prioridad:");

        cbPrioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cbPrioridad.setColorArrow(new java.awt.Color(0, 0, 0));
        cbPrioridad.setColorBorde(new java.awt.Color(255, 255, 255));
        cbPrioridad.setColorFondo(new java.awt.Color(0, 0, 0));
        cbPrioridad.setColorSeleccion(new java.awt.Color(102, 0, 153));

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(rsFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FondoLayout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfDui, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(FondoLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(FondoLayout.createSequentialGroup()
                                        .addComponent(rbHombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbMujer, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cbPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(FondoLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(49, 49, 49)
                                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(FondoLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(chEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDui, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbHombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbMujer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rsFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(chEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        rbHombre.getAccessibleContext().setAccessibleName("\n");

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 600, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(VistaFormularioEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaFormularioEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaFormularioEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaFormularioEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaFormularioEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    public newscomponents.RSButtonIcon_new btnGuardar;
    public RSMaterialComponent.RSComboBox cbPrioridad;
    public RSMaterialComponent.RSComboBox cbRol;
    public RSMaterialComponent.RSCheckBoxMaterial chEstado;
    private javax.swing.ButtonGroup grupoGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public RSMaterialComponent.RSRadioButtonMaterial rbHombre;
    public RSMaterialComponent.RSRadioButtonMaterial rbMujer;
    public rojeru_san.componentes.RSDateChooser rsFecha;
    public RSMaterialComponent.RSTextFieldMaterial tfApellido;
    public RSMaterialComponent.RSTextFieldMaterial tfCorreo;
    public RSMaterialComponent.RSTextFieldMaterial tfDui;
    public RSMaterialComponent.RSTextFieldMaterial tfNombre;
    // End of variables declaration//GEN-END:variables
}
