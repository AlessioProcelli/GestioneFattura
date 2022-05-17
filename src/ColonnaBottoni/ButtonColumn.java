/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColonnaBottoni;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Default
 */
public abstract class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener
    {
        JTable table;
        ViewWithTableInterface parent;
        JButton renderButton;
        JButton editButton;

    public ButtonColumn(JTable table,int column, ViewWithTableInterface parent) {
        this.table = table;
        this.parent = parent;
        renderButton=new JButton();
        editButton=new JButton();
        editButton.addActionListener( this );
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer( this );
        columnModel.getColumn(column).setCellEditor( this );
        }

        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            
            return renderButton;
        }

        public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column)
        {
            
            return editButton;
        }

        public Object getCellEditorValue()
        {
            return null;
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            fireEditingStopped();
            parent.onTablePressed(table.getSelectedRow(),table.getSelectedColumn());
        }

    protected void designButton() {
            
            
    }

    public JButton getRenderButton() {
        return renderButton;
    }

    public JButton getEditButton() {
        return editButton;
    }
    
    
        
          
    
}
