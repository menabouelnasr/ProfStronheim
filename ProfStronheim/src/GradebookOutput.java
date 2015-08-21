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
	static String assignment, assignment2,grade, output="", custID="", aveT="";
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
		
		String ID, ID2, ID3,assignmentName, type, type2,type3, day, tempStr;
    	String grade = "";
    	
    	ID= request.getParameter("A");
    	System.out.println(ID);
   
    	type=request.getParameter("B");
    	System.out.println(type);
    	
    	ID2= request.getParameter("C");
    	System.out.println(ID2);
    	
    	type2=request.getParameter("C2");
    	System.out.println(type2);
    	
    	ID3=request.getParameter("D");
    	System.out.println(ID2);
    	
    	type3=request.getParameter("E");
    	System.out.println(type3);
    	
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
            	 System.out.println("select assigment from Gradebook where type = '"+ type + "'");
            	 ResultSet rs = stmt.executeQuery("select assigment from Gradebook where type = '"+ type + "'"); 
            	 output+="<table border=2 color=white bgcolor=white>";
            	 output+="<tr><th>Assignments</th></tr> ";
            	 while(rs.next())
            	 {
            		 assignment= rs.getString("assigment");
            		 output+= "<tr><td>" + assignment +"</td></tr>"; 
            	 }
             }
             else if(custID.equalsIgnoreCase("c"))
             {
            	 System.out.println(type);
            	 System.out.println(ID);
            	 System.out.println("select assigment from Gradebook where type = '"+ type2 + "'and StudentID = '" + ID2 + "'");
            	 ResultSet rs = stmt.executeQuery("select assigment from Gradebook where type = '"+ type2 + "'and StudentID = '" + ID2 + "'"); 
            	 output+="<table border=2 color=white bgcolor=white>";
            	 output+="<tr><th>Assignment</th></tr> ";
            	 while(rs.next())
            	 {
            		 assignment= rs.getString("Assigment");
            		 output+= "<tr><td>" + assignment +"</td></tr>"; 
            	 }
             }
             else if(custID.equalsIgnoreCase("d"))
             {
            	 System.out.println(ID3);
            	 ResultSet rs = stmt.executeQuery("select grade from Gradebook where StudentID = '"+ ID3 + "'" ); 
            	 while(rs.next())
                	 {
                		 grade= rs.getString("Grade");
                		 grade2= Integer.parseInt(grade);
                		 average+=grade2;
                		 count++;
                	 }
            	 System.out.println(average);
            	 output+="<p></p><table alight=center border=1 color=white bgcolor=white>";
            	 output+="<tr><th>Average</th></tr> ";
            	 average2=average/count;
            	 output+= "<tr><td>" + String.valueOf(average2) +"</td></tr>";
             }
             else if(custID.equalsIgnoreCase("e"))
             {
            	 System.out.println("select max (Grade), min(Grade) from gradebook where type='" + type3+ "'");
            	 ResultSet rs = stmt.executeQuery("select max (Grade), min(Grade) from gradebook where type='" + type3+ "'"); 
            	 output+="<table border=2 color=white bgcolor=white>";
            	 output+="<tr><th>Max Grade</th><th>Min Grade</th></tr> ";
            	
            	 while(rs.next())
                	 {
            		 	assignment= rs.getString("Max(Grade)");
            		 	assignment2= rs.getString("Min(Grade)");
            		 	output+= "<tr><td>" + assignment +"</td><td>" + assignment2+ "</td></tr>"; 
                	 }
      
             }
             else
             {
            	 output+="<table border=2 color=white bgcolor=white>";
            	 output+="<tr>Thanks for using the gradebook!</tr> ";
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
