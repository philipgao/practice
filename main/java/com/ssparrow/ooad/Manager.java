package com.ssparrow.ooad;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Manager extends Employee {
	private BlockingQueue<Incident> blockingQueue=new ArrayBlockingQueue<Incident>(100);

	public Manager(String name) {
		super(name, null);
		this.title="Manager";
	}

	@Override
	public void assignIncident(Incident incident) {
		blockingQueue.add(incident);
	}

	@Override
	public void handleIncident() {
		Incident newIncident = blockingQueue.poll();

		if (newIncident == null) {
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			this.incident = newIncident;
			this.isAvailable = false;

			int processTime = new Random().nextInt(10);
			try {
				Thread.sleep(processTime * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.title+"["+this.name+"] handled incident["+incident.getId()+"] in "+processTime+" seconds");

			incident = null;
			isAvailable = true;
		}
	}
	
	

}
