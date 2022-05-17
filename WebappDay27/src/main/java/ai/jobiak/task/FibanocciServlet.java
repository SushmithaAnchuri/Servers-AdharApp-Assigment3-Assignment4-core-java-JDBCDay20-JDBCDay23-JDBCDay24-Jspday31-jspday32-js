package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FibanocciServlet
 */
@WebServlet("/fib")
public class FibanocciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FibanocciServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();//.append("Served at: ").append(request.getContextPath());
		 String s=request.getParameter("n1");
         int n=Integer.parseInt(s);
         int i=1,f1=0,f2=1,f3;
         while(i<=n)
         {
           out.println(f1);
           f3=f1+f2;
           f1=f2;
           f2=f3;
           i=i+1; 
	}
         out.println("The fibanocci is:"+f1);
}
}
