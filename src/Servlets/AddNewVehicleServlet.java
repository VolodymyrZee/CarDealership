package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Objects.Vehicle;

/**
 * Servlet implementation class AddNewVehicleServlet
 */
@WebServlet("/AddNewVehicleServlet")
public class AddNewVehicleServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewVehicleServlet()
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
		HttpSession session = request.getSession(true);
		Vehicle vehicle = new Vehicle();

		vehicle.setMake(request.getParameter("make"));
		vehicle.setModel(request.getParameter("model"));
		vehicle.setColor(request.getParameter("color"));
		vehicle.setYear(request.getParameter("year"));
		vehicle.setVin(request.getParameter("vin"));
		vehicle.setTransmission(request.getParameter("transmission"));
		vehicle.setFuelType(request.getParameter("fuelType"));
		String price = request.getParameter("price");
		vehicle.setPrice(Integer.parseInt(price));
		vehicle.setDateOfPurchase(request.getParameter("dateOfPurchase"));
		vehicle.setMileage(request.getParameter("mileage"));
		if (request.getParameter("isPreOwned").equals("used"))
		{
			vehicle.setIsPreOwned(true);
		} else
		{
			vehicle.setIsPreOwned(false);
		}
		vehicle.setIsInAuction(false);
		vehicle.setVehiclePicture(request.getParameter("vehiclePicture"));

		vehicle.addToInventory();

		session.setAttribute("msg", "The inventory was successfully updated.");
		RequestDispatcher rs = request.getRequestDispatcher("profile.jsp");
		rs.forward(request, response);
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
