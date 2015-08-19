package com.harrison.mainParty;

import com.harrison.partyUtils.LittleBirdy;
import com.harrison.partyUtils.PartyPasscodeParser;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class LetsParty {

	public static void main(String[] args) {
		PartyPasscodeParser parser = new PartyPasscodeParser(args[0]);
		
		LittleBirdy birdy = new LittleBirdy();
		
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setDebugEnabled(true);
		builder.setOAuthConsumerKey(parser.getConsumerKey());
		builder.setOAuthConsumerSecret(parser.getSecretKey());
		builder.setOAuthAccessToken(parser.getAuthToken());
		builder.setOAuthAccessTokenSecret(parser.getAuthSecretToken());
		TwitterFactory factory = new TwitterFactory(builder.build());
		Twitter twatter = factory.getInstance();
		
		String specialHash = "#TestParty";
		Query query = new Query(specialHash);
		try {
			while(true){
				QueryResult result = twatter.search(query);
				for(Status twat : result.getTweets()){
					birdy.onStatus(twat);
				}
				Thread.sleep(10000);
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		/*TwitterStream twatterStream = factory.getInstance();
		
		
		FilterQuery fq = new FilterQuery();
		String[] keywords = {"TestParty", "Harrison", "test"};
		fq.track(keywords);
		
		twatterStream.addListener(birdy);
		twatterStream.filter(fq);
		twatterStream.user();*/
	}

}
