package me.atticusthecoder.chatbot.cores;

import me.atticusthecoder.chatbot.common.Core;

public class BasicCore extends Core {

	public BasicCore() {
		super("Basic Core", new String[] {"Atticus Zambrana"});
	}

	@Override
	public void registerInvokationPhrases() {
		addInvokationPhrase("HELLO THERE");
	}
}
