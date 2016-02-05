package com.xmenus.commons.test.olivebranch.agents;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.xmenus.commons.test.olivebranch.queries.XPathQuery;
import com.xmenus.commons.test.olivebranch.time.Accordingly;

public class WebDriverAgent implements UserAgent {
	
	protected final WebDriver webDriver;
	
	public WebDriverAgent(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public UserAgent goTo(String url) {
		webDriver.get(url);
		return this;
	}

	public UserAgent click(XPathQuery query, Accordingly... actionDelay) {
		findElement(query, actionDelay).click();
		return this;
	}

	public String report(XPathQuery query, Accordingly... actionDelay) {
		return findElement(query, actionDelay).getText();
	}

	public UserAgent type(XPathQuery query, CharSequence keys, Accordingly... actionDelay) {
		WebElement element = findElement(query, actionDelay);
		element.sendKeys(keys);
		return this;
	}

	public UserAgent clear(XPathQuery query, Accordingly... actionDelay) {
		findElement(query, actionDelay).clear();
		return this;
	}

	public boolean verify(XPathQuery query, Accordingly... actionDelay) {
		return findElement(query, actionDelay) != null;
	}

	public UserAgent submit(XPathQuery query, Accordingly... actionDelay) {
		findElement(query, actionDelay).submit();
		return this;
	}

	public String currentUrl(Accordingly... actionDelay) {
		return webDriver.getCurrentUrl();
	}

	public UserAgent select(XPathQuery query, String option, Accordingly... actionDelay) {

        Select clickThis = new Select(findElement(query, actionDelay));
        
        clickThis.selectByVisibleText(option);
        
    	return this;
	}
	
	protected WebElement findElement(final XPathQuery query, Accordingly... actionDelay) {
		if(actionDelay.length == 0)
			try {
				webDriver.wait(actionDelay[0].getMilliseconds()/1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		return webDriver.findElement(By.xpath(query.toString()));
	}

	public UserAgent takeScreenShot() {

		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		
		String directory = "target/screenshots/screenshot-"+ new Date().getTime();
		
		try {
			FileUtils.copyFile(scrFile, new File(directory +".png"));
			FileUtils.writeStringToFile(new File(directory +".html"), webDriver.getPageSource());
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return this;
	}

	public UserAgent startAt(String string) {
			return this;
		
	}

	public void  quit() {
		webDriver.quit();
	}
}
