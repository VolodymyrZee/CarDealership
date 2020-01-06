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

import Objects.Vehicle;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String searchByModel = request.getParameter("searchByModel");
		
		Vehicle v = new Vehicle();
		ArrayList<Vehicle> vehicleInventory = new ArrayList<Vehicle>();
		try {
			vehicleInventory = v.loadInventory();
			
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		for(Vehicle vehicle: vehicleInventory) {
			if(vehicle.getModel().equalsIgnoreCase(searchByModel))
			{
				vehicles.add(vehicle);
			}
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("vehicles", vehicles);
		RequestDispatcher rs = request.getRequestDispatcher("showCars.jsp");
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
