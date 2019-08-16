package me.atticusthecoder.chatbot.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.atticusthecoder.chatbot.exception.ResponseNotFoundException;
import me.atticusthecoder.chatbot.util.ConsoleUtil;

public abstract class Core {
	
	private String coreName;
	private String[] coreAuthors;
	
	private List<String> invokationPhrases = new ArrayList<String>();
	private List<String> responses = new ArrayList<String>();
	
	protected Atticus atticus;
	
	public Core(String coreName, String[] coreAuthors) {
		this.coreName = coreName;
		this.coreAuthors = coreAuthors;
		ConsoleUtil.get().debug("Registered " + coreName + " to Core Library.");
		
		// Then register the invokation phrases to the core, that we are working with
		registerInvokationPhrases();
		registerResponses();
	}
	
	public String getCoreName() {
		return coreName;
	}
	
	public String[] getCoreAuthors() {
		return coreAuthors;
	}
	
	public List<String> getInvokationPhrases() {
		return invokationPhrases;
	}
	
	public void addInvokationPhrase(String phrase) {
		invokationPhrases.add(phrase.toLowerCase());
		ConsoleUtil.get().debug("Added '" + phrase.toLowerCase() + "' as an invokation phrase for Core " + coreName + ".");
	}
	
	public void addResponse(String response) {
		responses.add(response);
		ConsoleUtil.get().debug("Added '" + response + "' as a response for Core " + coreName + ".");
	}
	
	public String getResponse() {
		Random r = new Random();
		int i = r.nextInt(responses.size());
		return responses.get(i);
	}
	
	public String process(String rawInput, Atticus a) throws ResponseNotFoundException {
		atticus = a;
		String input = rawInput.toLowerCase();
		String output = "";
		for(String invokePhrase : invokationPhrases) {
			if(input.equals(invokePhrase)) {
				return getResponse();
			}
			if(input.indexOf(invokePhrase) >= 0) {
				return getResponse();
			}
		}
		
		throw new ResponseNotFoundException("");
	}
	
	public abstract void registerInvokationPhrases();
	
	public abstract void registerResponses();
}
