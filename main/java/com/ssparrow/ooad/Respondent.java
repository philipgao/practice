package com.ssparrow.ooad;

import java.util.Random;

public class Respondent extends Employee {

	public Respondent(String name, Employee supervisor) {
		super(name, supervisor);
		this.title="Respondent";
	}

	@Override
	public void assignIncident(Incident incident) {
		this.incident=incident;
		this.isAvailable=false;
	}

	@Override
	public void handleIncident() {
		if(incident==null){
			return;
		}
		
		int processTime = new Random().nextInt(10);
		try {
			Thread.sleep(processTime*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.title+"["+this.name+"] handled incident["+incident.getId()+"] for "+processTime+" seconds");
		
		int decision=new Random().nextInt(10);
		if(decision>5){
			escalate();
			System.out.println(this.title+"["+this.name+"] escalate incident["+incident.getId()+"] to "+supervisor.getTitle()+"["+supervisor.getName()+"]");
		}
		incident=null;
		isAvailable=true;
		
	}

}
