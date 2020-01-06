package Objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Transaction
{

	private String transactionDate;
	/* private Person person; */
	private String vinSold;
	/* public boolean isPreOwned; */
	private int salePrice;
	private String makeSold;
	private String modelSold;
	private String yearSold;
	private static final String path = "/Users/yuliiayarema/eclipse-workspace/CarDealership/Inventory/transactions.txt";

	
	
	
	public Transaction()
	{

	}

	public Transaction(String transactionDate, /* Person person, */ String vinSold, /*boolean isPreOwned*/ int salePrice, String makeSold, String modelSold, String yearSold)
	{

		this.transactionDate = transactionDate;
		/* this.person = person; */
		this.vinSold = vinSold;
		/* this.isPreOwned = isPreOwned; */
		this.salePrice = salePrice;
		this.makeSold = makeSold;
		this.modelSold = modelSold;
		this.yearSold = yearSold;
	}
	
	public String getMakeSold()
	{
		return makeSold;
	}

	public void setMakeSold(String makeSold)
	{
		this.makeSold = makeSold;
	}

	public String getModelSold()
	{
		return modelSold;
	}

	public void setModelSold(String modelSold)
	{
		this.modelSold = modelSold;
	}

	public String getYearSold()
	{
		return yearSold;
	}

	public void setYearSold(String yearSold)
	{
		this.yearSold = yearSold;
	}

	public String getTransactionDate()
	{
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate)
	{
		this.transactionDate = transactionDate;
	}

	/*
	 * public Person getPerson() { return person; }
	 * 
	 * public void setPerson(Person person) { this.person = person; }
	 */

	public String getVinSold()
	{
		return vinSold;
	}

	public void setVinSold(String vinSold)
	{
		this.vinSold = vinSold;
	}

	/*
	 * public boolean isPreOwned() { return isPreOwned; }
	 * 
	 * public void setIsPreOwned(boolean isPreOwned) { this.isPreOwned = isPreOwned;
	 * }
	 */
	 
	public int getSalePrice()
	{
		return salePrice;
	}

	public void setSalePrice(int salePrice)
	{
		this.salePrice = salePrice;
	}

//	public String formatString()
//	{
//
//		String text = this.transactionDate + "," + /* this.person.formatPerson() + "," + */  this.vinSold + ","
//		/* + this.isPreOwned + "," */ + this.salePrice+","+this.makeSold+","+this.modelSold+","+this.yearSold;
//		return text;
//	}
	

	@Override
	public String toString()
	{
		return "Transaction [transactionDate=" + transactionDate + ", vinSold=" + vinSold + ", salePrice=" + salePrice
				+ ", makeSold=" + makeSold + ", modelSold=" + modelSold + ", yearSold=" + yearSold + "]";
	}

	public void updateTransactions()
	{
		String fileName = path;
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(this.toString());
			bw.newLine();
			bw.close();

		} catch (IOException e)
		{
			System.out.println("Error. Couldn't save the file.");
		}
	}

	public ArrayList<Transaction> loadTransactions()
	{

		File file = new File(path);
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{

				String[] parsedLine = line.split(",");
				Transaction transaction = new Transaction();
				/*
				 * Person p = new Person(); Address a = new Address();
				 */

				transaction.setTransactionDate(parsedLine[0]);
				
				/*
				 * String firstName = parsedLine[1]; String lastName = parsedLine[2]; String
				 * telephone = parsedLine[3]; String email = parsedLine[4]; String street =
				 * parsedLine[5]; String city = parsedLine[6]; String state = parsedLine[7];
				 * String zipCode = parsedLine[8];
				 */
				 

				transaction.setVinSold(parsedLine[1]);
				
				/*
				 * if (parsedLine[2].equals("true")) { transaction.setIsPreOwned(true); } else {
				 * transaction.setIsPreOwned(false); }
				 */
				 
				transaction.setSalePrice(Integer.parseInt(parsedLine[2]));
				transaction.setMakeSold(parsedLine[3]);
				transaction.setModelSold(parsedLine[4]);
				transaction.setYearSold(parsedLine[5]);

				/*
				 * p.setFirstName(firstName); p.setLastName(lastName);
				 * p.setPhoneNumber(telephone); p.setEmail(email); p.setAddress(a);
				 * 
				 * a.setStreetAddress(street); a.setCity(city); a.setState(state);
				 * a.setZipCode(zipCode);
				 */
				  
				/* transaction.person.setAddress(a); transaction.person = p; */
				 

				transactions.add(transaction);

			}
		} catch (IOException e)
		{
			System.out.println("Error occured. Couldn't read from file.");
		}
		return transactions;
	}

	public ArrayList<Transaction> sortTransactions(ArrayList<Transaction> transactions)
	{

		ArrayList<Transaction> sortedTransactions = new ArrayList<Transaction>();

		int[] newDays = new int[transactions.size()];
		for (Transaction t : transactions)
		{
			String date = t.getTransactionDate();
			String temp = date.substring(6) + date.substring(0, 2) + date.substring(3, 5);
			newDays[transactions.indexOf(t)] = Integer.parseInt(temp);
		}

		Arrays.sort(newDays);
		ArrayList<String> sortedDates = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for (int i : newDays)
		{

			String sortedDate = Integer.toString(i);
			sb.append(sortedDate.substring(4, 6));
			sb.append("/");
			sb.append(sortedDate.substring(6));
			sb.append("/");
			sb.append(sortedDate.substring(0, 4));
			sortedDates.add(sb.toString());
			sb.delete(0, sb.length());
		}
		for (String date : sortedDates)
		{
			for (Transaction t : transactions)
			{
				String dos = t.getTransactionDate();
				if (dos.equals(date))
				{
					sortedTransactions.add(sortedDates.indexOf(date), t);
				}
			}
		}
		Collections.reverse(sortedTransactions);
		return sortedTransactions;
	}

}//closing bracket
