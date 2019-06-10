/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staff.controller;

import com.staff.common.ConnectDB;
import com.staff.view.SalaryReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.staff.model.Report;
import java.sql.Date;
/**
 *
 * @author sanja_000
 */
public class SalaryReportController {
    public ArrayList<Report> fetchData(Report ob1)
    {
        
        ArrayList<Report> list=new ArrayList();
        Connection con=null;
        try
        {
            con=ConnectDB.getConnection();
            Date dateTo=ob1.getDateT();
            Date dateFrom=ob1.getDateF();
            //System.out.println(dateTo);
            String sql="select ts.staffId,staffName,sum(s.basicSalary+bonus) as totalSalary from tbl_salary as s inner JOIN tbl_staff as ts on s.staffId=ts.staffId where salaryPaidDate BETWEEN '"+dateTo+"' and '"+dateFrom+"' GROUP by staffId order by staffName asc";
            PreparedStatement pst=con.prepareStatement(sql);
            //pst.setDate(1,dateTo);
            //pst.setDate(2,dateFrom);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                
                Report ob=new Report();
                ob.setStaffId(rs.getInt("staffId"));
                ob.setName(rs.getString("staffName"));
                ob.setTotal(rs.getDouble("totalSalary"));
                
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
