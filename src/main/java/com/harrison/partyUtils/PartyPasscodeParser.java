package com.harrison.partyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartyPasscodeParser {

	private String username;
	private String password;
	private String consumerKey;
	private String secretKey;
	private String authToken;
	private String authSecretToken;
	
	public PartyPasscodeParser(String filepath){
		System.out.println(filepath);
		File passFile = new File(filepath);
		try{
			parseFile(passFile);
		} catch(FileNotFoundException e){
			System.out.println("WARNING! PROBLEM PARSING FILE!!");
			e.printStackTrace();
		}
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	private void parseFile(File passFile) throws FileNotFoundException{
		Scanner inScanner = new Scanner(passFile);
		String usernameLine = inScanner.nextLine();	
		this.username = usernameLine.substring(usernameLine.indexOf(":") + 1);
		String passwordLine = inScanner.nextLine();
		this.password = passwordLine.substring(passwordLine.indexOf(":") + 1);
		String keyLine = inScanner.nextLine();
		this.consumerKey = keyLine.substring(keyLine.indexOf(":") + 1);
		String secretLine = inScanner.nextLine();
		this.secretKey = secretLine.substring(secretLine.indexOf(":") + 1);
		String authLine = inScanner.nextLine();
		this.authToken = authLine.substring(authLine.indexOf(":") + 1);
		String authSecretLine = inScanner.nextLine();
		this.authSecretToken = authSecretLine.substring(authSecretLine.indexOf(":") + 1);
		
		inScanner.close();
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getAuthSecretToken() {
		return authSecretToken;
	}

	public String getConsumerKey() {
		return consumerKey;
	}
	
	public String getSecretKey(){
		return secretKey;
	}
}
