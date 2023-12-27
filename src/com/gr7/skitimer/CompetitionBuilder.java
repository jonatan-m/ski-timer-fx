package com.gr7.skitimer;

import java.io.File;
import java.time.LocalTime;
import java.util.TreeMap;

enum CompetitionType {
	MASS_START,
	INTERVAL_START,
	PURSUIT_START
}

class CompetitionBuilder {

	private CompetitionType type;
	private LocalTime startTime;
	private Interval interval;
	private File previousResult;
	private TreeMap<String, Competitor> competitors = new TreeMap<>();
	
	public CompetitionBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	public void setType(CompetitionType type) {
		this.type = type;
	}
	
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	
	public void setPreviousResult(File previousResult) {
		this.previousResult = previousResult;
	}
	
	public void addCompetitor(String number, String name) {
		competitors.put(number, new Competitor(name, number));
	}
	
	public Competition build() {
		//TODO check that values are set before attempting to instantiate
		Competition comp = null;
		switch(type) {
		case MASS_START -> {
			comp = new MassStart();
			comp.addCompetitors(competitors);
			comp.setStartTimes(startTime);
			}
		case INTERVAL_START -> {
			comp = new IntervalStart(interval);
			comp.addCompetitors(competitors);
			comp.setStartTimes(startTime);
		}
		case PURSUIT_START -> {
			comp = new PursuitStart(previousResult);
			comp.setStartTimes(startTime);
		}
		}
			
		return comp;
	}

}
