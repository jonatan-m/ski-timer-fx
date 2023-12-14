package com.gr7.skitimer;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map.Entry;
import java.util.TreeMap;

enum StartFormat {
	MASS_START,
	INTERVAL,
	PURSUIT
}

class Competition {
	private TreeMap<String, Competitor> competitors = new TreeMap<>();
	private StartFormat startFormat;
	private int interval = 30;
	boolean isFinished = false;
	CompetitionResult previous = null;
	
	public Competition(StartFormat startFormat) {
		this.startFormat = startFormat;
	}
	
	public Competition(StartFormat startFormat, String competitionSaveFile) {
		this.startFormat = startFormat;
		
		//TODO: Read file, create CompetitionResult object from data
	}
	
	public void addCompetitor(String name, String number) {
		competitors.put(number, new Competitor(name, number));
	}
	
	
	public TreeMap<String, Competitor> getCompetitors(){
		return competitors;
	}
	
	public Result setStartTimes(LocalTime competitionStartTime) {
		switch(startFormat) {
		case MASS_START:
			return setMassStartTimes(competitionStartTime);
		case INTERVAL:
			return setIntervalStartTimes(competitionStartTime);
		case PURSUIT:
			return setPursuitStartTimes(competitionStartTime);
		}
		return Result.error(new IllegalStateException("Competition state invalid: no start format"));
	}
	
	private Result setMassStartTimes(LocalTime startTime) {
		competitors.forEach((key, value) -> value.setStartTime(startTime));
		
		return Result.success();
	}
	
	private Result setIntervalStartTimes(LocalTime startTime) {
		LocalTime intervalTime = startTime.minusSeconds(interval);
		
		for(var entry : competitors.entrySet()) {
			intervalTime = intervalTime.plusSeconds(interval);
			entry.getValue().setStartTime(intervalTime);
		}
		
		return Result.success();
	}
	
	private Result setPursuitStartTimes(LocalTime startTime) {
		if(previous == null) {
			return Result.error(
					new IllegalStateException(
							"Competition state invalid: pursuit format requires a previous result"));			
		}
		
		TreeMap<LocalTime, Competitor> prevResult = previous.getResults();
		
		Entry<LocalTime, Competitor> fasterEntry = prevResult.firstEntry();
		
		competitors.get(fasterEntry.getValue().getSkierNumber())
			.setStartTime(startTime);
		
		
		while(prevResult.higherKey(fasterEntry.getKey()) != null) {
			Entry<LocalTime, Competitor> slowerEntry = prevResult.higherEntry(fasterEntry.getKey());
			LocalTime time1 = fasterEntry.getKey();
			LocalTime time2 = slowerEntry.getKey();
			
			long diff = time1.until(time2, ChronoUnit.SECONDS);
			
			competitors.get(slowerEntry.getValue().getSkierNumber())
				.setStartTime(startTime.plusSeconds(diff));
			
			
			fasterEntry = slowerEntry;
		}
		
		
		return Result.success();
	}
	
}
