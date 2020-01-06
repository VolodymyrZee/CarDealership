package Objects;

public class Person
{
	private String firstName;
	private String lastName;
	private String telephone;
	private String email;
	private Address address;

	public String formatPerson()
	{
		return this.firstName + "," + this.lastName + "," + this.telephone + "," + this.email + ","
				+ this.address.formatAddress();
	}

	public Person()
	{
	}

	public Person(String firstName, String lastName, String telephone, String email, Address address)
	{

		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setPhoneNumber(String telephone)
	{
		this.telephone = telephone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}
}//closing bracket