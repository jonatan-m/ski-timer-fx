package com.gr7.skitimer;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.TreeMap;
import java.util.Map.Entry;

class PursuitStart extends Competition {

	private CompetitionResult previous = null;

	public PursuitStart(File previousResult) {
		super();
		this.date = LocalDate.now();
		this.type = "JAKT_START";
		
		previous = FileManager.loadResult(previousResult);
		
		if(previous != null) {
			previous.getResults().forEach((k, v) -> {
				competitors.put(v.getSkierName(), v);
			});
		}
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

			slowerEntry.getValue()
				.setStartTime(fasterEntry.getValue().getStartTime().plusNanos(diff));
			
			competitors.get(slowerEntry.getValue().getSkierNumber())
				.setStartTime(slowerEntry.getValue().getStartTime());
			
			fasterEntry = slowerEntry;
		}
		return Result.success();
	}

}
