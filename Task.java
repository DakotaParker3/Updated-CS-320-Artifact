package main;

public class Task {
	
	private String taskID;
	private String name;
	private String description;
	
	// Constructor
	public Task(String taskID, String name, String description) {
		
		validateTaskID(taskID);
		validateName(name);
		validateDescription(description);
		
		this.taskID = taskID;
		this.name = name;
		this.description = description;
	}
	
	// Getters
	public String getTaskID() {
		return taskID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	// Sets and validates name
	public void setName(String name) {
		validateName(name);
		this.name = name;
	}
	
	// Sets and validates description
	public void setDescription(String description) {
		validateDescription(description);
		this.description = description;
	}
	
	// Validates task ID
		private void validateTaskID(String taskID) {
			if(taskID == null || taskID.length() > 10) {
				throw new IllegalArgumentException("Invalid Task ID");
			}
		}
	
	// Validates name
	private void validateName(String name) {
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
	}
	
	// Validates description
	private void validateDescription(String description) {
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
	}
}