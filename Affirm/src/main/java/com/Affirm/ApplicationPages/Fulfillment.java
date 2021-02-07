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
	@FindBy(xpath = "//span[@id='ctl08_ctl02_ctl02_ctl06_ctl01_ctl03_sb1x0']")
	public static WebElement sol_state;

	// WebElement sol_state = driver
	// .findElement(By.xpath("//span[@id='ctl08_ctl02_ctl02_ctl06_ctl01_ctl03_sb1x0']"));

	public void execute() throws Exception {
		System.out.println("Affirm Fulfillment page started");
		Thread.sleep(4000);

		try {
			excelfield = "Commission_Option";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement coption = driver.findElement(By.xpath("//label[text()='" + temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(coption);

			excelfield = "Replacement_Question1";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_1 = driver.findElement(By.xpath(
					"//td[text()='Does the client have any existing life insurance policies or annuity contracts with this or any other company?']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));

			WebDriverInitialization.uiopt.clickByJavaScript(rplc_1);

			excelfield = "Replacement_Question2";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_2 = driver.findElement(By.xpath(
					"//td[text()='Is the client considering discontinuing making premium payments, surrendering, forfeiting, assigning to the insurer, or otherwise terminating their existing policy or contract?']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc_2);

			excelfield = "Replacement_Question3";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_3 = driver.findElement(By.xpath(
					"//td[text()='Is the client considering using funds from their existing policies or contracts to pay premiums due on the new policy or contract?  This includes taking withdrawals or loans and using these funds to pay premium(s) on a new policy or contract.']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc_3);

			excelfield = "Replacement_Question4";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_4 = driver.findElement(By.xpath(
					"//td[text()='To the best of my knowledge as the representative, the applicant has existing life insurance policies or annuity contracts with this or any other company?']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc_4);

			excelfield = "Replacement_Question5";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc_5 = driver.findElement(By.xpath(
					"//td[text()='To the best of my knowledge as the representative, the applicant is considering discontinuing making premium payments, surrendering, forfeiting, assigning to the insurer, or otherwise terminating their existing policy or contract?']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc_5);

			excelfield = "Replacement_Question6";
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

			excelfield = "Replacement_Question";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			WebElement rplc = driver.findElement(By.xpath(
					"//td[text()='Will any existing life insurance or annuity be (or has it been) surrendered, withdrawn from, loaned against, changed or otherwise reduced in value, or replaced in connection with this transaction assuming the certificate/contract applied for will be issued?']//following-sibling::*//label[text()='"
							+ temp + "']//preceding-sibling::*"));
			WebDriverInitialization.uiopt.clickByJavaScript(rplc);

			if (temp.equalsIgnoreCase("Yes")) {

				// NAIC Questionnaire
				excelfield = "NAIC_Questionnaire1";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
				if (temp.equalsIgnoreCase("None")) {
				} else {
					if (temp.equalsIgnoreCase("Yes")) {
						WebElement naic_1_yes = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl06_sb0x0_1']"));
						WebDriverInitialization.uiopt.clickByJavaScript(naic_1_yes);

					} else {
						WebElement naic_1_no = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl06_sb0x0_0']"));
						WebDriverInitialization.uiopt.clickByJavaScript(naic_1_no);
					}

					excelfield = "NAIC_Questionnaire2";
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

					excelfield = "NAIC_Questionnaire3";
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
						
						WebElement financial_advisor_NC = driver
								.findElement(By.xpath("//td[text()='I certify that I have truly and accurately recorded on the application the information provided by the Proposed Owner.']//following-sibling::*//input"));
						WebDriverInitialization.uiopt.clickByJavaScript(financial_advisor_NC);
					}

					// Sales Material Kit
					excelfield = "Sales_Material_Kit";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					String[] skit = temp.split(",");
					for (int i = 0; i < skit.length; i++) {

						WebElement soptions = driver
								.findElement(By.xpath("//td[text()='" + skit[i] + "']//following-sibling::*//input"));
						WebDriverInitialization.uiopt.clickByJavaScript(soptions);
					}

				}

				if (sol_state.getText().equalsIgnoreCase("New York")) {
					excelfield = "NY_Attestation";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					if (temp.equalsIgnoreCase("Yes")) {
						WebElement NY_attestation = driver.findElement(
								By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl01_sb0x0_0']"));
						WebDriverInitialization.uiopt.clickByJavaScript(NY_attestation);
					}

					WebElement reg60 = driver.findElement(By.xpath(
							"(//td[@class='dataLabel' and text()='You have indicated that this sale involves a replacement, as a result you will need to comply with NY Regulation 60.  You will need to submit signed copies of this paperwork to the service center along with this eApp.  These forms can either be generated by eApp or you can find copies in a NY Sales Kit and complete/submit them on your own.  Do you require eApp to generate the Regulation 60 documents for you?']//following-sibling::*/child::*//input)[2]"));
					WebDriverInitialization.uiopt.clickByJavaScript(reg60);

					// Insurance Department of the state of NY state Department
					excelfield = "NY_Insurance_Question1";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					WebElement NY_1 = driver.findElement(By.xpath(
							"//ul[text()='Lapsed, surrendered, partially surrendered, forfeited, assigned to the insurer replacing the life insurance policy or annuity contract, or otherwise terminated? ']/parent::*//following-sibling::*/child::*//label[text()='"
									+ temp + "']/preceding-sibling::*"));
					WebDriverInitialization.uiopt.clickByJavaScript(NY_1);

					excelfield = "NY_Insurance_Question2";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					WebElement NY_2 = driver.findElement(By.xpath(
							"//ul[text()='Changed or modified into Paid-up insurance; continued as extended term insurance or under another form of nonforfeiture benefit; or otherwise reduced in value by the use of nonforfeiture benefits, dividend accumulations, dividend cash values or other cash values? ']/parent::*//following-sibling::*/child::*//label[text()='"
									+ temp + "']/preceding-sibling::*"));
					WebDriverInitialization.uiopt.clickByJavaScript(NY_2);

					excelfield = "NY_Insurance_Question3";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					WebElement NY_3 = driver.findElement(By.xpath(
							"//ul[text()='Changed or modified so as to effect a reduction either in the amount of the existing life insurance or annuity benefit or in the period of time the existing life insurance or annuity benefit will continue in force? ']/parent::*//following-sibling::*/child::*//label[text()='"
									+ temp + "']/preceding-sibling::*"));
					WebDriverInitialization.uiopt.clickByJavaScript(NY_3);

					excelfield = "NY_Insurance_Question4";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					WebElement NY_4 = driver.findElement(By.xpath(
							"//ul[text()='Reissued with a reduction in amount such that any cash values are released, including all transactions wherein an amount of dividend accumulations or paid-up additions is to be released on one or more of the existing policies? ']/parent::*//following-sibling::*/child::*//label[text()='"
									+ temp + "']/preceding-sibling::*"));
					WebDriverInitialization.uiopt.clickByJavaScript(NY_4);

					excelfield = "NY_Insurance_Question5";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					WebElement NY_5 = driver.findElement(By.xpath(
							"//ul[text()='Assigned as collateral for a loan or made subject to borrowing or withdrawal of any portion of the loan value, including all transactions wherein any amount of dividend accumulations or paid-up additions is to be borrowed or withdrawn on one or more existing policies? ']/parent::*//following-sibling::*/child::*//label[text()='"
									+ temp + "']/preceding-sibling::*"));
					WebDriverInitialization.uiopt.clickByJavaScript(NY_5);

					excelfield = "NY_Insurance_Question6";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					WebElement NY_6 = driver.findElement(By.xpath(
							"//ul[text()='Continued with a stoppage of premium payments or reduction in the amount of premium paid? ']/parent::*//following-sibling::*/child::*//label[text()='"
									+ temp + "']/preceding-sibling::*"));
					WebDriverInitialization.uiopt.clickByJavaScript(NY_6);

					excelfield = "NY_Insurance_Question7";
					temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
					WebElement NY_7 = driver.findElement(By.xpath(
							"//td[text()='To the best of my knowledge, a replacement is involved in this transaction']//following-sibling::*//label[text()='"+temp+"']"));
					WebDriverInitialization.uiopt.clickByJavaScript(NY_7);


					WebElement certification_4 = driver
							.findElement(By.xpath("//ul[text()='I hereby certify that all sales materials used in this sales transaction have been approved by Equitable Life Insurance Company and are checked below or listed and copies attached. I further certify that the applicant received originals and/or copies of all sales material, and that printed copies of all electronically presented information will be given to the applicant at, or prior to, delivery of the policy or contract. ']/parent::*//following-sibling::*/child::*//input"));
					WebDriverInitialization.uiopt.clickByJavaScript(certification_4);
					
					WebElement sales_material_NY = driver
							.findElement(By.xpath("//ul[text()='I hereby certify that the attached sales illustration or proposal was used in this transaction. I further certify that the applicant received originals and / or copies of the sales illustration or proposal. ']//parent::*//following-sibling::*//input"));
					WebDriverInitialization.uiopt.clickByJavaScript(sales_material_NY);

				}

			}

			// Florida License Number
			excelfield = "FL_License_Number";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			if (temp.equalsIgnoreCase("None")) {
			}

			else {
				WebElement FL_License = driver
						.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl04_sb0x0']"));
				WebDriverInitialization.uiopt.sendKeys(temp, FL_License, excelfield);
			}

			// Financial Advisor question
			
			WebElement financial_advisor_1 = driver
					.findElement(By.xpath("(//td[text()='Did you verify the identity and age by reviewing the driver’s license/passport of each Owner/Annuitant, inquire about the source of the customer’s assets and income, and confirm that the Proposed Insured and Owner is not (nor family member of or associates with) a foreign military, government or political official?']//following-sibling::*/child::*//input)[2]"));
			WebDriverInitialization.uiopt.clickByJavaScript(financial_advisor_1);

			WebElement financial_advisor_2 = driver
					.findElement(By.xpath("(//td[text()='Is the Proposed Owner/Annuitant, or is their family member or close associate, a government,political official or foreign military official?']//following-sibling::*/child::*//input)[1]"));
			WebDriverInitialization.uiopt.clickByJavaScript(financial_advisor_2);

			// Non-Natural Owner Certification
			excelfield = "Is_Trust_Present";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Fulfillment");
			if (temp.equalsIgnoreCase("Yes")) {
				
				WebElement certification = driver
						.findElement(By.xpath("//td[text()='- Annuity Contract held by an employer until final payout of annuity contract resulting from an I.R.C. Section 401(a) qualified plan termination, under I.R.C. Section 72(u)(3)(D).']//following-sibling::*/child::*//input"));
				WebDriverInitialization.uiopt.clickByJavaScript(certification);

//
//				WebElement fin_adv_for_non_natural = driver
//						.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl05_ctl04_ctl04_sb0x0_0']"));
//				WebDriverInitialization.uiopt.clickByJavaScript(fin_adv_for_non_natural);

			}
			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
			By msg= By.xpath("//span[@class='ui-icon ui-icon-closethick' and text()='close']");
			Boolean result= new CustomWait(driver).alertMsgToBeClickable(msg);
			if(result) {
				WebElement alert= driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick' and text()='close']"));
				WebDriverInitialization.uiopt.clickByJavaScript(alert);
				new CustomWait(driver).waitForPageLoad();
			}
			
			

			WebElement order_summary = driver.findElement(By.xpath("//span[text()='Order Summary']"));
			try {
				Assert.assertEquals(order_summary.getText(), "Order Summary");
				System.out.println("You are on Order Summary Page");
				WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			} catch (Exception e) {
				System.out.println("You are not on Order Summary Page. Please check your data entry" + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Error in Fulfillment Page" + e.getMessage());
		}

	}
}
