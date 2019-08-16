package me.atticusthecoder.chatbot.util;

public class ConsoleUtil {
	private static ConsoleUtil me;
	
	private boolean debugMode = true;
	
	public static ConsoleUtil get() {
		if(me == null) {
			me = new ConsoleUtil();
		}
		return me;
	}
	
	public void debug(String message) {
		if(!debugMode) return;
		System.out.println("[DEBUG] " + message);
	}
}
