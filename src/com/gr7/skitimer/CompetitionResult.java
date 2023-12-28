package com.gr7.skitimer;

import java.time.LocalTime;
import java.util.TreeMap;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="competitionResult")
@XmlAccessorType(XmlAccessType.FIELD)
class CompetitionResult {
	
	@XmlJavaTypeAdapter(LocalTimeMapAdapter.class)
	private TreeMap<LocalTime, Competitor> results = new TreeMap<>();
	
	public void addResult(LocalTime finishTime, Competitor competitor) {
		results.put(finishTime, competitor);
	}
	
	public TreeMap<LocalTime, Competitor> getResults(){
		return results;
	}
	
	public void  setResults(TreeMap<LocalTime, Competitor> results) {
		this.results = results;
	}
}
