/**
 * 
 */
package com.harrison.partyUtils;

import twitter4j.TwitterStream;

/**
 * @author Harrison
 *
 */
public class PartyThread implements Runnable {

	private TwitterStream myStream;
	
	public PartyThread(TwitterStream stream){
		//this.myStream = stream.filter(arg0);
	}
	
	@Override
	public void run() {
		while(true){
			//myStream.
		}

	}

}
