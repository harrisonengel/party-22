package com.harrison.partyUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import twitter4j.HashtagEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class LittleBirdy implements StatusListener {
	
	private static final String PARTY_TAG = "TestParty";

	public LittleBirdy(){
		
	}
	
	public void onStatus(Status status) {
        HashtagEntity[] hashtags = status.getHashtagEntities();
        if(containsPartyHash(hashtags)){
        	File textFile = new File("partyFile.txt");
        	PrintWriter writer;
			try {
				writer = new PrintWriter("partyFile.txt", "UTF-8");
				System.out.println(status.getText());
				writer.println(status.getText());
				writer.close();
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
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
				System.out.println("********* Matching Tag ************");
				System.out.println("#" + hashtags[i].getText());
				return true;
			}
		}
		return false;
	}
}
