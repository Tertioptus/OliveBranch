package com.olivebranch.driver;

import com.olivebranch.*;

public final class LoggingAgent implements Agent<String> {
	
	private Agent<String> agent;
	
	public LoggingAgent(Agent<String> agent) {
		this.agent = agent;
	}

	public Agent<String> goTo(String url) {
		agent.goTo(url);
		agent.capture(ImageOf.SCREEN);
		return agent;
	}

	public Agent<String> click(Content<String> content) {
		agent.click(content);
		agent.capture(ImageOf.SCREEN);
		return agent;
	}

	public Agent<String> typeInto(Content<String> content, Input input) {
		agent.typeInto(content, input);
		return agent;
	}

	public Agent<String> clear(Content<String> content) {
		agent.clear(content);	
		return agent;
	}

	public boolean verify(Content<String> content) {
		return agent.verify(content);
	}

	public Agent<String> selectFrom(Content<String> content, String option) {
		agent.selectFrom(content, option);
		agent.capture(ImageOf.SCREEN);
		return agent;
	}

	public void quit() {
		agent.quit();
	}

	public Agent<String> wait(Time time) {
		return agent.wait(time);
	}

	public String report(On on) {
		return agent.report(on);
	}

	public String capture(ImageOf imageOf) {
		return agent.capture(imageOf);
	}

	public String read(Content<String> content) {
		return agent.read(content);
	}
}
