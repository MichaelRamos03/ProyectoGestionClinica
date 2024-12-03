package Vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import Utilidades.Fondo;

/**
 *
 * @author Gaby Lainez
 */
public class VistaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VistaUsuario
     */
    public VistaUsuario() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.Fondo.setBorder(new Fondo("/imagenes/usuario.jpeg"));
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblusuarios = new RSMaterialComponent.RSTableMetro();
        btnAgregarUsuario = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnEliminar = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnEditar = new RSMaterialComponent.RSButtonMaterialIconTwo();
        buscarUsuariolb = new RSMaterialComponent.RSTextFieldMaterial();
        btnBUscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblusuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblusuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tblusuarios.setBackgoundHead(new java.awt.Color(102, 102, 255));
        tblusuarios.setBackgoundHover(new java.awt.Color(0, 0, 0));
        tblusuarios.setColorBorderHead(new java.awt.Color(0, 51, 204));
        tblusuarios.setColorPrimary(new java.awt.Color(255, 204, 204));
        tblusuarios.setColorPrimaryText(new java.awt.Color(0, 0, 0));
        tblusuarios.setColorSecondary(new java.awt.Color(204, 204, 255));
        tblusuarios.setColorSecundaryText(new java.awt.Color(0, 0, 0));
        tblusuarios.setFont(new java.awt.Font("Myanmar Text", 3, 14)); // NOI18N
        tblusuarios.setFontHead(new java.awt.Font("Lucida Bright", 3, 14)); // NOI18N
        tblusuarios.setForegroundHead(new java.awt.Color(204, 255, 204));
        tblusuarios.setForegroundHover(new java.awt.Color(0, 0, 0));
        tblusuarios.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblusuarios);

        btnAgregarUsuario.setBackground(new java.awt.Color(204, 0, 255));
        btnAgregarUsuario.setForeground(new java.awt.Color(102, 0, 255));
        btnAgregarUsuario.setText("AGREGAR");
        btnAgregarUsuario.setBackgroundHover(new java.awt.Color(204, 0, 255));
        btnAgregarUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);

        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setForeground(new java.awt.Color(102, 0, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBackgroundHover(new java.awt.Color(204, 0, 255));
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE_SWEEP);

        btnEditar.setBackground(new java.awt.Color(51, 255, 204));
        btnEditar.setForeground(new java.awt.Color(102, 0, 255));
        btnEditar.setText("EDITAR");
        btnEditar.setBackgroundHover(new java.awt.Color(204, 0, 255));
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FOLDER_SHARED);

        buscarUsuariolb.setForeground(new java.awt.Color(153, 0, 204));
        buscarUsuariolb.setCaretColor(new java.awt.Color(204, 255, 255));
        buscarUsuariolb.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        buscarUsuariolb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarUsuariolbActionPerformed(evt);
            }
        });

        btnBUscar.setBackground(new java.awt.Color(0, 153, 153));
        btnBUscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBUscar.setText("BUSCAR");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addComponent(btnAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBUscar)
                        .addGap(18, 18, 18)
                        .addComponent(buscarUsuariolb, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBUscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarUsuariolb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarUsuariolbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarUsuariolbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarUsuariolbActionPerformed

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
            java.util.logging.Logger.getLogger(VistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    public RSMaterialComponent.RSButtonMaterialIconTwo btnAgregarUsuario;
    public javax.swing.JButton btnBUscar;
    public RSMaterialComponent.RSButtonMaterialIconTwo btnEditar;
    public RSMaterialComponent.RSButtonMaterialIconTwo btnEliminar;
    public RSMaterialComponent.RSTextFieldMaterial buscarUsuariolb;
    private javax.swing.JScrollPane jScrollPane1;
    public RSMaterialComponent.RSTableMetro tblusuarios;
    // End of variables declaration//GEN-END:variables
}