package com.sabretn.ai.ptx.model;

public class METAR {
	
	private String AirportID;
	private String StationID;
	private NameType CountryName;
	private NameType CityName;
	private NameType AirportName;
	private PointType StationPosition;
	private String ObservationTime;
	private String MetarText;
	private String MetarTime;
	private String WindDirection;
	private String WindSpeed;
	private String Visibility;
	private String Ceiling;
	private String Temperature;
	private NameType WeatherDescription;
	private String UpdateTime;
	
	public String getAirportID() {
		return AirportID;
	}
	public void setAirportID(String airportID) {
		AirportID = airportID;
	}	
	public String getStationID() {
		return StationID;
	}
	public void setStationID(String stationID) {
		StationID = stationID;
	}
	public NameType getCountryName() {
		return CountryName;
	}
	public void setCountryName(NameType countryName) {
		CountryName = countryName;
	}
	public NameType getCityName() {
		return CityName;
	}
	public void setCityName(NameType cityName) {
		CityName = cityName;
	}
	public NameType getAirportName() {
		return AirportName;
	}
	public void setAirportName(NameType airportName) {
		AirportName = airportName;
	}
	public PointType getStationPosition() {
		return StationPosition;
	}
	public void setStationPosition(PointType stationPosition) {
		StationPosition = stationPosition;
	}
	public String getObservationTime() {
		return ObservationTime;
	}
	public void setObservationTime(String observationTime) {
		ObservationTime = observationTime;
	}
	public String getMetarText() {
		return MetarText;
	}
	public void setMetarText(String metarText) {
		MetarText = metarText;
	}
	public String getMetarTime() {
		return MetarTime;
	}
	public void setMetarTime(String metarTime) {
		MetarTime = metarTime;
	}
	public String getWindDirection() {
		return WindDirection;
	}
	public void setWindDirection(String windDirection) {
		WindDirection = windDirection;
	}
	public String getWindSpeed() {
		return WindSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		WindSpeed = windSpeed;
	}
	public String getVisibility() {
		return Visibility;
	}
	public void setVisibility(String visibility) {
		Visibility = visibility;
	}
	public String getCeiling() {
		return Ceiling;
	}
	public void setCeiling(String ceiling) {
		Ceiling = ceiling;
	}
	public String getTemperature() {
		return Temperature;
	}
	public void setTemperature(String temperature) {
		Temperature = temperature;
	}
	public NameType getWeatherDescription() {
		return WeatherDescription;
	}
	public void setWeatherDescription(NameType weatherDescription) {
		WeatherDescription = weatherDescription;
	}
	public String getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(String updateTime) {
		UpdateTime = updateTime;
	}
	@Override
	public String toString() {
		return "METAR [AirportID=" + AirportID + ", StationID=" + StationID + ", CountryName=" + CountryName
				+ ", CityName=" + CityName + ", AirportName=" + AirportName + ", StationPosition=" + StationPosition
				+ ", ObservationTime=" + ObservationTime + ", MetarText=" + MetarText + ", MetarTime=" + MetarTime
				+ ", WindDirection=" + WindDirection + ", WindSpeed=" + WindSpeed + ", Visibility=" + Visibility
				+ ", Ceiling=" + Ceiling + ", Temperature=" + Temperature + ", WeatherDescription=" + WeatherDescription
				+ ", UpdateTime=" + UpdateTime + "]";
	}
	
}
