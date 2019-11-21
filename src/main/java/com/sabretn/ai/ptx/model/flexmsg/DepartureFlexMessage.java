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
import com.sabretn.ai.ptx.model.FIDSDeparture;
import com.sabretn.ai.ptx.model.FIDSInterface;

public class DepartureFlexMessage implements Supplier<FlexMessage>{
	private String iataCode;
	private List<FIDSDeparture> depList;
	
	@Override
	public FlexMessage get() {
		
		final Box header = createHeaderBlock();
		final Box body = createBodyBlock(this.depList);
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
		return new FlexMessage("即時離站資訊", bubble);
	}
	
	public Box createHeaderBlock() {
		final Text headerText = Text.builder()
						.text("即時離站資訊:")
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
	
	public Box createBodyBlock(List<FIDSDeparture> depList) {		
		List<FlexComponent> boxList = new ArrayList<>();
		
		for(FIDSDeparture dep : depList) {
			LocalDate date = LocalDate.parse(dep.getFlightDate());
			LocalDateTime depTime = LocalDateTime.parse(dep.getScheduleDepartureTime());
			String depPlace = "";
			if(dep.getGate() != null && dep.getGate().isEmpty()) {
				depPlace = " Gate: " + dep.getGate();
			}else if(!dep.getTerminal().isEmpty()) {
				depPlace = " Terimal: " + dep.getTerminal();
			}
			final Spacer spacer = Spacer.builder()					
					.size(FlexMarginSize.SM)					
					.build();
			
			final Text question = Text.builder()
					.text(date.getMonthValue()+"/"+date.getDayOfMonth() +" " + dep.getAirlineID() + dep.getFlightNumber() +" "+dep.getDepartureAirportID()+" → " + dep.getArrivalAirportID())
					.maxLines(1)
					.size(FlexFontSize.SM)
					.color("#333333")
					.align(FlexAlign.START)
					.weight(TextWeight.BOLD)
					.gravity(FlexGravity.TOP)
					.flex(0)
					.build();
			
			final Text answer = Text.builder()
				.text("預期離站: " + depTime.getHour()+":"+depTime.getMinute() + " " + dep.getDepartureRemark() + depPlace )
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
	public List<FIDSDeparture> getDepList() {
		return depList;
	}
	public void setDepList(List<FIDSDeparture> depList) {
		this.depList = depList;
	}
	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}	
}
