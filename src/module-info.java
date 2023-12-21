/**
 * 
 */
/**
 * 
 */
module SkiTimerFx {
	requires javafx.graphics;
	requires javafx.controls;
	requires jakarta.xml.bind;
	requires javafx.base;
	
	 opens com.gr7.skitimer to jakarta.xml.bind;
	exports com.gr7.skitimer;
}