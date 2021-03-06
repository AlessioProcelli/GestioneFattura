/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Home;

import java.awt.Color;

/**
 *
 * @author Alessio
 */
public class MenùDiNavigazione extends javax.swing.JFrame {

    /**
     * Creates new form MenùDiNavigazione
     */
    public MenùDiNavigazione(Home h) {
        initComponents();
        this.h=h;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        filtraFatture = new javax.swing.JButton();
        riepilogoFatture = new javax.swing.JButton();
        aggiungiFattura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(130, 211, 221));

        jPanel1.setBackground(new java.awt.Color(100, 141, 185));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        filtraFatture.setBackground(new java.awt.Color(100, 141, 185));
        filtraFatture.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        filtraFatture.setForeground(new java.awt.Color(255, 255, 255));
        filtraFatture.setText("Filtra fatture");
        filtraFatture.setBorder(null);
        filtraFatture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtraFattureActionPerformed(evt);
            }
        });
        jPanel1.add(filtraFatture);

        riepilogoFatture.setBackground(new java.awt.Color(100, 141, 185));
        riepilogoFatture.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        riepilogoFatture.setForeground(new java.awt.Color(255, 255, 255));
        riepilogoFatture.setText("Riepilogo fatture");
        riepilogoFatture.setBorder(null);
        riepilogoFatture.setMaximumSize(new java.awt.Dimension(93, 23));
        riepilogoFatture.setMinimumSize(new java.awt.Dimension(93, 23));
        riepilogoFatture.setPreferredSize(new java.awt.Dimension(93, 23));
        riepilogoFatture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                riepilogoFattureActionPerformed(evt);
            }
        });
        jPanel1.add(riepilogoFatture);

        aggiungiFattura.setBackground(new java.awt.Color(100, 141, 185));
        aggiungiFattura.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        aggiungiFattura.setForeground(new java.awt.Color(255, 255, 255));
        aggiungiFattura.setText("Aggiungi fattura");
        aggiungiFattura.setBorder(null);
        aggiungiFattura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiFatturaActionPerformed(evt);
            }
        });
        jPanel1.add(aggiungiFattura);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aggiungiFatturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiFatturaActionPerformed
        h.getHomeController().change(0);
    }//GEN-LAST:event_aggiungiFatturaActionPerformed

    private void filtraFattureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtraFattureActionPerformed
        h.getHomeController().change(1);
    }//GEN-LAST:event_filtraFattureActionPerformed

    private void riepilogoFattureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_riepilogoFattureActionPerformed
        h.getHomeController().change(2);
    }//GEN-LAST:event_riepilogoFattureActionPerformed

    /**
     * @param args the command line arguments
     */
   

    private Home h;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiungiFattura;
    private javax.swing.JButton filtraFatture;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton riepilogoFatture;
    // End of variables declaration//GEN-END:variables
}
