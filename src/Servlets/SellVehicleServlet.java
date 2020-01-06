package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Objects.Address;
import Objects.Person;
import Objects.Transaction;
import Objects.Vehicle;

/**
 * Servlet implementation class SellVehicleServlet
 */
@WebServlet("/SellVehicleServlet")
public class SellVehicleServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellVehicleServlet()
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
		String vin = request.getParameter("vin");
		Vehicle soldVehicle = new Vehicle();
		ArrayList<Vehicle> vehicleInventory = new ArrayList<Vehicle>();

		try
		{
			vehicleInventory = soldVehicle.loadInventory();

		} catch (ParseException e2)
		{
			e2.printStackTrace();
		}

		for (Vehicle v : vehicleInventory)
		{

			if (v.getVin().equals(vin))
			{
				soldVehicle = v;
				vehicleInventory.remove(soldVehicle);
				break;
			}
		}

		if (!(soldVehicle.getVin().equals(vin)))
		{
			request.getSession().setAttribute("msg", "Couldn't find vin.");
			response.sendRedirect("sellVehicle.jsp");

		}

		else
		{

			Transaction tr = new Transaction();

			/*
			 * Person p = new Person(); Address a = new Address();
			 */

			tr.setTransactionDate(request.getParameter("transactionDate"));

			/*
			 * p.setFirstName(request.getParameter("firstName"));
			 * p.setLastName(request.getParameter("lastName"));
			 * p.setPhoneNumber(request.getParameter("telephone"));
			 * p.setEmail(request.getParameter("email"));
			 * a.setStreetAddress(request.getParameter("street"));
			 * a.setCity(request.getParameter("city"));
			 * a.setState(request.getParameter("state"));
			 * a.setZipCode(request.getParameter("zipCode"));
			 */
			tr.setVinSold(vin);
			/* tr.setIsPreOwned(soldVehicle.isPreOwned()); */
			String salePrice = request.getParameter("salePrice");
			tr.setSalePrice(Integer.parseInt(salePrice));
			tr.setMakeSold(soldVehicle.getMake());
			tr.setModelSold(soldVehicle.getModel());
			tr.setYearSold(soldVehicle.getYear());

			/*
			 * p.setAddress(a); tr.setPerson(p);
			 */

			tr.updateTransactions();

			HttpSession session = request.getSession(true);
			session.setAttribute("msg", "Sale transaction went successfull.");
			RequestDispatcher rs = request.getRequestDispatcher("profile.jsp");
			rs.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
