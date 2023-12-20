package com.gr7.skitimer;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

class Timer {
	private Instant start;
	
	Timer(){
		
	};
	
	
	//Tar en Start tid
	private void startTimer() {
		start = Instant.now();
        System.out.println("Timer Startar");
		
	}
	public void stopTimer() {
		Instant stop = Instant.now();
        Duration timeElapsed = Duration.between(start, stop);
        
        long hours = timeElapsed.toHours();
        long minutes = timeElapsed.minusHours(hours).toMinutes();
        long seconds = timeElapsed.minusHours(hours).minusMinutes(minutes).toSeconds();
        long millis = timeElapsed.minusHours(hours).minusMinutes(minutes).minusSeconds(seconds).toMillis();
		
	}
	
	public void huntingStart15sec(List<String> comp) {
		for(String compet: comp) {
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			startTimer();
			System.out.println(compet+ " Startar");
		}
	}
	private void huntingStart30sec(List<String> competitors) {
		for(String compet: competitors) {
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			startTimer();
			System.out.println(compet+ " Startar");
		}
	}
}
