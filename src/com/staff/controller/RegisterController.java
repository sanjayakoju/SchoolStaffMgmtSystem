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
import javax.swing.JOptionPane;

/**
 *
 * @author sanja_000
 */
public class RegisterController {
     public void registerUser(Login ob)
    {
        Connection con=null;
        try
        {
            con=ConnectDB.getConnection();
            String sql="insert into tbl_user(username,password,status) values(?,md5(?),?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ob.getUsername());
            pst.setString(2,ob.getPassword());
            pst.setInt(3,ob.getStatus());
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"User Register Succesfully");
            
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
    }
}
