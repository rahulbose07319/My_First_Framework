package uioperation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CustomWait;

public class UIOperation {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	
	public UIOperation(WebDriver driver) {
		this.driver=driver;
	}
	
	public void sendKeys(String fieldvalue, WebElement element, String fieldname) {
		if(fieldvalue != null) {
			new CustomWait(driver).explicitWait(element);
			element.clear();
			element.sendKeys(fieldvalue + Keys.TAB);
			System.out.println(fieldname+ ":" +fieldvalue);
		}
	}
	
	public  void dropdown(String fieldvalue, WebElement element, String fieldname) {
		if(fieldvalue != null) {
			new CustomWait(driver).waitForPageLoad();
			Select dropdown= new Select(element);
			dropdown.selectByVisibleText(fieldvalue);
			System.out.println(fieldname+ ":" +fieldvalue);
		}
	}
	
	public  void click(WebElement element) {
		
			new CustomWait(driver).elementisVisible(element);
			element.click();
			System.out.println("Button clicked");
		
	}
	
	public void clickByJavaScript(WebElement element) {
		new CustomWait(driver).staticWait(10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

}
