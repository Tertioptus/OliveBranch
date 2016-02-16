package com.olivebranch.driver;

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

import com.olivebranch.Agent;
import com.olivebranch.Content;
import com.olivebranch.ImageOf;
import com.olivebranch.On;
import com.olivebranch.Time;

public class WebDriverAgent implements Agent<String> {

	private final String host;
	
	protected final WebDriver webDriver;
	
	public WebDriverAgent(final WebDriver webDriver, final String host) {
		this.webDriver = webDriver;
		this.host = host;
		webDriver.get(host);
	}

	public Agent<String> goTo(String url) {
		webDriver.get(host + "/" + url);
		return this;
	}

	public Agent<String> click(Content<String> content) {
		findElement(content).click();
		return this;
	}

	public String read(Content<String> content) {
		return findElement(content).getText();
	}

	public Agent<String> type(Content<String> content, CharSequence keys) {
		WebElement element = findElement(content);
		element.sendKeys(keys);
		return this;
	}

	public Agent<String> clear(Content<String> content) {
		findElement(content).clear();
		return this;
	}

	public boolean verify(Content<String> content) {
		return findElement(content) != null;
	}

	public Agent<String> submit(Content<String> content) {
		findElement(content).submit();
		return this;
	}

	public Agent<String> select(Content<String> content, String option) {

        Select clickThis = new Select(findElement(content));
        
        clickThis.selectByVisibleText(option);
        
    	return this;
	}
	
	protected WebElement findElement(final Content<String> content) {
			
		return webDriver.findElement(By.xpath(content.toString()));
	}

	private String takeScreenShot() {

		File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

		String directory = "target/screenshots/screenshot-" + new Date().getTime();

		String filePath = directory + ".png";
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	private String savePageSource() {
		String directory = "target/screenshots/screenshot-" + new Date().getTime();
		String filePath = directory + ".html";
		try {
			FileUtils.writeStringToFile(new File(directory + ".html"), webDriver.getPageSource());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	public void  quit() {
		webDriver.quit();
	}

	public Agent<String> wait(Time time) {
		try {
			Thread.sleep(time.milliseconds());
		} catch (InterruptedException e) {
			// TODO Log error
		}
		return this;
	}

	public String report(On on) {
		String message = null;
		switch (on) {
		case HOST:
			message = host;
			break;
		case LOCATION:
			message = webDriver.getCurrentUrl();
			break;
		case TITLE:
			message = webDriver.getTitle();
		}
		return message;
	}

	public String capture(ImageOf imageOf) {
		String path = null;
		switch (imageOf) {
		case SCREEN:
			path = takeScreenShot();
			break;
		case MARKUP:
			path = savePageSource();
			break;
		}
		return path;
	}
}
