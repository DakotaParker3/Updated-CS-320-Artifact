package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Contact;

public class ContactTest {
	
	// Tests a valid constructor
	@Test
    public void testValidConstructor() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
        
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);
        
        assertEquals(contactID, testContact.getContactID());
        assertEquals(firstName, testContact.getFirstName());
        assertEquals(lastName, testContact.getLastName());
        assertEquals(phone, testContact.getPhone());
        assertEquals(address, testContact.getAddress());
    }
	
	// Tests an invalid constructor - first name is too long
	@Test
	public void testConstructorFirstLong() {
        String contactID = "1";
      	String firstName = "DakotaDakotaDakotaDakotaDakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";       
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, phone, address);
        });
        
        assertEquals("Invalid First Name", exception.getMessage());
	}
	
	// Tests an invalid constructor - first name is null
	@Test
	public void testConstructorFirstNull() {
        String contactID = "1";
      	String firstName = null;
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";       
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, phone, address);
        });
        
        assertEquals("Invalid First Name", exception.getMessage());
	}
	
	// Tests an invalid constructor - last name is too long
	@Test
	public void testConstructorLastLong() {
        String contactID = "1";
      	String firstName = "Dakota";
        String lastName = "ParkerParkerParkerParkerParker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";       
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, phone, address);
        });
        
        assertEquals("Invalid Last Name", exception.getMessage());
	}
	
	// Tests an invalid constructor - last name is null
	@Test
	public void testConstructorLastNull() {
        String contactID = "1";
      	String firstName = "Dakota";
        String lastName = null;
        String phone = "1231231234";
        String address = "1234 Test Avenue";       
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, phone, address);
        });
        
        assertEquals("Invalid Last Name", exception.getMessage());
	}
	
	// Tests an invalid constructor - phone too short
	@Test
	public void testConstructorShortPhone() {
        String contactID = "1";
      	String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1";
        String address = "1234 Test Avenue";       
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, phone, address);
        });
        
        assertEquals("Invalid Phone Number", exception.getMessage());
	}
	
	// Tests an invalid constructor - phone too long
	@Test
	public void testConstructorLongPhone() {
        String contactID = "1";
      	String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1234567890123456789";
        String address = "1234 Test Avenue";       
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, phone, address);
        });
        
        assertEquals("Invalid Phone Number", exception.getMessage());
	}
	
	// Tests an invalid constructor - phone is null
	@Test
	public void testConstructorPhoneNull() {
        String contactID = "1";
      	String firstName = "Dakota";
        String lastName = "Parker";
        String phone = null;
        String address = "1234 Test Avenue";       
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, phone, address);
        });
        
        assertEquals("Invalid Phone Number", exception.getMessage());
	}
	
	// Tests an invalid constructor - address is too long
	@Test
	public void testConstructorAddressLong() {
        String contactID = "1";
      	String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "12345678901234567890 Address Too Long Avenue";       
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, phone, address);
        });
        
        assertEquals("Invalid Address", exception.getMessage());
	}
	
	// Tests an invalid constructor - address is null
	@Test
	public void testConstructorAddressNull() {
        String contactID = "1";
      	String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = null;       
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, phone, address);
        });
        
        assertEquals("Invalid Address", exception.getMessage());
	}
	
	// Tests getContactID with a valid constructor
	@Test
	public void testGetContactID() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        assertEquals("1", testContact.getContactID());
	}
	
	// Tests getContactID with an ID that is too long
	@Test
	public void testLongGetContactID() {
        String contactID = "1234567890123456789";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, phone, address);
        });
        
        assertEquals("Invalid Contact ID", exception.getMessage());
	}
	
	// Tests setFirstName with a valid input
	@Test
	public void testValidSetFirstName() {
        String contactID = "1";
      	String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        testContact.setFirstName("Parker");        
        assertEquals("Parker", testContact.getFirstName());
	}
	
	// Tests setFirstName with a null input
	@Test
	public void testNullSetFirstName() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName(null);
        });
        
        assertEquals("Invalid First Name", exception.getMessage());
	}
	
	// Tests setFirstName with a first name that is too long
	@Test
	public void testLongSetFirstName() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName("DakotaDakotaDakotaDakotaDakota");
        });
        
        assertEquals("Invalid First Name", exception.getMessage());
	}
	
	// Tests setLastName with a valid input
	@Test
	public void testValidSetLastName() {
        String contactID = "1";
      	String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        testContact.setLastName("Dakota");        
        assertEquals("Dakota", testContact.getLastName());
	}
		
	// Tests setLastName with a null input
	@Test
	public void testNullSetLastName() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName(null);
        });
        
        assertEquals("Invalid Last Name", exception.getMessage());
	}
		
	// Tests setLastName with a last name that is too long
	@Test
	public void testLongSetLastName() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName("ParkerParkerParkerParkerParker");
        });
        
        assertEquals("Invalid Last Name", exception.getMessage());
	}
		
	// Tests setPhone with a valid input
	@Test
	public void testValidSetPhone() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   

        testContact.setPhone("4321321321");        
        assertEquals("4321321321", testContact.getPhone());
	}
		
	// Tests setPhone with a null input
	@Test
	public void testNullSetPhone() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhone(null);
        });
        
        assertEquals("Invalid Phone Number", exception.getMessage());
	}
		
	// Tests setPhone with an input that is too short and an input that is too long
	@Test
	public void testInvalidSetPhone() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        
        IllegalArgumentException shortException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhone("1");
        });
        assertEquals("Invalid Phone Number", shortException.getMessage());
        
        IllegalArgumentException longException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhone("1234567890123456789");
        });
        assertEquals("Invalid Phone Number", longException.getMessage());
	}
		
	// Tests setAddress with a valid input
	@Test
	public void testValidSetAddress() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   

        testContact.setAddress("4321 Valid Avenue");        
        assertEquals("4321 Valid Avenue", testContact.getAddress());
	}
		
	// Tests setAddress with a null input
	@Test
	public void testNullSetAddress() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress(null);
        });
        
        assertEquals("Invalid Address", exception.getMessage());
	}
		
	// Tests setAddress with an input that is too long
	@Test
	public void testWrongLengthAddress() {
        String contactID = "1";
        String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";
		
        Contact testContact = new Contact(contactID, firstName, lastName, phone, address);   
        
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress("12345678901234567890 Address Too Long Avenue");
        });
        
        assertEquals("Invalid Address", exception.getMessage());
	}

}