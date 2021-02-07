package com.Affirm.ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CustomWait;
import utils.ExcelSheetOperation;
import utils.WebDriverInitialization;

public class Participants extends WebDriverInitialization {

	WebDriver driver;
	public String excelfield = "";
	public String temp = "";
	public String[] first_name;
	public String[] last_name;
	public String[] primary_role;
	public String[] secondary_role;
	public String[] additional_role;

	public Participants(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		execute();
	}

	@FindBy(xpath = "//input[@value='Next >>' and @class='NEXTButton' and @title='Go to Next Section']")
	public static WebElement next_btn;
	@FindBy(xpath = "//input[@value='Add Rows']")
	public static WebElement addRows;

	// Trust, QPDB/QPDC and Custodian
	@FindBy(xpath = "//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl03_DataGrid1_ctl02_sb0x0']")
	public static WebElement entity_name;
	@FindBy(xpath = "//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl03_DataGrid1_ctl02_sb0x3']")
	public static WebElement trust_secondary_role;

	public void execute() {
		System.out.println("Affirm Participants page started");

		try { 
			excelfield = "Total_number_of_Participants";
			String stemp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Participants");

			// taking number of participants to do data entry
			int number_of_participants = Integer.parseInt(stemp);
			if (number_of_participants > 3) {
				for (int i = 0; i < (number_of_participants - 3); i++) {
					WebDriverInitialization.uiopt.clickByJavaScript(addRows);
				}
			}

			// taking details of first name and then splitting on the basis of ',' separated
			String excelfield1 = "First_Name";
			temp = ExcelSheetOperation.getCellData(excelfield1, WebDriverInitialization.TC_Name, "Participants");
			first_name = temp.split(",");

			String excelfield2 = "Last_Name";
			temp = ExcelSheetOperation.getCellData(excelfield2, WebDriverInitialization.TC_Name, "Participants");
			last_name = temp.split(",");

			String excelfield3 = "Primary_Role";
			temp = ExcelSheetOperation.getCellData(excelfield3, WebDriverInitialization.TC_Name, "Participants");
			primary_role = temp.split(",");

			String excelfield4 = "Secondary_Role";
			temp = ExcelSheetOperation.getCellData(excelfield4, WebDriverInitialization.TC_Name, "Participants");
			secondary_role = temp.split(",");

			String excelfield5 = "Additional_Role";
			temp = ExcelSheetOperation.getCellData(excelfield5, WebDriverInitialization.TC_Name, "Participants");
			additional_role = temp.split(",");

			excelfield = "Is_Trust_present";
			String trust_data = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name,
					"Participants");

			for (int i = 0; i < number_of_participants; i++) {
				int j = i + 2;
				// for first name
				if (first_name[i] != null || first_name[i] != "None") {
					WebElement indv_fname = driver.findElement(
							By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_DataGrid1_ctl0" + j + "_sb"
									+ i + "x1']"));
					WebDriverInitialization.uiopt.sendKeys(first_name[i], indv_fname, excelfield1);
				}

				// for last name
				if (last_name[i] != null || last_name[i] != "None") {
					WebElement indv_lname = driver.findElement(
							By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_DataGrid1_ctl0" + j + "_sb"
									+ i + "x3']"));
					WebDriverInitialization.uiopt.sendKeys(last_name[i], indv_lname, excelfield2);
				}

				// for primary role. For owner primary role, value is auto selected.
				if (primary_role[i] != null || primary_role[i] != "None") {
					if (!primary_role[i].equalsIgnoreCase("Owner")) {
						WebElement pmy_role = driver.findElement(
								By.xpath("//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_DataGrid1_ctl0" + j
										+ "_sb" + i + "x5']"));
						WebDriverInitialization.uiopt.dropdown(primary_role[i], pmy_role, excelfield3);
					}
				}

				// for secondary role
				if (secondary_role[i] != null || secondary_role[i] != "None") {
					WebElement srole = driver.findElement(
							By.xpath("//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_DataGrid1_ctl0" + j
									+ "_sb" + i + "x6']"));
					WebDriverInitialization.uiopt.dropdown(secondary_role[i], srole, excelfield4);
				}

				// for additional role
				if (additional_role[i] == "" || additional_role[i] == "None") {
					System.out.println("There is no additional Role defined for this participant");
				}
				WebElement addrole = driver
						.findElement(By.xpath("//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_DataGrid1_ctl0"
								+ j + "_sb" + i + "x7']"));
				WebDriverInitialization.uiopt.dropdown(additional_role[i], addrole, excelfield5);

			}

			if (trust_data.equalsIgnoreCase("Yes")) {
				excelfield = "Trust_Name";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Participants");
				WebDriverInitialization.uiopt.sendKeys(temp, entity_name, excelfield);

				excelfield = "Trust_Secondary_Role";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Participants");
				WebDriverInitialization.uiopt.dropdown(temp, trust_secondary_role, excelfield);
			}

			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
			System.out.println("Participants page completed");
		} catch (Exception e) {
			System.out.println("Please check your data entry-->>" + e.getMessage());
		}
	}

}
