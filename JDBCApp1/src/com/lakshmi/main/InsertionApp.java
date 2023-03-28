package com.lakshmi.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lakshmi.jdbc.JdbcUtil;

public class InsertionApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt =null;
		ResultSet rst=null;
		try {
			con=JdbcUtil.getJdbcConnection();
			if(con!=null) {
				stmt=con.createStatement();
			}
			if(stmt!=null) {
				rst=stmt.executeQuery("select sid,sname,sage,scity from student");
			}
			if(rst!=null) {
				System.out.println("sid\t\tsname\t\tsage\t\tscity");
				while(rst.next()) {
					
					System.out.println(rst.getInt(1)+"\t\t"+rst.getString(2)+"\t\t"+rst.getInt(3)+"\t\t"+rst.getString(4));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.CleanUp(con, stmt, rst);
				System.out.println("resources closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}{
				
			}
		}
	}

}