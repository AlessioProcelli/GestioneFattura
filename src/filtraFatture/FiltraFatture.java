/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package filtraFatture;
import mvc.View;
import clienti.Cliente;
import fattura.Fattura;
import colonnaBottoni.IconButtonColumn;
import colonnaBottoni.IconColumn;
import colonnaBottoni.ViewWithTableInterface;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Alessio
 */
public class FiltraFatture extends View implements ViewWithTableInterface{
    private ModelFiltraFattura model;
    private ControllerFiltraFattura controller;
    
    public FiltraFatture(ControllerFiltraFattura controller, ModelFiltraFattura model) {
        super(controller, model);
        this.model=model;
        this.controller=controller;
        initComponents();
        update();
        azzeraComboBox();
    }

    /**
     * Creates new form Home
     */
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        groupPagato = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        clientiComboBox = new javax.swing.JComboBox<>();
        daPagareCeck = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pagataCeck = new javax.swing.JRadioButton();
        applicaFiltriButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        azzeraFiltriButton = new javax.swing.JButton();
        anniComboBox = new javax.swing.JComboBox<>();
        cercaInput = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        imponibileView = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        prezzoView = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ivaView = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        hardwareView = new javax.swing.JTextField();
        serviziView = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        daAvereView = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 245, 245));
        setForeground(new java.awt.Color(245, 245, 245));

        panel.setLayout(new java.awt.GridLayout(2, 0));

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setDoubleBuffered(false);
        jPanel4.setEnabled(false);
        jPanel4.setFocusable(false);

        jSplitPane1.setDividerSize(100);
        jSplitPane1.setRequestFocusEnabled(false);
        jSplitPane1.setVerifyInputWhenFocusTarget(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 141, 185)), "Filtri", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(401, 290));

        clientiComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientiComboBoxActionPerformed(evt);
            }
        });

        groupPagato.add(daPagareCeck);
        daPagareCeck.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        daPagareCeck.setText("Da Pagare");
        daPagareCeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daPagareCeckActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setText("Anno:");

        groupPagato.add(pagataCeck);
        pagataCeck.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        pagataCeck.setText("Pagata");
        pagataCeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagataCeckActionPerformed(evt);
            }
        });

        applicaFiltriButton.setBackground(new java.awt.Color(100, 141, 185));
        applicaFiltriButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        applicaFiltriButton.setForeground(new java.awt.Color(255, 255, 255));
        applicaFiltriButton.setText("Applica filtri");
        applicaFiltriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicaFiltriButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel9.setText("Cerca:");

        azzeraFiltriButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        azzeraFiltriButton.setText("Azzera filtri");
        azzeraFiltriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                azzeraFiltriButtonActionPerformed(evt);
            }
        });

        anniComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anniComboBoxActionPerformed(evt);
            }
        });

        cercaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cercaInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(anniComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(clientiComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cercaInput)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pagataCeck, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(daPagareCeck, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(applicaFiltriButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(azzeraFiltriButton)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anniComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clientiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cercaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(daPagareCeck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pagataCeck)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applicaFiltriButton)
                    .addComponent(azzeraFiltriButton))
                .addGap(25, 25, 25))
        );

        jSplitPane1.setLeftComponent(jPanel2);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 141, 185)), "Riepilogo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(401, 279));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setText("Totale:");

        imponibileView.setEditable(false);
        imponibileView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imponibileViewActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setText("Netto");

        prezzoView.setEditable(false);
        prezzoView.setToolTipText("");
        prezzoView.setName(""); // NOI18N
        prezzoView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prezzoViewActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setText("Iva:");

        ivaView.setEditable(false);
        ivaView.setToolTipText("");
        ivaView.setName(""); // NOI18N
        ivaView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ivaViewActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel11.setText("Hardware");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel12.setText("Servizi");

        hardwareView.setEditable(false);
        hardwareView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardwareViewActionPerformed(evt);
            }
        });

        serviziView.setEditable(false);
        serviziView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviziViewActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel13.setText("Da Avere");

        daAvereView.setEditable(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hardwareView, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(daAvereView, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviziView, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imponibileView, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ivaView, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prezzoView, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(prezzoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ivaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(imponibileView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(hardwareView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(serviziView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daAvereView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        prezzoView.getAccessibleContext().setAccessibleName("prezzoTotaleLabel");

        jSplitPane1.setRightComponent(jPanel10);

        jPanel4.add(jSplitPane1);

        jPanel3.add(jPanel4);

        panel.add(jPanel3);

        jScrollPane1.setBorder(null);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Nome cliente", "Imponibile", "Totale", "Pagato", "Da avere", "Emissione", "Scadenza", "Paga", "Visualizza"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Boolean.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.setAutoscrolls(false);
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setIntercellSpacing(new java.awt.Dimension(2, 2));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(100, 141, 185));
        jTable1.setSelectionForeground(new java.awt.Color(254, 254, 254));
        jTable1.setShowGrid(true);
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2089, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 2089, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        panel.add(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anniComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anniComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anniComboBoxActionPerformed

    private void clientiComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientiComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientiComboBoxActionPerformed

    private void prezzoViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prezzoViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prezzoViewActionPerformed

    private void imponibileViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imponibileViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imponibileViewActionPerformed

    private void cercaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cercaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cercaInputActionPerformed

    private void applicaFiltriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicaFiltriButtonActionPerformed
        int id=-1;
        String cerca=cercaInput.getText();
        if( clientiComboBox.getSelectedItem()!=null){
        String s=(String) clientiComboBox.getSelectedItem();
        String[] splits = s.split(" - ");
        id=Integer.parseInt(splits[0]);
        }
        Boolean pagato=null;
        if(daPagareCeck.isSelected()){
            pagato=false;
        }
        if(pagataCeck.isSelected()){
            pagato=true;
        }
        if(cerca.equals("")){
            cerca=null;
        }
        controller.effettuaFiltraggio((String) anniComboBox.getSelectedItem(),id,pagato,cerca);
    }//GEN-LAST:event_applicaFiltriButtonActionPerformed

    private void azzeraFiltriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_azzeraFiltriButtonActionPerformed
       anniComboBox.setSelectedItem(null);
       clientiComboBox.setSelectedItem(null);
       cercaInput.setText(null);
       groupPagato.clearSelection();
    }//GEN-LAST:event_azzeraFiltriButtonActionPerformed

    private void pagataCeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagataCeckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagataCeckActionPerformed

    private void daPagareCeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daPagareCeckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daPagareCeckActionPerformed

    private void ivaViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ivaViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ivaViewActionPerformed

    private void hardwareViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardwareViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hardwareViewActionPerformed

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1FocusGained

    private void serviziViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviziViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serviziViewActionPerformed

    @Override
    public void update() {
            
            String[]scelte=model.getAnni();
            int itemIndice=anniComboBox.getSelectedIndex();
            anniComboBox.setModel(new DefaultComboBoxModel(scelte));
            anniComboBox.setSelectedIndex(itemIndice);
            String[] nc=estraiNomiClienti();
            itemIndice=clientiComboBox.getSelectedIndex();
            clientiComboBox.setModel(new DefaultComboBoxModel(nc));
            clientiComboBox.setSelectedIndex(itemIndice);
            addRowTabella();
            addRiepilogo();
       
       
        
    }
    
     private void azzeraComboBox() {
       anniComboBox.setSelectedItem(null);
       clientiComboBox.setSelectedItem(null);
   
    }
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> anniComboBox;
    private javax.swing.JButton applicaFiltriButton;
    private javax.swing.JButton azzeraFiltriButton;
    private javax.swing.JTextField cercaInput;
    private javax.swing.JComboBox<String> clientiComboBox;
    private javax.swing.JTextField daAvereView;
    private javax.swing.JRadioButton daPagareCeck;
    private javax.swing.Box.Filler filler1;
    private javax.swing.ButtonGroup groupPagato;
    private javax.swing.JTextField hardwareView;
    private javax.swing.JTextField imponibileView;
    private javax.swing.JTextField ivaView;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JRadioButton pagataCeck;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField prezzoView;
    private javax.swing.JTextField serviziView;
    // End of variables declaration//GEN-END:variables

    private void addRowTabella()  {
        DefaultTableModel modelTable = (DefaultTableModel) jTable1.getModel();
        deleteRighe(modelTable);
        ArrayList<Fattura> listFattura=model.getFatture();
        for(int i=0;i<listFattura.size();i++){
            Fattura f=listFattura.get(i);
            Cliente c=listFattura.get(i).getCliente();
            modelTable.addRow(new Object[]{f.getNumeroFattura(),c.getNome(),f.getImponibile(),f.getTotale(),f.getPagato(),f.getDaAvere(),dateToString(f.getDataEmissione()),dateToString(f.getDataScadenza()),null});
        }
        centraColonne(modelTable); 
        aggiungiColonneBottoni();
         
    }

    private void addRiepilogo() {
       
       prezzoView.setText(Float.toString(model.getPrezzoTotale())+VALUTA);
       ivaView.setText(Float.toString(model.getIva())+VALUTA);
       imponibileView.setText(Float.toString(model.getImponibile())+VALUTA);
       hardwareView.setText(Float.toString(model.getHardware())+VALUTA);
       serviziView.setText(Float.toString(model.getServizi())+VALUTA);
       daAvereView.setText(Float.toString(model.getDaAvere())+VALUTA);
    }

    private String[] estraiNomiClienti() {
        ArrayList<Cliente> listC = model.getClienti();
        String[] nomeClienti = new String[listC.size()];
        for (int i = 0; i < listC.size(); i++) {
            Cliente c = listC.get(i);
            nomeClienti[i] = (Integer.toString(c.getId()) + " - " + c.getNome());
        }
        return nomeClienti;
    }

    private void deleteRighe(DefaultTableModel modelTable) {
        int nRighe=modelTable.getRowCount();
        for(int i=0;i<nRighe;i++){
            modelTable.removeRow(0);
        }
     
    }

    private void centraColonne(DefaultTableModel modelTable) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        for (int columnIndex = 0; columnIndex < jTable1.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }
    }

    @Override
    public void onTablePressed(int row, int column) {

        if (column == jTable1.getColumn("Visualizza").getModelIndex()) {
            int colonnaNumeroFattura = jTable1.getColumn("Numero").getModelIndex();
            int numeroFattura = (int) jTable1.getModel().getValueAt(row, colonnaNumeroFattura);
            int colonnaNomeCliente = jTable1.getColumn("Nome cliente").getModelIndex();
            String nomeCliente = (String) jTable1.getModel().getValueAt(row, colonnaNomeCliente);
            int colonnaEmissione = jTable1.getColumn("Emissione").getModelIndex();
            String dataEmissione = (String) jTable1.getModel().getValueAt(row, colonnaEmissione);
            controller.visualizzaFattura(numeroFattura, nomeCliente, super.stringToDate(dataEmissione));

        }
        if (column == jTable1.getColumn("Paga").getModelIndex()) {
            int colonnaNumeroFattura = jTable1.getColumn("Numero").getModelIndex();
            int numeroFattura = (int) jTable1.getModel().getValueAt(row, colonnaNumeroFattura);
            int colonnaEmissione = jTable1.getColumn("Emissione").getModelIndex();
            String dataEmissione = (String) jTable1.getModel().getValueAt(row, colonnaEmissione);
            int colonnaNomeCliente = jTable1.getColumn("Nome cliente").getModelIndex();
            String nomeCliente = (String) jTable1.getModel().getValueAt(row, colonnaNomeCliente);
            controller.pagaFattura(numeroFattura, stringToDate(dataEmissione), nomeCliente);

        }
    }

    private void aggiungiColonneBottoni()  {
        int visualizza=jTable1.getColumn("Visualizza").getModelIndex();
        int paga=jTable1.getColumn("Paga").getModelIndex();
        int pagato=jTable1.getColumn("Pagato").getModelIndex();
        try{
        Image imgV=getImageByPath(PATH_IMG+"visualizza.png");
        Image imgPressedV=getImageByPath(PATH_IMG+"visualizzaPressed.png");
        new IconButtonColumn(jTable1,visualizza,this,imgV,imgPressedV);
        Image imgP=getImageByPath(PATH_IMG+"paga.png");
        Image imgPressedP=getImageByPath(PATH_IMG+"pagaPressed.png");
        new IconButtonColumn(jTable1,paga,this,imgP,imgPressedP);
        Image imgPagato=getImageByPath(PATH_IMG+"true.png");
        Image imgPressedPagato=getImageByPath(PATH_IMG+"false.png");
        new IconColumn(jTable1,pagato,this,imgPagato,imgPressedPagato);
        }
        catch(Exception e){
            Logger.getLogger(FiltraFatture.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("errore IconButton");
        }
    }
    
    
   
   
    
   
    
}