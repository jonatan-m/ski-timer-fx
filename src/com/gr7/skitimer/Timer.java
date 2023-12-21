package com.gr7.skitimer;

import java.time.Duration;
import java.time.LocalTime;


class Timer {
	
	
	Timer(){};
	
	public static LocalTime stopTimer(LocalTime startTime) {
		LocalTime time = LocalTime.now();
        Duration timeElapsed = Duration.between(startTime, time);
        
        long seckonds = timeElapsed.getSeconds();
        int hours = (int) seckonds / 3600;
        int minuts = ((int) seckonds %3600) / 60;
        int sec = ((int) seckonds/3600) % 60;
        int nanoSeconds = timeElapsed.getNano();
        LocalTime results = LocalTime.of(hours, minuts, sec, nanoSeconds);
        return results;      
	}

	public LocalTime getTime() {
		return LocalTime.now();
	}
	
	
}
