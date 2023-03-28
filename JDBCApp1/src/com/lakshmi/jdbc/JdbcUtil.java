package com.lakshmi.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
       private JdbcUtil()
       {
    	   
       }
       static
       {
    	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
       public static Connection getJdbcConnection() throws SQLException, IOException{
    	   FileInputStream fis=new FileInputStream("J:\\Programming\\JDBCApp1\\application.properties");
    	   Properties p=new Properties();
    	   p.load(fis);
    	   Connection con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
    	   System.out.println("connection established");
    	   return con;
    	   
       }
       public static void CleanUp(Connection con, Statement stmt, ResultSet rst) throws SQLException
       {
    	   if(con!=null)
    	   {
    		   con.close();
    	   }
    	   if(stmt!=null) {
    		   stmt.close();
    	   }
    	   if(rst!=null)
    	   {
    		   rst.close();
    	   }
       }

	}
