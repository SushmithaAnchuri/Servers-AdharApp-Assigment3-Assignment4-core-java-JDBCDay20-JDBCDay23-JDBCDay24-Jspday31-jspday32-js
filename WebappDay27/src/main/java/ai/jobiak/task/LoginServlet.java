package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>Servlet LoginServlet</title></head>");
		String uname = request.getParameter("txtId");
		String upass = request.getParameter("txtPass");
		if(uname.equals("admin") && upass.equals("servlet"))
		{
		RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
		rd.forward(request, response);
		}
		else
		{
		out.println("<body bgcolor=red >");
		out.println("<h1> Login Fail !!! </h1>");
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.include(request, response);
		}
		out.println("</body>");
		out.println("</html>");
	}

}
