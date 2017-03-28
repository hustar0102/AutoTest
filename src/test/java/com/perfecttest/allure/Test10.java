package com.perfecttest.allure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.thit.hustar.util.TestCase;
import ru.yandex.qatools.allure.annotations.Title;
@Listeners({ AllureReporterListener.class })
public class Test10  extends TestCase{
	static WebDriver driver;
	    @Test
	    @Title("测试截图")
	    public void testInput(){
	        driver = DriverManager.getDriver();
			driver.get("http://192.168.8.144:9193");
			driver.findElement(By.id("loginname")).sendKeys("sysadmin");
			driver.findElement(By.id("loginpass2")).sendKeys("123");
			driver.findElement(By.xpath("//*[@id='btnLogin']/div")).click();
			driver.findElement(By.xpath("//*[@id='uie_menu_func']/a/span/span[1]")).click();
	    }  

}
