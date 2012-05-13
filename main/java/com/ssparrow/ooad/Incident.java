package com.ssparrow.ooad;

public class Incident {
	private String id;
	private int priority;
	private String description;
	private Employee owner;
	
	public Incident(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

}
