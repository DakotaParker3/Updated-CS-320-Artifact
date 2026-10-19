package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;
import main.Appointment;

public class AppointmentTest {
	
	// Tests a valid constructor
    @Test
    void testValidConstructor() {
        String appointmentID = "1";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date goodDate = c.getTime();
        String description = "Valid Description";
        
        Appointment testAppointment = new Appointment(appointmentID, goodDate, description);
        
        assertEquals(appointmentID, testAppointment.getAppointmentID());  
        assertEquals(goodDate, testAppointment.getDate());
        assertEquals(description, testAppointment.getDescription());       
    }

    // Tests invalid constructor - appointmentID is too long
    @Test
    void testConstructorLongID() {
        String appointmentID = "1234567890123456789";
        Date date = new Date();
        String description = "Valid Description";
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, date, description);
        });
        
        assertEquals("Invalid Appointment ID", exception.getMessage());
    }

    // Tests invalid constructor - appointmentID is null
    @Test
    void testConstructorNullID() {
        String appointmentID = null;
        Date date = new Date();
        String description = "Valid Description";
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, date, description);
        });
        
        assertEquals("Invalid Appointment ID", exception.getMessage());
    }

    // Tests invalid constructor - date is in the past
    @Test
    void testConstructorPastDate() {
        String appointmentID = "1";
        Calendar c = Calendar.getInstance();
        c.set(2000, Calendar.DECEMBER, 25);
        Date invalidDate = c.getTime();
        String description = "Valid Description";
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, invalidDate, description);
        });
        
        assertEquals("Invalid Date", exception.getMessage());
    }

    // Tests invalid constructor - date is null
    @Test
    void testConstructorNullDate() {
        String appointmentID = "1";
        String description = "Valid Description";    	
        Date nullDate = null;
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, nullDate, description);
        });
        
        assertEquals("Invalid Date", exception.getMessage());
    }

    // Tests invalid constructor - description is too long
    @Test
    void testConstructorLongDescription() {
        String appointmentID = "1";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date validDate = c.getTime();
        String description = "Invalid Description due to length being greater than 50 characters, which is too long";
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, validDate, description);
        });
        
        assertEquals("Invalid Description", exception.getMessage());
    }

    // Tests invalid constructor - description is null
    @Test
    void testConstructorNullDescription() {
        String appointmentID = "1";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date validDate = c.getTime();
        String description = null;
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, validDate, description);
        });
        
        assertEquals("Invalid Description", exception.getMessage());
    }
    
    // Tests setDate with valid input
    @Test
    void testSetDateValid() {
        String appointmentID = "1";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date originalDate = c.getTime();
        String description = "Valid Description";

        Appointment testAppointment = new Appointment(appointmentID, originalDate, description);

        // Sets and validates that the date is 5 days later
        c.add(Calendar.DAY_OF_YEAR, 5);
        Date newDate = c.getTime();
        testAppointment.setDate(newDate);
        assertEquals(newDate, testAppointment.getDate());
    }
    
    // Tests setDate with a date in the past
    @Test
    void testSetDatePast() {
        String appointmentID = "1";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date originalDate = c.getTime();
        String description = "Valid Description";

        Appointment testAppointment = new Appointment(appointmentID, originalDate, description);

        c.set(2000, Calendar.DECEMBER, 25);
        Date newDate = c.getTime();
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	testAppointment.setDate(newDate);
        });
        
        assertEquals("Invalid Date", exception.getMessage());
    }
    
    // Tests setDate with a null input
    @Test
    void testSetDateNull() {
        String appointmentID = "1";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date validDate = c.getTime();
        String description = "Valid Description";

        Appointment testAppointment = new Appointment(appointmentID, validDate, description);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	testAppointment.setDate(null);
        });
        
        assertEquals("Invalid Date", exception.getMessage());
    }
    
    // Tests setDescription with a valid input
    @Test
    void testValidSetDescription() {
        String appointmentID = "1";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date futureDate = c.getTime();
        String description = "Valid Description";

        Appointment testAppointment = new Appointment(appointmentID, futureDate, description);

        String newDescription = "Description Valid";
        testAppointment.setDescription(newDescription);
        assertEquals(newDescription, testAppointment.getDescription());
    }

    // Tests setDescription with a description that is too long
    @Test
    void testSetDescriptionTooLong() {
        String appointmentID = "1";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date futureDate = c.getTime();
        String description = "Valid Description";

        Appointment testAppointment = new Appointment(appointmentID, futureDate, description);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            testAppointment.setDescription("Invalid Description due to length being greater than 50 characters, which is too long");
        });

        assertEquals("Invalid Description", exception.getMessage());
    }
    
    // Tests setDescription with a null input
    @Test
    void testSetDescriptionNull() {
        String appointmentID = "1";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date futureDate = c.getTime();
        String description = "Valid Description";

        Appointment testAppointment = new Appointment(appointmentID, futureDate, description);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            testAppointment.setDescription(null);
        });

        assertEquals("Invalid Description", exception.getMessage());
    }

}