package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReverseString
 */
@WebServlet("/reverse")
public class ReverseString extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReverseString() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=  response.getWriter();//.append("Served at: ").append(request.getContextPath());
		String rev = "";
        String n = request.getParameter("myText"); // read user entered value in text box.
        if(n != null) { // if myText is entered 
            int len = n.length();
            for (int i = len - 1; i >= 0; i--) {
                rev = rev + n.charAt(i);
            }
            // 3. Print the result string.
            out.println("Reverse of Given String is :");
            out.println("" + rev);
	}

}
}
