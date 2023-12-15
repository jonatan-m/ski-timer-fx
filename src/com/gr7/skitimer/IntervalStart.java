package com.gr7.skitimer;

import java.time.LocalTime;

enum Interval {
	THIRTY,
	FIFTHTEEN
}

class IntervalStart extends Competition {

	private int interval;
	
	public IntervalStart(Interval interval) {
		super();
		if(interval == Interval.THIRTY) {
			this.interval = 30;
		}
		else {
			this.interval = 15;
		}
	}
	

	@Override
	public Result setStartTimes(LocalTime startTime) {
		LocalTime intervalTime = startTime.minusSeconds(interval);
		
		for(var entry : competitors.entrySet()) {
			intervalTime = intervalTime.plusSeconds(interval);
			entry.getValue().setStartTime(intervalTime);
		}
		
		return Result.success();
	}

}
