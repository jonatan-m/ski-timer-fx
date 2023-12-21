package com.gr7.skitimer;

import java.time.LocalDate;
import java.time.LocalTime;

class MassStart extends Competition {

	MassStart() {
		super();
		this.date = LocalDate.now();
		this.type = "MASS_START";
	}

	@Override
	public Result setStartTimes(LocalTime startTime) {
		competitors.forEach((key, value) -> value.setStartTime(startTime));
		
		return Result.success();
	}

}
