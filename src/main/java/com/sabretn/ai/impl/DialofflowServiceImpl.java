package com.sabretn.ai.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.cloud.dialogflow.v2.TextInput.Builder;
import com.google.protobuf.Value;
import com.sabretn.ai.model.DialogflowModel;
import com.sabretn.ai.service.DialogflowService;

@Service
public class DialofflowServiceImpl implements DialogflowService{
	
	@Override
	public DialogflowModel CustomerAnalysis(String input, String projectId, String userId, String languageCode) {
		
		DialogflowModel resModel = new DialogflowModel();
		//filter size
		if(input.length() > 256) {
			input = input.substring(0, 250);
		}
		
		try (SessionsClient sessionsClient = SessionsClient.create()) {
			// Set the session name using the sessionId (UUID) and projectID (my-project-id)
			SessionName session = SessionName.of(projectId, userId);
			
			// Detect intents for each text request
			// Set the text (hello) and language code (en-US) for the query
			Builder textInput = TextInput.newBuilder().setText(input).setLanguageCode(languageCode);
			
			// Build the query with the TextInput
			QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();
			
			// Performs the detect intent request
			DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
			
			// Display the query result
			QueryResult queryResult = response.getQueryResult();
			
			System.out.println("========== CustomerAnalysis ==========");
		    System.out.format("Query Text: '%s'\n", queryResult.getQueryText());
		    System.out.format("Detected Intent: %s (confidence: %f)\n",
		          queryResult.getIntent().getDisplayName(), queryResult.getIntentDetectionConfidence());
		    System.out.format("Fulfillment Text: '%s'\n", queryResult.getFulfillmentText());
		    List<String> keywordList = new ArrayList<>();
		    Value value = queryResult.getParameters().getFieldsOrDefault("keyword", null);
		    if(value != null) {
		    	keywordList = value.getListValue().getValuesList().stream()
    					.map(o -> o.getStringValue())
    					.collect(Collectors.toList());
		    }
		    
		    resModel.setIntentsName(queryResult.getIntent().getDisplayName());
		    resModel.setKeywords(keywordList);
		    
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return resModel;
	}

}
