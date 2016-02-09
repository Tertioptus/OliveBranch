package com.olivebranch.driver;

import com.olivebranch.Agent;
import com.olivebranch.Content;
import com.olivebranch.ImageOf;
import com.olivebranch.On;
import com.olivebranch.Time;

public final class LoggingAgent implements Agent {
	
	private Agent agent;
	
	public LoggingAgent(Agent agent) {
		this.agent = agent;
	}

	public Agent goTo(String url) {
		agent.goTo(url);
		agent.capture(ImageOf.SCREEN);
		return agent;
	}

	public Agent click(Content content) {
		agent.click(content);
		agent.capture(ImageOf.SCREEN);
		return agent;
	}

	public Agent type(Content content, CharSequence keys) {
		agent.type(content, keys);
		return agent;
	}

	public Agent clear(Content content) {
		agent.clear(content);	
		return agent;
	}

	public boolean verify(Content content) {
		return agent.verify(content);
	}

	public Agent select(Content content, String option) {
		agent.select(content, option);
		agent.capture(ImageOf.SCREEN);
		return agent;
	}

	public void quit() {
		agent.quit();
	}

	public Agent wait(Time time) {
		return agent.wait(time);
	}

	public String report(On on) {
		return agent.report(on);
	}

	public String capture(ImageOf imageOf) {
		return agent.capture(imageOf);
	}

	public String read(Content content) {
		return agent.read(content);
	}
}
