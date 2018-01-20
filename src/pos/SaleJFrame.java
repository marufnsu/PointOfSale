package pos;

import javax.sound.midi.SysexMessage;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class SaleJFrame extends javax.swing.JFrame implements IPropertyListener {

    ProcessSaleController psc;
    // private static boolean isSenior = true;
    public static String[] comboList = {"Percent Discount", "Threshold Discount", "Senior Discount", "Best For Customer", "Best For Store"};

    public SaleJFrame() {
        initComponents();

        psc = new ProcessSaleController();
        initializeTableEvent();

        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tVAT1 = new javax.swing.JTextField();
        bNewSale = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tItemID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tQuantity = new javax.swing.JTextField();
        bAddItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        saleTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tVAT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tGrandTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tDiscount = new javax.swing.JTextField();
        discountCombo = new JComboBox(comboList);
        seniorCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bNewSale.setText("New Sale");
        bNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewSaleActionPerformed(evt);
            }
        });

        jLabel1.setText("Item ID");

        jLabel2.setText("Quantity");

        bAddItem.setText("Add Item");
        bAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddItemActionPerformed(evt);
            }
        });

        saleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL #", "Item Name", "Unit Price", "Quantity", "Sub Total"
            }
        ));
        jScrollPane1.setViewportView(saleTable);

        jLabel3.setText("Total");

        jLabel4.setText("VAT");

        jLabel5.setText("Grand Total");

        jLabel6.setText("Discount");

        seniorCheckBox.setText("Senior Cityzen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bNewSale)
                                    .addComponent(tItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bAddItem)
                                    .addComponent(tQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(discountCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(seniorCheckBox)))
                        .addContainerGap(104, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(tVAT)
                            .addComponent(tGrandTotal)
                            .addComponent(tDiscount))
                        .addGap(10, 10, 10))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bNewSale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bAddItem)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seniorCheckBox))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(tDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewSaleActionPerformed
        //System.out.println(discountCombo.getSelectedIndex());
        tItemID.setText("");
        tQuantity.setText("");
        tTotal.setText("");
        tDiscount.setText("");
        tGrandTotal.setText("");
        tVAT.setText("");


        DefaultTableModel model = (DefaultTableModel) saleTable.getModel();
        int rc = model.getRowCount();
        for (int i = 0; i < rc; i++) {
            model.removeRow(0);
        }

        psc.makeNewSale();
        psc.addListenerToSale(this);
    }//GEN-LAST:event_bNewSaleActionPerformed

    private void bAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddItemActionPerformed
        if (!tItemID.getText().equals("") && !tQuantity.getText().equals("")) {

            try {
                int id = Integer.parseInt(tItemID.getText());
                int quantity = Integer.parseInt(tQuantity.getText());
                psc.addItem(id, quantity);

                updateUIElemnets();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please fill up the text field with integer.");
                tItemID.setText("");
                tQuantity.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please fill up the text field.");
        }
    }//GEN-LAST:event_bAddItemActionPerformed

    private void initializeTableEvent() {
        saleTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int selectedProductId = Integer.parseInt(saleTable.getValueAt(saleTable.getSelectedRow(), 0).toString());
                ProductSpecification ps = (ProductSpecification) PersistenceFacade.getInsFacade().get(selectedProductId, ProductSpecification.class);
                JOptionPane.showMessageDialog(null, ps.getManufacturerAddress());
            }
        });
    }

    private void updateUIElemnets() {
        updateTable();
        updateTextBlocks();
    }

    private void updateTable() {
        try {
            SalesLineItem saleLineItem = psc.getSale().getSli().get(psc.getSale().getSli().size() - 1);

            Object[] row = {saleLineItem.getPs().getId(), saleLineItem.getPs().getName(),
                saleLineItem.getPs().getPrice(), saleLineItem.getQuantity(),
                saleLineItem.getSubTotal()
            };

            DefaultTableModel model = (DefaultTableModel) saleTable.getModel();

            model.addRow(row);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void updateTextBlocks() {
        try {
            tDiscount.setText(String.valueOf(psc.getSale().getDiscountAmount()));
            //tTotal.setText(String.valueOf(psc.getSale().getPreDiscountTotal()));
            tVAT.setText(String.valueOf(psc.getSale().getVATAmount()));
            tGrandTotal.setText(String.valueOf(psc.getSale().getGrandTotal()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public void onPropertyEvent(String name, String value) {
        if (name.equals("sale.total")) {
            tTotal.setText(value);
        }
    }

    public static boolean isSenior() {
        return seniorCheckBox.isSelected();
    }

    public static String getSelectedItem() {
        return discountCombo.getSelectedItem().toString().replaceAll("\\s+", "");
    }

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
            java.util.logging.Logger.getLogger(SaleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddItem;
    private javax.swing.JButton bNewSale;
    private static javax.swing.JComboBox discountCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable saleTable;
    private static javax.swing.JCheckBox seniorCheckBox;
    private javax.swing.JTextField tDiscount;
    private javax.swing.JTextField tGrandTotal;
    private javax.swing.JTextField tItemID;
    private javax.swing.JTextField tQuantity;
    private javax.swing.JTextField tTotal;
    private javax.swing.JTextField tVAT;
    private javax.swing.JTextField tVAT1;
    // End of variables declaration//GEN-END:variables
}
