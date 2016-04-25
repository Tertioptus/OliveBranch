package com.olivebranch.driver;

import com.olivebranch.*;

public final class LoggingAgent implements Agent<String> {
	
	private Agent<String> agent;
	
	public LoggingAgent(Agent<String> agent) {
		this.agent = agent;
	}

	public Agent<String> goTo(String url) {
		agent.goTo(url);
		return agent;
	}

	public Agent<String> click(Content<String> content) {
		agent.capture(ImageOf.SCREEN);
		agent.click(content);
		return agent;
	}

	public Agent<String> typeInto(Content<String> content, Input input) {
		agent.capture(ImageOf.SCREEN);
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
		agent.capture(ImageOf.SCREEN);
		agent.selectFrom(content, option);
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

	@Override
	public String noteFor(String key) {
		return agent.noteFor(key);
	}

	@Override
	public Note note(Input input) {
		return agent.note(input);
	}

	@Override
	public Note note(Content<String> content) {
		return agent.note(content);
	}
}
