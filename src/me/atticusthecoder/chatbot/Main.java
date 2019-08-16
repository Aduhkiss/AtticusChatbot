package me.atticusthecoder.chatbot;

import java.util.Scanner;

import me.atticusthecoder.chatbot.common.Atticus;

public class Main {
	/*
	 * Atticus Chatbot
	 * Written by Atticus Zambrana
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//TODO: Maybe later in the programs lifetime, we could use the args for something usful
		
		// for testing reasons, lets just create an example Atticus instance that we could use for something, idk
		Atticus atticus = new Atticus("Atticus");
		
		System.out.println("You are now talking with Atticus. Say Hi!");
		run(sc, atticus);
	}
	
	public static void run(Scanner sc, Atticus a) {
		String input = sc.nextLine();
		String output = a.getResponse(input);
		
		if(output == null) {
			output = a.getName() + " didn't understand what you said.";
		}
		
		a.say(output);
		run(sc, a);
	}
}
