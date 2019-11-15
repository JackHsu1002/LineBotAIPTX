package com.sabretn.ai.service;

import java.util.List;

import com.sabretn.ai.ptx.model.FIDSArrival;
import com.sabretn.ai.ptx.model.FIDSDeparture;
import com.sabretn.ai.ptx.model.METAR;

public interface PTXService {
	
	List<FIDSDeparture> getFIDSDeparture(String IATACode);
	List<FIDSArrival> getFIDSArrivals(String IATACode);
	List<METAR> getAirportWeather(String IATACode);
	
}
