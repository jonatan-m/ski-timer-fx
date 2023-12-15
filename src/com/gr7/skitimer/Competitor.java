package com.gr7.skitimer;

import java.time.LocalTime;
import java.util.HashMap;

class Competitor {
	
	HashMap<String, LocalTime> splitTimes = new HashMap<String, LocalTime>();

		private String skierName;
		private String skierNumber;
		private LocalTime startTime;
		private LocalTime finishTime;
		
		public Competitor (String skierName, String skierNumber) {
			this.skierName = skierName;
			this.skierNumber= skierNumber;

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
		public void setStartTime(LocalTime startTime) {
            this.startTime = startTime;
		}
		
		public LocalTime getFinishTime() {
			return finishTime;
		}
		public void setFinishTime(LocalTime finishTime) {
			this.finishTime = finishTime;
		}
}
	

