package com.gr7.skitimer;

import java.time.Duration;
import java.time.LocalTime;


class Timer {
	private static LocalTime time = LocalTime.now();
	
	
	Timer(){
		
	};
	
	public static Duration stopTimer(LocalTime startTime) {
		
        Duration timeElapsed = Duration.between(startTime, time);
         
        return timeElapsed;
        
	}

	public LocalTime getTime() {
		return time;
	}
	
	
}
