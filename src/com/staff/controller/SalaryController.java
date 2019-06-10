/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staff.controller;

import com.staff.common.ConnectDB;
import com.staff.model.Salary;
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
public class SalaryController {
     public ArrayList<Salary> fetchData()
    {
        
        ArrayList<Salary> list=new ArrayList();
        Connection con=null;
        try
        {
            con=ConnectDB.getConnection();
            String sql="SELECT staffId, fullName ,basicSalary from tbl_staff order by staffId ASC";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                
                Salary ob=new Salary();
                ob.setStaffId(rs.getInt("staffId"));
                ob.setStaffName(rs.getString("Fullname"));
                /*ob.setAddress(rs.getString("address"));
                ob.setDob(rs.getString("dob"));
                ob.setDoj(rs.getString("doj"));
                ob.setDesignation(rs.getString("designation"));
                ob.setContactNo(rs.getLong("contactNo"));
                ob.setBankAccNo(rs.getLong("bankAccNo"));*/
                ob.setBasicSalary(rs.getDouble("basicSalary"));
                list.add(ob);
            }
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
        return list;
    }

    public void saveData(ArrayList<Salary> list) 
    {
        Connection con=null;
        try
        {
           con=ConnectDB.getConnection();
           con.setAutoCommit(false);
           for(int i=0;i<list.size();i++)
           {
               
               SalaryController pdc=new SalaryController();
               
               String sql="insert into tbl_salary (staffName,salaryPaidDate,bonus,basicSalary,staffId) values (?,?,?,?,?)";
               PreparedStatement pst=con.prepareStatement(sql);
               
               pst.setString(1,list.get(i).getStaffName());
               pst.setString(2,list.get(i).getSalaryPaidDate());
               pst.setDouble(3,list.get(i).getBonus());
               pst.setDouble(4,list.get(i).getBasicSalary());
               pst.setInt(5,list.get(i).getStaffId());
              
 
               pst.execute();
               con.commit();
                
           }
           JOptionPane.showMessageDialog(null,"Salary Successfully paid.");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            try
            {
                con.rollback();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
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
