/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import RSMaterialComponent.RSSwitch;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof RSMaterialComponent.RSSwitch) {
            RSMaterialComponent.RSSwitch swActivo = (RSMaterialComponent.RSSwitch) value;
            return swActivo;
        }
        if (value instanceof JButton) {
            JButton btn = (JButton) value;
            return btn;
        }
         if (value instanceof JLabel) {
            JLabel lbl = (JLabel) value;
            return lbl;
        }

        return super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
