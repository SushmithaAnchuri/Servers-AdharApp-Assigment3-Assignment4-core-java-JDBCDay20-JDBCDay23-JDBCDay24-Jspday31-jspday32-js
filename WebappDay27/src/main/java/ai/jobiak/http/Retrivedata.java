package ai.jobiak.http;

import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Retrivedata
 */
@WebServlet("/retrive")
public class Retrivedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Retrivedata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private Connection connect() {
   	 
  		String userName = "root";
  		String password = "admin";
  		String url = "jdbc:mysql://localhost:3306/world";
  		Connection con = null;
  	try {
  		Class.forName("com.mysql.cj.jdbc.Driver");
  		 con = DriverManager.getConnection(url,userName, password);
  	     }
  	catch (SQLException e) 
  	{
  	e.printStackTrace();
  } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	return con;
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter()//.append("Served at: ").append(request.getContextPath());
		String fnameStr=request.getParameter("fname");
		String emailStr=request.getParameter("email");
		String mobileStr=request.getParameter("mobile");
		//response.getWriter().println(fnameStr+emailStr+mobileStr);
		Connection con=connect();
        PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Statement  st=con.createStatement();
            ResultSet rs = st.executeQuery("select * from signup");  
            out.println("<table border=1 width=20% height=20%>");  
            out.println("<tr><th>fname</th><th>email</th><th>mobile</th><tr>");  
            while (rs.next()) 
            {  
                String name = rs.getString("fname");  
                String email = rs.getString("email");  
                String mobile = rs.getString("mobile");  
                out.println("<tr><td>" + name + "</td><td>" + email + "</td><td>" + mobile + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            	// TODO Auto-generated catch block
            	e.printStackTrace();
        }  
	}
	}


