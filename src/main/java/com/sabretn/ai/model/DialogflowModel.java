package com.sabretn.ai.model;


public class DialogflowModel {
	
	private String IntentsName;
	
	private String iataCode;
	private String currencyCode;
	
	public String getIntentsName() {
		return IntentsName;
	}
	public void setIntentsName(String intentsName) {
		IntentsName = intentsName;
	}	
	public String getIataCode() {
		return iataCode;
	}
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	@Override
	public String toString() {
		return "DialogflowModel [IntentsName=" + IntentsName + ", iataCode=" + iataCode + ", currencyCode="
				+ currencyCode + "]";
	}		
}
