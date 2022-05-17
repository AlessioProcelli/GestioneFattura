/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColonnaBottoni;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
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
public class IconButtonColumn extends ButtonColumn implements TableCellRenderer, TableCellEditor, ActionListener
    {
        ImageIcon img;
        ImageIcon imgPressed;
        String text;
    
        
        
public IconButtonColumn(JTable table, int column,ViewWithTableInterface parent,Image img, Image pressed) throws IOException
        {
            
            super(table,column,parent);
            this.img=new ImageIcon(img);
            this.imgPressed=new ImageIcon(pressed);
            designButton();
            
            
            
        }

        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
           
                
                
          
            return super.getRenderButton();
        }

       
        
     
        @Override
    protected void designButton() {
            super.getRenderButton().setForeground(table.getForeground());
            super.getRenderButton().setBackground(UIManager.getColor("JPanel.background"));
            super.getRenderButton().setBorderPainted(false);
            super.getRenderButton().setIcon(img);
            super.getEditButton().setIcon(imgPressed);
            //super.getRenderButton().setOpaque(true);
            
            
    }

    public ImageIcon getImg() {
        return img;
    }

    public ImageIcon getImgPressed() {
        return imgPressed;
    }

   

   
 
    }
    
