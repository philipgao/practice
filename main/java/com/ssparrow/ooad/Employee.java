package com.ssparrow.ooad;

public abstract class Employee {
	protected Employee supervisor;
	protected boolean isAvailable;
	protected Incident incident;
	protected String name;
	protected String title;
	
	public Employee(String name, Employee supervisor){
		this.name=name;
		this.supervisor=supervisor;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	
	abstract public void assignIncident(Incident incident) ;
	
	abstract public void handleIncident();
	
	public void escalate() {
		this.getSupervisor().assignIncident(incident);
	}

}
