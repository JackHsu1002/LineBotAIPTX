package com.sabretn.ai.ptx.model;

public class FIDSArrival implements FIDSInterface{
	
	private String FlightDate;
	private String FlightNumber;
	private Integer AirRouteType;
	private String AirlineID;
	private String DepartureAirportID;
	private String ArrivalAirportID;
	private String ScheduleArrivalTime;
	private String ActualArrivalTime;
	private String EstimatedArrivalTime;
	private String ArrivalRemark;
	private String ArrivalRemarkEn;
	private String Terminal;
	private String Gate;
	private String CodeShare;
	private Boolean IsCargo;
	private String AcType;
	private String BaggageClaim;
	private String CheckCounter;
	private String UpdateTime;
	
	public String getFlightDate() {
		return FlightDate;
	}
	public void setFlightDate(String flightDate) {
		FlightDate = flightDate;
	}
	public String getFlightNumber() {
		return FlightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		FlightNumber = flightNumber;
	}
	public Integer getAirRouteType() {
		return AirRouteType;
	}
	public void setAirRouteType(Integer airRouteType) {
		AirRouteType = airRouteType;
	}	
	public String getAirlineID() {
		return AirlineID;
	}
	public void setAirlineID(String airlineID) {
		AirlineID = airlineID;
	}
	public String getDepartureAirportID() {
		return DepartureAirportID;
	}
	public void setDepartureAirportID(String departureAirportID) {
		DepartureAirportID = departureAirportID;
	}
	public String getArrivalAirportID() {
		return ArrivalAirportID;
	}
	public void setArrivalAirportID(String arrivalAirportID) {
		ArrivalAirportID = arrivalAirportID;
	}	
	public String getScheduleArrivalTime() {
		return ScheduleArrivalTime;
	}
	public void setScheduleArrivalTime(String scheduleArrivalTime) {
		ScheduleArrivalTime = scheduleArrivalTime;
	}
	public String getActualArrivalTime() {
		return ActualArrivalTime;
	}
	public void setActualArrivalTime(String actualArrivalTime) {
		ActualArrivalTime = actualArrivalTime;
	}
	public String getEstimatedArrivalTime() {
		return EstimatedArrivalTime;
	}
	public void setEstimatedArrivalTime(String estimatedArrivalTime) {
		EstimatedArrivalTime = estimatedArrivalTime;
	}
	public String getArrivalRemark() {
		return ArrivalRemark;
	}
	public void setArrivalRemark(String arrivalRemark) {
		ArrivalRemark = arrivalRemark;
	}
	public String getArrivalRemarkEn() {
		return ArrivalRemarkEn;
	}
	public void setArrivalRemarkEn(String arrivalRemarkEn) {
		ArrivalRemarkEn = arrivalRemarkEn;
	}
	public String getTerminal() {
		return Terminal;
	}
	public void setTerminal(String terminal) {
		Terminal = terminal;
	}
	public String getGate() {
		return Gate;
	}
	public void setGate(String gate) {
		Gate = gate;
	}
	public String getCodeShare() {
		return CodeShare;
	}
	public void setCodeShare(String codeShare) {
		CodeShare = codeShare;
	}
	public Boolean getIsCargo() {
		return IsCargo;
	}
	public void setIsCargo(Boolean isCargo) {
		IsCargo = isCargo;
	}
	public String getAcType() {
		return AcType;
	}
	public void setAcType(String acType) {
		AcType = acType;
	}
	public String getBaggageClaim() {
		return BaggageClaim;
	}
	public void setBaggageClaim(String baggageClaim) {
		BaggageClaim = baggageClaim;
	}
	public String getCheckCounter() {
		return CheckCounter;
	}
	public void setCheckCounter(String checkCounter) {
		CheckCounter = checkCounter;
	}
	public String getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(String updateTime) {
		UpdateTime = updateTime;
	}
	@Override
	public String toString() {
		return "FIDSArrival [FlightDate=" + FlightDate + ", FlightNumber=" + FlightNumber + ", AirRouteType="
				+ AirRouteType + ", AirlineID=" + AirlineID + ", DepartureAirportID=" + DepartureAirportID
				+ ", ArrivalAirportID=" + ArrivalAirportID + ", ScheduleArrivalTime=" + ScheduleArrivalTime
				+ ", ActualArrivalTime=" + ActualArrivalTime + ", EstimatedArrivalTime=" + EstimatedArrivalTime
				+ ", ArrivalRemark=" + ArrivalRemark + ", ArrivalRemarkEn=" + ArrivalRemarkEn + ", Terminal=" + Terminal
				+ ", Gate=" + Gate + ", CodeShare=" + CodeShare + ", IsCargo=" + IsCargo + ", AcType=" + AcType
				+ ", BaggageClaim=" + BaggageClaim + ", CheckCounter=" + CheckCounter + ", UpdateTime=" + UpdateTime
				+ "]";
	}
}
