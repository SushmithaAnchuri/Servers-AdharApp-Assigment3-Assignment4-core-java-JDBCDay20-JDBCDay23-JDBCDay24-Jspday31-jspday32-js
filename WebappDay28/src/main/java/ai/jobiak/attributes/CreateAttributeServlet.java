package ai.jobiak.attributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAttributeServlet
 */
public class CreateAttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAttributeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();//.append("Served at: ").append(request.getContextPath());
		
		ServletContext context=getServletContext();//context is alive till the application is running in an application
		context.setAttribute("dbname", "mysql");//the context attributes will be available to all servlets and jsp in an application
		context.setAttribute("dbVersion", "8.0.28");//these attributes will be in memory till the applivation is running 
		
		
		request.setAttribute("jdk", "17.01");// will be alive till the request is in progress on server side
		request.setAttribute("os", "Windows 10");//they are lost once the responce is sent to client
		RequestDispatcher dispatcher= context.getRequestDispatcher("/read");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
