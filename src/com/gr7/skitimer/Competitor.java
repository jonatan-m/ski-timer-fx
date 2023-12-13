package com.gr7.skitimer;

import java.time.LocalTime;

class Competitor {

		private String skierName;
		private String skierNumber;
		private LocalTime startTime;
		
		public Competitor (String skierName, String skierNumber, LocalTime startTime) {
			this.skierName = skierName;
			this.skierNumber= skierNumber;
			this.startTime = startTime;
		}
		public String getSkierName() {
			return skierName;
			
		}
		public String getSkierNumber() {
			return skierNumber;
			
		}
		public LocalTime getStartTime() {
			return startTime;
			
		
	}
}
	

