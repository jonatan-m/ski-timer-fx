package com.gr7.skitimer;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.TreeMap;
import java.util.Map.Entry;

class PursuitStart extends Competition {

	private CompetitionResult previous = null;
	
	public PursuitStart(String saveFilePath) {
		super();
		//TODO read file, create CompetitionResult
	}
	
	public PursuitStart(CompetitionResult result) {
		super();
		previous = result;
	}

	@Override
	public Result setStartTimes(LocalTime startTime) {
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
			
			long diff = time1.until(time2, ChronoUnit.NANOS);

			slowerEntry.getValue().setStartTime(fasterEntry.getValue().getStartTime().plusNanos(diff));
			competitors.get(slowerEntry.getValue().getSkierNumber())
				.setStartTime(slowerEntry.getValue().getStartTime());
			
			fasterEntry = slowerEntry;
		}
		return Result.success();
	}

}
