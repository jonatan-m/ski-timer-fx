package com.gr7.skitimer;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

class Timer {
	private Instant start;
	
	//Tar en Start tid
	private void startTimer() {
		start = Instant.now();
        System.out.println("Timer Startar");
		
	}
	private void stopTimer() {
		Instant stop = Instant.now();
        Duration timeElapsed = Duration.between(start, stop);
        System.out.println("Tid som har gått: " + timeElapsed.toMillis() + " ms");
		
	}
	
	private void huntingStart15sec(List<String> comp) {
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
