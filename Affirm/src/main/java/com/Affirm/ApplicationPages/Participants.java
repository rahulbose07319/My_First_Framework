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
			excelfield = "Total number of Participants";
			temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Participants");

			// taking number of participants to do data entry
			int number_of_participants = Integer.parseInt(temp);
			if (number_of_participants > 3) {
				for (int i = 0; i < (number_of_participants - 3); i++) {
					WebDriverInitialization.uiopt.clickByJavaScript(addRows);
				}
			}

			// taking details of first name and then splitting on the basis of ',' separated
			String excelfield1 = "First Name";
			temp = ExcelSheetOperation.getCellData(excelfield1, WebDriverInitialization.TC_Name, "Participants");
			String[] first_name = temp.split(",");

			String excelfield2 = "Last Name";
			temp = ExcelSheetOperation.getCellData(excelfield2, WebDriverInitialization.TC_Name, "Participants");
			String[] last_name = temp.split(",");

			String excelfield3 = "Primary Role";
			temp = ExcelSheetOperation.getCellData(excelfield3, WebDriverInitialization.TC_Name, "Participants");
			String[] primary_role = temp.split(",");
			
			String excelfield4 = "Secondary Role";
			temp = ExcelSheetOperation.getCellData(excelfield4, WebDriverInitialization.TC_Name, "Participants");
			String[] secondary_role = temp.split(",");
			
			String excelfield5 = "Additional Role";
			temp = ExcelSheetOperation.getCellData(excelfield5, WebDriverInitialization.TC_Name, "Participants");
			String[] additional_role = temp.split(",");
			
			excelfield = "Is Trust present";
			String trust_data = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Participants");

			for (int i = 0; i < number_of_participants; i++) {
				int j = i + 2;
				// for first name
				WebElement indv_fname = driver
						.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_DataGrid1_ctl0"
								+ j + "_sb" + i + "x1']"));
				WebDriverInitialization.uiopt.sendKeys(first_name[i], indv_fname, excelfield1);

				// for last name
				WebElement indv_lname = driver
						.findElement(By.xpath("//input[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_DataGrid1_ctl0"
								+ j + "_sb" + i + "x3']"));
				WebDriverInitialization.uiopt.sendKeys(last_name[i], indv_lname, excelfield2);

				// for primary role. For owner primary role, value is auto selected.
				if(!primary_role[i].equalsIgnoreCase("Owner")) {
				WebElement pmy_role = driver
						.findElement(By.xpath("//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_DataGrid1_ctl0"
								+ j + "_sb" + i + "x5']"));
				WebDriverInitialization.uiopt.dropdown(primary_role[i], pmy_role, excelfield3);
				}
				
				//for secondary role
				WebElement srole = driver
						.findElement(By.xpath("//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_DataGrid1_ctl0"+j+"_sb"+i+"x6']"));
				WebDriverInitialization.uiopt.dropdown(secondary_role[i], srole, excelfield4);
				
				//for additional role
				WebElement addrole = driver
						.findElement(By.xpath("//select[@id='ctl08_ctl02_ctl02_ctl06_ctl03_ctl01_ctl01_DataGrid1_ctl0"+j+"_sb"+i+"x7']"));
				WebDriverInitialization.uiopt.dropdown(additional_role[i], addrole, excelfield5);
				
				
			}
			
			if(trust_data != null) {
				excelfield = "Trust Name";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Participants");
				WebDriverInitialization.uiopt.sendKeys(temp, entity_name, excelfield);
				
				excelfield = "Trust Secondary Role";
				temp = ExcelSheetOperation.getCellData(excelfield, WebDriverInitialization.TC_Name, "Participants");
				WebDriverInitialization.uiopt.sendKeys(temp, trust_secondary_role, excelfield);
			}

			WebDriverInitialization.uiopt.clickByJavaScript(next_btn);
			new CustomWait(driver).waitForPageLoad();
			System.out.println("Participants page completed");
		} catch (Exception e) {
			System.out.println("Please check your data entry-->>" + e.getMessage());
		}
	}

}
