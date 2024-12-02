/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JFrame;
import Utilidades.Fondo;

/**
 *
 * @author karla
 */
public class VistaCrudMedicamentos extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public VistaCrudMedicamentos() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         this.setLocationRelativeTo(this);
        this.jPanel1.setBorder(new Fondo("/imagenes/ImagenMedicamentos.jpg"));
 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMedicamentos = new javax.swing.JTable();
        btnRegistrarMedicamento = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        labelMedicine = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMedicamentos.setBackground(new java.awt.Color(255, 255, 255));
        tablaMedicamentos.setForeground(new java.awt.Color(0, 0, 0));
        tablaMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaMedicamentos.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tablaMedicamentos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaMedicamentos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 810, 450));

        btnRegistrarMedicamento.setBackground(new java.awt.Color(102, 255, 255));
        btnRegistrarMedicamento.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        btnRegistrarMedicamento.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon-park--add.png"))); // NOI18N
        btnRegistrarMedicamento.setText("Registrar Medicamento");
        btnRegistrarMedicamento.setToolTipText("Registro de nuevo medicamento");
        btnRegistrarMedicamento.setFocusable(false);
        jPanel1.add(btnRegistrarMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 40));

        btnModificar.setBackground(new java.awt.Color(102, 255, 255));
        btnModificar.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modify icon.png"))); // NOI18N
        btnModificar.setText("Modificar medicamento ");
        btnModificar.setToolTipText("Seleccione un medicamento");
        btnModificar.setFocusable(false);
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, 40));

        btnEliminar.setBackground(new java.awt.Color(102, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Sitka Heading", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon-park--delete-one (1).png"))); // NOI18N
        btnEliminar.setText("Eliminar medicamento");
        btnEliminar.setToolTipText("Seleccione un medicamento");
        btnEliminar.setFocusable(false);
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 220, 40));

        labelMedicine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ant-design--medicine-box-filled (2).png"))); // NOI18N
        jPanel1.add(labelMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Sitka Heading", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Medicamentos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 120, 30));

        btnBuscar.setBackground(new java.awt.Color(102, 255, 255));
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon-park--search.png"))); // NOI18N
        btnBuscar.setText("Buscar Medicamento");
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 210, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1095, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(VistaCrudMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaCrudMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaCrudMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaCrudMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaCrudMedicamentos().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnRegistrarMedicamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelMedicine;
    public javax.swing.JTable tablaMedicamentos;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
