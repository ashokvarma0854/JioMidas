package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CalculatorPage;

public class CalculatorTests {
	
	private WebDriver driver;
    private CalculatorPage calculatorPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
        driver.get("http://localhost:3000/"); 
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.pause(1000);
    }

    @Test
    public void testBasicAddition()  {
    	calculatorPage.pause(1000);
        calculatorPage.clickButton("2");
        calculatorPage.clickButton("+");
        calculatorPage.clickButton("3");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "5");
    }

    @Test
    public void testHandlingDivisionByZero() {
    	 calculatorPage.pause(1000);
        calculatorPage.clickButton("5");
        calculatorPage.clickButton("/");
        calculatorPage.clickButton("0");
        calculatorPage.clickButton("=");       
        Assert.assertTrue(calculatorPage.getDisplayValue().contains("Invalid Expression"));
    }

    @Test
    public void testDecimalAddition() {
    	calculatorPage.pause(1000);
        calculatorPage.selectDecimal("1.25");
        calculatorPage.clickButton("+");
        calculatorPage.selectDecimal("3.75");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "5");
    }

    @Test
    public void testResultOutOfRange() {
    	calculatorPage.pause(1000);
        calculatorPage.selectDecimal("9999.99");
        calculatorPage.clickButton("+");
        calculatorPage.selectDecimal("0.01");
        calculatorPage.clickButton("=");
        Assert.assertTrue(calculatorPage.getDisplayValue().contains("Result out of range"));
    }

    @Test
    public void testClearFunctionality() {
    	calculatorPage.pause(1000);
        calculatorPage.clickButton1("12");
        calculatorPage.clickActionDisplay("AC");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "0");
    }
    
    @Test
    public void testDecimalSubtraction() {
    	calculatorPage.pause(1000);
        calculatorPage.selectDecimal("5.50");
        calculatorPage.clickButton("-");
        calculatorPage.selectDecimal("2.25");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "3.25");
    }
    @Test
    public void testDecimalMultiplication() {
    	calculatorPage.pause(1000);
        calculatorPage.selectDecimal("2.50");
        calculatorPage.clickButton("*");
        calculatorPage.selectDecimal("4.00");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "10");
    }
    @Test
    public void testDecimalDivision() {
    	calculatorPage.pause(1000);
        calculatorPage.selectDecimal("9.00");
        calculatorPage.clickButton("/");
        calculatorPage.selectDecimal("3.00");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "3");
    }
    public void testConsecutiveCalculations() {
    	calculatorPage.pause(1000);
        calculatorPage.selectDecimal("1.25");
        calculatorPage.clickButton("+");
        calculatorPage.selectDecimal("2.75");
        calculatorPage.clickButton("=");
        calculatorPage.clickButton("+");
        calculatorPage.selectDecimal("1.00");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "5");
    }
    @Test
    public void testSubtractionOperation() {
    	calculatorPage.pause(2000);
        calculatorPage.clickButton("7");
        calculatorPage.clickButton("-");
        calculatorPage.clickButton("4");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "3");
    }
    @Test
    public void testMultiplicationOperation() {
        calculatorPage.clickButton("6");
        calculatorPage.clickButton("*");
        calculatorPage.clickButton("3");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "18");
    }

    @Test
    public void testDecimalSubtractionNegativeResult() {
        calculatorPage.selectDecimal("1.00");
        calculatorPage.clickButton("-");
        calculatorPage.selectDecimal("2.50");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "-1.5");
    }
    @Test
    public void testDecimalAdditionLeadingZero() {
        calculatorPage.selectDecimal("0.75");
        calculatorPage.clickButton("+");
        calculatorPage.selectDecimal("0.25");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "1");
    }
    @Test
    public void testDecimalSubtractionLeadingZero() {
        calculatorPage.selectDecimal("0.80");
        calculatorPage.clickButton("-");
        calculatorPage.selectDecimal("0.55");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "0.25");
    }
    @Test
    public void testDecimalMultiplicationLeadingZero() {
        calculatorPage.selectDecimal("0.40");
        calculatorPage.clickButton("*");
        calculatorPage.selectDecimal("0.25");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "0.1");
    }
    @Test
    public void testDecimalDivisionLeadingZero() {
        calculatorPage.selectDecimal("0.90");
        calculatorPage.clickButton("/");
        calculatorPage.selectDecimal("0.30");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "3");
    }
    @Test
    public void testBasicDivision() {
        calculatorPage.clickButton("8");
        calculatorPage.clickButton("/");
        calculatorPage.clickButton("2");
        calculatorPage.clickButton("=");
        Assert.assertEquals(calculatorPage.getDisplayValue(), "4");
    }
    

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
	

}
