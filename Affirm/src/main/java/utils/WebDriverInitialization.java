package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import uioperation.UIOperation;

public class WebDriverInitialization {

	public static WebDriver driver;
	public static Properties prop;
	public static UIOperation uiopt;
	public static String userdir = null;
	public static String TC_Name = null;

	public static String[] affirmScreenFlow() {
		String flow[] = new String[] { "LoginPage","FinancialAdvisor", "Product", "Funding", "Participants",
				"ParticipantDetails", "Features", "FeatureDetails", "SubAccounts", "Suitability", "Fulfillment", "Summary" };
		return flow;
	}

	public static void loadfile() {
		prop = new Properties();

		try {
			File location = new File("C:\\Users\\rahul\\git\\Affirm\\Affirm\\config.properties");
			FileInputStream fp = new FileInputStream(location);
			prop.load(fp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriver"));
		// chrome settings for downloading files without any popup
		
		ChromeOptions options = new ChromeOptions();
		String path= "C:\\Users\\rahul\\git\\Affirm\\Affirm\\Downloads";
		//Path download_folder = Paths.get(System.getProperty("user.home") + "rahul/eclipse-workspace/Affirm/Downloads");
		
		Map<String, Object> chromeprefs = new HashMap<String, Object>();
		chromeprefs.put("profile.default_content_settings.popups", 0);
		chromeprefs.put("download.default_directory", path);
		//chromeprefs.put("download.default_directory", download_folder.toAbsolutePath());
		
		options.setExperimentalOption("prefs", chromeprefs);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		System.out.println("Affirm url launched");
		uiopt = new UIOperation(driver);
	}

}
