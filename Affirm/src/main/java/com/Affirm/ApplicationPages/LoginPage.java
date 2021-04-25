package com.Affirm.ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uioperation.UIOperation;
import utils.WebDriverInitialization;

public class LoginPage extends WebDriverInitialization {
	/* This class is used to login Affirm application*/

	public String excelfield = "";
	public String temp = "";
	public static WebDriver driver;

	public LoginPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	@FindBy(xpath = "//input[@id=\"UserName\"]")
	public static WebElement username;
	@FindBy(xpath = "//input[@id=\"Password\"]")
	public static WebElement password;
	@FindBy(xpath = "//input[@id=\"BtnLogin\"]")
	public static WebElement login;
	@FindBy(xpath = "//a[@id=\"ctl08_ctl02_Repeater2_ctl02_MenuLinkText\"]")
	public static WebElement OrderEntryDashboard;
	@FindBy(xpath = "//input[@value=\"Enter New Business\"]")
	public static WebElement EnterNewBusiness;

	public void execute() throws Exception {
		System.out.println("Affirm Login page started");
		try {
			WebDriverInitialization.uiopt.sendKeys(prop.getProperty("username"), username, "User_Name");
			WebDriverInitialization.uiopt.sendKeys(prop.getProperty("password"), password, "Password");
			WebDriverInitialization.uiopt.click(login);
			WebDriverInitialization.uiopt.clickByJavaScript(OrderEntryDashboard);
			WebDriverInitialization.uiopt.clickByJavaScript(EnterNewBusiness);

		} catch (Exception e) {
			System.out.println("Please check your data entry. There is some error in LoginPage -->>" + e.getMessage());
		}
	}

}
