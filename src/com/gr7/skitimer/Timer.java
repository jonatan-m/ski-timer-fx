package com.gr7.skitimer;

import java.time.Duration;
import java.time.LocalTime;


class Timer {
	
	
	Timer(){};
	
	public static LocalTime stopTimer(LocalTime startTime) {
		LocalTime time = LocalTime.now();
        Duration timeElapsed = Duration.between(startTime, time);
        
        LocalTime results = LocalTime.ofNanoOfDay(timeElapsed.getNano());
        
        return results;      
	}

	public LocalTime getTime() {
		return LocalTime.now();
	}
	
	
}
