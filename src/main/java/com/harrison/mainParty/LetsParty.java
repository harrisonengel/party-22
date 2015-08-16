package com.harrison.mainParty;


import com.harrison.partyUtils.LittleBirdy;
import com.harrison.partyUtils.PartyPasscodeParser;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class LetsParty {

	public static void main(String[] args) {
		
		PartyPasscodeParser passParser = new PartyPasscodeParser(args[1]);
		
		LittleBirdy birdy = new LittleBirdy();
		
		TwitterStream twatterStream = new TwitterStreamFactory().getInstance();
		twatterStream.addListener(birdy);
	}

}
