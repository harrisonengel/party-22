package com.harrison.partyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import twitter4j.HashtagEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class LittleBirdy implements StatusListener {
	
	private static final String PARTY_TAG = "TestParty";
	private static Date current;
	private File partyFile;
	private String[] speaker = {"C:\\Program Files (x86)\\eSpeak\\command_line\\espeak.exe", "-f", "partyFile.txt", "-p", "10", "-s", "100"};
	
	public LittleBirdy(){
		if(current == null)
			current = new Date();
		try {
			Files.deleteIfExists(Paths.get("partyFile.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		partyFile = new File("partyFile.txt");
	}
	
	public void onStatus(Status status) {
        HashtagEntity[] hashtags = status.getHashtagEntities();
        if(containsPartyHash(hashtags) && (status.getCreatedAt().compareTo(current) > 0)){
        	PrintWriter writer;
			try {
				System.out.println("FOUND TWEET: \n" + status.getText());
				writer = new PrintWriter(partyFile, "UTF-8");
				writer.println(specialString(status.getText()));
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			Runtime thisRun = Runtime.getRuntime();
			try {
				thisRun.exec(speaker);
			} catch (IOException e) {
				e.printStackTrace();
			}
			current = new Date();
        }
    }
	
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
    
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
    
    public void onException(Exception ex) {
        ex.printStackTrace();
    }

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}
    
	private boolean containsPartyHash(HashtagEntity[] hashtags){
		for(int i=0; i<hashtags.length; i++){
			if((hashtags[i].getText()).equalsIgnoreCase(PARTY_TAG)){
				return true;
			}
		}
		return false;
	}
	
	private String specialString(String toWrite){
		StringBuilder builder = new StringBuilder("");
		for(int ii=0; ii<toWrite.length(); ii++){
			if(toWrite.charAt(ii) == '#'){
				builder.append(" hashtag ");
			} else{
				builder.append(toWrite.charAt(ii));
			}
		}
		return builder.toString();
	}
}
