package com.olivebranch.driver;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.olivebranch.Agent;
import com.olivebranch.Content;
import com.olivebranch.ImageOf;
import com.olivebranch.On;
import com.olivebranch.Time;

public final class PhantomJsAgent implements Agent {

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
		webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		webDriver.manage().window().setSize(new Dimension(1024, 768));
	}

	public Agent goTo(String path) {
		webDriver.get(rootUrl + "/" + path);
		return this;
	}

	public Agent click(Content content) {
		findElement(content).click();
		return this;
	}

	public Agent type(Content content, CharSequence keys) {
		WebElement element = findElement(content);
		element.sendKeys(keys);
		return this;
	}

	public Agent clear(Content content) {
		findElement(content).clear();
		return this;
	}

	public boolean verify(Content content) {
		return findElement(content) != null;
	}

	public Agent select(Content content, String option) {

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

	private WebElement findElement(final Content content) {
		takeScreenShot();

		WebDriverWait wait = new WebDriverWait(webDriver, 30l, 2l);
		wait.ignoring(NoSuchElementException.class);

		return wait.until(new ExpectedCondition<WebElement>() {

			public WebElement apply(WebDriver webDriver) {

				WebElement elementTesting = null;

				try {

					elementTesting = webDriver.findElement(By.xpath(content.toString()));

				} catch (StaleElementReferenceException exception) {
					elementTesting = null;
				}

				return elementTesting;
			}
		});
	}

	public void quit() {
		webDriver.quit();
	}

	public Agent wait(Time time) {
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

	public String read(Content content) {
		return findElement(content).getText();
	};
}
