package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import main.Task;
import main.TaskService;

class TaskServiceTest {

	// Clears tasks after each test
    @AfterEach
    void tearDown() {
        TaskService.tasks.clear();
    }

    // Tests that a task can be added correctly
    @Test
    void testAddTask() {
    	String taskID = "0";
        String name = "Dakota Parker";
        String description = "Valid Description";
        
        TaskService test = new TaskService();
        
        assertTrue(TaskService.tasks.isEmpty());
        
        test.addTask(name, description);
       
        assertTrue(TaskService.tasks.containsKey(taskID));
        assertEquals(name, TaskService.tasks.get(taskID).getName());
        assertEquals(description, TaskService.tasks.get(taskID).getDescription());              
    }

    // Tests that a task can be removed by ID
    @Test
    void testRemoveTask() {
        TaskService test = new TaskService();
        
        assertTrue(TaskService.tasks.isEmpty());

        // Adds three tasks with IDs 0, 1, and 2 respectively
        test.addTask("Dakota Parker", "Valid Description");
        test.addTask("Alex Smith", "Review Project");
        test.addTask("Jordan Johnson", "Complete Assignment");
          
        assertEquals(3, TaskService.tasks.size());
          
        // Removes task with ID "1"
        test.removeTask("1");
          
        assertEquals(2, TaskService.tasks.size());
        assertFalse(TaskService.tasks.containsKey("1"));
        
        // Asserts that removing a non existent task should not change the size
        test.removeTask("1");
        assertEquals(2, TaskService.tasks.size());
    }

    // Tests that a duplicate task cannot be added
    @Test
    void testDuplicateTask() {
        TaskService test = new TaskService();

        test.addTask("Dakota Parker", "Valid Description");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            test.addTask("Dakota Parker", "Valid Description");
        });

        assertEquals("Task Already Exists", exception.getMessage());
    }

    // Tests searching tasks by name
    @Test
    void testSearchTasksByName() {
        TaskService test = new TaskService();

        test.addTask("Dakota Parker", "Complete assignment");
        test.addTask("Alex Smith", "Review project");

        List<Task> results = test.searchTasks("name", "Dakota Parker");

        assertEquals(1, results.size());
        assertEquals("Dakota Parker", results.get(0).getName());
    }
    
 // Tests searching tasks by description
    @Test
    void testSearchTasksByDescription() {
        TaskService test = new TaskService();

        test.addTask("Dakota Parker", "Complete assignment");
        test.addTask("Alex Smith", "Review project");

        List<Task> results = test.searchTasks("description", "Complete assignment");

        assertEquals(1, results.size());
        assertEquals("Complete assignment", results.get(0).getDescription());
    }

    // Tests sorting tasks by name
    @Test
    void testSortTasksByName() {
        TaskService test = new TaskService();

        test.addTask("Dakota Parker", "Complete assignment");
        test.addTask("Alex Smith", "Review project");

        List<Task> results = test.sortTasks("name");

        assertEquals("Alex Smith", results.get(0).getName());
        assertEquals("Dakota Parker", results.get(1).getName());
    }
    
 // Tests sorting tasks by description
    @Test
    void testSortTasksByDescription() {
        TaskService test = new TaskService();

        test.addTask("Dakota Parker", "Review project");
        test.addTask("Alex Smith", "Complete assignment");

        List<Task> results = test.sortTasks("description");

        assertEquals("Complete assignment", results.get(0).getDescription());
        assertEquals("Review project", results.get(1).getDescription());
    }

    // Tests updateTask with valid ID
    @Test
    void testValidUpdateTask() {
    	String taskID = "0";
        String name = "Dakota Parker";
        String description = "Valid Description";
        TaskService test = new TaskService();
        
        test.addTask(name, description);

        test.updateTask("0", "New Name", "New Description");
        assertEquals("New Description", TaskService.tasks.get(taskID).getDescription());
        assertEquals("New Name", TaskService.tasks.get(taskID).getName());
    }

    // Tests updateTask with invalid ID
    @Test
    void testInvalidUpdateTask() {
    	String taskID = "0";
        String name = "Dakota Parker";
        String description = "Valid Description";
        TaskService test = new TaskService();
        
        test.addTask(name, description);

        // Attempts to update non-existent task with ID "1"
        test.updateTask("1", "New Name", "New Description");
        
        // Verifies task with ID "0" remains unchanged
        assertEquals(description, TaskService.tasks.get(taskID).getDescription());
        assertEquals(name, TaskService.tasks.get(taskID).getName());
    }
}