package com.xmenus.commons.test.olivebranch.agents;

import com.xmenus.commons.test.olivebranch.queries.XPathQuery;
import com.xmenus.commons.test.olivebranch.time.Accordingly;

public class LoggingUserAgent implements UserAgent {
	
	private UserAgent agent;
	
	public LoggingUserAgent(UserAgent agent) {
		this.agent = agent;
	}

	public UserAgent goTo(String url) {
		agent.goTo(url);
		agent.takeScreenShot();
		return agent;
	}

	public UserAgent click(XPathQuery query, Accordingly... actionDelay) {
		agent.click(query, actionDelay);
		agent.takeScreenShot();
		return agent;
	}

	public String report(XPathQuery query, Accordingly... actionDelay) {
		return agent.report(query, actionDelay);
	}

	public UserAgent type(XPathQuery query, CharSequence keys, Accordingly... actionDelay) {
		agent.type(query, keys, actionDelay);
		return agent;
	}

	public UserAgent clear(XPathQuery query, Accordingly... actionDelay) {
		agent.clear(query, actionDelay);	
		return agent;
	}

	public boolean verify(XPathQuery query, Accordingly... actionDelay) {
		return agent.verify(query, actionDelay);
	}

	public UserAgent submit(XPathQuery query, Accordingly... actionDelay) {
		agent.submit(query, actionDelay);
		agent.takeScreenShot();
		return agent;
	}

	public String currentUrl(Accordingly... actionDelay) {
		return agent.currentUrl(actionDelay);
	}

	public UserAgent select(XPathQuery query, String option, Accordingly... actionDelay) {
		agent.select(query, option, actionDelay);
		agent.takeScreenShot();
		return agent;
	}

	public UserAgent takeScreenShot() {
		agent.takeScreenShot();
		return agent;
	}

	public UserAgent startAt(String string) {
		return agent;
		
	}

	public void quit() {
		agent.quit();
	}
}
