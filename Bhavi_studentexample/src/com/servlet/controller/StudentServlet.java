package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.student.bean.StudentBean;
import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImpl;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter pw=response.getWriter();
	String no=request.getParameter("sno");
	int sno=Integer.parseInt(no);
	
	String sname=request.getParameter("sname");
	String sadd=request.getParameter("sadd");
	
	//pw.println(sno+"\t"+sname+"\t"+sadd);
	//instead of sending a data individually we can store a data into the object 
	//sent its called technically dto (data transfer object)
	StudentBean bean=new StudentBean(sno,sname,sadd);
	StudentDao dao=new StudentDaoImpl();
	int count=dao.insert(bean);
	if(count!=0)
	{
		pw.println("Data inserted successfully" +"<br>");
		pw.println("<a href='student.html'>Home</a>");
		pw.println("<a href='Retrive.html'>ViewStudentId</a>");
	}
	
	else
		
		pw.println("Data not inserted successfully" +"<br>");
	    pw.println("<a href='student.html'>Home</a>");
	    pw.println("<a href='Retrive.html'>ViewStudentId</a>");
	    
	
	}
	

	
	
	
	

}
