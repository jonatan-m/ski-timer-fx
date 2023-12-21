package com.gr7.skitimer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

class LocalTimeMapAdapter extends XmlAdapter<LocalTimeMapAdapter.AdaptedMap ,TreeMap<LocalTime, Competitor>> {
	static class AdaptedMap {

        public List<Entry> entry = new ArrayList<Entry>();

    }

    static class Entry {

        public String key;

        public Competitor value;

    }

	@Override
	public TreeMap<LocalTime, Competitor> unmarshal(AdaptedMap v) throws Exception {
		TreeMap<LocalTime, Competitor> map = new TreeMap<>();
		
		for(Entry e: v.entry) {
			map.put(LocalTime.parse(e.key), e.value);
		}
		
		return map;
	}

	@Override
	public AdaptedMap marshal(TreeMap<LocalTime, Competitor> v) throws Exception {
		AdaptedMap adaptedMap = new AdaptedMap();
		for(Map.Entry<LocalTime, Competitor> entry : v.entrySet()) {
			Entry e = new Entry();
			e.key = entry.getKey().toString();
			e.value = entry.getValue(); 
			adaptedMap.entry.add(e);
		}
		return adaptedMap;
	}
}
