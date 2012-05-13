package com.ssparrow.ooad;

public class ManagerProcessor implements Runnable{
	private Manager manager;
	
	public ManagerProcessor(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void run() {
		while(true){
			manager.handleIncident();
		}
	}

}
