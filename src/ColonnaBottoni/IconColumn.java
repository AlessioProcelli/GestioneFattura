/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColonnaBottoni;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Default
 */
public class IconColumn extends IconButtonColumn
    {

    

    public IconColumn( JTable jtable, int i, ViewWithTableInterface vwti, Image image, Image image1) throws IOException {
        super(jtable, i, vwti, image, image1);
        
        
        
    }
        

    

        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
          if(isSelected){
              super.getRenderButton().setBackground(UIManager.getColor("Component.focusColor"));
             
          }
          else{
              super.getRenderButton().setBackground(UIManager.getColor("JPanel.background"));
          }
            if((Boolean)value){
                super.getRenderButton().setIcon(super.getImg());
                super.getEditButton().setIcon(super.getImg());
                
            }
           if(!(Boolean)value){
               super.getRenderButton().setIcon(super.getImgPressed());
               super.getEditButton().setIcon(super.getImgPressed());
           }
          
            return super.getRenderButton();
        }
       

        public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column)
        {
            
            return null;
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
        
        public void designButton(){
            super.getRenderButton().setForeground(table.getForeground());
            super.getRenderButton().setBackground(UIManager.getColor("JPanel.background"));
            super.getRenderButton().setBorderPainted(false);
            super.getEditButton().setForeground(table.getForeground());
            super.getEditButton().setBackground(UIManager.getColor("JPanel.background"));
            super.getEditButton().setBorderPainted(false);
        }
    

   
    
        
          
    
}