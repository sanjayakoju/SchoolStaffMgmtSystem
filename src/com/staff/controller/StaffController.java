/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staff.controller;


import com.staff.common.ConnectDB;

import com.staff.model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sanja_000
 */
public class StaffController {
     public void addStaff(Staff ob)
    {
        Connection con=null;
        try
        {
            con=ConnectDB.getConnection();
            String sql="insert into tbl_staff(fullName,address,dob,doj,designation,contactNo,bankAccNo,basicSalary) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ob.getFullName());
            pst.setString(2,ob.getAddress());
            pst.setString(3,ob.getDob());
            pst.setString(4,ob.getDoj());
            pst.setString(5,ob.getDesignation());
            pst.setLong(6,ob.getContactNo()); 
            pst.setLong(7,ob.getBankAccNo());
            pst.setDouble(8,ob.getBasicSalary()); 
            pst.execute();
            JOptionPane.showMessageDialog(null,"Staff Add Succesfully");
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Record Already Exit");
            //System.out.println(ex);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
    }
     
     public ArrayList<Staff> fetchData()
    {
        
        ArrayList<Staff> list=new ArrayList();
        Connection con=null;
        try
        {
            con=ConnectDB.getConnection();
            String sql="SELECT * from tbl_staff";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                
                Staff ob=new Staff();
                ob.setStaffId(rs.getInt("staffId"));
                ob.setFullName(rs.getString("Fullname"));
                ob.setAddress(rs.getString("address"));
                ob.setDob(rs.getString("dob"));
                ob.setDoj(rs.getString("doj"));
                ob.setDesignation(rs.getString("designation"));
                ob.setContactNo(rs.getLong("contactNo"));
                ob.setBankAccNo(rs.getLong("bankAccNo"));
                ob.setBasicSalary(rs.getDouble("basicSalary"));
                list.add(ob);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        return list;
    }
     
     public void updateStaff(Staff ob1)
    {
        Connection con=null;
        try
        {
            con=ConnectDB.getConnection();
            String sql="update tbl_staff set fullName=?, address=?, dob=?, doj=?, designation=?, contactNo=?, bankAccNo=?, basicSalary=? where staffId=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ob1.getFullName());
            pst.setString(2,ob1.getAddress());
            pst.setString(3,ob1.getDob());
            pst.setString(4,ob1.getDoj());
            pst.setString(5,ob1.getDesignation());
            pst.setLong(6,ob1.getContactNo());
            pst.setLong(7,ob1.getBankAccNo());
            pst.setDouble(8,ob1.getBasicSalary());
            pst.setInt(9,ob1.getStaffId());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Record Updated");
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null,ex);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        
    }
     
      public void deleteStaff(int id)
    {
        Connection con=null;
        try
        {
            con=ConnectDB.getConnection();
            String sql="delete from tbl_staff where staffId=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Record Deleted");
            
        }
        catch(Exception ex)
        {
            //System.out.println(ex);
            JOptionPane.showMessageDialog(null,"Can't Delete the Record Foreign Key Constraint");
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
     
}
}