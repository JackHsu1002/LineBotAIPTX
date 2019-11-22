package com.sabretn.ai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "globalconfig") //此為將yml的值注入
public class GlobalConfig {
	private String dialogflow;
	private String ptxid;
	private String ptxkey;
	private String weatherurl;

	public String getDialogflow() {
		return dialogflow;
	}
	public void setDialogflow(String dialogflow) {
		this.dialogflow = dialogflow;
	}
	public String getPtxid() {
		return ptxid;
	}
	public void setPtxid(String ptxid) {
		this.ptxid = ptxid;
	}
	public String getPtxkey() {
		return ptxkey;
	}
	public void setPtxkey(String ptxkey) {
		this.ptxkey = ptxkey;
	}
	public String getWeatherurl() {
		return weatherurl;
	}
	public void setWeatherurl(String weatherurl) {
		this.weatherurl = weatherurl;
	}
		
}
