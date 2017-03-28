package com.thit.hustar.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * 用一个类扩展web driver自带的事件监听器，可以实现许多有趣的功能。 比如自动log a customer event listener
 */
public class LogEventListener implements WebDriverEventListener {
	private Log log = LogFactory.getLog(this.getClass());

	private By lastFindBy;
	private String originalValue;

	@Override
	public void beforeNavigateTo(String url, WebDriver selenium) {
		log.info("WebDriver navigating to:'" + url + "'");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver selenium) {
		lastFindBy = by;
	}


	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver selenium) {
		String locator = element.toString().split("-> ")[1];// 为了使log更短
		log.info("WebDriver clicking on:'" + locator.substring(0, locator.length() - 

1) + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver selenium) {
		originalValue = element.getAttribute("value");
	}

	public void afterChangeValueOf(WebElement element, WebDriver selenium) {
		try {
		log.info("WebDriver changing value in element found " + lastFindBy + " from '" + originalValue + "' to '"
				+ element.getAttribute("value") + "'");
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			// e.printStackTrace();
		}
	}
	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	// 这个以后要改掉。这段不是很好用
		public void onException(Throwable error, WebDriver selenium) {
			if (error.getClass().equals(NoSuchElementException.class)) {
				log.error("WebDriver error: Element not found " + lastFindBy);
			} else {
				log.error("WebDriver error:", error);
			}
		}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

}
