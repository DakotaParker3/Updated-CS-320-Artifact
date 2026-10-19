package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import main.Contact;
import main.ContactService;

public class ContactServiceTest {
	
	// Clears contact list after each test
	@AfterEach
    void tearDown() {
        ContactService.contactList.clear();
    }
	
	// Tests that a contact can be added correctly
	@Test
    void testAddContact() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();

        assertTrue(ContactService.contactList.isEmpty());

        test.addContact(firstName, lastName, phone, address);

        assertFalse(ContactService.contactList.isEmpty());
        assertEquals("0", ContactService.contactList.get("0").getContactID());
        assertEquals(firstName, ContactService.contactList.get("0").getFirstName());
        assertEquals(lastName, ContactService.contactList.get("0").getLastName());
        assertEquals(phone, ContactService.contactList.get("0").getPhone());
        assertEquals(address, ContactService.contactList.get("0").getAddress());
    }
	
	// Tests that a contact can be removed by ID
	@Test
    void testRemoveContact() {
        ContactService test = new ContactService();

        // Adds three contacts with IDs 0, 1, and 2 respectively
        test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");
        test.addContact("Alex", "Smith", "4321321321", "5678 Test Street");
        test.addContact("Jordan", "Johnson", "5555555555", "9876 Test Road");

        assertEquals(3, ContactService.contactList.size());

        // Removes contact with ID "1"
        test.removeContact("1");

        assertEquals(2, ContactService.contactList.size());
        assertFalse(ContactService.contactList.containsKey("1"));
    }
	
	// Tests that a duplicate contact cannot be added
	@Test
    void testDuplicateContact() {
        ContactService test = new ContactService();

        test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");
        });

        assertEquals("Contact Already Exists", exception.getMessage());
    }
	
	// Tests searching contacts by first name
	@Test
    void testSearchContactsByFirstName() {
        ContactService test = new ContactService();

        test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");
        test.addContact("Alex", "Smith", "4321321321", "5678 Test Street");

        List<Contact> results = test.searchContacts("firstName", "Dakota");

        assertEquals(1, results.size());
        assertEquals("Dakota", results.get(0).getFirstName());
    }
	
	// Tests searching contacts by last name
	@Test
    void testSearchContactsByLastName() {
        ContactService test = new ContactService();

        test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");
        test.addContact("Alex", "Parker", "4321321321", "5678 Test Street");

        List<Contact> results = test.searchContacts("lastName", "Parker");

        assertEquals(2, results.size());
    }
	
	// Tests searching contacts by phone number
	@Test
	void testSearchContactsByPhone() {
	    ContactService test = new ContactService();

	    test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");
	    test.addContact("Alex", "Smith", "4321321321", "5678 Test Street");

	    List<Contact> results = test.searchContacts("phone", "1231231234");

	    assertEquals(1, results.size());
	    assertEquals("1231231234", results.get(0).getPhone());
	}

	// Tests searching contacts by address
	@Test
	void testSearchContactsByAddress() {
	    ContactService test = new ContactService();

	    test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");
	    test.addContact("Alex", "Smith", "4321321321", "5678 Test Street");

	    List<Contact> results = test.searchContacts("address", "1234 Test Avenue");

	    assertEquals(1, results.size());
	    assertEquals("1234 Test Avenue", results.get(0).getAddress());
	}
	
	// Tests sorting contacts by first name
	@Test
	void testSortContactsByFirstName() {
	    ContactService test = new ContactService();

	    test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");
	    test.addContact("Alex", "Anderson", "4321321321", "5678 Test Street");

	    List<Contact> results = test.sortContacts("firstName");

	    assertEquals("Alex", results.get(0).getFirstName());
	    assertEquals("Dakota", results.get(1).getFirstName());
	}
	
	// Tests sorting contacts by last name
	@Test
    void testSortContactsByLastName() {
        ContactService test = new ContactService();

        test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");
        test.addContact("Alex", "Anderson", "4321321321", "5678 Test Street");

        List<Contact> results = test.sortContacts("lastName");

        assertEquals("Anderson", results.get(0).getLastName());
        assertEquals("Parker", results.get(1).getLastName());
    }
	
	// Tests sorting contacts by phone
	@Test
	void testSortContactsByPhone() {
	    ContactService test = new ContactService();

	    test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");
	    test.addContact("Alex", "Anderson", "4321321321", "5678 Test Street");

	    List<Contact> results = test.sortContacts("phone");

	    assertEquals("1231231234", results.get(0).getPhone());
	    assertEquals("4321321321", results.get(1).getPhone());
	}

	// Tests sorting contacts by address
	@Test
	void testSortContactsByAddress() {
	    ContactService test = new ContactService();

	    test.addContact("Dakota", "Parker", "1231231234", "1234 Test Avenue");
	    test.addContact("Alex", "Anderson", "4321321321", "5678 Test Street");

	    List<Contact> results = test.sortContacts("address");

	    assertEquals("1234 Test Avenue", results.get(0).getAddress());
	    assertEquals("5678 Test Street", results.get(1).getAddress());
	}
	
	// Tests that a contact's first name can be updated by ID
	@Test
    void testUpdateFirstName() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phone, address);

        assertEquals(firstName, ContactService.contactList.get("0").getFirstName());

        test.updateFirstName("0", "Test_First");
        assertEquals("Test_First", ContactService.contactList.get("0").getFirstName());
    }
	
	// Tests that a contact's last name can be updated by ID
	@Test
    void testUpdateLastName() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phone, address);

        assertEquals(lastName, ContactService.contactList.get("0").getLastName());

        test.updateLastName("0", "Test_Last");
        assertEquals("Test_Last", ContactService.contactList.get("0").getLastName());
    }
	
	// Test that a contact's phone can be updated by ID
	@Test
    void testUpdatePhone() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phone, address);

        assertEquals(phone, ContactService.contactList.get("0").getPhone());

        test.updatePhone("0", "1987654321");
        assertEquals("1987654321", ContactService.contactList.get("0").getPhone());
    }
	
	// Tests that a contact's address can be updated by ID
	@Test
    void testUpdateAddress() {
		String firstName = "Dakota";
        String lastName = "Parker";
        String phone = "1231231234";
        String address = "1234 Test Avenue";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phone, address);

        assertEquals(address, ContactService.contactList.get("0").getAddress());

        test.updateAddress("0", "Test_Address");
        assertEquals("Test_Address", ContactService.contactList.get("0").getAddress());
    }

}