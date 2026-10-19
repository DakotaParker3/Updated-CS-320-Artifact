package main;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class TaskService {

	// ID to be incremented
    	private int currentID = 0;
    
    	// HashMap to store tasks
    	public static HashMap<String, Task> tasks = new HashMap<>();

    	// Adds new task and increments ID
    	public void addTask(String name, String description) {

        	String stringID = Integer.toString(currentID);

		// Checks for duplicate task ID
		if(tasks.containsKey(stringID)) {
			throw new IllegalArgumentException("Task Already Exists");
		}

		// Checks for duplicate entry
		for(Task task : tasks.values()) {
			if(task.getName().equalsIgnoreCase(name) &&
				task.getDescription().equalsIgnoreCase(description)) {
				throw new IllegalArgumentException("Task Already Exists");
			}
		}

        	Task task = new Task(stringID, name, description);
        	tasks.put(stringID, task);
        	currentID++;
    	}

    	// Removes task by ID
    	public void removeTask(String taskID) {
        	tasks.remove(taskID);
    	}

    	// Updates task based on ID
    	public void updateTask(String taskID, String newName, String newDescription) {
        	if (tasks.containsKey(taskID)) {
            	Task taskToUpdate = tasks.get(taskID);
            	taskToUpdate.setName(newName);
            	taskToUpdate.setDescription(newDescription);
		}
	}

	// Searches tasks by selected field
	public List<Task> searchTasks(String field, String value) {

		List<Task> results = new ArrayList<Task>();

		for(Task task : tasks.values()) {

			if(field.equalsIgnoreCase("name") &&
				task.getName().equalsIgnoreCase(value)) {

				results.add(task);

			} else if(field.equalsIgnoreCase("description") &&
				task.getDescription().equalsIgnoreCase(value)) {

				results.add(task);
			}
		}

		return results;
	}

	// Sorts tasks by selected field
	public List<Task> sortTasks(String field) {

		List<Task> sortedTasks = new ArrayList<Task>(tasks.values());

		if(field.equalsIgnoreCase("name")) {

			sortedTasks.sort(Comparator.comparing(Task::getName));

		} else if(field.equalsIgnoreCase("description")) {

			sortedTasks.sort(Comparator.comparing(Task::getDescription));
		}

		return sortedTasks;
	}
}