package com.sabretn.ai.ptx.model.flexmsg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;

import com.linecorp.bot.model.action.PostbackAction;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.Box;
import com.linecorp.bot.model.message.flex.component.Button;
import com.linecorp.bot.model.message.flex.component.Filler;
import com.linecorp.bot.model.message.flex.component.FlexComponent;
import com.linecorp.bot.model.message.flex.component.Separator;
import com.linecorp.bot.model.message.flex.component.Spacer;
import com.linecorp.bot.model.message.flex.component.Text;
import com.linecorp.bot.model.message.flex.component.Button.ButtonHeight;
import com.linecorp.bot.model.message.flex.component.Button.ButtonStyle;
import com.linecorp.bot.model.message.flex.component.Text.TextWeight;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.container.BubbleStyles;
import com.linecorp.bot.model.message.flex.container.BubbleStyles.BlockStyle;
import com.linecorp.bot.model.message.flex.container.Carousel;
import com.linecorp.bot.model.message.flex.unit.FlexAlign;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexGravity;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;
import com.sabretn.ai.ptx.model.FIDSArrival;
import com.sabretn.ai.ptx.model.FIDSInterface;

public class ArrivalFlexMessage implements Supplier<FlexMessage>{
	private String iataCode;
	private List<FIDSArrival> arList;
	
	@Override
	public FlexMessage get() {
		
		final Box header = createHeaderBlock();
		final Box body = createBodyBlock(this.arList);
		final Box footer = createFooterBlock();
		
		BlockStyle headerStyle = BlockStyle.builder()
				.backgroundColor("#E50000")
				.separator(false)
				.separatorColor("#000000")
				.build();
		BlockStyle bodyStyle = BlockStyle.builder()
				.backgroundColor("#FFFFFF")				
				.separator(false)
				.separatorColor("#000000")
				.build();
		BlockStyle footerStyle = BlockStyle.builder()
				.backgroundColor("#FFFFFF")				
				.separator(false)
				.separatorColor("#000000")
				.build();
		
		final Bubble bubble =
				Bubble.builder()
					.header(header)
					.body(body)
//					.footer(footer)
					.styles(new BubbleStyles(headerStyle, bodyStyle, bodyStyle, bodyStyle))
					.build();
		return new FlexMessage("即時到站資訊", bubble);
	}
	
	public Box createHeaderBlock() {
		final Text headerText = Text.builder()
						.text("即時到站資訊:")
						.size(FlexFontSize.Md)
						.weight(TextWeight.BOLD)
						.color("#FFFFFF")
						.margin(FlexMarginSize.NONE)
						.flex(0)
						.build();
		
		final Text keyword = Text.builder()
				.text(iataCode)
				.size(FlexFontSize.Md)
				.weight(TextWeight.BOLD)
				.color("#333333")
				.margin(FlexMarginSize.MD)
				.flex(0)
				.build();
						
		return Box.builder()
				.layout(FlexLayout.HORIZONTAL)
				.margin(FlexMarginSize.NONE)
				.contents(Arrays.asList(headerText, keyword))
				.build();			
	}
	
	public Box createBodyBlock(List<FIDSArrival> arList) {		
		List<FlexComponent> boxList = new ArrayList<>();
		
		for(FIDSArrival ar : arList) {
			LocalDate date = LocalDate.parse(ar.getFlightDate());
			LocalDateTime arrTime = LocalDateTime.parse(ar.getScheduleArrivalTime());
			String arrPlace = "";
			if(ar.getGate() != null && !ar.getGate().isEmpty()) {
				arrPlace = " Gate: " + ar.getGate();
			}else if(ar.getTerminal() != null && !ar.getTerminal().isEmpty()) {
				arrPlace = " Terimal: " + ar.getTerminal();
			}
			final Spacer spacer = Spacer.builder()					
					.size(FlexMarginSize.SM)					
					.build();
			
			final Text question = Text.builder()
					.text(date.getMonthValue()+"/"+date.getDayOfMonth() +" " + ar.getAirlineID() + ar.getFlightNumber() +" "+ar.getDepartureAirportID()+" → " + ar.getArrivalAirportID())
					.maxLines(1)
					.size(FlexFontSize.SM)
					.color("#333333")
					.align(FlexAlign.START)
					.weight(TextWeight.BOLD)
					.gravity(FlexGravity.TOP)
					.flex(0)
					.build();
			
			final Text answer = Text.builder()
				.text("預期到站: " + arrTime.getHour()+":"+arrTime.getMinute() + " " + ar.getArrivalRemark() + arrPlace )
				.size(FlexFontSize.XS)
				.align(FlexAlign.START)
				.color("#AAAAAA")
				.weight(TextWeight.REGULAR)
				.gravity(FlexGravity.BOTTOM)
				.maxLines(1)
				.flex(0)
				.build();
			
			Box box = Box.builder()
					.layout(FlexLayout.VERTICAL)
					.margin(FlexMarginSize.SM)
					.action(new PostbackAction("Q&A", "{\"action\":\"findqa\",\"param\":\""+1+"\"}"))
					.contents(Arrays.asList(spacer,question,answer))
					.spacing(FlexMarginSize.SM)
					.build();
			
			boxList.add(box);
		}
		
		return  Box.builder()
				.layout(FlexLayout.VERTICAL)
				.margin(FlexMarginSize.NONE)
				.contents(boxList)
				.spacing(FlexMarginSize.MD)
				.build();
	}
	
	public Box createFooterBlock() {
		
//		final Spacer spacer = Spacer.builder().size(FlexMarginSize.SM).build();
		
//		final Separator separator = Separator.builder()
//				.margin(FlexMarginSize.MD)
//				.build();
		
		final Button searchBtn = Button.builder()
				.style(ButtonStyle.SECONDARY)
				.height(ButtonHeight.SMALL)
				.margin(FlexMarginSize.MD)
				.color("#ceffce")
				.action(new PostbackAction("繼續搜尋", "{\"action\":\"keepSearch\",\"param\":\"0\"}"))
				.build();
		
		final Button findSvcBtn = Button.builder()
				.style(ButtonStyle.SECONDARY)
				.height(ButtonHeight.SMALL)
				.margin(FlexMarginSize.MD)				
				.color("#c4e1ff")
				.action(new PostbackAction("真人客服", "{\"action\":\"findCS\",\"param\":\"CS\"}"))
				.build();
		
		return Box.builder()
				.layout(FlexLayout.HORIZONTAL)
				.margin(FlexMarginSize.XS)
				.contents(Arrays.asList(searchBtn, findSvcBtn))
				.build();
	}
	public List<FIDSArrival> getArList() {
		return arList;
	}
	public void setArList(List<FIDSArrival> arList) {
		this.arList = arList;
	}
	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}	
}
