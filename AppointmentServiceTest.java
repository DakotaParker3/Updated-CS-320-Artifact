package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import main.Appointment;
import main.AppointmentService;

public class AppointmentServiceTest {
	
	// Clears appointments after each test
	@AfterEach
    void tearDown() {
        AppointmentService.appointments.clear();
    }

    // Tests that an appointment can be added correctly
    @Test
    void testAddApointment() {
        String appointmentID = "0";
        String description = "Valid Description";
        
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date validDate = c.getTime();

        AppointmentService testAppointment = new AppointmentService();

        assertTrue(AppointmentService.appointments.isEmpty());

        testAppointment.addAppointment(validDate, description);

        assertTrue(AppointmentService.appointments.containsKey(appointmentID));
        assertEquals(validDate, AppointmentService.appointments.get(appointmentID).getDate());
        assertEquals(description, AppointmentService.appointments.get(appointmentID).getDescription());
    }

    // Tests addAppointment with a null description
    @Test
    void testAddAppointmentNullDescription() {
        String description = null;
        
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date validDate = c.getTime();

        AppointmentService testAppointment = new AppointmentService();
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	testAppointment.addAppointment(validDate, description);
        });

        assertEquals("Invalid Description", exception.getMessage());
    }

    // Tests that an appointment can be removed by ID
    @Test
    void testRemoveAppointment() {
        AppointmentService testAppointment = new AppointmentService();

        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date firstDate = c.getTime();

        c.add(Calendar.DAY_OF_MONTH, 1);
        Date secondDate = c.getTime();

        c.add(Calendar.DAY_OF_MONTH, 1);
        Date thirdDate = c.getTime();

        assertTrue(AppointmentService.appointments.isEmpty());

        // Adds three appointments with IDs 0, 1, and 2 respectively
        testAppointment.addAppointment(firstDate, "First Appointment");
        testAppointment.addAppointment(secondDate, "Second Appointment");
        testAppointment.addAppointment(thirdDate, "Third Appointment");

        assertEquals(3, AppointmentService.appointments.size());

        // Removes appointment with ID "1"
        testAppointment.removeAppointment("1");

        assertEquals(2, AppointmentService.appointments.size());
        assertFalse(AppointmentService.appointments.containsKey("1"));

        // Asserts that removing a non existent appointment should not change the size
        testAppointment.removeAppointment("1");
        assertEquals(2, AppointmentService.appointments.size());
    }
    
    // Tests removing a non-existent appointment
    @Test
    void testRemoveNonExistentAppointment() {
        AppointmentService service = new AppointmentService();

        service.removeAppointment("9000");
        assertTrue(AppointmentService.appointments.isEmpty());
    }
    
    // Tests adding an appointment with a past date
    @Test
    void testAddAppointmentPastDate() {
        AppointmentService service = new AppointmentService();

        Calendar c = Calendar.getInstance();
        c.set(2000, Calendar.JANUARY, 1);
        Date pastDate = c.getTime();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(pastDate, "Valid Description");
        });

        assertEquals("Invalid Date", exception.getMessage());
    }
    
    // Tests that a duplicate appointment cannot be added
    @Test
    void testDuplicateAppointment() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date futureDate = c.getTime();

        AppointmentService service = new AppointmentService();

        service.addAppointment(futureDate, "Doctor Appointment");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(futureDate, "Doctor Appointment");
        });

        assertEquals("Appointment Already Exists", exception.getMessage());
    }
    
    // Tests searching appointments by description
    @Test
    void testSearchAppointmentsByDescription() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date firstDate = c.getTime();

        c.add(Calendar.DAY_OF_MONTH, 1);
        Date secondDate = c.getTime();

        AppointmentService service = new AppointmentService();

        service.addAppointment(firstDate, "Doctor Appointment");
        service.addAppointment(secondDate, "Dentist Appointment");

        List<Appointment> results = service.searchAppointments("description", "Doctor Appointment");

        assertEquals(1, results.size());
        assertEquals("Doctor Appointment", results.get(0).getDescription());
    }
    
    // Tests sorting appointments by date
    @Test
    void testSortAppointmentsByDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date laterDate = c.getTime();

        c.add(Calendar.DAY_OF_MONTH, -2);
        Date earlierDate = c.getTime();

        AppointmentService service = new AppointmentService();

        service.addAppointment(laterDate, "Later Appointment");
        service.addAppointment(earlierDate, "Earlier Appointment");

        List<Appointment> results = service.sortAppointments("date");

        assertEquals(earlierDate, results.get(0).getDate());
        assertEquals(laterDate, results.get(1).getDate());
    }
    
 // Tests sorting appointments by description
    @Test
    void testSortAppointmentsByDescription() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date firstDate = c.getTime();

        c.add(Calendar.DAY_OF_MONTH, 1);
        Date secondDate = c.getTime();

        AppointmentService service = new AppointmentService();

        service.addAppointment(firstDate, "Zebra Appointment");
        service.addAppointment(secondDate, "Apple Appointment");

        List<Appointment> results = service.sortAppointments("description");

        assertEquals("Apple Appointment", results.get(0).getDescription());
        assertEquals("Zebra Appointment", results.get(1).getDescription());
    }
    
 // Tests updating an appointment with a valid ID
    @Test
    void testValidUpdateAppointment() {
        AppointmentService service = new AppointmentService();

        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date originalDate = c.getTime();

        c.add(Calendar.DAY_OF_MONTH, 5);
        Date newDate = c.getTime();

        service.addAppointment(originalDate, "Original Appointment");
        service.updateAppointment("0", newDate, "Updated Appointment");

        assertEquals(newDate, AppointmentService.appointments.get("0").getDate());
        assertEquals("Updated Appointment",
            AppointmentService.appointments.get("0").getDescription());
    }

    // Tests updating an appointment with an invalid ID
    @Test
    void testInvalidUpdateAppointment() {
        AppointmentService service = new AppointmentService();

        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date validDate = c.getTime();

        service.addAppointment(validDate, "Original Appointment");
        service.updateAppointment("1", validDate, "Updated Appointment");

        assertEquals(validDate, AppointmentService.appointments.get("0").getDate());
        assertEquals("Original Appointment",
            AppointmentService.appointments.get("0").getDescription());
    }

}