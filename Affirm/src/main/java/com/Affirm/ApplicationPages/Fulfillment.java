package com.Affirm.ApplicationPages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CustomWait;
import utils.ExcelSheetOperation;
import utils.WebDriverInitialization;

public class Fulfillment extends WebDriverInitialization {

	WebDriver driver;
	public String excelfield = "";
	public String temp = "";

	public Fulfillment(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	@FindBy(xpath = "//input[@value='Next >>' and @class='NEXTButton' and @title='Go to Next Section']")
	public static WebElement next_btn;

	public void execute() throws Exception {
		System.out.println("Affirm Fulfillment page started");

		try {
			excelfield = "Commission Option";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement coption = driver.findElement(By.xpath("//label[text()='" + temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(coption);

			excelfield = "Replacement Question 1";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_1 = driver.findElement(By.xpath(
					"//td[text()='Does the client have any existing life insurance policies or annuity contracts with this or any other company?']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));

			WebDriverInitialization.uiopt.clickByJavaScript(rplc_1);

			excelfield = "Replacement Question 2";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_2 = driver.findElement(By.xpath(
					"//td[text()='Is the client considering discontinuing making premium payments, surrendering, forfeiting, assigning to the insurer, or otherwise terminating their existing policy or contract?']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc_2);

			excelfield = "Replacement Question 3";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_3 = driver.findElement(By.xpath(
					"//td[text()='Is the client considering using funds from their existing policies or contracts to pay premiums due on the new policy or contract?  This includes taking withdrawals or loans and using these funds to pay premium(s) on a new policy or contract.']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc_3);

			excelfield = "Replacement Question 4";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_4 = driver.findElement(By.xpath(
					"//td[text()='To the best of my knowledge as the representative, the applicant has existing life insurance policies or annuity contracts with this or any other company?']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc_4);

			excelfield = "Replacement Question 5";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_5 = driver.findElement(By.xpath(
					"//td[text()='To the best of my knowledge as the representative, the applicant is considering discontinuing making premium payments, surrendering, forfeiting, assigning to the insurer, or otherwise terminating their existing policy or contract?']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc_5);

			excelfield = "Replacement Question 6";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_6 = driver.findElement(By.xpath(
					"//td[text()='To the best of my knowledge as the representative, the applicant is considering using funds from their existing policies or contracts to pay premiums due on the new policy or contract?  This includes taking withdrawals or loans and using these funds to pay premium(s) on a new policy or contract.']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc_6);

			// excelfield = "General Question";
			// temp = ExcelSheetOperation.getCellData(excelfield,
			// WebDriverInitialization.TC_Name, "Fulfillment");
			// Below question always need to be Yes
			WebElement generalq_yes = driver
					.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl01_sb0x0_1']"));
			WebDriverInitialization.uiopt.clickByJavaScript(generalq_yes);

			excelfield = "Replacement Question";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc = driver.findElement(By.xpath(
					"//td[text()='Will any existing life insurance or annuity be (or has it been) surrendered, withdrawn from, loaned against, changed or otherwise reduced in value, or replaced in connection with this transaction assuming the certificate/contract applied for will be issued?']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc);

			if (temp.equalsIgnoreCase("Yes")) {

				// NAIC Questionnaire
				excelfield = "NAIC Questionnaire 1";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
				if (temp != null) {
					if (temp.equalsIgnoreCase("Yes")) {
						WebElement naic_1_yes = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl06_sb0x0_1']"));
						WebDriverInitialization.uiopt.clickByJavaScript(naic_1_yes);

					} else {
						WebElement naic_1_no = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl06_sb0x0_0']"));
						WebDriverInitialization.uiopt.clickByJavaScript(naic_1_no);
					}

					excelfield = "NAIC Questionnaire 2";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					if (temp.equalsIgnoreCase("Yes")) {
						WebElement naic_2_yes = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl06_sb0x1_1']"));
						WebDriverInitialization.uiopt.clickByJavaScript(naic_2_yes);

						WebElement text = driver.findElement(
								By.xpath("//textarea[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl06_sb0x2']"));
						WebDriverInitialization.uiopt.sendKeys("NA", text, excelfield);

					} else {
						WebElement naic_2_no = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl06_sb0x1_0']"));
						WebDriverInitialization.uiopt.clickByJavaScript(naic_2_no);
					}

					excelfield = "NAIC Questionnaire 3";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					if (temp.equalsIgnoreCase("Yes")) {
						WebElement naic_3_yes = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl06_sb0x3_1']"));
						WebDriverInitialization.uiopt.clickByJavaScript(naic_3_yes);

					} else {
						WebElement naic_3_no = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl06_sb0x3_0']"));
						WebDriverInitialization.uiopt.clickByJavaScript(naic_3_no);
					}

					// NC Specific Question
					WebElement sol_state = driver
							.findElement(By.xpath("//span[@id='ctl08_ctl02_ctl02_ctl06_ctl01_ctl03_sb1x0']"));
					if (sol_state.getText().equalsIgnoreCase("North Carolina")) {
						WebElement NC_1 = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl02_sb0x62_1']"));
						WebDriverInitialization.uiopt.clickByJavaScript(NC_1);

						WebElement NC_2 = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl02_sb0x63_1']"));
						WebDriverInitialization.uiopt.clickByJavaScript(NC_2);

						WebElement NC_3 = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl02_sb0x64_1']"));
						WebDriverInitialization.uiopt.clickByJavaScript(NC_3);

						WebElement NC_4 = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl02_sb0x65_1']"));
						WebDriverInitialization.uiopt.clickByJavaScript(NC_4);
					}

					if (sol_state.getText().equalsIgnoreCase("New York")) {
						WebElement NY_attestation = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl01_sb0x0_0']"));
						WebDriverInitialization.uiopt.clickByJavaScript(NY_attestation);

						WebElement reg60 = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl03_sb0x8_1']"));
						WebDriverInitialization.uiopt.clickByJavaScript(reg60);

						// Insurance Department of the state of NY state Department
						excelfield = "NY Insurance Question 1";
						temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
								"Fulfillment");
						WebElement NY_1 = driver.findElement(By.xpath(
								"//ul[text()='Lapsed, surrendered, partially surrendered, forfeited, assigned to the insurer replacing the life insurance policy or annuity contract, or otherwise terminated? ']/parent::*//following-sibling::*/child::*//label[text()='"
										+ temp + "']/preceding-sibling::*"));
						WebDriverInitialization.uiopt.clickByJavaScript(NY_1);

						excelfield = "NY Insurance Question 2";
						temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
								"Fulfillment");
						WebElement NY_2 = driver.findElement(By.xpath(
								"//ul[text()='Changed or modified into Paid-up insurance; continued as extended term insurance or under another form of nonforfeiture benefit; or otherwise reduced in value by the use of nonforfeiture benefits, dividend accumulations, dividend cash values or other cash values? ']/parent::*//following-sibling::*/child::*//label[text()='"
										+ temp + "']/preceding-sibling::*"));
						WebDriverInitialization.uiopt.clickByJavaScript(NY_2);

						excelfield = "NY Insurance Question 3";
						temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
								"Fulfillment");
						WebElement NY_3 = driver.findElement(By.xpath(
								"//ul[text()='Changed or modified so as to effect a reduction either in the amount of the existing life insurance or annuity benefit or in the period of time the existing life insurance or annuity benefit will continue in force? ']/parent::*//following-sibling::*/child::*//label[text()='"
										+ temp + "']/preceding-sibling::*"));
						WebDriverInitialization.uiopt.clickByJavaScript(NY_3);

						excelfield = "NY Insurance Question 4";
						temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
								"Fulfillment");
						WebElement NY_4 = driver.findElement(By.xpath(
								"//ul[text()='Reissued with a reduction in amount such that any cash values are released, including all transactions wherein an amount of dividend accumulations or paid-up additions is to be released on one or more of the existing policies? ']/parent::*//following-sibling::*/child::*//label[text()='"
										+ temp + "']/preceding-sibling::*"));
						WebDriverInitialization.uiopt.clickByJavaScript(NY_4);

						excelfield = "NY Insurance Question 5";
						temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
								"Fulfillment");
						WebElement NY_5 = driver.findElement(By.xpath(
								"//ul[text()='Assigned as collateral for a loan or made subject to borrowing or withdrawal of any portion of the loan value, including all transactions wherein any amount of dividend accumulations or paid-up additions is to be borrowed or withdrawn on one or more existing policies? ']/parent::*//following-sibling::*/child::*//label[text()='"
										+ temp + "']/preceding-sibling::*"));
						WebDriverInitialization.uiopt.clickByJavaScript(NY_5);

						excelfield = "NY Insurance Question 6";
						temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
								"Fulfillment");
						WebElement NY_6 = driver.findElement(By.xpath(
								"//ul[text()='Continued with a stoppage of premium payments or reduction in the amount of premium paid? ']/parent::*//following-sibling::*/child::*//label[text()='"
										+ temp + "']/preceding-sibling::*"));
						WebDriverInitialization.uiopt.clickByJavaScript(NY_6);

						excelfield = "NY Insurance Question 7";
						temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
								"Fulfillment");
						WebElement NY_7 = driver.findElement(By.xpath(
								"//ul[text()='To the best of my knowledge, a replacement is involved in this transaction']/parent::*//following-sibling::*/child::*//label[text()='"
										+ temp + "']/preceding-sibling::*"));
						WebDriverInitialization.uiopt.clickByJavaScript(NY_7);
						
						WebElement No_sales_material_NY= driver.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl08_sb0x87']"));
						WebDriverInitialization.uiopt.clickByJavaScript(No_sales_material_NY);
						
						WebElement sales_material_NY= driver.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl08_sb0x89']"));
						WebDriverInitialization.uiopt.clickByJavaScript(sales_material_NY);

					}

					// Sales Material Kit
					excelfield = "Sales Material Kit";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					String[] skit = temp.split(",");
					for (int i = 0; i < skit.length; i++) {

						WebElement soptions = driver
								.findElement(By.xpath("//td[text()='" + skit[i] + "']//following-sibling::*//input"));
						WebDriverInitialization.uiopt.clickByJavaScript(soptions);
					}

				}
			}

			// Florida License Number
			excelfield = "FL License Number";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			if (temp != null) {
				WebElement FL_License = driver
						.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl04_sb0x0']"));
				WebDriverInitialization.uiopt.sendKeys(temp, FL_License, excelfield);
			}

			// Financial Advisor question
			WebElement financial_advisor_1 = driver
					.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl04_sb0x1_1']"));
			WebDriverInitialization.uiopt.clickByJavaScript(financial_advisor_1);

			WebElement financial_advisor_2 = driver
					.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl04_sb0x2_0']"));
			WebDriverInitialization.uiopt.clickByJavaScript(financial_advisor_2);

			// Non-Natural Owner Certification
			WebElement non_natural = driver
					.findElement(By.xpath("//div[contains(text(),'Non Natural Owner Certification')]"));
			if (non_natural.getText().equalsIgnoreCase("Non Natural Owner Certification")) {
				WebElement certification_3 = driver
						.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl08_sb0x8']"));
				WebDriverInitialization.uiopt.clickByJavaScript(certification_3);

				WebElement certification_4 = driver
						.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl08_sb0x9']"));
				WebDriverInitialization.uiopt.clickByJavaScript(certification_4);

				WebElement fin_adv_for_non_natural = driver
						.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl04_sb0x0_0']"));
				WebDriverInitialization.uiopt.clickByJavaScript(fin_adv_for_non_natural);

			}

			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
			System.out.println("Fulfillment page completed");
			
			WebElement order_summary= driver.findElement(By.xpath("//span[text()='Order Summary']"));
			try {
			Assert.assertEquals(order_summary.getText(), "Order Summary");
			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			}catch(Exception e) {
				System.out.println("You are not on Order Summary Page. Please check your data entry" +e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Please check your data entry-->>" + e.getMessage());
		}

	}
}
