package com.thit.hustar.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Global_Function extends TestCase {

	static WebDriver driver;

	/**
	 * 打开浏览器
	 * 
	 * @return
	 * @date 2016-07-28
	 */
	public Global_Function openPage() {
		driver = DriverManager.getDriver();
		DriverManager.getDriver().get("http://192.168.8.144:9193");
//		DriverManager.getDriver().get("http://192.168.9.123:9193");
//		DriverManager.getDriver().get("http://192.168.8.66:9193");
		return this;
	}


	/**
	 * 刷新
	 */
	public void refresh() {
		driver.navigate().refresh();
	}

	/**
	 * js操作datebox
	 * 
	 * @param id
	 *            定位的id
	 * @param t
	 *            0为当前时间 1为当前时间加一天
	 * @param adate
	 *            为空时走if 不为空时 格式为yyyy-MM-dd
	 */
	public void inputDateBox(String id, int t, String adate) {
		if (adate.equals("")) {
			Date date = new Date();// 取时间
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, t);// 把日期往后增加一天.整数往后推,负数往前移动
			date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(date);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("$('#" + id + "').datebox('setValue', '" + dateString + "')");
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("$('#" + id + "').datebox('setValue', '" + adate + "')");
		}
	}

	/**
	 * js操作dateTimebox
	 * 
	 * @param id
	 *            定位的id
	 * @param t
	 *            0为当前时间 1为当前时间加一天
	 * @param adate
	 *            adate 为空时走if 不为空时 格式为yyyy-MM-dd HH:mm:ss
	 */
	public void inputDateTimeBox(String id, int t, String adate) {
		if (adate.equals("")) {
			Date date = new Date();// 取时间
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, t);// 把日期往后增加一天.整数往后推,负数往前移动
			date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(date);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("$('#" + id + "').datetimebox('setValue', '" + dateString + "')");
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("$('#" + id + "').datetimebox('setValue', '" + adate + "')");
		}
	}
	/**
	 * js操作Combobox
	 * @param id	通过id定位
	 * @param selectName	需要选择的选项
	 */
	public void intputCombobox(String id, String selectName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("$('#" + id + "').combobox('setValue','" + selectName + "')");
	}

	/**
	 * alert 点击确认
	 */
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * alert 点击退出、取消
	 */
	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * 获取alert上的值
	 * 
	 * @return
	 */
	public String getTextAlert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	/**
	 * 只弹出一个窗口时，不需要传任何参数，直接切换到下一窗口
	 * 
	 * @date 2016-8-8
	 */
	public void switchToWindow() {
		// 获取当前窗口
		String currentWindow = driver.getWindowHandle();
		// 得到所有窗口
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle))
				continue;
			WebDriver window = driver.switchTo().window(handle);
			log.info("title:=" + window.getTitle() + "url:=" + window.getCurrentUrl());

		}
	}

	/**
	 * 判断一个元素是否存在
	 * 
	 * @param by
	 * @date 2016-8-8
	 */
	public boolean isElementExist(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
/**
 * 判断元素不存在，
 * @param driver
 * @param locator
 * @return false 不存在，  true：存在
 */
	public boolean isElementExsit(WebDriver driver, By locator) {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			flag = null != element;
		} catch (NoSuchElementException e) {
			System.out.println("Element:" + locator.toString() + " is not exsit!");
		}
		return flag;
	}




	/**
	 * 判断指定窗口存在--遍历最多10次，找到为止，适用于多个弹框的情况，传入指定窗口的title
	 * 
	 * @param windowTtitle:指定窗口的title
	 * @return
	 * @date 2016-8-8
	 */
	public boolean switchToWindow2(String windowTtitle) {
		boolean flag = false;
		for (int a = 0; a < 9; a++) {

			Set<String> windowHandles = driver.getWindowHandles();
			for (String handler : windowHandles) {
				driver.switchTo().window(handler);
				String title = driver.getTitle();
				if (windowTtitle.equals(title)) {
					a = 10;
					flag = true;
					break;
				}
			}

		}
		return flag;
	}

	/**
	 * 右键点击
	 */

	// Actions action=new Actions(driver);
	// action.contextClick(driver.findElement(By.xpath("//*[@class='tree-title'
	// and text()='"+Project_name+"']"))).build().perform();

}
