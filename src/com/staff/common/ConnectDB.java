/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.staff.common;


    
    import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sanjaya Koju
 */
public class ConnectDB {
    
    public static Connection getConnection()
    {
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_schoolstaffmgmt","root","");
            return con;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return null;
    }
    
}
