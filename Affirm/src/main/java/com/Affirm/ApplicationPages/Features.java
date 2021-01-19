package com.Affirm.ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CustomWait;
import utils.ExcelSheetOperation;
import utils.WebDriverInitialization;

public class Features extends WebDriverInitialization {

	WebDriver driver;
	public String excelfield = "";
	public String temp = "";

	public Features(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	@FindBy(xpath = "//input[@value='Next >>' and @class='NEXTButton' and @title='Go to Next Section']")
	public static WebElement next_btn;

	// For IE, RC and SCS
	@FindBy(xpath = "//td[contains(text(),'Death Benefit')]//following-sibling::*/select")
	WebElement Death_Benefit;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_LivingBenefitGrid_ctl02_Include']")
	WebElement GMIB_chkbox;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_LivingBenefitGrid_ctl02_FeatureOptProduct']")
	WebElement GMIB;
	@FindBy(xpath = "//td[contains(text(),'Asset Allocation')]//following-sibling::*/child::*/following-sibling::*")
	WebElement Asset_Allocation;
	@FindBy(xpath = "//td[contains(text(),'Dollar Cost Averaging' or text(),'Dollar Cap Averaging' or text(),'General Dollar Cost Averaging')]//preceding-sibling::*/child::*")
	WebElement DCA_chkbox;
	@FindBy(xpath = "//td[contains(text(),'Dollar Cost Averaging')]//following-sibling::*/select")
	WebElement DCA;

	// For IE
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ProgramGrid_ctl05_Include']")
	WebElement RB_chkbox;
	

	public void execute() throws Exception {
		System.out.println("Affirm Features page started");

		try {

			excelfield = "GMIB";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Features");
			if (temp != null) {
				WebDriverInitialization.uiopt.clickByJavaScript(GMIB_chkbox);
				WebDriverInitialization.uiopt.dropdown(temp, GMIB, excelfield);

			}

			excelfield = "Death Benefit";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Features");
			if (temp != null) {
				WebDriverInitialization.uiopt.dropdown(temp, Death_Benefit, excelfield);
			}

			excelfield = "Asset Allocation";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Features");
			if (temp != null) {
				WebDriverInitialization.uiopt.dropdown(temp, Asset_Allocation, excelfield);
			}

			excelfield = "DCA";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Features");
			if (temp.equalsIgnoreCase("Yes")) {
				WebDriverInitialization.uiopt.clickByJavaScript(DCA_chkbox);

				excelfield = "DCA Frequency";
				String DCA_freq = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
						"Features");
				WebDriverInitialization.uiopt.dropdown(DCA_freq, DCA, excelfield);

			}

			excelfield = "RB";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Features");
			if (temp.equalsIgnoreCase("Yes")) {
				WebDriverInitialization.uiopt.clickByJavaScript(RB_chkbox);

			}

			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
			System.out.println("Features Details page completed");

		} catch (Exception e) {
			System.out.println("Please check your data entry-->>" + e.getMessage());
		}

	}

}
