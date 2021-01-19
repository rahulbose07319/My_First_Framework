package com.Affirm.ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CustomWait;
import utils.ExcelSheetOperation;
import utils.WebDriverInitialization;

public class Product extends WebDriverInitialization {

	WebDriver driver;
	public String excelfield = "";
	public String temp = "";

	public Product(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	@FindBy(xpath = "//td[3][@class='DataEntryPanelItemStyle']/child::select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ddOwnership']")
	public static WebElement ownership;
	@FindBy(xpath = "//td[2][@class='DataEntryPanelItemStyle']/child::select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ResidenceState']")
	public static WebElement residence_state;
	@FindBy(xpath = "//td[3][@class='DataEntryPanelItemStyle']/child::select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_SolicitationState']")
	public static WebElement solicitation_state;
	@FindBy(xpath = "//td[4][@class='DataEntryPanelItemStyle']/child::select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_CountyList']")
	public static WebElement county;
	@FindBy(xpath = "//td[1][@class='DataEntryPanelItemStyle']/child::select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_QualPlanType']")
	public static WebElement annuity_plan_type;
	@FindBy(xpath = "//input[@value='Search Products' and @type='submit']")
	public static WebElement search_products;
	@FindBy(xpath = "//input[@value='Next >>' and @class='NEXTButton' and @title='Go to Next Section']")
	public static WebElement next_btn;

	public void execute() throws Exception {
		System.out.println("Affirm Product page started");

		try {
			excelfield = "Ownership_Type";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Product");
			WebDriverInitialization.uiopt.dropdown(temp, ownership, excelfield);

			excelfield = "Residence_State";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Product");
			WebDriverInitialization.uiopt.dropdown(temp, residence_state, excelfield);

			excelfield = "Solicitation_State";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Product");
			WebDriverInitialization.uiopt.dropdown(temp, solicitation_state, excelfield);
			if (temp.equalsIgnoreCase("FL")) {
				excelfield = "County";
				String temp_county = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
						"Product");
				WebDriverInitialization.uiopt.dropdown(temp_county, county, excelfield);
			}

			excelfield = "Annuity_Plan_Type";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Product");
			WebDriverInitialization.uiopt.dropdown(temp, annuity_plan_type, excelfield);

			// click on search product
			WebDriverInitialization.uiopt.clickByJavaScript(search_products);

			// Search specific product
			excelfield = "Product_Code";
			String productCode = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
					"Product");
			WebElement cusip = driver.findElement(
					By.xpath("//td[text()='" + productCode + "']/parent::*/child::td[1]/child::span/child::input"));
			WebDriverInitialization.uiopt.clickByJavaScript(cusip);

			// click on next button
			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
			By Temp = By.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']");
			Boolean result = new CustomWait(driver).alertMsgToBeClickable(Temp);

			if (result.equals(true)) {
				WebElement warning_msg = driver.findElement(By
						.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']"));
				WebDriverInitialization.uiopt.clickByJavaScript(warning_msg);
				WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
				new CustomWait(driver).waitForPageLoad();
			}
			System.out.println("Product selected successfully");

		} catch (Exception e) {
			System.out.println("Please check your data entry ->>" + e.getMessage());
		}
	}

}
