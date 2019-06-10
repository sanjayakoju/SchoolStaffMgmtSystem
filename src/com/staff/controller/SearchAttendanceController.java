/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staff.controller;

import com.staff.common.ConnectDB;
import com.staff.model.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sanja_000
 */
public class SearchAttendanceController {
     public ArrayList<Attendance> fetchData(Attendance ob1)
    {
        
        ArrayList<Attendance> list=new ArrayList();
        Connection con=null;
        try
        {
            con=ConnectDB.getConnection();
            String date=ob1.getAttendancedate();
            String sql="select * from tbl_attendance where attendancedate like ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, "%"+date+"%");
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                
                Attendance ob=new Attendance();
                ob.setAttendanceId(rs.getInt("attendanceId"));
                ob.setStaffname(rs.getString("staffName"));
                ob.setAttendancedate(rs.getString("attendancedate"));
                ob.setAttendance(rs.getString("attendance"));
                ob.setStaffId(rs.getInt("staffId"));
                
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
