package com.gr7.skitimer;

import java.time.LocalTime;

class MassStart extends Competition {

	MassStart() {
		super();
	}

	@Override
	public Result setStartTimes(LocalTime startTime) {
		competitors.forEach((key, value) -> value.setStartTime(startTime));
		
		return Result.success();
	}

}
