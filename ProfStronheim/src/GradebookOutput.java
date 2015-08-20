import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Servlet implementation class Details	
 */
@WebServlet("/GradebookOutput")
public class GradebookOutput extends HttpServlet {
	static Connection conn;
	static String assignment, grade, output="", custID="", aveT="";
	static int grade2, count=0;
	static double average, average2;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradebookOutput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest( HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException 
    {
    	

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ID, assignmentName, type, day, tempStr;
    	String grade = "";
    	
    	ID= request.getParameter("A");
    	System.out.println(ID);
   
    	type=request.getParameter("B");
    	
    	
         try {
        	//URL of Oracle database server
        	 
             String url = "jdbc:oracle:thin:testuser/password@localhost"; 
             Class.forName("oracle.jdbc.driver.OracleDriver");
             
             //properties for creating connection to Oracle database
             Properties props = new Properties();
             props.setProperty("user", "testdb");
             props.setProperty("password", "password");
           
             //creating connection to Oracle database using JDBC
             try {
     			conn = DriverManager.getConnection(url,props);
     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
          
             Statement stmt = conn.createStatement();
             
             custID= request.getParameter("display");
             System.out.println(custID);
             if(custID.equalsIgnoreCase("A"))
             {
            	 ResultSet rs = stmt.executeQuery("select Assigment from Gradebook where StudentID = '"+ ID + "'" ); 
            	 
            	 output+="<table border=1 color=white bgcolor=white>";
            	 output+="<tr><th>Assignments</th></tr> ";
            	 while(rs.next())
                	 {
                		 assignment= rs.getString("Assigment");
                		 output+= "<tr><td>" + assignment +"</td></tr>"; 
                	 }
             }
             else if(custID.equalsIgnoreCase("b"))
             {
            	 ResultSet rs = stmt.executeQuery("select assigment from Gradebook where type = '"+ type + "'"); 
            	 output+="<table border=2 color=white bgcolor=black>";
            	 output+="<tr><th>Assignments</th></tr> ";
            	 while(rs.next())
            	 {
            		 assignment= rs.getString("type");
            		 output+= "<tr><td>" + assignment +"</td></tr>"; 
            	 }
             }
             else if(custID.equalsIgnoreCase("c"))
             {
            	 ResultSet rs = stmt.executeQuery("select assigment from Gradebook where type = "+ type + "and StudentID = '" + ID + "'"); 
            	 output+="<table border=2 color=white bgcolor=black>";
            	 output+="<tr><th>Assignment</th></tr> ";
            	 while(rs.next())
            	 {
            		 assignment= rs.getString("Assigment");
            		 output+= "<tr><td>" + assignment +"</td></tr>"; 
            	 }
             }
             else if(custID.equalsIgnoreCase("d"))
             {
            	 ResultSet rs = stmt.executeQuery("select grade from Gradebook where StudentID =" + ID); 
            	 while(rs.next())
                	 {
                		 grade= rs.getString("Grade");
                		 grade2= Integer.parseInt(grade);
                		 average+=grade2;
                		 count++;
                	 }
            	 aveT+="<p></p><table alight=center border=1 color=white bgcolor=white>";
            	 aveT+="<tr><th>Average</th></tr> ";
            	 average2=average/count;
            	 aveT+= "<tr><td>" + String.valueOf(average2) +"</td></tr>";
             }
             else if(custID.equalsIgnoreCase("e"))
             {
            	 //do max and min
             }
             else
             {
            	 //done
             }
       
               conn.close();
        }
         catch (Exception e) 
         {
        	 e.getMessage();
         }
         
         request.setAttribute("message", output);
	     getServletContext().getRequestDispatcher("/FinalOutput.jsp").forward(request,response);
	     output="";
	     aveT="";
	 
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
