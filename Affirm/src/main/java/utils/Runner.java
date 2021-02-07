package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.Affirm.ApplicationPages.*;

public class Runner {

	public static Properties prop;

	public static void main(String[] args) throws Exception {

		WebDriverInitialization.loadfile();
		WebDriverInitialization.openBrowser();

		System.out.println("Starting Execution");

		ArrayList<String> data = ExcelSheetOperation.readExecutionPlan();

		for (String ar : data) {
			WebDriverInitialization.TC_Name = ar;
			System.out.println("Test Case" + ar + "started");
			executeTestCases(WebDriverInitialization.affirmScreenFlow());
			Thread.sleep(4000);
			afterTest();
			System.out.println("Test Case completed successfully");
		}

	}

	public static void executeTestCases(String[] flow) throws Exception {
		for (String page : flow) {
			switch (page) {
			case "LoginPage":
				new LoginPage(WebDriverInitialization.driver);
				break;

			case "FinancialAdvisor":
				new FinancialAdvisor(WebDriverInitialization.driver);
				break;

			case "Product":
				new Product(WebDriverInitialization.driver);
				break;

			case "Funding":
				new Funding(WebDriverInitialization.driver);
				break;

			case "Participants":
				new Participants(WebDriverInitialization.driver);
				break;

			case "ParticipantDetails":
				new ParticipantDetails(WebDriverInitialization.driver);
				break;

			case "Features":
				new Features(WebDriverInitialization.driver);
				break;

			case "FeatureDetails":
				new FeatureDetails(WebDriverInitialization.driver);
				break;

			case "SubAccounts":
				new SubAccounts(WebDriverInitialization.driver);
				break;
				
			case "Suitability":
				new Suitability(WebDriverInitialization.driver);
				break;

			case "Fulfillment":
				new Fulfillment(WebDriverInitialization.driver);
				break;

			case "Summary":
				new Summary(WebDriverInitialization.driver);
				break;

			}

		}

	}

	public static void afterTest() {

		WebDriverInitialization.driver.quit();
	}
}
