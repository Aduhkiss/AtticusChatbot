package me.atticusthecoder.chatbot.common;

import java.util.ArrayList;
import java.util.List;

import me.atticusthecoder.chatbot.cores.BasicCore;
import me.atticusthecoder.chatbot.exception.ResponseNotFoundException;
import me.atticusthecoder.chatbot.util.ConsoleUtil;

public class Atticus {
	
	private String myName;
	
	private List<Core> activeCores = new ArrayList<Core>();
	
	public Atticus(String myName) {
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
	
	public String getResponse(String message) {
		boolean found = false;
		String theReponse = null;
		for(Core c : activeCores) {
			if(!found) {
				String response = null;
				try {
					response = c.process(message, this);
				} catch(ResponseNotFoundException ex) {
					// There was no response found from this core, just ignore it and move on.
				}
				if(response != null) {
					found = true;
					theReponse = response;
				}
			}
		}
		
		return theReponse;
	}
	
	public String getName() {
		return myName;
	}
}