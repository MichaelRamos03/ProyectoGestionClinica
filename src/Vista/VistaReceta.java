/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Utilidades.Fondo;

/**
 *
 * @author Gaby Laínez
 */
public class VistaReceta extends javax.swing.JFrame {

    /**
     * Creates new form VistaReceta
     */
    public VistaReceta() {
        initComponents();
           this.setLocationRelativeTo(this);
        this.Fondo.setBorder(new Fondo("/imagenes/rece.jpg"));
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReceta = new RSMaterialComponent.RSTableMetroCustom();
        btnAgregarReceta = new RSMaterialComponent.RSButtonMaterialIconShadow();
        btnEliminar = new RSMaterialComponent.RSButtonMaterialIconShadow();
        btnEditar = new RSMaterialComponent.RSButtonMaterialIconShadow();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblReceta.setBackground(new java.awt.Color(204, 102, 255));
        tblReceta.setForeground(new java.awt.Color(0, 0, 0));
        tblReceta.setModel(new javax.swing.table.DefaultTableModel(
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
        tblReceta.setBackgoundHead(new java.awt.Color(100, 72, 130));
        tblReceta.setBorderHead(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblReceta.setBorderRows(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblReceta.setColorPrimary(new java.awt.Color(204, 153, 255));
        tblReceta.setColorPrimaryText(new java.awt.Color(0, 0, 0));
        tblReceta.setColorSecundaryText(new java.awt.Color(0, 0, 0));
        tblReceta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblReceta.setFontHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblReceta.setFontRowHover(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblReceta.setFontRowSelect(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblReceta.setForegroundHead(new java.awt.Color(0, 0, 0));
        tblReceta.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jScrollPane2.setViewportView(tblReceta);

        btnAgregarReceta.setBackground(new java.awt.Color(138, 173, 103));
        btnAgregarReceta.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarReceta.setText("AGREGAR");
        btnAgregarReceta.setBackgroundHover(new java.awt.Color(100, 72, 130));
        btnAgregarReceta.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);

        btnEliminar.setBackground(new java.awt.Color(229, 36, 29));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBackgroundHover(new java.awt.Color(100, 72, 130));
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);

        btnEditar.setBackground(new java.awt.Color(214, 158, 143));
        btnEditar.setText("EDITAR");
        btnEditar.setBackgroundHover(new java.awt.Color(100, 72, 130));
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FOLDER_SHARED);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnAgregarReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(544, Short.MAX_VALUE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaReceta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Fondo;
    public RSMaterialComponent.RSButtonMaterialIconShadow btnAgregarReceta;
    public RSMaterialComponent.RSButtonMaterialIconShadow btnEditar;
    public RSMaterialComponent.RSButtonMaterialIconShadow btnEliminar;
    private javax.swing.JScrollPane jScrollPane2;
    public RSMaterialComponent.RSTableMetroCustom tblReceta;
    // End of variables declaration//GEN-END:variables
}
