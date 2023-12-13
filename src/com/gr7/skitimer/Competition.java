package com.gr7.skitimer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

enum StartFormat {
	MASS_START,
	INTERVAL,
	PURSUIT
}

class Competition {
	private ArrayList<Competitor> competitors = new ArrayList<>();
	private StartFormat startFormat;
	private int interval = 30;
	
	public Competition(StartFormat startFormat) {
		this.startFormat = startFormat;
	}
	
	public void addCompetitor(String name, String number, LocalTime startTime) {
		competitors.add(new Competitor(name, number, startTime));
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
		return Result.error(new IllegalStateException("Competition object has an invalid start format"));
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
		return Result.success();
	}
	
}
