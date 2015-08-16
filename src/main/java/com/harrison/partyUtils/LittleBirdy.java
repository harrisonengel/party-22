package com.harrison.partyUtils;

import twitter4j.Status;
import twitter4j.StatusDeletionNotice;

public class LittleBirdy implements StatusListener {

	public StreamListener(){
		
	}
	
	public void onStatus(Status status) {
        System.out.println(status.getUser().getName() + " : " + status.getText());
    }
	
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
    
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
    
    public void onException(Exception ex) {
        ex.printStackTrace();
    }
    
}
