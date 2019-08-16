package me.atticusthecoder.chatbot.cores;

import me.atticusthecoder.chatbot.common.Core;

public class BasicCore extends Core {

	public BasicCore() {
		super("Basic Core", new String[] {"Atticus Zambrana"});
	}

	@Override
	public void registerInvokationPhrases() {
		addInvokationPhrase("HELLO THERE");
		addInvokationPhrase("HI THERE");
		addInvokationPhrase("HI");
		addInvokationPhrase("HELLO");
	}

	@Override
	public void registerResponses() {
		addResponse("Hi!");
		addResponse("Hey!");
		addResponse("Hi there!");
	}
}
