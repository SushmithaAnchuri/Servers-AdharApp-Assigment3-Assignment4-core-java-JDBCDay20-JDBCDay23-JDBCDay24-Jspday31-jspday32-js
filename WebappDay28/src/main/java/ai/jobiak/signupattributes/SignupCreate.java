package ai.jobiak.signupattributes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupCreate
 */
public class SignupCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupCreate() {
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
		
		/*
		 * String fnameStr=request.getParameter("fname"); String
		 * emailStr=request.getParameter("email"); String
		 * mobileStr=request.getParameter("mobile");
		 * response.getWriter().println(fnameStr+emailStr+mobileStr);
		 */
		Connection con=connect();
		int count=0;
		try {
		
			//String str="select * from signup";
	      Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from customer");
		rs.next();
		PrintWriter out= response.getWriter();//.append("Served at: ").append(request.getContextPath());
		
		ServletContext context=getServletContext();
		context.setAttribute("id", rs.getString(1));
		context.setAttribute("name", rs.getString(2));
		context.setAttribute("price", rs.getString(3));
		
		/*
		 * request.setAttribute("fname", rs.getString(1)); request.setAttribute("email",
		 * rs.getString(2)); request.setAttribute("mobile", rs.getString(3));
		 */
		
		RequestDispatcher dispatcher= context.getRequestDispatcher("/reads");
		dispatcher.forward(request, response);
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
}
