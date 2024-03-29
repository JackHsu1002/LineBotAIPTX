package com.sabretn.ai.rate.model;


public class RateWrapper {
	private boolean success;
	private Long timestamp;
	private String base;
	private String date;
	private Rate rates;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Rate getRates() {
		return rates;
	}
	public void setRates(Rate rates) {
		this.rates = rates;
	}
	@Override
	public String toString() {
		return "RateWrapper [success=" + success + ", timestamp=" + timestamp + ", base=" + base + ", date=" + date
				+ ", rates=" + rates + "]";
	}
	
	
}
