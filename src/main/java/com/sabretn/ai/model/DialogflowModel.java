package com.sabretn.ai.model;

import java.util.List;
import java.util.stream.Collectors;

public class DialogflowModel {
	
	private String IntentsName;
	
	private List<String> keywords;
	
	public String getIntentsName() {
		return IntentsName;
	}
	public void setIntentsName(String intentsName) {
		IntentsName = intentsName;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public void filterKeyword() {
		if(this.keywords != null & keywords.size() != 0) {
			this.keywords = this.keywords.stream()
				.filter(k -> k.length() != 1)
				.collect(Collectors.toList());
		}
	}
	public String formatKeyword() {
		String formatKeyword = "";
		if(this.keywords != null & keywords.size() != 0) {
			formatKeyword = keywords.stream()
				.collect(Collectors.joining(",","[","]"));
		}
		return formatKeyword;
	}
	public String srKeyword() {
		String srKeyword = "";
		if(this.keywords != null & keywords.size() != 0) {
			srKeyword = keywords.stream()
					.collect(Collectors.joining(";"));
		}
		return srKeyword;
	}
	public String getQaTypeCode() {
		String typeCode = "";
		if(this.IntentsName != null && this.IntentsName.length() != 0) {
			typeCode = IntentsName.replace("questionType.", "");
		}
		return typeCode;
	}
}
