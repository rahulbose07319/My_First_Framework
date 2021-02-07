package com.Affirm.ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CustomWait;
import utils.WebDriverInitialization;

public class Suitability extends WebDriverInitialization{
	
	WebDriver driver;
	public String excelfield = "";
	public String temp = "";

	public Suitability(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}
	
	@FindBy(xpath = "//input[@value='Next >>' and @class='NEXTButton' and @title='Go to Next Section']")
	public static WebElement next_btn;
	
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl04_ctl01_sb0x0_0']")
	public static WebElement tax_deferal;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl04_ctl01_sb0x1']")
	public static WebElement years;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl04_ctl01_sb0x3']")
	public static WebElement total_investment;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl04_ctl01_sb0x4_0']")
	public static WebElement bonus_annuity;
	

	public void execute() throws Exception {
		System.out.println("Affirm Suitability page started");

		try {
			System.out.println("On the Suitability page");
			//Thread.sleep(2000);
			WebDriverInitialization.uiopt.clickByJavaScript(tax_deferal);
			years.sendKeys("5");
			total_investment.sendKeys("25000");
			WebDriverInitialization.uiopt.clickByJavaScript(bonus_annuity);
			Thread.sleep(2000);
			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
		}catch(Exception e) {
			System.out.println("Receiving error in Suitability Page-->>" + e.getMessage());
		}
		
		}

}
