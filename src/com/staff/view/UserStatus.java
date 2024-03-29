/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staff.view;

import com.staff.controller.AttendanceController;
import com.staff.controller.LoginController;
import com.staff.controller.StaffController;
import com.staff.model.Attendance;
import com.staff.model.Login;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author sanja_000
 */
public class UserStatus extends javax.swing.JInternalFrame {

    DefaultTableModel model;
   
    /**
     * Creates new form UserStatus
     */
    public UserStatus() {
        initComponents();
         model = new DefaultTableModel(null,new String[]{"ID","Username","Status","Status2"});
        jTable_userStatus.setModel(model);
    }

     private void clearTable()
    {
        int count = jTable_userStatus.getRowCount();
        for(int i=0;i<count;i++)
        {
           model.removeRow(0);
        }
        //clearField();
    }
     
     private void loadData()
    {
         clearTable();
        LoginController sc=new LoginController();
        ArrayList<Login> list=sc.fetchData();
        String[] a = {"Active","Deactive"};
        JComboBox c = new JComboBox(a);
        String p="Deactive";
        for(int i=0;i<list.size();i++)
        {
            TableColumn col= jTable_userStatus.getColumnModel().getColumn(3);
            col.setCellEditor(new DefaultCellEditor(c));
            model.addRow(new Object[]
            {
            list.get(i).getId(),
            list.get(i).getUsername(),
            list.get(i).getStatus(),
            list.get(i).getStatus2()
            });
             
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_userStatus = new javax.swing.JTable();
        jButton_load = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("User Status");

        jTable_userStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_userStatus);

        jButton_load.setText("Load");
        jButton_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loadActionPerformed(evt);
            }
        });

        jButton_update.setText("Update");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton_load)
                        .addGap(42, 42, 42)
                        .addComponent(jButton_update)
                        .addGap(63, 63, 63)
                        .addComponent(jButton1)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_load)
                    .addComponent(jButton1)
                    .addComponent(jButton_update))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loadActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_jButton_loadActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        // TODO add your handling code here:
        ArrayList<Login> list=new ArrayList();
         int count=jTable_userStatus.getRowCount();
          
         for(int i=0;i<count;i++)
        {
           
            Login ob=new Login();
            int id=Integer.parseInt(jTable_userStatus.getValueAt(i,0).toString());
            int status=Integer.parseInt(jTable_userStatus.getValueAt(i,2).toString());
            String username=jTable_userStatus.getValueAt(i,1).toString();
            
            String status2=jTable_userStatus.getValueAt(i,3).toString();
            
            
            //String d=new java.util.Date().toString();
            
            ob.setId(id);
            ob.setUsername(username);
            ob.setStatus(status);
            ob.setStatus2(status2);
            
           
            
            list.add(ob);
             
        }
        LoginController sdc=new LoginController();
        sdc.updateUser(list);
        clearTable();
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int count = jTable_userStatus.getRowCount();
        for(int i=0;i<count;i++)
        {
           model.removeRow(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_load;
    private javax.swing.JButton jButton_update;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_userStatus;
    // End of variables declaration//GEN-END:variables
}
