package com.anstech.speechtotext;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoundexApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoundexApplication.class, args);
		deleteFile();
	}

	private static void deleteFile() {
		
		File file = new File("D://projects//file.txt");
		if(file.delete()) {
			System.out.println("file deleted successfully");
		}
		if(!file.exists()){
			System.out.println("We had to make a new file.");
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
