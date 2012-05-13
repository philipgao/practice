package com.ssparrow.ooad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class IncidentHandler {
	private BlockingQueue<Respondent> availableRespondents=new ArrayBlockingQueue<Respondent>(100);	
	private List<ManagerProcessor> managersProcessors=new ArrayList<ManagerProcessor>();
	
	public IncidentHandler(List<Employee> employees){
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee iEmployee = (Employee) iterator.next();
			if(iEmployee instanceof Respondent){
				availableRespondents.add((Respondent) iEmployee);
			}else if(iEmployee instanceof Manager){
				ManagerProcessor managerProcessor=new ManagerProcessor((Manager) iEmployee);
				new Thread(managerProcessor).start();
			}
		}
	}
	
	public void handleIncident(Incident incident) throws InterruptedException{
		Respondent respondent = availableRespondents.take();
		respondent.assignIncident(incident);
		RespondentProcessor incidentProcessor=new RespondentProcessor(this, respondent);
		new Thread(incidentProcessor).run();
	}
	
	public void releaseRespondent(Respondent respondent) throws InterruptedException{
		availableRespondents.put(respondent);
	}
}
