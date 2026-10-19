package main;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor
	public Contact(String contactID, String firstName, String lastName,
			String phone, String address) {

		validateContactID(contactID);
		validateFirstName(firstName);
		validateLastName(lastName);
		validatePhone(phone);
		validateAddress(address);
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		
	}
	
	// Getters
	public String getContactID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	// Sets and validates first name
	public void setFirstName(String firstName) {
		validateFirstName(firstName);
		this.firstName = firstName;
	}
	
	// Sets and validates last name
	public void setLastName(String lastName) {
		validateLastName(lastName);
		this.lastName = lastName;
	}
	
	// Sets and validates phone
	public void setPhone(String phone) {
		validatePhone(phone);
		this.phone = phone;
	}
	
	// Sets and validates address
	public void setAddress(String address) {
		validateAddress(address);
		this.address = address;
	}

	// Validates contact ID
	private void validateContactID(String contactID) {
		if(contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
	}

	// Validates first name
	private void validateFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
	}

	// Validates last name
	private void validateLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
	}

	// Validates phone
	private void validatePhone(String phone) {
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
	}

	// Validates address
	private void validateAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
	}

}
