package com.sabretn.ai.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.BeaconEvent;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.JoinEvent;
import com.linecorp.bot.model.event.MemberJoinedEvent;
import com.linecorp.bot.model.event.MemberLeftEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.PostbackEvent;
import com.linecorp.bot.model.event.UnfollowEvent;
import com.linecorp.bot.model.event.message.AudioMessageContent;
import com.linecorp.bot.model.event.message.FileMessageContent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import com.linecorp.bot.model.event.message.LocationMessageContent;
import com.linecorp.bot.model.event.message.StickerMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.event.message.VideoMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.sabretn.ai.config.GlobalConfig;
import com.sabretn.ai.model.DialogflowModel;
import com.sabretn.ai.ptx.model.FIDSArrival;
import com.sabretn.ai.ptx.model.FIDSDeparture;
import com.sabretn.ai.ptx.model.METAR;
import com.sabretn.ai.ptx.model.flexmsg.ArrivalFlexMessage;
import com.sabretn.ai.ptx.model.flexmsg.DepartureFlexMessage;
import com.sabretn.ai.ptx.model.flexmsg.WeatherFlexMsg;
import com.sabretn.ai.service.DialogflowService;
import com.sabretn.ai.service.PTXService;

@LineMessageHandler
public class LineMessageController {
	
	@Autowired
	private LineMessagingClient lineMessagingClient;
	@Autowired
	private DialogflowService dailogflowSvc;
	@Autowired
	private GlobalConfig globalConfig;
	@Autowired
	private PTXService ptxService;
	
	
	private final Logger logger = LoggerFactory.getLogger(LineMessageController.class);
	
	@EventMapping
    public void handleUnfollowEvent(UnfollowEvent event) {		
    }
	
	@EventMapping
	public void handleFollowEvent(FollowEvent event) {
	}
	
	@EventMapping
    public void handleLocationMessageEvent(MessageEvent<LocationMessageContent> event) {
    }
	
	@EventMapping
    public void handleOtherEvent(Event event) {
    }
	
	@EventMapping
	public void handleStickerMessageEvent(MessageEvent<StickerMessageContent> event) {
	}
	
	@EventMapping
    public void handleImageMessageEvent(MessageEvent<ImageMessageContent> event) throws IOException {
	}
	
	@EventMapping
    public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws Exception {
		String messageText = event.getMessage().getText();
		String userId      = event.getSource().getUserId();
		String replyToken  = event.getReplyToken();
		DialogflowModel res   = dailogflowSvc.CustomerAnalysis(messageText, globalConfig.getDialogflow(), userId, "zh-tw");
		System.out.println(res);
		String type = res.getIntentsName();
		
		//機場即時入境航班
		if("type.airport.arrivalTime".equals(type)) {
			String iataCode = res.getIataCode();
			List<FIDSArrival> arList =  ptxService.getFIDSArrivals(iataCode);
			ArrivalFlexMessage afmsg = new ArrivalFlexMessage();
			afmsg.setArList(arList);
			afmsg.setIataCode(iataCode);
			List<Message> messages = new ArrayList<>();
			messages.add(afmsg.get()); 
			lineMessagingClient.replyMessage(new ReplyMessage(replyToken, messages));
			
		}
		
		//機場即時出境航班
		if("type.airport.departureTime".equals(type)) {
			String iataCode = res.getIataCode();
			List<FIDSDeparture> depList = ptxService.getFIDSDeparture(iataCode);
			DepartureFlexMessage demsg = new DepartureFlexMessage();
			demsg.setDepList(depList);
			demsg.setIataCode(iataCode);
			List<Message> messages = new ArrayList<>();
			messages.add(demsg.get()); 
			lineMessagingClient.replyMessage(new ReplyMessage(replyToken, messages));
		}
		
		//國內機場氣象資訊觀測資料
		if("type.airport.weather".equals(type)) {
			String iataCode = res.getIataCode();
			List<METAR> metarList = ptxService.getAirportWeather(iataCode);
			if(!metarList.isEmpty()) {
				METAR metar = metarList.get(0);
				WeatherFlexMsg wFlexMsg = new WeatherFlexMsg();
				wFlexMsg.setHeroImgUrl("https://0fb69f26.ngrok.io/img/weather.jpg");
				wFlexMsg.setTitle(metar.getAirportName().getZh_tw());
				wFlexMsg.setBodyText("溫度:"+metar.getTemperature() +" 風速:"+metar.getWindSpeed() + " "+metar.getWeatherDescription().getZh_tw());
				List<Message> messages = new ArrayList<>();
				messages.add(wFlexMsg.get());
				lineMessagingClient.replyMessage(new ReplyMessage(replyToken, messages));
			}
			
		}
		
		
		System.out.println(res);
    }
	
	@EventMapping
    public void handleAudioMessageEvent(MessageEvent<AudioMessageContent> event) throws IOException {
		
	}
	
	@EventMapping
    public void handleVideoMessageEvent(MessageEvent<VideoMessageContent> event) throws IOException {
	}
	
	@EventMapping
    public void handleFileMessageEvent(MessageEvent<FileMessageContent> event) {
	}
	
	@EventMapping
	public void handleJoinEvent(JoinEvent event) {
	}
	
	
    @EventMapping
    public void handlePostbackEvent(PostbackEvent event) {
    }

    @EventMapping
    public void handleBeaconEvent(BeaconEvent event) {
    }
    
    @EventMapping
    public void handleMemberJoined(MemberJoinedEvent event) {
    }
    
    @EventMapping
    public void handleMemberLeft(MemberLeftEvent event) {
    }

	private void reply(@NonNull String replyToken, @NonNull List<Message> messages) {
	    try {
	        BotApiResponse apiResponse = lineMessagingClient
	                  .replyMessage(new ReplyMessage(replyToken, messages))
	                  .get();
	        System.out.println("Sent messages: {}" + apiResponse);
	    } catch (InterruptedException | ExecutionException e) {
	        throw new RuntimeException(e);
	    }
	}
	 
	private void reply(@NonNull String replyToken, @NonNull Message message) {
	    reply(replyToken, Collections.singletonList(message));
	}	

    private void replyText(@NonNull String replyToken, @NonNull String message) {
        if (replyToken.isEmpty()) {
            throw new IllegalArgumentException("replyToken must not be empty");
        }
        if (message.length() > 1000) {
            message = message.substring(0, 1000 - 2) + "……";
        }
        this.reply(replyToken, new TextMessage(message));
    }
	
}
