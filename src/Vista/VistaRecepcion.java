/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import utilidades.Fondo;

/**
 *
 * @author karla
 */
public class VistaRecepcion extends javax.swing.JFrame {

    /**
     * Creates new form VistaRecepcion
     */
    public VistaRecepcion() {
        initComponents();
          this.setLocationRelativeTo(this);
        this.jPanel1.setBorder(new Fondo("/imagenes/FondoRecepcion.jpg"));
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRecepciones = new javax.swing.JTable();
        btnAgregarRecepcion = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminarRecepcion = new javax.swing.JButton();
        btnBuscarRecepcion = new javax.swing.JButton();
        ComboBuscarPrioridad = new javax.swing.JComboBox<>();
        btnMostrarTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Recepcíon");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        tablaRecepciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaRecepciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 1050, 490));

        btnAgregarRecepcion.setText("Agregar Recepcion");
        jPanel1.add(btnAgregarRecepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 150, 30));

        btnModificar.setText("Modificar Recepcíon");
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        btnEliminarRecepcion.setText("Eliminar Recepcíon");
        jPanel1.add(btnEliminarRecepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        btnBuscarRecepcion.setText("Buscar Recepcíon por prioridad");
        jPanel1.add(btnBuscarRecepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        ComboBuscarPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBuscarPrioridad.setToolTipText("Seleccione y presione el botón para buscar");
        jPanel1.add(ComboBuscarPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, -1, -1));

        btnMostrarTodos.setText("Mostrar todos los registros");
        jPanel1.add(btnMostrarTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(VistaRecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRecepcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRecepcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> ComboBuscarPrioridad;
    public javax.swing.JButton btnAgregarRecepcion;
    public javax.swing.JButton btnBuscarRecepcion;
    public javax.swing.JButton btnEliminarRecepcion;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnMostrarTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaRecepciones;
    // End of variables declaration//GEN-END:variables
}
