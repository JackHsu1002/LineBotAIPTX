package com.sabretn.ai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ptxapi") //此為將yml的值注入
public class PTXConfig {
	
	private String airport_weather;
	private String airport_arrival;
	private String airport_departure;
	
	public String getAirport_weather() {
		return airport_weather;
	}
	public void setAirport_weather(String airport_weather) {
		this.airport_weather = airport_weather;
	}
	public String getAirport_arrival() {
		return airport_arrival;
	}
	public void setAirport_arrival(String airport_arrival) {
		this.airport_arrival = airport_arrival;
	}
	public String getAirport_departure() {
		return airport_departure;
	}
	public void setAirport_departure(String airport_departure) {
		this.airport_departure = airport_departure;
	}	
	
}
