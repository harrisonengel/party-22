package com.harrison.partyUtils;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class LittleBirdy implements StatusListener {

	public LittleBirdy(){
		
	}
	
	public void onStatus(Status status) {
        System.out.println(status.getUser().getName() + " : " + status.getText());
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
    
}
