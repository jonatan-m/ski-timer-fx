package com.gr7.skitimer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

abstract class Competition {
	protected TreeMap<String, Competitor> competitors = new TreeMap<>();
	protected boolean isFinished = false;
	protected CompetitionResult result = new CompetitionResult();
	protected String type;
	protected LocalDate date;
	
	
	public abstract Result setStartTimes(LocalTime startTime);
	
	public void addCompetitor(String name, String number) {
		competitors.put(number, new Competitor(name, number));
	}
	
	public void addCompetitors(TreeMap<String, Competitor> competitors) {
		this.competitors = competitors;
	}
	
	public TreeMap<String, Competitor> getCompetitors(){
		return competitors;
	}
	
	public void finishCompetitor(String number, LocalTime finishTime) {
		if(isFinished) return;
		
		competitors.get(number).setFinishTime(finishTime);
		result.addResult(finishTime, competitors.get(number));
		
		isFinished = true;
		competitors.forEach((k,v) -> {
			if(v.getFinishTime() == null) isFinished = false;
			});
	}
	
	public CompetitionResult getResult() {
		if(!isFinished) return null;
		
		return result;
	}
	
	public boolean endCompetition() {
		if(!isFinished) return false;
		
		return FileManager.saveResult(result, type.concat(date.format(DateTimeFormatter.BASIC_ISO_DATE)));
	}
	
}
