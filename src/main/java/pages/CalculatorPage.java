package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {
	private WebDriver driver;  
    private By display = By.xpath("//div[@class='display hide-scrollbar']");
    private By actionButton(String value) {
        return By.xpath("//button[@class='button actions' and text()='" + value + "']");
    }
    private By button(String value) {
        return By.xpath("//button[text()='" + value + "']");
    }

    
    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDecimal(String value) {
    	for (char c : value.toCharArray()) {
            if (Character.isDigit(c)) {
                WebElement digitButton = driver.findElement(button(String.valueOf(c)));
                pause(1000);
                digitButton.click();
            } else if (c == '.') {
                WebElement dotButton = driver.findElement(button(String.valueOf(c)));
                pause(1000);
                dotButton.click();
            }
        }
    	
    }
    public void clickButton(String value) {
      			
        WebElement button = driver.findElement(button(value));
        button.click();
    		
    }
    public void clickButton1(String value) {
    	if(value.length()>=1) {
    		for (char c : value.toCharArray()) {
                if (Character.isDigit(c)) {
                    WebElement digitButton = driver.findElement(button(String.valueOf(c)));
                    pause(1000);
                    digitButton.click();
                }
    	}}
    		else {
    			
        WebElement button = driver.findElement(button(value));
        pause(1000);
        button.click();
    		}
    }

    
    public void pause(int milliSeconds) {
    	try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
    }
    public String getDisplayValue() {
        return driver.findElement(display).getText();
    }
    public void clickActionDisplay(String value) {
      WebElement ACButton= driver.findElement(actionButton(value));
      pause(1000);
      ACButton.click();
    }
    
}
