package main;

import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class AppointmentService {

	// ID to be incremented
	private int currentID = 0;
	
	// HashMap to store appointments
	public static HashMap<String, Appointment> appointments = new HashMap<>();

	// Adds new appointment and increments ID
	public void addAppointment(Date date, String description) {

		String stringID = Integer.toString(currentID);

		// Checks for duplicate appointment ID
		if(appointments.containsKey(stringID)) {
			throw new IllegalArgumentException("Appointment Already Exists");
		}

		// Checks for duplicate entry
		for(Appointment appointment : appointments.values()) {
			if(appointment.getDate().equals(date) &&
				appointment.getDescription().equalsIgnoreCase(description)) {
			throw new IllegalArgumentException("Appointment Already Exists");
			}
		}

		Appointment newAppointment = new Appointment(stringID, date, description);
		appointments.put(stringID, newAppointment);
		currentID++;
	}

	// Removes appointment by ID
	public void removeAppointment(String appointmentID) {
		appointments.remove(appointmentID);
	}

	// Updates appointment based on ID
	public void updateAppointment(String appointmentID, Date newDate, String newDescription) {
		if(appointments.containsKey(appointmentID)) {
			Appointment appointment = appointments.get(appointmentID);
			appointment.setDate(newDate);
			appointment.setDescription(newDescription);
		}
	}

	// Searches appointments by selected field
	public List<Appointment> searchAppointments(String field, String value) {

		List<Appointment> results = new ArrayList<Appointment>();

		for(Appointment appointment : appointments.values()) {

			if(field.equalsIgnoreCase("description") &&
				appointment.getDescription().equalsIgnoreCase(value)) {

				results.add(appointment);
			}
		}

		return results;
	}

	// Sorts appointments by selected field
	public List<Appointment> sortAppointments(String field) {

		List<Appointment> sortedAppointments = new ArrayList<Appointment>(appointments.values());

		if(field.equalsIgnoreCase("date")) {

			sortedAppointments.sort(Comparator.comparing(Appointment::getDate));

		} else if(field.equalsIgnoreCase("description")) {

			sortedAppointments.sort(Comparator.comparing(Appointment::getDescription));

		}

		return sortedAppointments;
	}
}