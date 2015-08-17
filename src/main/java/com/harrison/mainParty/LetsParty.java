package com.harrison.mainParty;


import com.harrison.partyUtils.LittleBirdy;
import com.harrison.partyUtils.PartyPasscodeParser;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class LetsParty {

	public static void main(String[] args) {
		PartyPasscodeParser parser = new PartyPasscodeParser(args[1]);
		
		LittleBirdy birdy = new LittleBirdy(parser);
		
		TwitterStream twatterStream = new TwitterStreamFactory().getInstance();
		twatterStream.addListener(birdy);
		twatterStream.sample();
		
		try {
			twatterStream.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
