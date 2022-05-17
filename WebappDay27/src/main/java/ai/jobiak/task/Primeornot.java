package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Primeornot
 */
@WebServlet("/pn")
public class Primeornot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Primeornot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=   response.getWriter();
		response.setContentType("text/html");    
        out=response.getWriter();    
            
        String n=request.getParameter("number");    
        int number=Integer.parseInt(n);    
            
        int flag=0;    
            
        for(int i=2;i<=(number-1);i++)    
        {    
            if(number%2==0)    
            {    
                flag=1;    
                break;    
            }    
        }    
                    
            
        if(flag==0)    
        {    
            out.println("Number is Prime");    
        }    
        else    
        {    
            out.println("Number is not prime");    
        }    
            
        out.close();    
	}

}
