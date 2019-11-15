package com.sabretn.ai.model;


public class DialogflowModel {
	
	private String IntentsName;
	
	private String iataCode;
	
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
	public String getQaTypeCode() {
		String typeCode = "";
		if(this.IntentsName != null && this.IntentsName.length() != 0) {
			typeCode = IntentsName.replace("questionType.", "");
		}
		return typeCode;
	}
	@Override
	public String toString() {
		return "DialogflowModel [IntentsName=" + IntentsName + ", iataCode=" + iataCode + "]";
	}
	
}
