/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staff.view;

import com.staff.controller.SearchStaffController;
import com.staff.controller.StaffController;
import com.staff.model.Staff;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sanja_000
 */
public class SearchStaff extends javax.swing.JInternalFrame {
     DefaultTableModel model;
    /**
     * Creates new form SearchStaff
     */
    public SearchStaff() {
        initComponents();
        model = new DefaultTableModel(null,new String[]{"Id","FullName","Address","Dob","Doj","Designation","Contact No","BankAccNo","BasicSalary"});
        jTable_search.setModel(model);
    }
    
    
    private void clearTable()
    {
        int count = jTable_search.getRowCount();
        for(int i=0;i<count;i++)
        {
           model.removeRow(0);
        }
        //clearField();
    }
     
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField_staffName = new javax.swing.JTextField();
        jButton_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_search = new javax.swing.JTable();
        jButton_cleartable = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Search Staff");
        setMinimumSize(new java.awt.Dimension(1364, 772));
        setPreferredSize(new java.awt.Dimension(1364, 772));

        jLabel1.setText("Staff Name");

        jButton_search.setText("Search");
        jButton_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchActionPerformed(evt);
            }
        });

        jTable_search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_search);

        jButton_cleartable.setText("Clear table");
        jButton_cleartable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cleartableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1195, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(jTextField_staffName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton_search)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(jButton_cleartable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_staffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_cleartable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchActionPerformed
        // TODO add your handling code here:
        Staff ob1=new Staff();
        ob1.setFullName(jTextField_staffName.getText());
        SearchStaffController scc=new SearchStaffController();
        ArrayList<Staff> list;
        list=scc.fetchData(ob1);
        //ArrayList<Staff> list=sc.fetchData(ob1);
        for(int i=0;i<list.size();i++)
        {
            model.addRow(new Object[]
            {
            list.get(i).getStaffId(),
            list.get(i).getFullName(),
            list.get(i).getAddress(),
            list.get(i).getDob(),
            list.get(i).getDoj(),
            list.get(i).getDesignation(),
            list.get(i).getContactNo(),
            list.get(i).getBankAccNo(),
            list.get(i).getBasicSalary()});
        }
        jTextField_staffName.setText("");
    }//GEN-LAST:event_jButton_searchActionPerformed

    private void jButton_cleartableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cleartableActionPerformed
        // TODO add your handling code here:
        int count = jTable_search.getRowCount();
        for(int i=0;i<count;i++)
        {
           model.removeRow(0);
        }
    }//GEN-LAST:event_jButton_cleartableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cleartable;
    private javax.swing.JButton jButton_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_search;
    private javax.swing.JTextField jTextField_staffName;
    // End of variables declaration//GEN-END:variables
}
