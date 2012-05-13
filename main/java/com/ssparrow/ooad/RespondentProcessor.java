package com.ssparrow.ooad;

public class RespondentProcessor implements Runnable {
	private IncidentHandler incidentHandler;
	private Respondent respondent;
	
	public RespondentProcessor(IncidentHandler incidentHandler, Respondent respondent){
		this.incidentHandler=incidentHandler;
		this.respondent=respondent;
	}

	@Override
	public void run() {
		respondent.handleIncident();
		try {
			incidentHandler.releaseRespondent(respondent);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
