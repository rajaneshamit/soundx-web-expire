package com.anstech.speechtotext.service;

import java.util.concurrent.ExecutionException;

import com.anstech.speechtotext.model.Response;

public interface SpeechToTextService {

	public Response speechToText(String subscriptionKey,String regionKey, boolean isSpeaking)throws InterruptedException, ExecutionException;

}
