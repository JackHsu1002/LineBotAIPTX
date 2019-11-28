package com.sabretn.ai.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sabretn.ai.config.GlobalConfig;
import com.sabretn.ai.config.PTXConfig;
import com.sabretn.ai.ptx.HMAC_SHA1;
import com.sabretn.ai.ptx.SslUtils;
import com.sabretn.ai.ptx.model.FIDSArrival;
import com.sabretn.ai.ptx.model.FIDSDeparture;
import com.sabretn.ai.ptx.model.METAR;
import com.sabretn.ai.service.PTXService;


@Service
public class PTXServiceImpl implements PTXService{
	@Autowired
	private GlobalConfig globalConfig;
	@Autowired
	private PTXConfig ptxConfig;
	@Override
	public List<FIDSDeparture> getFIDSDeparture(String IATACode) {
		String APIUrl = ptxConfig.getAirport_departure() + IATACode + "?$orderby=ScheduleDepartureTime%20desc&$format=JSON";
		String response = getApiResponseString(APIUrl);
		 
	    Type FIDSDepartureListType = new TypeToken<ArrayList<FIDSDeparture>>(){}.getType();
	    Gson gsonReceiver = new Gson();
	    List<FIDSDeparture> resultList = gsonReceiver.fromJson(response, FIDSDepartureListType);
	    resultList.forEach(ob->{
	    	System.out.println(ob);
	    });
		return resultList;
	}
	

	@Override
	public List<FIDSArrival> getFIDSArrivals(String IATACode) {
		String APIUrl = ptxConfig.getAirport_arrival() + IATACode + "?$orderby=ScheduleArrivalTime%20desc&$top=10&$format=JSON";
		String response = getApiResponseString(APIUrl);
		 
	    Type FIDSArrivalListType = new TypeToken<ArrayList<FIDSArrival>>(){}.getType();
	    Gson gsonReceiver = new Gson();
	    List<FIDSArrival> resultList = gsonReceiver.fromJson(response, FIDSArrivalListType);
	    resultList.forEach(ob->{
	    	System.out.println(ob);
	    });
		return resultList;
	}


	@Override
	public List<METAR> getAirportWeather(String IATACode) {
		String APIUrl = ptxConfig.getAirport_weather() + IATACode + "?$top=10&$format=JSON";
		String response = getApiResponseString(APIUrl);
		 
	    Type METARListType = new TypeToken<ArrayList<METAR>>(){}.getType();
	    Gson gsonReceiver = new Gson();
	    List<METAR> resultList = gsonReceiver.fromJson(response, METARListType);
	    resultList.forEach(ob->{
	    	System.out.println(ob);
	    });
		return resultList;
	}

	
	
	
	
	public String getApiResponseString(String apiUrl) {
		
		String APPID = globalConfig.getPtxid();
		String APPKey = globalConfig.getPtxkey();		
		String xdate = getServerTime();
		String SignDate = "x-date: " + xdate;
		String Signature="";
		String result = "";
		try {
			//取得加密簽章
			Signature = HMAC_SHA1.Signature(SignDate, APPKey);
		} catch (SignatureException e1) {
			e1.printStackTrace();
		}
		String sAuth = "hmac username=\"" + APPID + "\", algorithm=\"hmac-sha1\", headers=\"x-date\", signature=\"" + Signature + "\"";
			
		HttpURLConnection connection = null;
		try{  
		     URL url=new URL(apiUrl);
		     if("https".equalsIgnoreCase(url.getProtocol())){
		           SslUtils.ignoreSsl();
		       }
		     connection=(HttpURLConnection)url.openConnection();
		     connection.setRequestMethod("GET");
		     connection.setRequestProperty("Authorization", sAuth);
		     connection.setRequestProperty("x-date", xdate);
		     connection.setRequestProperty("Accept-Encoding", "gzip");
		     connection.setDoInput(true);
		     connection.setDoOutput(true);
		     
		     Reader reader = null;
		      if ("gzip".equals(connection.getContentEncoding())) {
		         reader = new InputStreamReader(new GZIPInputStream(connection.getInputStream()), "UTF-8");
		      }
		      else {
		         reader = new InputStreamReader(connection.getInputStream(), "UTF-8");
		      }
		      
		     BufferedReader in = new BufferedReader(reader);
		     //讀取回傳資料
		     String line="";
		     String response="";
		     while ((line = in.readLine()) != null) {
		         response+=(line+"\n");
		     }
		     result = response;		    
		     
		  }catch(ProtocolException e){
		   e.printStackTrace();
		  }
		  
		  catch(Exception e){
		   e.printStackTrace();
		  }
		
		return result;
	}
	
		
	 //取得當下UTC時間
	public static String getServerTime() {
	    Calendar calendar = Calendar.getInstance();
	    SimpleDateFormat dateFormat = new SimpleDateFormat(
	        "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
	    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	    return dateFormat.format(calendar.getTime());
	}

}
