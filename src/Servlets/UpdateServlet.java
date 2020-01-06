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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vin = request.getParameter("vin");
		Vehicle vehicleToBeUpdated = new Vehicle();
		ArrayList<Vehicle> vehicleInventory= new ArrayList<Vehicle>();
		
		try {
			vehicleInventory = vehicleToBeUpdated.loadInventory();
			
		}catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		for(Vehicle v : vehicleInventory) {
			if(v.getVin().equals(vin)) {
				vehicleToBeUpdated = v;
				vehicleInventory.remove(v);
				break;
			}
		}
		
		Vehicle updatedVehicle = new Vehicle();
		updatedVehicle.setMake(vehicleToBeUpdated.getMake());
		updatedVehicle.setModel(vehicleToBeUpdated.getModel());
		updatedVehicle.setColor(vehicleToBeUpdated.getColor());
		updatedVehicle.setYear(vehicleToBeUpdated.getYear());
		updatedVehicle.setVin(vehicleToBeUpdated.getVin());
		updatedVehicle.setTransmission(vehicleToBeUpdated.getTransmission());
		updatedVehicle.setFuelType(vehicleToBeUpdated.getFuelType());
		updatedVehicle.setPrice(vehicleToBeUpdated.getPrice());
		updatedVehicle.setDateOfPurchase(vehicleToBeUpdated.getDateOfPurchase());
		updatedVehicle.setMileage(vehicleToBeUpdated.getMileage());
		
		if(!(request.getParameter("newVehiclePicture").equals(null))) {
			updatedVehicle.setVehiclePicture(request.getParameter("newVehiclePicture"));
		}
		else {
			updatedVehicle.setVehiclePicture(vehicleToBeUpdated.getVehiclePicture());
		}
		vehicleInventory.add(updatedVehicle);
		updatedVehicle.updateInventory(vehicleInventory);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("msg", "The Inventory was successfully updated. Thank you.");
		RequestDispatcher rs = request.getRequestDispatcher("profile.jsp");
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
