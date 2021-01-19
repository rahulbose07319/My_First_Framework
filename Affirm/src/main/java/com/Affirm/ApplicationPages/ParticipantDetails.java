package com.Affirm.ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CustomWait;
import utils.ExcelSheetOperation;
import utils.WebDriverInitialization;

public class ParticipantDetails extends WebDriverInitialization {
	WebDriver driver;
	public String excelfield = "";
	public String temp = "";

	public ParticipantDetails(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	@FindBy(xpath = "//input[@value='Next >>' and @class='NEXTButton' and @title='Go to Next Section']")
	public static WebElement next_btn;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl04_sb1x6']")
	public static WebElement add_line1;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl04_sb1x8']")
	public static WebElement city;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl04_sb1x9']")
	public static WebElement state;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl04_sb1x10']")
	public static WebElement country;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl04_sb1x11']")
	public static WebElement zip;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl04_sb1x18']")
	public static WebElement citizenship;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl04_sb1x20_1']")
	public static WebElement active_military;
	
	//For NQ Trust, QPDB/QPDC
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl02_ctl01_ctl05_sb1x1']")
	public static WebElement bene_percentage_trust;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl02_ctl01_ctl05_sb1x2']")
	public static WebElement taxid_trust;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl02_ctl01_ctl05_sb1x3']")
	public static WebElement trust_date;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl02_ctl01_ctl05_sb1x0']")
	public static WebElement rltn_ann_trust;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl02_ctl01_ctl05_sb1x5']")
	public static WebElement add_line1_trust;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl02_ctl01_ctl05_sb1x7']")
	public static WebElement city_trust;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl02_ctl01_ctl05_sb1x8']")
	public static WebElement state_trust;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl02_ctl01_ctl05_sb1x9']")
	public static WebElement country_trust;
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl02_ctl01_ctl05_sb1x10']")
	public static WebElement zip_trust;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl02_ctl01_ctl05_sb1x15']")
	public static WebElement domicile;

	public void execute() {
		System.out.println("Affirm Participant details page started");

		try {
			excelfield = "Total number of Participants";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			int number_of_participants = Integer.parseInt(temp);
			
			//For NQ Trust, QPDB/QPDC
			excelfield = "Non-Natural Owner";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			if(temp.equalsIgnoreCase("Yes")) {
				
				excelfield = "Beneficiary% for Trust";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
				bene_percentage_trust.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				WebDriverInitialization.uiopt.sendKeys(temp, bene_percentage_trust, excelfield);
				
				excelfield = "Relationship to Annuitant";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
				WebDriverInitialization.uiopt.dropdown(temp, rltn_ann_trust, excelfield);
				
				excelfield = "TAX ID";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
				if(temp!=null) {
				taxid_trust.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				WebDriverInitialization.uiopt.sendKeys(temp, taxid_trust, excelfield);
				}
				
				excelfield = "Trust Date";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
				if(temp!=null) {
					trust_date.sendKeys(Keys.chord(Keys.CONTROL, "a"));
					WebDriverInitialization.uiopt.sendKeys(temp, trust_date, excelfield);
				}
				
				excelfield = "Address Line1 Trust";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
				if(temp!=null) {
				WebDriverInitialization.uiopt.sendKeys(temp, add_line1_trust, excelfield);
				}
				
				excelfield = "City Trust";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
				if(temp!=null) {
				WebDriverInitialization.uiopt.sendKeys(temp, city_trust, excelfield);
				}
				
				excelfield = "ZIP Trust";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
				if(temp!=null) {
				WebDriverInitialization.uiopt.sendKeys(temp, zip_trust, excelfield);
				}
				
				excelfield = "State Trust";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
				if(temp!=null) {
				WebDriverInitialization.uiopt.dropdown(temp, state_trust, excelfield);
				}
				
				excelfield = "Country Trust";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
				if(temp!=null) {
				WebDriverInitialization.uiopt.dropdown(temp, country_trust, excelfield);
				}
				
				excelfield = "Domicile";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
				WebDriverInitialization.uiopt.dropdown(temp, domicile, excelfield);
			}

			excelfield = "Address Line1";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			WebDriverInitialization.uiopt.sendKeys(temp, add_line1, excelfield);

			excelfield = "City";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			WebDriverInitialization.uiopt.sendKeys(temp, city, excelfield);

			excelfield = "State";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			WebDriverInitialization.uiopt.dropdown(temp, state, excelfield);

			excelfield = "Country";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			WebDriverInitialization.uiopt.dropdown(temp, country, excelfield);

			excelfield = "ZIP";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			WebDriverInitialization.uiopt.sendKeys(temp, zip, excelfield);

			excelfield = "Citizenship";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			WebDriverInitialization.uiopt.dropdown(temp, citizenship, excelfield);

			// Active Military question is marked as No for Owner.
			WebDriverInitialization.uiopt.clickByJavaScript(active_military);
			
			// Employer Name for SEP IRA
			excelfield = "Employer Name";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			WebElement empname= driver.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl04_sb1x20']"));
			WebDriverInitialization.uiopt.sendKeys(temp, empname, excelfield);

			String excelfield1 = "Gender";
			temp = ExcelSheetOperation.getCellData(excelfield1, WebDriverInitialization.TC_Name, "ParticipantDetails");
			String[] Gender = temp.split(",");

			String excelfield2 = "Date of Birth";
			temp = ExcelSheetOperation.getCellData(excelfield2, WebDriverInitialization.TC_Name, "ParticipantDetails");
			String[] Birth = temp.split(",");

			String excelfield3 = "SSN";
			temp = ExcelSheetOperation.getCellData(excelfield3, WebDriverInitialization.TC_Name, "ParticipantDetails");
			String[] SSN = temp.split(",");

			String excelfield4 = "Relationship To Owner";
			temp = ExcelSheetOperation.getCellData(excelfield4, WebDriverInitialization.TC_Name, "ParticipantDetails");
			String[] rltnship = temp.split(",");

			String excelfield5 = "Beneficiary %";
			temp = ExcelSheetOperation.getCellData(excelfield5, WebDriverInitialization.TC_Name, "ParticipantDetails");
			String[] bene_percent = temp.split(",");

			excelfield = "Active Military Other Than Owner";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			String[] active_military_other = temp.split(",");

			excelfield = "Address As Owner";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			String[] addr = temp.split(",");

			excelfield = "BTA";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			if (temp.equalsIgnoreCase("Yes")) {
				WebElement bta_yes = driver.findElement(
						By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl03_ctl01_ctl05_ctl02_sb0x0_1']"));
				WebDriverInitialization.uiopt.clickByJavaScript(bta_yes);
			} else {
				WebElement bta_no = driver.findElement(
						By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl03_ctl01_ctl05_ctl02_sb0x0_0']"));
				WebDriverInitialization.uiopt.clickByJavaScript(bta_no);
			}

			// e-delivery selection
			excelfield = "Consent for E-Delivery";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			if (temp.equalsIgnoreCase("Yes")) {
				WebElement edel_yes = driver.findElement(
						By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl08_ctl03_sb1x0_1']"));
				WebDriverInitialization.uiopt.clickByJavaScript(edel_yes);

				excelfield = "E-Del Email Type";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
						"ParticipantDetails");
				WebElement edel_email_type = driver.findElement(
						By.xpath("//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl08_ctl04_sb1x0']"));
				WebDriverInitialization.uiopt.dropdown(temp, edel_email_type, excelfield);

				excelfield = "E-del Email address";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
						"ParticipantDetails");
				WebElement edel_email_add = driver.findElement(
						By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl08_ctl04_sb1x1']"));
				WebDriverInitialization.uiopt.sendKeys(temp, edel_email_add, excelfield);

			} else {
				WebElement edel_no = driver.findElement(
						By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl08_ctl03_sb1x0_0']"));
				WebDriverInitialization.uiopt.clickByJavaScript(edel_no);
			}

			// Consent for electronic signature
			excelfield = "Consent for E-sign";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "ParticipantDetails");
			if (temp.equalsIgnoreCase("Yes")) {
				WebElement esign_yes = driver.findElement(
						By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl05_ctl02_sb1x0_0']"));
				WebDriverInitialization.uiopt.clickByJavaScript(esign_yes);

				excelfield = "Signature Method";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
						"ParticipantDetails");
				if (temp.equalsIgnoreCase("Remote")) {
					WebElement remote = driver.findElement(
							By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl06_ctl02_sb1x0_1']"));
					WebDriverInitialization.uiopt.clickByJavaScript(remote);
				} else {
					WebElement Inperson = driver.findElement(
							By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl06_ctl02_sb1x0_0']"));
					WebDriverInitialization.uiopt.clickByJavaScript(Inperson);
				}

				excelfield = "E-mail Type";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
						"ParticipantDetails");
				WebElement email_type = driver.findElement(
						By.xpath("//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl04_sb1x16']"));
				WebDriverInitialization.uiopt.dropdown(temp, email_type, excelfield);

				excelfield = "E-mail address";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
						"ParticipantDetails");
				WebElement email_add = driver
						.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_ctl04_sb1x17']"));
				WebDriverInitialization.uiopt.sendKeys(temp, email_add, excelfield);

			} else {
				WebElement esign_no = driver.findElement(
						By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl03_ctl01_ctl05_ctl02_sb0x0_0']"));
				WebDriverInitialization.uiopt.clickByJavaScript(esign_no);
			}

			// Iterate through the number of participants to enter data 
			for (int i = 0; i < number_of_participants; i++) {
				int j = i + 1;
				int k = i + 2;
				WebElement gender = driver.findElement(
						By.xpath("//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl0" + j + "_ctl04_sb1x1']"));
				WebDriverInitialization.uiopt.dropdown(Gender[i], gender, excelfield1);

				WebElement dob = driver.findElement(
						By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl0" + j + "_ctl04_sb1x2']"));
				dob.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				WebDriverInitialization.uiopt.sendKeys(Birth[i], dob, excelfield2);

				WebElement ssn = driver.findElement(
						By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl0" + j + "_ctl04_sb1x3']"));
				ssn.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				WebDriverInitialization.uiopt.sendKeys(SSN[i], ssn, excelfield3);

				// Relationship to owner for n-1 participants
				if (rltnship[i] != null) {
					WebElement relation = driver.findElement(
							By.xpath("//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl0" + k + "_ctl04_sb1x0']"));
					WebDriverInitialization.uiopt.dropdown(rltnship[i], relation, excelfield4);
				}

				// address same as owner for n-1 participants
				if (addr[i] != null) {
					WebElement sameaddress = driver.findElement(
							By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl0" + k + "_ctl04_sb1x6']"));
					WebDriverInitialization.uiopt.clickByJavaScript(sameaddress);
				}

				// Beneficiary percentage
				if(bene_percent[i]!=null) {
				WebElement bene_percentage = driver.findElement(
						By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl0" + k + "_ctl04_sb1x4']"));
				bene_percentage.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				WebDriverInitialization.uiopt.sendKeys(bene_percent[i], bene_percentage, excelfield5);
				}

				// Active military other than Owner
				if (active_military_other[i] != null) {
					WebElement act_milt_oth = driver.findElement(By
							.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl0" + k + "_ctl04_sb1x22_1']"));
					WebDriverInitialization.uiopt.clickByJavaScript(act_milt_oth);
				}
			}

			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
			System.out.println("Participants Details page completed");

		} catch (Exception e) {
			System.out.println("Please check your data entry-->>" + e.getMessage());
		}
	}

}
