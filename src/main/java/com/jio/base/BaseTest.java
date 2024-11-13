package com.jio.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;





public class BaseTest {
	public WebDriver driver;
	
	
 
    public void setUp() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-debugging-port=9222");
        driver = new ChromeDriver(options);  
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(4));
        driver.get("https://www.facebook.com/");
    }

   
    public void tearDown() {
        if (driver != null) {
            driver.quit();  
            driver = null;  
        }
    }
}
