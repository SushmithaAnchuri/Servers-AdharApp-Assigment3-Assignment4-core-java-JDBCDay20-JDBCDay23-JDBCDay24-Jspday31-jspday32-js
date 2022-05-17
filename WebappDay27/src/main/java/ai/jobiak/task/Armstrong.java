package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Armstrong
 */
@WebServlet("/arm")
public class Armstrong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Armstrong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String input=request.getParameter("number");
		int num=Integer.parseInt(input);
		int i = num;
		int number=0,remainder;
		while(num > 0){
		remainder = num % 10;
		number = number + (int)Math.pow(remainder,3);
		num = num / 10;
		}
		if(number == i){
		out.println(i+" is an Armstrong Number");
		}
		else{
		out.println(i+" is not a Armstrong Number");
	}

	}
}
