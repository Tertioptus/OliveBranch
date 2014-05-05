package com.xmenus.commons.test.olivebranch.agents;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xmenus.commons.test.olivebranch.queries.XPathQuery;
import com.xmenus.commons.test.olivebranch.time.Accordingly;

public class ResponseWaitingAgent extends WebDriverAgent implements UserAgent {

	public ResponseWaitingAgent(WebDriver webDriver) {
		super(webDriver);
	}

	@Override
	protected WebElement findElement(final XPathQuery query, Accordingly... actionDelay) {

		if(actionDelay.length == 0)
			return webDriver.findElement(By.xpath(query.toString()));
		
		WebDriverWait wait = new WebDriverWait(webDriver, actionDelay[0].getMilliseconds()/1000);
		wait.withTimeout(30, TimeUnit.SECONDS);
        wait.pollingEvery(2, TimeUnit.SECONDS);
        wait.ignoring(NoSuchElementException.class);
        
        return wait.until(new ExpectedCondition<WebElement>() {

                    public WebElement apply(WebDriver webDriver) {

                        WebElement elementTesting = null;

                        try {
                        	
                        	elementTesting = webDriver.findElement(By.xpath(query.toString()));

                        } catch(StaleElementReferenceException exception) {
                            elementTesting = null;
                        }

                        return elementTesting;
                    }
                });
	}
}
