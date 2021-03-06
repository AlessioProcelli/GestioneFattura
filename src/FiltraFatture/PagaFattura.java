/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FiltraFatture;

import FiltraFatture.ControllerFiltraFattura;
import fattura.Fattura;

import javax.swing.JFrame;

/**
 *
 * @author Default
 */
public class PagaFattura extends javax.swing.JFrame {
    Fattura f;
    ControllerFiltraFattura controller;
    
   
    public PagaFattura(Fattura f,ControllerFiltraFattura controller){
        initComponents();
        this.f=f;
        this.controller=controller;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scelta = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        pagataParCeckButton = new javax.swing.JRadioButton();
        pagataComCeckButton = new javax.swing.JRadioButton();
        pagataParText = new javax.swing.JTextField();
        button = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Paga Fattura");

        scelta.add(pagataParCeckButton);
        pagataParCeckButton.setText("Pagata Parzialmente");
        pagataParCeckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagataParCeckButtonActionPerformed(evt);
            }
        });

        scelta.add(pagataComCeckButton);
        pagataComCeckButton.setText("Pagata Completamente");
        pagataComCeckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagataComCeckButtonActionPerformed(evt);
            }
        });

        pagataParText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagataParTextActionPerformed(evt);
            }
        });

        button.setText("Conferma");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button)
                    .addComponent(pagataComCeckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pagataParText, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pagataParCeckButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(pagataComCeckButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pagataParCeckButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pagataParText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(button)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagataComCeckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagataComCeckButtonActionPerformed
        pagataParText.setVisible(false);
    }//GEN-LAST:event_pagataComCeckButtonActionPerformed

    private void pagataParTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagataParTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagataParTextActionPerformed

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        
        if(pagataComCeckButton.isSelected()){
            f.setPagato(true);
            notifica();
        }
        if(pagataParCeckButton.isSelected()){
            
            if(!pagataParText.getText().equals("")){
            float p=Float.parseFloat(pagataParText.getText());
            float tot=f.getDaAvere();
            tot=tot-p;
             if(tot>=0){       
            f.setDaAvere(tot);
             }
             else{
                 f.setPagato(true);
             
                }
            
            notifica();
            }
        }
    }//GEN-LAST:event_buttonActionPerformed

    private void pagataParCeckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagataParCeckButtonActionPerformed
        pagataParText.setVisible(true);
    }//GEN-LAST:event_pagataParCeckButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton pagataComCeckButton;
    private javax.swing.JRadioButton pagataParCeckButton;
    private javax.swing.JTextField pagataParText;
    private javax.swing.ButtonGroup scelta;
    // End of variables declaration//GEN-END:variables

    private void notifica() {
        controller.fatturaPagata(f);
        this.dispose();
    }
}
