package com.sabretn.ai.ptx.model.flexmsg;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.function.Supplier;

import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.Box;
import com.linecorp.bot.model.message.flex.component.Button;
import com.linecorp.bot.model.message.flex.component.Text;
import com.linecorp.bot.model.message.flex.component.Button.ButtonHeight;
import com.linecorp.bot.model.message.flex.component.Button.ButtonStyle;
import com.linecorp.bot.model.message.flex.component.Image;
import com.linecorp.bot.model.message.flex.component.Image.ImageAspectMode;
import com.linecorp.bot.model.message.flex.component.Image.ImageAspectRatio;
import com.linecorp.bot.model.message.flex.component.Image.ImageSize;
import com.linecorp.bot.model.message.flex.component.Text.TextWeight;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;

public class WeatherFlexMsg implements Supplier<FlexMessage>{
	
	private String heroImgUrl;
	private String bodyText;
//	private String actionUri;
	private String title;
	
	@Override
	public FlexMessage get() {
		URI heroimgURI = null;
		try {
			heroimgURI = new URI(heroImgUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		final Image heroBlock =
				Image.builder()				
					.url(heroImgUrl)
					.size(ImageSize.FULL_WIDTH)
					.aspectMode(ImageAspectMode.Cover)
					.aspectRatio(ImageAspectRatio.R20TO13)
//					.action(new URIAction("填寫代碼", actionUri, null))
					.build();
		
		final Box bodyBlock = createBodyBlock();
		final Box footerBlock = createFooterBlock();
		final Bubble bubble =
                Bubble.builder()
                      .hero(heroBlock)
                      .body(bodyBlock)
//                      .footer(footerBlock)
                      .build();
		
		return new FlexMessage("天氣資訊", bubble);
	}
	
	public Box createBodyBlock() {
		
		final Text titleText = Text.builder()
				.text(title)
				.size(FlexFontSize.Md)
				.weight(TextWeight.BOLD)
				.color("#333333")
				.margin(FlexMarginSize.XS)
				.wrap(true)
				.flex(0)
				.build();
		
		final Text BodyText = Text.builder()
				.text(bodyText)
				.size(FlexFontSize.Md)
				.weight(TextWeight.REGULAR)
				.color("#333333")
				.margin(FlexMarginSize.XS)
				.wrap(true)
				.flex(0)
				.build();
				
		return Box.builder()
				.layout(FlexLayout.VERTICAL)
				.margin(FlexMarginSize.MD)
				.contents(Arrays.asList(titleText, BodyText))				
				.build();
	}
	
	public Box createFooterBlock() {
		
		final Button pdCollectionBtn = Button.builder()
				.style(ButtonStyle.PRIMARY)
				.height(ButtonHeight.SMALL)
				.margin(FlexMarginSize.MD)
				.color("#E50000")
//				.action(new URIAction("前往填寫代碼", actionUri, null))
				.build();
		
		return Box.builder()
				.layout(FlexLayout.HORIZONTAL)
				.margin(FlexMarginSize.XS)				
				.contents(Arrays.asList(pdCollectionBtn))
				.build();
	}

	
	public String getHeroImgUrl() {
		return heroImgUrl;
	}

	public void setHeroImgUrl(String heroImgUrl) {
		this.heroImgUrl = heroImgUrl;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

//	public String getActionUri() {
//		return actionUri;
//	}
//
//	public void setActionUri(String actionUri) {
//		this.actionUri = actionUri;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
