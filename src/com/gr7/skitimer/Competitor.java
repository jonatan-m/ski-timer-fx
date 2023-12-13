package com.gr7.skitimer;

import java.time.LocalDateTime;

class Competitor {
	
	private String skierName;
	private String skierNumber;
	
	
	public class Skier{
		
		private String skierName;
		private String skierNumber;
		private LocalDateTime startTime;
		
		public Skier (String skierName, String skierNumber, LocalDateTime startTime) {
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
		public LocalDateTime getStartTime() {
			return startTime;
			
		}
		public static void main(String[] args) {
	        LocalDateTime baseStartTime = LocalDateTime.of(2023, 12, 13, 10, 0);

	        Competitor competitor = new Competitor();
	        Competitor.Skier skier1 = competitor.new Skier("John Doe", "01", baseStartTime.plusSeconds(15).plusNanos(500 * 1000000));

	        System.out.println("Åkare: " + skier1.getSkierName() +
	                           ", Åkarnummer: " + skier1.getSkierNumber() +
	                           ", Starttid: " + skier1.getStartTime());
		
		
	}
	
	}
}
	

