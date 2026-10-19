package main;

import java.util.Date;

public class Appointment {

	private String appointmentID;
	private Date date;
	private String description;

	// Constructor
	public Appointment(String appointmentID, Date date, String description) {

		validateAppointmentID(appointmentID);
		validateDate(date);
		validateDescription(description);

		this.appointmentID = appointmentID;
		this.date = date;
		this.description = description;
	}

	// Getters
	public String getAppointmentID() {
		return appointmentID;
	}

	public Date getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}

	// Sets and validates date
	public void setDate(Date date) {
		validateDate(date);
		this.date = date;
	}

	// Sets and validates description
	public void setDescription(String description) {
		validateDescription(description);
		this.description = description;
	}

	// Validates appointment ID
	private void validateAppointmentID(String appointmentID) {
		if(appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
	}

	// Validates date
	private void validateDate(Date date) {
		if(date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
	}

	// Validates description
	private void validateDescription(String description) {
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
	}
}