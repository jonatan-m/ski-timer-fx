package com.gr7.skitimer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

enum StartFormat {
	MASS_START,
	INTERVAL,
	PURSUIT
}

class Competition {
	private ArrayList<Competitor> competitors = new ArrayList<>();
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
		competitors.add(new Competitor(name, number));
	}
	
	public void addCompetitor(ArrayList<Competitor> competitors) {
		this.competitors.addAll(competitors);
	}
	
	public ArrayList<Competitor> getCompetitors(){
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
		for(var competitor : competitors) {
			competitor.setStartTime(startTime);
		}
		
		return Result.success();
	}
	
	private Result setIntervalStartTimes(LocalTime startTime) {
		LocalTime intervalTime = startTime.minusSeconds(interval);
		competitors.sort(Comparator.comparingInt(c -> Integer.parseInt(c.getSkierNumber())));
		
		for(var competitor : competitors) {
			intervalTime = intervalTime.plusSeconds(interval);
			competitor.setStartTime(intervalTime);
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
		
		
		return Result.success();
	}
	
}
