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

/**
 *
 * @author sanja_000
 */
public class SearchStaffController {
    public ArrayList<Staff> fetchData(Staff ob1)
    {
        
        ArrayList<Staff> list=new ArrayList();
        Connection con=null;
        try
        {
            con=ConnectDB.getConnection();
            String name=ob1.getFullName();
            String sql="select * from tbl_staff where fullName like ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, "%"+name+"%");
            ResultSet rs=pst.executeQuery();
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
    
}
