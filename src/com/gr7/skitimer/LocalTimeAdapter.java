package com.gr7.skitimer;

import java.time.LocalTime;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {

	@Override
	public LocalTime unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return LocalTime.parse(v);
	}

	@Override
	public String marshal(LocalTime v) throws Exception {
		// TODO Auto-generated method stub
		return v.toString();
	}

}
