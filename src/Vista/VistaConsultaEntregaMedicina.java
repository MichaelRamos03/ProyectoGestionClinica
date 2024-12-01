
package Vista;

import utilidades.Fondo;

/**
 *
 * @author Michael Ramos;
 */
public class VistaConsultaEntregaMedicina extends javax.swing.JFrame {
    
    public VistaConsultaEntregaMedicina() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.Fondo.setBorder(new Fondo("/imagenes/4_1.jpg"));
    }
    
    public void iniciar() {
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDatos = new rojerusan.RSTableMetro();
        btnAgregar = new newscomponents.RSButtonIcon_new();
        btnEliminar = new newscomponents.RSButtonIcon_new();
        btnEditar = new newscomponents.RSButtonIcon_new();
        btnBuscar = new newscomponents.RSButtonIcon_new();
        txtBuscar = new RSMaterialComponent.RSTextFieldMaterial();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDatos.setColorBackgoundHead(new java.awt.Color(51, 0, 51));
        jScrollPane2.setViewportView(tbDatos);

        btnAgregar.setBackground(new java.awt.Color(51, 0, 51));
        btnAgregar.setText("Agregar");
        btnAgregar.setBackgroundHover(new java.awt.Color(153, 153, 153));
        btnAgregar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);

        btnEliminar.setBackground(new java.awt.Color(51, 0, 51));
        btnEliminar.setText("Elimiinar");
        btnEliminar.setBackgroundHover(new java.awt.Color(153, 153, 153));
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE_SWEEP);

        btnEditar.setBackground(new java.awt.Color(51, 0, 51));
        btnEditar.setText("Editar");
        btnEditar.setBackgroundHover(new java.awt.Color(153, 153, 153));
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);

        btnBuscar.setBackground(new java.awt.Color(51, 0, 51));
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.setBackgroundHover(new java.awt.Color(153, 153, 153));
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.VISIBILITY);

        txtBuscar.setBackground(new java.awt.Color(0, 0, 0));
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setPlaceholder("");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
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
            java.util.logging.Logger.getLogger(VistaConsultaEntregaMedicina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaEntregaMedicina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaEntregaMedicina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaEntregaMedicina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaConsultaEntregaMedicina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    public newscomponents.RSButtonIcon_new btnAgregar;
    public newscomponents.RSButtonIcon_new btnBuscar;
    public newscomponents.RSButtonIcon_new btnEditar;
    public newscomponents.RSButtonIcon_new btnEliminar;
    private javax.swing.JScrollPane jScrollPane2;
    public rojerusan.RSTableMetro tbDatos;
    public RSMaterialComponent.RSTextFieldMaterial txtBuscar;
    // End of variables declaration//GEN-END:variables
}