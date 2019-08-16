package me.atticusthecoder.chatbot.common;

import java.util.ArrayList;
import java.util.List;

import me.atticusthecoder.chatbot.cores.BasicCore;
import me.atticusthecoder.chatbot.util.ConsoleUtil;

public class Atticus {
	
	private Mood myMood;
	private String myName;
	
	private List<Core> activeCores = new ArrayList<Core>();
	
	public Atticus(String myName) {
		myMood = Mood.NORMAL;
		this.myName = myName;
		registerCores();
	}
	
	public void registerCores() {
		ConsoleUtil.get().debug("Registering Cores...");
		
		// Then add all of the cores we are going to use here
		activeCores.add(new BasicCore());
	}
	
	public void say(String message) {
		System.out.println("[" + myName + "] " + message);
	}
	
	public enum Mood {
		NORMAL,
		HAPPY,
		SAD,
		ANGRY,
	}
}