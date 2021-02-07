package com.Affirm.ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CustomWait;
import utils.ExcelSheetOperation;
import utils.WebDriverInitialization;

public class FeatureDetails extends WebDriverInitialization {

	WebDriver driver;
	public String excelfield = "";
	public String temp = "";

	public FeatureDetails(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	@FindBy(xpath = "//input[@value='Next >>' and @class='NEXTButton' and @title='Go to Next Section']")
	public static WebElement next_btn;
	@FindBy(xpath = "//td[text()='Model: Protected Benefit Account Investment Options']//preceding-sibling::*/input")
	public static WebElement prot_allocation;
	@FindBy(xpath = "//td[text()='Model: Investment Account Investment Options']//preceding-sibling::*/input")
	public static WebElement perf_allocation;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl05_ctl01_FreqOfPaymentDD']")
	public static WebElement RB_freq;

	public void execute() throws Exception {
		System.out.println("Affirm Features Details page started");

		try {

			excelfield = "Prot_Allocation";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "FeatureDetails");
			if (temp.equalsIgnoreCase("Yes")) {
				WebDriverInitialization.uiopt.clickByJavaScript(prot_allocation);

			}
			excelfield = "Perf_Allocation";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "FeatureDetails");
			if (temp.equalsIgnoreCase("Yes")) {
				WebDriverInitialization.uiopt.clickByJavaScript(perf_allocation);

			}
			excelfield = "RB_Frequency";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "FeatureDetails");
			if (temp.equalsIgnoreCase("None")) {}
				
			else {WebDriverInitialization.uiopt.dropdown(temp, RB_freq, excelfield);}

			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
			System.out.println("Features Details page completed");
		} catch (Exception e) {
			System.out.println("Please check your data entry-->>" + e.getMessage());
		}

	}

}
