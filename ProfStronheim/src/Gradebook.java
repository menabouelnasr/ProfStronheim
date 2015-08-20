

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class InputName
 */
@WebServlet("/Gradebook")
public class Gradebook extends HttpServlet 
{
	static Connection conn;
	static String name, grade, output;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

    public Gradebook() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void addToDatabase ( String StudentID, String assignmentName, String type, String day, String grade ) {
         	//URL of Oracle database server
         	 
              String url = "jdbc:oracle:thin:testuser/password@localhost"; 
              try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
              
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
              Statement stmt = null;
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try 
			{    
				String insertQuery = "insert into Gradebook";
				insertQuery += " values ( '" + StudentID + "', '"+ assignmentName + "', '" + type + "','"+ day + "','" +grade + "' )"; 
				stmt.execute ( insertQuery );   
				
				System.out.println(insertQuery);
				conn.close();    
			} 
			catch ( SQLException ex ) 
			{
				ex.printStackTrace();
			}

    }
    protected void processRequest( HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException 
    {
    	String ID, assignmentName, type, day, tempStr;
	
    	ID= request.getParameter("StudentID");
    	assignmentName = (String)request.getParameter( "Assignment" );
    	type=request.getParameter("type");
    	day=request.getParameter("day");
    	tempStr = (String)request.getParameter( "grade" );
    	//System.out.println(tempStr);
    	//System.out.println(assignmentName);
    	//grade = Integer.parseInt( tempStr );
    	addToDatabase ( ID, assignmentName, type, day, tempStr );
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    getServletContext().getRequestDispatcher("/Output.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		processRequest(request, response);
		getServletContext().getRequestDispatcher("/Output.jsp").forward(request,response);
		
	}

}
