package demo.servlet.chaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd=null;
		//retriving data from html page
		String uid= request.getParameter("userid");
		String password=request.getParameter("password");
		if(uid.equals("java") && password.equals("java")) {
			System.out.println("Welcome "+uid);
			out.print("<h1>Welcome "+uid+"</h1>");
			rd=request.getRequestDispatcher("userpage");
//			rd.include(request, response);
			rd.forward(request, response);
		}
		else {
			out.println("<h3>invalid username or password</h3>");
			//rd=request.getRequestDispatcher("/html/index.html");
			//rd.include(request, response);
			response.sendRedirect("http://localhost:8090/ServletChaining/html/index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
