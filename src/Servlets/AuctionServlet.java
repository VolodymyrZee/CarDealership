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
 * Servlet implementation class AuctionServlet
 */
@WebServlet("/AuctionServlet")
public class AuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vehicle vehicle = new Vehicle();
		ArrayList <Vehicle> vehicles = new ArrayList<Vehicle>();
		try {
			vehicles = vehicle.loadInventory();
			}catch (ParseException e) {
				e.printStackTrace();
			}
		ArrayList<Vehicle> vehiclesInAuction = new ArrayList<Vehicle>();
		for(Vehicle v: vehicles) {
			if(v.isInAuction()) {
				vehiclesInAuction.add(v);
			}
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("vehicles", vehiclesInAuction);
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
