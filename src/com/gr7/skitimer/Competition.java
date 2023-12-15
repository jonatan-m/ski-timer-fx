package com.gr7.skitimer;

import java.time.LocalTime;
import java.util.TreeMap;


abstract class Competition {
	protected TreeMap<String, Competitor> competitors = new TreeMap<>();
	protected boolean isFinished = false;
	
	public void addCompetitor(String name, String number) {
		competitors.put(number, new Competitor(name, number));
	}
	
	public TreeMap<String, Competitor> getCompetitors(){
		return competitors;
	}
	
	public abstract Result setStartTimes(LocalTime startTime);
	
	
}
