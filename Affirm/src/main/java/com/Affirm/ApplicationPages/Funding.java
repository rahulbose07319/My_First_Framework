package com.Affirm.ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CustomWait;
import utils.ExcelSheetOperation;
import utils.WebDriverInitialization;

public class Funding extends WebDriverInitialization {
	WebDriver driver;
	public String excelfield = "";
	public String temp = "";

	public Funding(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	// WebElements for next button
	@FindBy(xpath = "//input[@value='Next >>' and @class='NEXTButton' and @title='Go to Next Section']")
	public static WebElement next_btn;

	// WebElements for Qualified Policy Transfer
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl09_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x1']")
	public static WebElement surrendering_company_name;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl09_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x2']")
	public static WebElement estimated_policy_value;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl09_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x3']")
	public static WebElement estimated_surrender_amount;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl09_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x6']")
	public static WebElement product_type;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl09_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x8']")
	public static WebElement liquidation_type;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl09_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x9']")
	public static WebElement policy_number;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl09_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x13']")
	public static WebElement qualified_plan;

	// WebElements for Qualified Fund Transfer
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl10_ctl01_ctl01_ctl01_FundingAmount']")
	public static WebElement estimated_surrender_amount_fundtransfer;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl10_ctl01_ctl01_ctl01_LiquidationType']")
	public static WebElement liquidation_type_fundtransfer;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl10_ctl01_ctl01_ctl01_InvType']")
	public static WebElement investment_type_fundtransfer;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl10_ctl01_ctl01_ctl01_QualPlan']")
	public static WebElement qualified_plan_fundtransfer;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl10_ctl01_ctl01_ctl01_CompanyName']")
	public static WebElement financial_institution_name;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl10_ctl01_ctl01_ctl01_AcctNumber']")
	public static WebElement account_number;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl10_ctl01_ctl01_ctl01_AcctHolderName']")
	public static WebElement account_holder_name;

	// WebElements for Check Payment
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl06_ctl01_ctl01_ctl01_ctl02_PaymentAmt']")
	public static WebElement premium_purchase_amount;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl06_ctl01_ctl01_ctl01_ctl02_CheckNo']")
	public static WebElement check_number;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl06_ctl01_ctl01_ctl01_ctl03_ctl02_AddVolCashBtn']")
	public static WebElement equity_bond_cash;

	// WebElement for 1035 Exchange
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl07_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x9']")
	public static WebElement surrendering_company_name_1035;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl07_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x6']")
	public static WebElement estimated_policy_value_1035;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl07_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x2']")
	public static WebElement estimated_surrender_amount_1035;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl07_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x5']")
	public static WebElement product_type_1035;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl07_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x4']")
	public static WebElement liquidation_type_1035;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl07_ctl01_ctl01_ctl02_ctl02_ctl01_ctl01_sb1x1']")
	public static WebElement policy_number_1035;

	// WebElement for Non-Qualified Funds Transfer
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl11_ctl01_ctl01_ctl01_FundingAmount']")
	public static WebElement estimated_surrender_amount_NQ;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl11_ctl01_ctl01_ctl01_LiquidationType']")
	public static WebElement liquidation_type_NQ;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl11_ctl01_ctl01_ctl01_InvType']")
	public static WebElement investment_type_NQ;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl11_ctl01_ctl01_ctl01_CompanyName']")
	public static WebElement financial_institution_name_NQ;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl11_ctl01_ctl01_ctl01_AcctNumber']")
	public static WebElement account_number_NQ;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl11_ctl01_ctl01_ctl01_AcctHolderName']")
	public static WebElement account_holder_name_NQ;

	public void execute() throws Exception {
		System.out.println("Affirm Funding page started");

		try {

			excelfield = "Payment_Source";
			String payment_method = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
					"Funding");
			WebElement payment_source = driver
					.findElement(By.xpath("//input[contains(@value,'" + payment_method + "')]"));
			WebDriverInitialization.uiopt.clickByJavaScript(payment_source);

			switch (payment_method) {

			case "Add Qualified Policy Transfer/Rollover":
				new CustomWait(driver).waitForPageLoad();

				excelfield = "Surrendering_Company_Name";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, surrendering_company_name, excelfield);

				excelfield = "Estimated_Policy_Value";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, estimated_policy_value, excelfield);

				excelfield = "Estimated_Surrender_Amount";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, estimated_surrender_amount, excelfield);

				excelfield = "Product_Type";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.dropdown(temp, product_type, excelfield);

				excelfield = "Liquidation_Type";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.dropdown(temp, liquidation_type, excelfield);

				excelfield = "Policy_Number";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, policy_number, excelfield);

				excelfield = "Qualified_Plan";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.dropdown(temp, qualified_plan, excelfield);
				break;

			case "Add Qualified Funds Transfer/Rollover":
				new CustomWait(driver).waitForPageLoad();

				excelfield = "Estimated_Surrender_Amount";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, estimated_surrender_amount_fundtransfer, excelfield);

				excelfield = "Liquidation_Type";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.dropdown(temp, liquidation_type_fundtransfer, excelfield);

				excelfield = "Investment_Type";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.dropdown(temp, investment_type_fundtransfer, excelfield);

				excelfield = "Qualified_Plan";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.dropdown(temp, qualified_plan_fundtransfer, excelfield);

				excelfield = "Financial_Ins_Name";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, financial_institution_name, excelfield);

				excelfield = "Acc_Number";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, account_number, excelfield);

				excelfield = "Acc_Holder_Name";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, account_holder_name, excelfield);
				break;

			case "Add Check":
				new CustomWait(driver).waitForPageLoad();

				excelfield = "Purchase_amount";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, premium_purchase_amount, excelfield);

				excelfield = "Check_number";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, check_number, excelfield);

				WebDriverInitialization.uiopt.clickByJavaScript(equity_bond_cash);
				break;

			case "Add 1035 Exchange":
				new CustomWait(driver).waitForPageLoad();

				excelfield = "Surrendering_Company_Name";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, surrendering_company_name_1035, excelfield);

				excelfield = "Estimated_Policy_Value";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, estimated_policy_value_1035, excelfield);

				excelfield = "Estimated_Surrender_Amount";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, estimated_surrender_amount_1035, excelfield);

				excelfield = "Product_Type";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.dropdown(temp, product_type_1035, excelfield);

				excelfield = "Liquidation_Type";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.dropdown(temp, liquidation_type_1035, excelfield);

				excelfield = "Policy_Number";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, policy_number_1035, excelfield);
				break;

			case "Add Non-Qualified Funds Transfer":
				new CustomWait(driver).waitForPageLoad();

				excelfield = "Estimated_Surrender_Amount";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, estimated_surrender_amount_NQ, excelfield);

				excelfield = "Liquidation_Type";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.dropdown(temp, liquidation_type_NQ, excelfield);

				excelfield = "Investment_Type";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.dropdown(temp, investment_type_NQ, excelfield);

				excelfield = "Financial_Ins_Name";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, financial_institution_name_NQ, excelfield);

				excelfield = "Acc_Number";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, account_number_NQ, excelfield);

				excelfield = "Acc_Holder_Name";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Funding");
				WebDriverInitialization.uiopt.sendKeys(temp, account_holder_name_NQ, excelfield);
				break;

			}
			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
			System.out.println("Funding page completed");

		} catch (Exception e) {
			System.out.println("Please check your data entry-->>" + e.getMessage());
		}

	}

}
