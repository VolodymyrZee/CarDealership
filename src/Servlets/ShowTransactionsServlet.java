package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Objects.Transaction;

/**
 * Servlet implementation class ShowTransactionsServlet
 */
@WebServlet("/ShowTransactionsServlet")
public class ShowTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTransactionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Transaction t = new Transaction();
		ArrayList<Transaction> transactions =  t.loadTransactions();
		ArrayList<Transaction> sortedTransactions = t.sortTransactions(transactions);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("transactions", sortedTransactions);
		RequestDispatcher rs = request.getRequestDispatcher("transactionsReport.jsp");
		rs.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
