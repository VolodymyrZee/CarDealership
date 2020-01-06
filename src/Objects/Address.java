package Objects;

public class Address
{
	private String street;
	private String city;
	private String state;
	private String zipCode;

	public String formatAddress()
	{
		return this.street+","+this.city+","+this.state+","+this.zipCode;
	}

	public Address()
	{
	}

	public Address(String stret, String city, String state, String zipCode)
	{
		this.street = stret;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreetAddress(String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

} // closing bracket