package com.student.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.utility.JdbcUtility;
import com.student.bean.StudentBean;
import com.student.query.QueryConstants;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int insert(StudentBean sb) {
		// TODO Auto-generated method stub
		connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try{
			con=(connection) JdbcUtility.getConnection();
			ps=con.prepareStatement(QueryConstants.INSERT_QUERY);
			ps.setInt(1,sb.getSno());
			ps.setString(2,sb.getSname());
			ps.setString(3,sb.getSadd());
			count=ps.executeUpdate();
		
	
	
			return count;
			
			
		}catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
			
		}
		finally
		{
			try {
				JdbcUtility.release(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public StudentBean viewStudentId(int sno) {
		// TODO Auto-generated method stub
		connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StudentBean bean=null;
		
		try{
			con=(connection) JdbcUtility.getConnection();
			ps=con.prepareStatement(QueryConstants.SELECT_QUERY);
		ps.setInt(1,sno);
		rs=ps.executeQuery();
		if(rs.next())
		{
			bean=new StudentBean(sno, null, null);
		    bean.setSno(rs.getInt(1));
		    bean.setSname(rs.getString(2));
		    bean.setSadd(rs.getString(3));
			
		}
	
		}catch (ClassNotFoundException |SQLException e){
			e.printStackTrace();
			
			
		}
		return bean;
	}

}
