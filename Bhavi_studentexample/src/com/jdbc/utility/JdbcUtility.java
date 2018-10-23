package com.jdbc.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.student.dao.connection;

public class JdbcUtility {
   private static Connection con=null;
   public static Connection getConnection() throws ClassNotFoundException, SQLException
   {
	   //step 1: register a driver
	   //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   //step 2: Establish Connection with database software
	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","bparm");
	   if(con!=null)
		   System.out.println("Connection Established");
	   else
		   System.out.println("Connection is not Established");
	   
	   return con;
	   
   }
public static void release(connection con2, PreparedStatement ps) throws SQLException {
	//TODO Auto-generated method stub
	if(ps!=null)
		ps.close();
	if(con2!=null)
		con2.close();
	
}
    public static void release (Connection con,PreparedStatement ps, ResultSet rs) throws SQLException {
    	//TODO Auto-generated method stub
    	if(rs!=null)
    		rs.close();
    	if(con!=null)
    		con.close();
    }

    	
    		
    		
    }


