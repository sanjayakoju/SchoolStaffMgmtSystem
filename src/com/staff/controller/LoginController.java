/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.staff.controller;

import com.staff.common.ConnectDB;
import com.staff.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanjaya Koju
 */
public class LoginController {
    
    public int userLogin(Login ob)
    {
        int status=-1;
        String status2;
        Connection con=null;
        
        try
        {
            con=ConnectDB.getConnection();
            String sql="select * from tbl_user where username=? and password=md5(?) and status2='Active'";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ob.getUsername());
            pst.setString(2,ob.getPassword());
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                int id=rs.getInt("id");
                String username=rs.getString("username");
                status=rs.getInt("status");
                status2=rs.getString("status2");
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
        return status;
        
    }
    
    
     public ArrayList<Login> fetchData()
    {
        
        ArrayList<Login> list=new ArrayList();
        Connection con=null;
        try
        {
            con=ConnectDB.getConnection();
            String sql="SELECT id,username,status,status2 from tbl_user order by id ASC";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                
                Login ob=new Login();
                ob.setId(rs.getInt("id"));
                ob.setUsername(rs.getString("username"));
                ob.setStatus(rs.getInt("status"));
                ob.setStatus2(rs.getString("status2"));
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
     
     
      public void updateUser(ArrayList<Login> list)
    {
       Connection con=null;
        try
        {
           con=ConnectDB.getConnection();
           con.setAutoCommit(false);
           for(int i=0;i<list.size();i++)
           {
               
               
               String sql="update tbl_user set username=?, status=?, status2=? where id=?";
               PreparedStatement pst=con.prepareStatement(sql);
               
               pst.setString(1,list.get(i).getUsername());
               pst.setInt(2,list.get(i).getStatus());
               pst.setString(3,list.get(i).getStatus2());
               pst.setInt(4,list.get(i).getId());
              
               
               pst.execute();
               con.commit();
                
           }
           JOptionPane.showMessageDialog(null,"User Update Successfully.");
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

    
