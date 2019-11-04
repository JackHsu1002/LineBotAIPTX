package com.sabretn.ai.service;

import com.sabretn.ai.model.DialogflowModel;

public interface DialogflowService {
	
	DialogflowModel CustomerAnalysis(String input, String projectId, String userId, String languageCode);
}
