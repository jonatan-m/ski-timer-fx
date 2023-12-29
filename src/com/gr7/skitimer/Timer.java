package com.gr7.skitimer;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;


class Timer {
	
	
	Timer(){};
	
	public static LocalTime stopTimer(LocalTime startTime) {
		LocalTime time = LocalTime.now();
        long diff = startTime.until(time, ChronoUnit.NANOS);
        
        if(diff <0) {
        	 long dayInNanos = (long)24 * 60 * 60 * 1000000000;
        	 
        	 diff += dayInNanos;
        };
        LocalTime results = LocalTime.ofNanoOfDay(diff);
        
        return results;      
	}

	public static LocalTime getTime() {
		return LocalTime.now();
	}
	
	
}