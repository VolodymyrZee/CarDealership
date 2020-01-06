package Objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Vehicle
{

	private String make;
	private String model;
	private String color;
	private String year;
	private String vin;
	private String transmission; // automatic, manual
	private String fuelType; // gas or diesel or...??
	private int price; // in $
	private String dateOfPurchase; // ??from todays date??
	private String mileage; // if 0 - new, in >0 - used??
	private boolean isPreOwned;
	private boolean isInAuction;
	private String vehiclePicture;
	private static final String path = "/Users/yuliiayarema/eclipse-workspace/CarDealership/Inventory/inventory.txt";

	public Vehicle()
	{
	}

	public Vehicle(String make, String model, String color, String year, String vin, String transmission,
			String fuelType, int price, String dateOfPurchase, String mileage, boolean isPreowned,
			boolean isInAuction, String vehiclePicture)
	{
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.vin = vin;
		this.transmission = transmission;
		this.fuelType = fuelType;
		this.price = price;
		this.dateOfPurchase = dateOfPurchase;
		this.mileage = mileage;
		this.isPreOwned = isPreowned;
		this.isInAuction = isInAuction;
		this.vehiclePicture = vehiclePicture;

	}

	public String getVehiclePicture()
	{
		return vehiclePicture;
	}

	public void setVehiclePicture(String vehiclePicture)
	{
		this.vehiclePicture = vehiclePicture;
	}

	public boolean isPreOwned()
	{
		return isPreOwned;
	}

	public void setIsPreOwned(boolean isPreOwned)
	{
		this.isPreOwned = isPreOwned;
	}

	public boolean isInAuction()
	{
		return isInAuction;
	}

	public void setIsInAuction(boolean isInAuction)
	{
		this.isInAuction = isInAuction;
	}

	public String getMake()
	{
		return make;
	}

	public void setMake(String make)
	{
		this.make = make;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	public String getVin()
	{
		return vin;
	}

	public void setVin(String vin)
	{
		this.vin = vin;
	}

	public String getTransmission()
	{
		return transmission;
	}

	public void setTransmission(String transmission)
	{
		this.transmission = transmission;
	}

	public String getFuelType()
	{
		return fuelType;
	}

	public void setFuelType(String fuelType)
	{
		this.fuelType = fuelType;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public String getDateOfPurchase()
	{
		return dateOfPurchase;
	}

	public void setDateOfPurchase(String dateOfPurchase)
	{
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getMileage()
	{
		return mileage;
	}

	public void setMileage(String mileage)
	{
		this.mileage = mileage;
	}

	public String formatString()
	{
		String text = this.isPreOwned + "," + this.isInAuction + ","+this.make + "," + this.model + "," + this.color + "," + this.year + "," + this.vin + ","
				+ this.transmission + "," + this.fuelType + "," + this.price + ","
				+ this.dateOfPurchase + "," + this.mileage + ","  
				+ this.vehiclePicture;
		return text;
	}

	public void addToInventory()
	{
		String fileName = path;
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(this.formatString());
			bw.newLine();
			bw.close();
		} catch (IOException e)
		{
			System.out.println("Error. File wasn't saved.");
		}
	}

	

	public ArrayList<Vehicle> loadInventory() throws ParseException
	{
		File file = new File(path);
		ArrayList<Vehicle> vehicleInventory = new ArrayList<Vehicle>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				Vehicle vehicle = new Vehicle();
				String[] parsedLine = line.split(",");

				if (parsedLine[0].equals("true"))
				{
					vehicle.setIsPreOwned(true);
				} else
				{
					vehicle.setIsPreOwned(false);
				}
				if (parsedLine[1].equals("true"))
				{
					vehicle.setIsInAuction(true);
				} else
				{
					vehicle.setIsInAuction(false);
				}
				vehicle.setMake(parsedLine[2]);
				vehicle.setModel(parsedLine[3]);
				vehicle.setColor(parsedLine[4]);
				vehicle.setYear(parsedLine[5]);
				vehicle.setVin(parsedLine[6]);
				vehicle.setTransmission(parsedLine[7]);
				vehicle.setFuelType(parsedLine[8]);
				vehicle.setPrice(Integer.parseInt(parsedLine[9]));
				vehicle.setDateOfPurchase(parsedLine[10]);
				vehicle.setMileage(parsedLine[11]);
				vehicle.setVehiclePicture(parsedLine[12]);
				vehicle.checkAuctionStatus();

				vehicleInventory.add(vehicle);

			}
			reader.close();
		} catch (IOException e)
		{
			System.out.println("Error, Couldn't read from file.");
		}

		return vehicleInventory;
	}

	
	public void updateInventory(ArrayList<Vehicle> vehicles)
	{
		String fileName = path;
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false));
			for (Vehicle v : vehicles)
			{
				bw.write(v.formatString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e)
		{
			System.out.println("Eror. File Wasn't saved");
		}
	}
	
	
	
	public void checkAuctionStatus() throws ParseException
	{
		
		Date purchaseDate = new SimpleDateFormat("MM/dd/yyyy").parse(this.getDateOfPurchase());
		
		Calendar cal = Calendar.getInstance();
		long todayInMills = cal.getTimeInMillis();
		long pDateMills = purchaseDate.getTime();
		long dif = todayInMills - pDateMills;
		int days = (int) (dif/(1000*60*60*24));
	
		
		if(days>=120)
		{
			this.setIsInAuction(true);
			int price = this.getPrice();
			this.setPrice((int) (price*.9));
		}
		else {
			this.setIsInAuction(false);
		}
		
		
	}

} // closing bracket
