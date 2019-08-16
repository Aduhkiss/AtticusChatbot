package me.atticusthecoder.chatbot.common;

import java.util.ArrayList;
import java.util.List;

import me.atticusthecoder.chatbot.util.ConsoleUtil;

public abstract class Core {
	
	private String coreName;
	private String[] coreAuthors;
	
	private List<String> invokationPhrases = new ArrayList<String>();
	
	public Core(String coreName, String[] coreAuthors) {
		this.coreName = coreName;
		this.coreAuthors = coreAuthors;
		ConsoleUtil.get().debug("Registered " + coreName + " to Core Library.");
		
		// Then register the invokation phrases to the core, that we are working with
		registerInvokationPhrases();
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
	
	public abstract void registerInvokationPhrases();
}
