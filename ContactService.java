package main;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;

public class ContactService {

	// ID to be incremented
	private int currentID = 0;

	// Hash map to store contacts using contact ID as the key
	public static HashMap<String, Contact> contactList = new HashMap<String, Contact>();

	// Adds new contact and increments ID
	public void addContact(String firstName, String lastName, String phone, String address) {
		String stringID = Integer.toString(currentID);

		// Checks for duplicate contact ID
		if(contactList.containsKey(stringID)) {
			throw new IllegalArgumentException("Contact Already Exists");
		}

		// Checks for duplicate entry
		for(Contact contact : contactList.values()) {
		    if(contact.getFirstName().equalsIgnoreCase(firstName) &&
		       contact.getLastName().equalsIgnoreCase(lastName) &&
		       contact.getPhone().equals(phone) &&
		       contact.getAddress().equalsIgnoreCase(address)) {
		        throw new IllegalArgumentException("Contact Already Exists");
		    }
		}

		Contact contact = new Contact(stringID, firstName, lastName, phone, address);
		contactList.put(stringID, contact);
		++currentID;
	}

	// Removes contact by ID
	public void removeContact(String ID) {
		contactList.remove(ID);
	}

	// Updates first name by ID
	public void updateFirstName(String contactID, String firstName) {
		Contact contact = contactList.get(contactID);

		if(contact != null) {
			contact.setFirstName(firstName);
		}
	}

	// Updates last name by ID
	public void updateLastName(String contactID, String lastName) {
		Contact contact = contactList.get(contactID);

		if(contact != null) {
			contact.setLastName(lastName);
		}
	}

	// Updates phone by ID
	public void updatePhone(String contactID, String phone) {
		Contact contact = contactList.get(contactID);

		if(contact != null) {
			contact.setPhone(phone);
		}
	}

	// Updates address by ID
	public void updateAddress(String contactID, String address) {
		Contact contact = contactList.get(contactID);

		if(contact != null) {
			contact.setAddress(address);
		}
	}

	// Searches contacts by selected field
	public List<Contact> searchContacts(String field, String value) {

		List<Contact> results = new ArrayList<Contact>();

		for(Contact contact : contactList.values()) {

			if(field.equalsIgnoreCase("firstName") &&
				contact.getFirstName().equalsIgnoreCase(value)) {

				results.add(contact);

			} else if(field.equalsIgnoreCase("lastName") &&
				contact.getLastName().equalsIgnoreCase(value)) {

				results.add(contact);

			} else if(field.equalsIgnoreCase("phone") &&
				contact.getPhone().equals(value)) {

				results.add(contact);

			} else if(field.equalsIgnoreCase("address") &&
				contact.getAddress().equalsIgnoreCase(value)) {

				results.add(contact);
			}
		}

		return results;
	}

	// Sorts contacts by selected field
	public List<Contact> sortContacts(String field) {

		List<Contact> sortedContacts = new ArrayList<Contact>(contactList.values());

		if(field.equalsIgnoreCase("firstName")) {

			sortedContacts.sort(Comparator.comparing(Contact::getFirstName));

		} else if(field.equalsIgnoreCase("lastName")) {

			sortedContacts.sort(Comparator.comparing(Contact::getLastName));

		} else if(field.equalsIgnoreCase("phone")) {

			sortedContacts.sort(Comparator.comparing(Contact::getPhone));

		} else if(field.equalsIgnoreCase("address")) {

			sortedContacts.sort(Comparator.comparing(Contact::getAddress));

		}

		return sortedContacts;
	}
}