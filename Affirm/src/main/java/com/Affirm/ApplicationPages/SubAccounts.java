package com.Affirm.ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CustomWait;
import utils.ExcelSheetOperation;
import utils.WebDriverInitialization;

public class SubAccounts extends WebDriverInitialization {

	WebDriver driver;
	public String excelfield = "";
	public String temp = "";

	public SubAccounts(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	@FindBy(xpath = "//input[@value='Next >>' and @class='NEXTButton' and @title='Go to Next Section']")
	public static WebElement next_btn;
	
	// For RC when Prot and Perf is selected
	@FindBy(xpath = "//td[text()='Protected Benefit Account Investment Options']//following-sibling::*/input")
	WebElement prot_fund;
	@FindBy(xpath = "//td[text()='Investment Account Investment Options']//following-sibling::*/input")
	WebElement perf_fund;

	

	public void execute() throws Exception {
		System.out.println("Affirm SubAccounts page started");

		try {

			excelfield = "Prot_Percentage";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "SubAccounts");
			if (temp.equalsIgnoreCase("None")) {
			}

			else {
				WebDriverInitialization.uiopt.sendKeys(temp, prot_fund, excelfield);
			}

			excelfield = "Perf_Percentage";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "SubAccounts");
			if (temp.equalsIgnoreCase("None")) {
			} else {

				WebDriverInitialization.uiopt.sendKeys(temp, perf_fund, excelfield);
			}

			excelfield = "Funds";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "SubAccounts");
			String[] fund_name = temp.split(",");

			excelfield = "Funds_Percentage";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "SubAccounts");
			String[] fund_percent = temp.split(",");
			for (int i = 0; i < fund_name.length; i++) {

				WebElement funds = driver
						.findElement(By.xpath("//td[text()='" + fund_name[i] + "']//following-sibling::*/input"));
				WebDriverInitialization.uiopt.sendKeys(fund_percent[i], funds, excelfield);

			}

			// Warning message on funds page
			By msg= By.xpath("//span[@class='ui-icon ui-icon-closethick' and text()='close']");
			Boolean result= new CustomWait(driver).alertMsgToBeClickable(msg);
			if(result) {
				WebElement alert= driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick' and text()='close']"));
				WebDriverInitialization.uiopt.clickByJavaScript(alert);
				new CustomWait(driver).waitForPageLoad();
			}

			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
			System.out.println("SubAccounts page completed");
			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
		} catch (Exception e) {
			System.out.println("Please check your data entry-->>" + e.getMessage());
		}
	}

}
