package com.xmenus.commons.test.olivebranch.agents;

import com.google.common.base.Function;
import com.xmenus.commons.test.olivebranch.agents.UserAgent;
import com.xmenus.commons.test.olivebranch.queries.XPathQuery;
import com.xmenus.commons.test.olivebranch.time.Accordingly;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public final class PhantomJsAgent implements UserAgent {
	
	private final WebDriver webDriver;
	
	private String rootUrl;
        private String[] phantomjsArgs;
        
    public PhantomJsAgent(final String host){
    	this();
    	rootUrl=host;
    }

	public PhantomJsAgent() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        phantomjsArgs = new String[]{"--webdriver-logfile=target/phantomjsdriver.log", "--webdriver-loglevel=INFO" };
	desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomjsArgs);
        webDriver = new PhantomJSDriver(desiredCapabilities);
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		webDriver.manage().window().setSize(new Dimension(1024, 768));
	}

	public UserAgent goTo(String path) {
		webDriver.get(rootUrl + "/" + path);
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
	
	public UserAgent takeScreenShot() {
		
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		
		String directory = "target/screenshots/screenshot-"+ new Date().getTime();
		
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File(directory +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		savePageSource(directory);
		return this;
	}
	
	private UserAgent savePageSource(String directory) {
		try {
			FileUtils.writeStringToFile(new File(directory +".html"), webDriver.getPageSource());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	private WebElement findElement(final XPathQuery query, Accordingly... actionDelay) {
		takeScreenShot();
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
	
	private WebElement fluentWait(final By locator) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
	            .withTimeout(30, TimeUnit.SECONDS)
	            .pollingEvery(5, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);

	    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(locator);
	        }
	    });

	    return  foo;
	}

	public UserAgent startAt(String rootUrl) {
		this.rootUrl = rootUrl;
		webDriver.get(rootUrl);
		return this;
	};

    public void quit() {
    	webDriver.quit();
    };
}
