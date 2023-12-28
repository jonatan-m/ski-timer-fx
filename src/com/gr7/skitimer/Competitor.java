package com.gr7.skitimer;

import java.time.LocalTime;
import java.util.HashMap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
class Competitor {
	
	HashMap<String, LocalTime> splitTimes = new HashMap<String, LocalTime>();

		
		private String skierName;
		private String skierNumber;
		@XmlJavaTypeAdapter(LocalTimeAdapter.class)
		private LocalTime startTime;
		@XmlJavaTypeAdapter(LocalTimeAdapter.class)
		private LocalTime finishTime;
		
		public Competitor() {
			
		}
		
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
	

