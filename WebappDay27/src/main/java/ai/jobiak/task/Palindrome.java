package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Palindrome
 */
@WebServlet("/pal")
public class Palindrome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Palindrome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();    
        response.setContentType("text/html");      
        String name=request.getParameter("name");    
            
        StringBuffer sb=new StringBuffer(name);    
        String reverse=sb.reverse().toString();    
            
        if(name.equalsIgnoreCase(reverse))    
        {    
            out.println("It is a palindrome");    
        }    
        else    
        {    
            out.println("It is not a palindrome");    
        }    
            
        out.close();   
	}

}
