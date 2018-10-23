package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.student.bean.StudentBean;
import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImpl;

/**
 * Servlet implementation class RetriveServlet
 */

public class RetriveServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public RetriveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String no=request.getParameter("sno");
	int sno=Integer.parseInt(no);
	StudentDao dao= new StudentDaoImpl();
	StudentBean sb=dao.viewStudentId(sno);
	PrintWriter pw=response.getWriter();
	
	if(sb!=null)
	{
	pw.println("<center><table width=50px borde=2>");
	pw.println("<tr><th>sno</th><th>sname</th><th>sadd</th></tr>");
	pw.println("<td>"+sb.getSno()+"</td>");
	pw.println("<td>"+sb.getSname()+"</td>");
	pw.println("<td>"+sb.getSadd()+"</td>");
	pw.println("</tr></table></center>");
	pw.println("<a href='student.html'>Home</a>");
	pw.println("<a href='Retrive.html'>ViewStudentId</a>");
	}
	else
	{
	pw.println("<center><h1>student is not available</h1></center>");
	pw.println("<a href='student.html'>Home</a>");
	pw.println("<a href='Retrive.html'>ViewStudentId</a>");
	
	}
	
	
	}
	}

