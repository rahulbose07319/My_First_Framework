package com.Affirm.ApplicationPages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CustomWait;
import utils.FileHandling;
import utils.WebDriverInitialization;

public class Summary extends WebDriverInitialization{
	
	WebDriver driver;
	public String excelfield = "";
	public String temp = "";
	public File file= null;

	public Summary(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	@FindBy(xpath = "//input[@value='Next >>' and @class='NEXTButton' and @title='Go to Next Section']")
	public static WebElement next_btn;
	@FindBy(xpath = "//input[@value='View Summary as PDF']")
	public static WebElement order_summary_report;
	@FindBy(xpath = "//input[@value='Render Forms']")
	public static WebElement render_form;
	@FindBy(xpath = "//span[@class='ui-button-text' and text()='OK']")
	public static WebElement msg;
	@FindBy(xpath = "//input[@value='Submit']")
	public static WebElement submit;
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-closethick' and text()='close']")
	public static WebElement submit_confirmation;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl02_ctl02_ViewSelectedForms']")
	public static WebElement view_selected;
	
	
	public void execute() throws Exception {
		System.out.println("Order Summary Page");

		try {
			
			
			WebDriverInitialization.uiopt.click(order_summary_report);
			Thread.sleep(2000);
			WebDriverInitialization.uiopt.click(render_form);
			WebDriverInitialization.uiopt.click(msg);
			new CustomWait(driver).waitForPageLoad(); 
			WebDriverInitialization.uiopt.click(submit);
			WebDriverInitialization.uiopt.click(msg);
			new CustomWait(driver).waitForPageLoad();
			WebDriverInitialization.uiopt.click(submit_confirmation);
			Thread.sleep(2000);
			WebDriverInitialization.uiopt.clickByJavaScript(view_selected);
			//WebDriverInitialization.uiopt.click(view_selected);
			Thread.sleep(4000);
			new FileHandling();
			
			
			
		}catch(Exception e) {
			System.out.println("File is not downloaded sucessfully. Please check the error -->>" +e.getMessage());
		}
		}

}
