package com.olivebranch.driver;

import com.olivebranch.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public final class PhantomJsAgent implements Agent<String> {

	private final WebDriver webDriver;

	private String rootUrl;
	private String[] phantomjsArgs;

	public PhantomJsAgent(final String host) {
		this();
		rootUrl = host;
	}

	public PhantomJsAgent() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		phantomjsArgs = new String[] { "--webdriver-logfile=target/phantomjsdriver.log", "--webdriver-loglevel=INFO" };
		desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomjsArgs);
		webDriver = new PhantomJSDriver(desiredCapabilities);
		webDriver.manage().window().setSize(new Dimension(1024, 768));
	}

	public Agent<String> goTo(String path) {
		webDriver.get(rootUrl + "/" + path);
		return this;
	}

	public Agent<String> click(Content<String> content) {
		findElement(content).click();
		return this;
	}

	public Agent<String> typeInto(Content<String> content, Input input) {
		WebElement element = findElement(content);
		element.sendKeys(input.value());
		return this;
	}

	public Agent<String> clear(Content<String> content) {
		findElement(content).clear();
		return this;
	}

	public boolean verify(Content<String> content) {
		boolean isPresent=false;
		try {
			isPresent=findElement(content) != null;
		} catch (Exception e) {
			isPresent = false;
		}
		return isPresent;
	}

	public Agent<String> selectFrom(Content<String> content, String option) {

		Select clickThis = new Select(findElement(content));

		clickThis.selectByVisibleText(option);
		return this;
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

	private WebElement findElement(final Content<String> content) {

		return webDriver.findElement(By.xpath(content.toString()));
	}

	public void quit() {
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
			message = rootUrl;
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

	public String read(Content<String> content) {
		return findElement(content).getText();
	};
}
