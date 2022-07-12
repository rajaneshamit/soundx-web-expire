package com.anstech.speechtotext.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anstech.speechtotext.model.Response;
import com.anstech.speechtotext.service.SpeechToTextService;

@RestController
@RequestMapping("rest/api")
public class SpeechToTextController {

	public static final String subscriptionKey = "ce6997094d4a4a22a5871fa927aae1ba";
	public static final String regionKey = "westus";

	@Autowired
	SpeechToTextService speechToTextService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/speect-to-text")
	public Response speechToText() {
		
		boolean isSpeaking = true;
		Response response = null;
		try {
			response = speechToTextService.speechToText(subscriptionKey, regionKey,isSpeaking);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/stop-recognition")
	public Response stopRecognition() {
		Response response = null;
		try {
			boolean isSpeaking = false;
			response = speechToTextService.speechToText(subscriptionKey, regionKey,isSpeaking);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
