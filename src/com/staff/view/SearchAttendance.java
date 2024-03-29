/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staff.view;

import com.staff.controller.SearchAttendanceController;
import com.staff.controller.SearchStaffController;
import com.staff.model.Attendance;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sanja_000
 */
public class SearchAttendance extends javax.swing.JInternalFrame {

     DefaultTableModel model;
     private SimpleDateFormat SimpleDateFormat;
    /**
     * Creates new form SearchAttendance
     */
    public SearchAttendance() {
        initComponents();
        model = new DefaultTableModel(null,new String[]{"FullName","Date","Attendance"});
        jTable_attendanceSearch.setModel(model);
    }
    
     private void clearTable()
    {
        int count = jTable_attendanceSearch.getRowCount();
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
        jTextField_date = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_attendanceSearch = new javax.swing.JTable();
        jButton_searchStaffAttendance = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Search Attendance Of Staff");

        jLabel1.setText("Date");

        jTable_attendanceSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_attendanceSearch);

        jButton_searchStaffAttendance.setText("Search");
        jButton_searchStaffAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchStaffAttendanceActionPerformed(evt);
            }
        });

        jButton1.setText("Clear Table");
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
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_date, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_searchStaffAttendance)
                        .addContainerGap(343, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_searchStaffAttendance)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addGap(90, 90, 90))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_searchStaffAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchStaffAttendanceActionPerformed
          SimpleDateFormat dFormat;
       SimpleDateFormat = dFormat =new SimpleDateFormat("yyyy-MM-dd");
        String dob=dFormat.format(jTextField_date.getDate()); 
       
        Attendance ob1=new Attendance();
         ob1.setAttendancedate(dob);
        SearchAttendanceController scc=new SearchAttendanceController();
        ArrayList<Attendance> list;
        list=scc.fetchData(ob1);
        //ArrayList<Staff> list=sc.fetchData(ob1);
        for(int i=0;i<list.size();i++)
        {
            model.addRow(new Object[]
            {
            //list.get(i).getAttendanceId(),
            list.get(i).getStaffname(),
            list.get(i).getAttendancedate(),
            list.get(i).getAttendance(),
            //list.get(i).getStaffId(),
            });
            
             
        }
        
    }//GEN-LAST:event_jButton_searchStaffAttendanceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int count = jTable_attendanceSearch.getRowCount();
        for(int i=0;i<count;i++)
        {
           model.removeRow(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_searchStaffAttendance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_attendanceSearch;
    private com.toedter.calendar.JDateChooser jTextField_date;
    // End of variables declaration//GEN-END:variables
}
