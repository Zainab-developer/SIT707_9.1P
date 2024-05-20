package web.service;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;


public class FunctionalTest {
private WebDriver driver;
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testLoginSuccess() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\\\chromedriver-win64\\\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("http://localhost:8080/login");

		sleep(5);
		
		
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("ahsan");
		
		
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("ahsan_pass");
		
		
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		Assert.assertEquals("http://localhost:8080/q1", driver.getCurrentUrl());
	}
	
	@Test
    public void testQ1AdditionValid() {

		testLoginSuccess();
        driver.get("http://localhost:8080/q1");

        WebElement firstNumberInput = driver.findElement(By.name("number1"));
        WebElement secondNumberInput = driver.findElement(By.name("number2"));
        WebElement resultInput = driver.findElement(By.name("result"));
        
        firstNumberInput.sendKeys("15");
        secondNumberInput.sendKeys("4");
        resultInput.sendKeys("19");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        
        Assert.assertEquals("http://localhost:8080/q2", driver.getCurrentUrl());
	}
	
	@Test
	public void testQ2SubstractionValid() {
	    testQ1AdditionValid(); 
	    driver.get("http://localhost:8080/q2");
	    
	    WebElement firstNumberInput = driver.findElement(By.name("number1"));
	    WebElement secondNumberInput = driver.findElement(By.name("number2"));
	    WebElement resultInput = driver.findElement(By.name("result"));
	    
	    firstNumberInput.sendKeys("39");
	    secondNumberInput.sendKeys("20");
	    resultInput.sendKeys("19");

	    WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
	    submitButton.click();
	    
	    sleep(5);
	    Assert.assertEquals("http://localhost:8080/q3", driver.getCurrentUrl());
	    
	    driver.close(); 
	}

	
	@Test
    public void testQ1AdditionInvalid() {
        testLoginSuccess();
        driver.get("http://localhost:8080/q1");

        WebElement firstNumberInput = driver.findElement(By.name("number1"));
        WebElement secondNumberInput = driver.findElement(By.name("number2"));
        WebElement resultInput = driver.findElement(By.name("result"));
        
        firstNumberInput.sendKeys("invalid");
        secondNumberInput.sendKeys("4");
        resultInput.sendKeys("19");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        
        sleep(5);
        Assert.assertEquals("http://localhost:8080/q1", driver.getCurrentUrl());
    }

    @Test
    public void testQ2SubtractionInvalid() {
        testLoginSuccess();
        driver.get("http://localhost:8080/q2");

        WebElement firstNumberInput = driver.findElement(By.name("number1"));
        WebElement secondNumberInput = driver.findElement(By.name("number2"));
        WebElement resultInput = driver.findElement(By.name("result"));
        
        firstNumberInput.sendKeys("invalid");
        secondNumberInput.sendKeys("20");
        resultInput.sendKeys("19");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        
        sleep(5);
        Assert.assertEquals("http://localhost:8080/q2", driver.getCurrentUrl());
    }
    @Test
    public void testQ1AdditionEmptyFields() {
        testLoginSuccess();
        driver.get("http://localhost:8080/q1");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        
        sleep(5);
        Assert.assertEquals("http://localhost:8080/q1", driver.getCurrentUrl());
    }

    @Test
    public void testQ2SubtractionEmptyFields() {
        testLoginSuccess();
        driver.get("http://localhost:8080/q2");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        
        sleep(5);
        Assert.assertEquals("http://localhost:8080/q2", driver.getCurrentUrl());
    }


}
