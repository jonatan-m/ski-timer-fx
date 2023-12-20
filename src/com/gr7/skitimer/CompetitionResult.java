package com.gr7.skitimer;

import java.time.LocalTime;
import java.util.TreeMap;

class CompetitionResult {
	private TreeMap<LocalTime, Competitor> results = new TreeMap<>();
	
	public void addResult(LocalTime finishTime, Competitor competitor) {
		results.put(finishTime, competitor);
	}
	
	public TreeMap<LocalTime, Competitor> getResults(){
		return results;
	}
}
