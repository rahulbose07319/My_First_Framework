package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FileHandling extends WebDriverInitialization {

	WebDriver driver;
	public static File oldfilename;
	public static File newfilename;

	public FileHandling(WebDriver driver) throws Exception {
		this.driver = driver;
	}

	public static void fileRname() {
		oldfilename = new File("C:\\Users\\rahul\\eclipse-workspace\\Affirm\\Downloads\\JoinedFile.pdf");
		newfilename = new File(
				"C:\\Users\\rahul\\eclipse-workspace\\Affirm\\Downloads\\" + WebDriverInitialization.TC_Name + ".pdf");
		if (oldfilename.renameTo(newfilename))
			System.out.println("Filename is updated");

	}

}
