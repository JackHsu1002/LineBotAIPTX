package com.sabretn.ai.ptx.model;

public class FIDSDeparture implements FIDSInterface{
	private String FlightDate;
	private String FlightNumber;
	private Integer AirRouteType;
	private String AirlineID;
	private String DepartureAirportID;
	private String ArrivalAirportID;
	private String ScheduleDepartureTime;
	private String ActualDepartureTime;
	private String EstimatedDepartureTime;
	private String DepartureRemark;
	private String DepartureRemarkEn;
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
		this.AirlineID = airlineID;
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
	public String getScheduleDepartureTime() {
		return ScheduleDepartureTime;
	}
	public void setScheduleDepartureTime(String scheduleDepartureTime) {
		ScheduleDepartureTime = scheduleDepartureTime;
	}
	public String getActualDepartureTime() {
		return ActualDepartureTime;
	}
	public void setActualDepartureTime(String actualDepartureTime) {
		ActualDepartureTime = actualDepartureTime;
	}
	public String getEstimatedDepartureTime() {
		return EstimatedDepartureTime;
	}
	public void setEstimatedDepartureTime(String estimatedDepartureTime) {
		EstimatedDepartureTime = estimatedDepartureTime;
	}
	public String getDepartureRemark() {
		return DepartureRemark;
	}
	public void setDepartureRemark(String departureRemark) {
		DepartureRemark = departureRemark;
	}
	public String getDepartureRemarkEn() {
		return DepartureRemarkEn;
	}
	public void setDepartureRemarkEn(String departureRemarkEn) {
		DepartureRemarkEn = departureRemarkEn;
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
		return "FIDSDeparture [FlightDate=" + FlightDate + ", FlightNumber=" + FlightNumber + ", AirRouteType="
				+ AirRouteType + ", airlineID=" + AirlineID + ", DepartureAirportID=" + DepartureAirportID
				+ ", ArrivalAirportID=" + ArrivalAirportID + ", ScheduleDepartureTime=" + ScheduleDepartureTime
				+ ", ActualDepartureTime=" + ActualDepartureTime + ", EstimatedDepartureTime=" + EstimatedDepartureTime
				+ ", DepartureRemark=" + DepartureRemark + ", DepartureRemarkEn=" + DepartureRemarkEn + ", Terminal="
				+ Terminal + ", Gate=" + Gate + ", CodeShare=" + CodeShare + ", IsCargo=" + IsCargo + ", AcType="
				+ AcType + ", BaggageClaim=" + BaggageClaim + ", CheckCounter=" + CheckCounter + ", UpdateTime="
				+ UpdateTime + "]";
	}
		
	
}
