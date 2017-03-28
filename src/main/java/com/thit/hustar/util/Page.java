package com.thit.hustar.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.thit.hustar.util.TestCase.DriverManager;


public class Page {
	protected WebDriver driver;
	protected JavascriptExecutor js;
	public Page( WebDriver driver){
		/**
		 * 构造方法，被所有Page的子类继承，所以每个页面都可以通过自动调用这个方法来初始化页面对象 
		 */
		this.driver=driver;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(DriverManager.getDriver(),this);
	}

}
