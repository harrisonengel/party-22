package com.harrison.partyUtils;

import twitter4j.HashtagEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class LittleBirdy implements StatusListener {
	
	private static final String PARTY_TAG = "TestParty";

	public LittleBirdy(PartyPasscodeParser parser){
		
	}
	
	public void onStatus(Status status) {
        HashtagEntity[] hashtags = status.getHashtagEntities();
        if(containsPartyHash(hashtags)){
        	System.out.println("PARTY TIME!: " + status.getText());
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
			if((hashtags[i].getText()).equals(PARTY_TAG))
				return true;
		}
		return false;
	}
}
