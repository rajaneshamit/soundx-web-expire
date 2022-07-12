package com.anstech.speechtotext.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.anstech.speechtotext.model.Data;
import com.anstech.speechtotext.model.Response;
import com.microsoft.cognitiveservices.speech.CancellationDetails;
import com.microsoft.cognitiveservices.speech.CancellationReason;
import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;

@Service
public class SpeechToTextServiceImpl implements SpeechToTextService {
	private static Semaphore stopTranslationWithFileSemaphore;
	private SpeechRecognizer speechRecognizer;
	private SpeechConfig speechConfig;
	private AudioConfig audioConfig;


	@Override
	public Response speechToText(String subScriptionKey,String regionKey,boolean isSpeaking) throws InterruptedException, ExecutionException {
		speechConfig = SpeechConfig.fromSubscription(subScriptionKey, regionKey);
		speechConfig.setSpeechRecognitionLanguage("en-US");
		speechConfig.enableDictation();
		// TODO Auto-generated method stub
		return recognizeFromMicrophone(speechConfig,isSpeaking);
	}

	public Response recognizeFromMicrophone(SpeechConfig speechConfig,boolean isSpeaking) throws InterruptedException, ExecutionException {
		Response response = new Response();
		if(audioConfig==null) {
			audioConfig = AudioConfig.fromDefaultMicrophoneInput();
		}
		System.out.println("speechRecognizer ::"+speechRecognizer);
		if(speechRecognizer==null) {
			System.out.println("insideee@@@@@@ null to create session");
			speechRecognizer = new SpeechRecognizer(speechConfig, audioConfig);
		}
		stopTranslationWithFileSemaphore = new Semaphore(0);
		System.out.println("Speak into your microphone. "+isSpeaking);
		if(isSpeaking) {
			speechRecognizer.recognized.addEventListener((s, e) -> {
				if (e.getResult().getReason() == ResultReason.RecognizedSpeech) {
					response.setMessage("Success");
					response.setStatusCode("200");
					response.setDescription(e.getResult().getText());
					System.out.println(Thread.currentThread().getName()+": " + e.getResult().getText());
					writeData(e.getResult().getText(),isSpeaking);
					if(e.getResult().getText().equalsIgnoreCase("Thank you.")) {
						System.out.println("inside thank you");
						speechRecognizer.close();
					}

				}
				else if (e.getResult().getReason() == ResultReason.NoMatch) {
					System.out.println("NOMATCH: Speech could not be recognized.");
				}
			});

		}else {
			System.out.println("into else part to stop the session");
			//9speechRecognizer.close();
			speechRecognizer.sessionStopped.addEventListener((s, e) -> {
				System.out.println("\n    Session stopped event.");
				stopTranslationWithFileSemaphore.release();
			});
		}
		speechRecognizer.startContinuousRecognitionAsync().get();
		if(!isSpeaking) {
			speechRecognizer.stopContinuousRecognitionAsync().get();
			speechRecognizer.close();
			speechRecognizer = null;
			audioConfig = null;
			File file = new File("D://projects//speechtotext//file.txt");
			file.delete();
			 if(!file.exists()) {
            	 try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
		}
		return response;

		//  System.exit(0);
	}

	private void writeData(String data, boolean isSpeaking) {
		File file = new File("D://projects//speechtotext//file.txt");

		try{
			if(isSpeaking) {
                FileWriter fileWriter = new FileWriter(file, true);

				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(" " + data +" " + " ");
				bufferedWriter.close();
			}
			System.out.println("Done");
		} catch(IOException e) {
			System.out.println("COULD NOT LOG!!");
		}
	}

}
