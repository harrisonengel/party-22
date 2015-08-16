package com.harrison.partyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartyPasscodeParser {

	private String username;
	private String password;
	
	public PartyPasscodeParser(String filepath){
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
		this.username = usernameLine.substring(usernameLine.indexOf("username:"));
		String passwordLine = inScanner.nextLine();
		this.password = passwordLine.substring(passwordLine.indexOf("password:"));
		inScanner.close();
	}
}
