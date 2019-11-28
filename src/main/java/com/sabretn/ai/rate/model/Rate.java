package com.sabretn.ai.rate.model;


import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Rate{
	
	@JsonProperty("TWD")
	private Double TWD;
	@JsonProperty("USD")
	private Double USD;
	@JsonProperty("HKD")
	private Double HKD;
	@JsonProperty("GBP")
	private Double GBP;
	@JsonProperty("AUD")
	private Double AUD;
	@JsonProperty("CAD")
	private Double CAD;
	@JsonProperty("SGD")
	private Double SGD;
	@JsonProperty("CHF")
	private Double CHF;
	@JsonProperty("JPY")
	private Double JPY;
	@JsonProperty("ZAR")
	private Double ZAR;
	@JsonProperty("SEK")
	private Double SEK;
	@JsonProperty("NZD")
	private Double NZD;
	@JsonProperty("THB")
	private Double THB;
	@JsonProperty("PHP")
	private Double PHP;
	@JsonProperty("IDR")
	private Double IDR;
	@JsonProperty("EUR")
	private Double EUR;
	@JsonProperty("KRW")
	private Double KRW;
	@JsonProperty("VND")
	private Double VND;
	@JsonProperty("MYR")
	private Double MYR;
	@JsonProperty("CNY")
	private Double CNY;
	public Double getTWD() {
		return TWD;
	}
	public void setTWD(Double tWD) {
		TWD = tWD;
	}
	public Double getUSD() {
		return USD;
	}
	public void setUSD(Double uSD) {
		USD = uSD;
	}
	public Double getHKD() {
		return HKD;
	}
	public void setHKD(Double hKD) {
		HKD = hKD;
	}	
	public Double getGBP() {
		return GBP;
	}
	public void setGBP(Double gBP) {
		GBP = gBP;
	}
	public Double getAUD() {
		return AUD;
	}
	public void setAUD(Double aUD) {
		AUD = aUD;
	}
	public Double getCAD() {
		return CAD;
	}
	public void setCAD(Double cAD) {
		CAD = cAD;
	}
	public Double getSGD() {
		return SGD;
	}
	public void setSGD(Double sGD) {
		SGD = sGD;
	}
	public Double getCHF() {
		return CHF;
	}
	public void setCHF(Double cHF) {
		CHF = cHF;
	}
	public Double getJPY() {
		return JPY;
	}
	public void setJPY(Double jPY) {
		JPY = jPY;
	}
	public Double getZAR() {
		return ZAR;
	}
	public void setZAR(Double zAR) {
		ZAR = zAR;
	}
	public Double getSEK() {
		return SEK;
	}
	public void setSEK(Double sEK) {
		SEK = sEK;
	}
	public Double getNZD() {
		return NZD;
	}
	public void setNZD(Double nZD) {
		NZD = nZD;
	}
	public Double getTHB() {
		return THB;
	}
	public void setTHB(Double tHB) {
		THB = tHB;
	}
	public Double getPHP() {
		return PHP;
	}
	public void setPHP(Double pHP) {
		PHP = pHP;
	}
	public Double getIDR() {
		return IDR;
	}
	public void setIDR(Double iDR) {
		IDR = iDR;
	}
	public Double getEUR() {
		return EUR;
	}
	public void setEUR(Double eUR) {
		EUR = eUR;
	}
	public Double getKRW() {
		return KRW;
	}
	public void setKRW(Double kRW) {
		KRW = kRW;
	}
	public Double getVND() {
		return VND;
	}
	public void setVND(Double vND) {
		VND = vND;
	}
	public Double getMYR() {
		return MYR;
	}
	public void setMYR(Double mYR) {
		MYR = mYR;
	}
	public Double getCNY() {
		return CNY;
	}
	public void setCNY(Double cNY) {
		CNY = cNY;
	}
	@Override
	public String toString() {
		return "Rate [TWD=" + TWD + ", USD=" + USD + ", HKD=" + HKD + ", GBP=" + GBP + ", AUD=" + AUD + ", CAD=" + CAD
				+ ", SGD=" + SGD + ", CHF=" + CHF + ", JPY=" + JPY + ", ZAR=" + ZAR + ", SEK=" + SEK + ", NZD=" + NZD
				+ ", THB=" + THB + ", PHP=" + PHP + ", IDR=" + IDR + ", EUR=" + EUR + ", KRW=" + KRW + ", VND=" + VND
				+ ", MYR=" + MYR + ", CNY=" + CNY + "]";
	}
	
		
}
