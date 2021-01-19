package com.Affirm.ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CustomWait;
import utils.ExcelSheetOperation;
import utils.WebDriverInitialization;

public class FinancialAdvisor extends WebDriverInitialization {

	WebDriver driver;
	public String excelfield = "";
	public String temp = "";

	public FinancialAdvisor(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	@FindBy(xpath = "//input[@id=\"ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_DataGrid1_ctl02_sb0x0\"]")
	public static WebElement Advisor_Id;
	@FindBy(xpath = "//input[@id=\"ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_DataGrid1_ctl02_sb0x1\"]")
	public static WebElement Advisor_Fname;
	@FindBy(xpath = "//input[@id=\"ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_DataGrid1_ctl02_sb0x3\"]")
	public static WebElement Advisor_Lname;
	@FindBy(xpath = "//input[@id=\"ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_DataGrid1_ctl02_sb0x4\"]")
	public static WebElement Advisor_SSN;
	@FindBy(xpath = "//input[@id=\"ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_DataGrid1_ctl02_sb0x8\"]")
	public static WebElement Advisor_percentage;
	@FindBy(xpath = "//input[@type='submit' and @value='Next >>' and @title='Go to Next Section']")
	public static WebElement nextbtn;

	public void execute() throws Exception {
		System.out.println("Affirm Financial Advisor page started");
		try {
			excelfield = "Rep_ID";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Financial_Advisor");
			WebDriverInitialization.uiopt.sendKeys(temp, Advisor_Id, excelfield);

			excelfield = "Advisor_FNAME";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Financial_Advisor");
			WebDriverInitialization.uiopt.sendKeys(temp, Advisor_Fname, excelfield);

			excelfield = "Advisor_LNAME";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Financial_Advisor");
			WebDriverInitialization.uiopt.sendKeys(temp, Advisor_Lname, excelfield);

			excelfield = "Advisor_SSN";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Financial_Advisor");
			WebDriverInitialization.uiopt.sendKeys(temp, Advisor_SSN, excelfield);

			excelfield = "Commission";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Financial_Advisor");
			WebDriverInitialization.uiopt.sendKeys(temp, Advisor_percentage, excelfield);

			WebDriverInitialization.uiopt.clickByJavaScript(nextbtn);
			new CustomWait(driver).waitForPageLoad();
			System.out.println("Financial Advisor page completed");

		} catch (Exception e) {
			System.out.println("Please check your data entry -->>" + e.getMessage());
		}

	}

}
