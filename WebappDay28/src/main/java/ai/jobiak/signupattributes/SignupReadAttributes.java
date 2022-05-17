package ai.jobiak.signupattributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupReadAttributes
 */
public class SignupReadAttributes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupReadAttributes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();//.append("Served at: ").append(request.getContextPath());
		ServletContext context=getServletContext();
		out.println("id:"+context.getAttribute("id"));
		out.println("name:"+context.getAttribute("name"));
		out.println("price:"+context.getAttribute("price"));
		
	}

}
