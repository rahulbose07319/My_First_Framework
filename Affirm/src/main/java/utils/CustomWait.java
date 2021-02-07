package utils;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
	
	WebDriver driver;
	public static int default_wait_time= 20;
	public static int product_load_time= 30;
	
	public CustomWait(WebDriver driver) {
		this.driver=driver;
	}
	
	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,default_wait_time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
//	public void implicitWait(WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver,default_wait_time);
//		try {
//			wait.wait(default_wait_time);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void elementisVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,product_load_time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public Boolean alertMsgToBeClickable(By msg) {
		WebDriverWait wait = new WebDriverWait(driver,default_wait_time);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(msg));
			return true;
		}catch(Exception e) {
			System.out.println("Element is disabled");
			return false;
			
		}
		
	}
	
	public void waitForPageLoad() {
		//copied from stackoverflow
		try {
			 WebDriverWait wait = new WebDriverWait(driver, 30);

			    wait.until(new ExpectedCondition<Boolean>() {
			        public Boolean apply(WebDriver wdriver) {
			            return ((JavascriptExecutor) driver).executeScript(
			                "return document.readyState"
			            ).equals("complete");
			        }
			    });
			
		}catch(Exception e) {
			staticWait(10);
		}
	}
	public void staticWait(int waitTime) {
		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
