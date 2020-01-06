package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getSession().setAttribute("msg", "Please login");
		response.sendRedirect("login.jsp");
	}

	protected void getProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.sendRedirect("profile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (!(username.equals("admin") && password.equals("pass")))
		{
			request.getSession().setAttribute("msg", "One of the fields invalid.");
			response.sendRedirect("login.jsp");
		} else
		{
			request.getSession().setAttribute("msg", "Login success. Welcome back " + username);
			getProfile(request, response);

		}
	}

}
