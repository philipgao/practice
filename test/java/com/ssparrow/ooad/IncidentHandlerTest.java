package com.ssparrow.ooad;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IncidentHandlerTest {
	
	@Test
	public void testIncidentHandler() throws InterruptedException{
		List<Employee> employees=new ArrayList<Employee>();
		
		Manager philip=new Manager("philip");
		Manager jamie=new Manager("jamie");
		
		employees.add(philip);
		employees.add(jamie);
		
		for(int index=0;index<10;index++){
			employees.add(new Respondent("philip."+index, philip));
			employees.add(new Respondent("jamie."+index, jamie));
		}
		
		IncidentHandler incidentHandler=new IncidentHandler(employees);
		
		int id=1;
		while(id<=10){
			Incident incident=new Incident(String.valueOf(id++));
			incidentHandler.handleIncident(incident);
		}
	}

}
